package yuanxin_shuxian.crawler.university.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yuanxin_shuxian.crawler.university.model.range.Batch;
import yuanxin_shuxian.crawler.university.model.range.Curriculum;
import yuanxin_shuxian.crawler.university.model.range.Province;
import yuanxin_shuxian.crawler.university.service.EnrollNumService;
import yuanxin_shuxian.crawler.university.service.MinScoreOrderService;
import yuanxin_shuxian.crawler.university.service.MinScoreService;
import yuanxin_shuxian.crawler.university.model.collegeinfo.EnrollNum;
import yuanxin_shuxian.crawler.university.model.collegeinfo.MinScore;
import yuanxin_shuxian.crawler.university.model.collegeinfo.MinScoreOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@Component
public class CrawlerUtil {

    /**
     * 大学名称的列表
     */
    List<String> collegeNameList;
    final EnrollNumService enrollNumService;
    final MinScoreService minScoreService;
    final MinScoreOrderService minScoreOrderService;

    int finished;
    int needed;

    @Autowired
    public CrawlerUtil(EnrollNumService enrollNumService, MinScoreService minScoreService, MinScoreOrderService minScoreOrderService) {
        this.enrollNumService = enrollNumService;
        this.minScoreService = minScoreService;
        this.minScoreOrderService = minScoreOrderService;
    }

    public List<String> getCollegeNameListNoInDataBaseName() {
        List<String> allCollegeNameList = CollegeNameCrawlerUtil.getAllCollegeNameList();
        System.out.println(allCollegeNameList.size());
        QueryWrapper<MinScore> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT college_name");
        List<MinScore> minScoreList = minScoreService.list(queryWrapper);
        minScoreList.forEach(it -> {
            System.out.println("已爬取" + it.getCollegeName() + "的信息,跳过");
            allCollegeNameList.removeIf(it.getCollegeName()::equals);
        });
        finished = minScoreList.size();
        needed = allCollegeNameList.size() + minScoreList.size();
        return allCollegeNameList;
    }

    public void saveCollegeInfo() {
        collegeNameList = getCollegeNameListNoInDataBaseName();
        List<MinScore> minScoreList = new ArrayList<>();
        List<MinScoreOrder> minScoreOrderList = new ArrayList<>();
        List<EnrollNum> enrollNumList = new ArrayList<>();
        for (String collegeName : collegeNameList
        ) {
            System.out.println("爬取状态:  " + finished + "/" + needed);
            System.out.println("开始爬取" + collegeName + "的分数线、最低排位和招生人数");
            for (Province province : Province.values()
            ) {
                for (Batch batch : Batch.values()
                ) {
                    for (Curriculum curriculum : Curriculum.values()
                    ) {
                        JSONObject jsonObject = CollageInfoCrawlerUtil.getCollageInfoJson(collegeName, province.getName(), curriculum.getName(), batch.getName());
                        HashMap<String, JSONArray> minScoreMap = CollageInfoCrawlerUtil.getCollageInfoMap(jsonObject, "minScore");
                        for (String key : minScoreMap.keySet()) {
                            JSONArray jsonArray = minScoreMap.get(key);
                            for (Object o : jsonArray
                            ) {
                                JSONObject temp = (JSONObject) o;
                                String minScore = temp.getString("value");
                                String type = temp.getString("name");
                                minScoreList.add(new MinScore(collegeName, minScore, key, province.getName(), curriculum.getName(), batch.getName(), type));
                            }
                        }

                        HashMap<String, JSONArray> minScoreOrderMap = CollageInfoCrawlerUtil.getCollageInfoMap(jsonObject, "minScoreOrder");
                        for (String key : minScoreOrderMap.keySet()) {
                            JSONArray jsonArray = minScoreOrderMap.get(key);
                            for (Object o : jsonArray
                            ) {
                                JSONObject temp = (JSONObject) o;
                                String rank = temp.getString("value");
                                String type = temp.getString("name");
                                minScoreOrderList.add(new MinScoreOrder(collegeName, rank, key, province.getName(), curriculum.getName(), batch.getName(), type));
                            }
                        }

                        HashMap<String, JSONArray> enrollNumMap = CollageInfoCrawlerUtil.getCollageInfoMap(jsonObject, "enrollNum");
                        for (String key : enrollNumMap.keySet()) {
                            JSONArray jsonArray = enrollNumMap.get(key);
                            for (Object o : jsonArray
                            ) {
                                JSONObject temp = (JSONObject) o;
                                String num = temp.getString("value");
                                String type = temp.getString("name");
                                enrollNumList.add(new EnrollNum(collegeName, num, key, province.getName(), curriculum.getName(), batch.getName(), type));
                            }
                        }
                    }
                }
            }
            enrollNumService.saveBatch(enrollNumList.stream().filter(it -> !"--".equals(it.getNum())).collect(Collectors.toList()));
            minScoreService.saveBatch(minScoreList.stream().filter(it -> !"--".equals(it.getScore())).collect(Collectors.toList()));
            minScoreOrderService.saveBatch(minScoreOrderList.stream().filter(it -> !"--".equals(it.getRank())).collect(Collectors.toList()));
            enrollNumList.clear();
            minScoreList.clear();
            minScoreOrderList.clear();
            finished++;
            System.out.println(collegeName + "的分数线、最低排位和招生人数爬取完成");
        }
    }

}
