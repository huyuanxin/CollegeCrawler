package shuxian.crawler.university.util;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * @author huyuanxin
 * @author guoshuxian
 */
public class CollegeNameCrawlerUtil {

    /**
     * 获得高校名称的请求url
     */
    final static String URL = "https://gaokao.baidu.com/gaokao/gkschool/ranklist?ajax=1&province=全国&city=所有地区&character=&batch=&type=&rn=100&rankType=1&page=";

    /**
     * 总页数
     */
    final static int TOTAL_PAGE = 21;

    /**
     * 模拟浏览器请求 URL
     *
     * @param page 页数，对应URL的page=?
     * @return 请求返回的结果
     */
    public static JSONObject getCollegeNameJson(int page) {
        String requestUrl = URL + page;
        String jsonString = HttpUtil.createGet(requestUrl).header(Header.USER_AGENT, "Mozilla/5.0").execute().body();
        return JSONObject.parseObject(jsonString);
    }

    /**
     * 获得 {@link #getCollegeNameJson(int)} 返回结果里面的data
     *
     * @param page 页数，对应URL的page=?
     * @return 返回结果里面的data
     */
    public static JSONArray getCollegeNameJsonArray(int page) {
        JSONObject json = getCollegeNameJson(page);
        JSONObject data = json.getJSONObject("data");
        if (null != data) {
            JSONArray jsonArray = data.getJSONArray("disp_data");
            if (null != jsonArray) {
                return jsonArray;
            }
        }
        return new JSONArray();
    }

    /**
     * 获取高校名称
     *
     * @param page 页数，对应URL的page=?
     * @return 对应页数返回的全部高校名称
     */
    public static List<String> getCollegeNameList(int page) {
        List<String> collegeNameList = new ArrayList<>();
        JSONArray jsonArray = getCollegeNameJsonArray(page);
        jsonArray.forEach(it -> {
            JSONObject jsonObject = (JSONObject) it;
            collegeNameList.add(jsonObject.getString("college_name"));
        });
        return collegeNameList;
    }

    /**
     * 循环请求，全部高校名称
     *
     * @return 全部高校名称
     */
    public static List<String> getAllCollegeNameList() {
        System.out.println("开始爬取高校名");
        List<String> allCollegeNameList = new ArrayList<>();
        for (int i = 1; i < TOTAL_PAGE; ++i) {
            System.out.println("爬取第" + i + "页的高校名");
            allCollegeNameList.addAll(getCollegeNameList(i));
        }
        System.out.println("高校名爬取完成");
        return allCollegeNameList;
    }
}
