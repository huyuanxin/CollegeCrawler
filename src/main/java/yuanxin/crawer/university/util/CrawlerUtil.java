package yuanxin.crawer.university.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yuanxin.crawer.university.model.collegeinfo.EnrollNum;
import yuanxin.crawer.university.model.collegeinfo.MinScore;
import yuanxin.crawer.university.model.collegeinfo.MinScoreOrder;
import yuanxin.crawer.university.model.range.Batch;
import yuanxin.crawer.university.model.range.Curriculum;
import yuanxin.crawer.university.model.range.Province;
import yuanxin.crawer.university.service.EnrollNumService;
import yuanxin.crawer.university.service.MinScoreOrderService;
import yuanxin.crawer.university.service.MinScoreService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huyuanxin
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

    @Autowired
    public CrawlerUtil(EnrollNumService enrollNumService, MinScoreService minScoreService, MinScoreOrderService minScoreOrderService) {
        this.enrollNumService = enrollNumService;
        this.minScoreService = minScoreService;
        this.minScoreOrderService = minScoreOrderService;
    }

    public void saveCollegeInfo() {
        collegeNameList = CollegeNameCrawlerUtil.getAllCollegeNameList();
        List<MinScore> minScoreList = new ArrayList<>();
        List<MinScoreOrder> minScoreOrderList = new ArrayList<>();
        List<EnrollNum> enrollNumList = new ArrayList<>();
        for (String collegeName : collegeNameList
        ) {
            System.out.println("开始爬取" + collegeName + "的分数线、最低排位和招生人数");
            for (Province province : Province.values()
            ) {
                for (Batch batch : Batch.values()
                ) {
                    for (Curriculum curriculum : Curriculum.values()
                    ) {
                        try {
                            Thread.sleep(0);
                        } catch (Exception e) {
                            continue;
                        }
                        System.out.println("开始爬取" + collegeName + "," + province.getName() + curriculum.getName() + batch.getName() + "分数线");
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

                        System.out.println("开始爬取" + collegeName + "," + province.getName() + curriculum.getName() + batch.getName() + "最低排位");
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

                        System.out.println("开始爬取" + collegeName + "," + province.getName() + curriculum.getName() + batch.getName() + "招生人数");
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
            enrollNumService.saveOrUpdateBatch(enrollNumList.stream().filter(it -> !"--".equals(it.getNum())).collect(Collectors.toList()));
            minScoreService.saveOrUpdateBatch(minScoreList.stream().filter(it -> !"--".equals(it.getScore())).collect(Collectors.toList()));
            minScoreOrderService.saveOrUpdateBatch(minScoreOrderList.stream().filter(it -> !"--".equals(it.getRank())).collect(Collectors.toList()));
            enrollNumList.clear();
            minScoreList.clear();
            minScoreOrderList.clear();
            System.out.println(collegeName + "的分数线、最低排位和招生人数爬取完成");
        }


    }
}
