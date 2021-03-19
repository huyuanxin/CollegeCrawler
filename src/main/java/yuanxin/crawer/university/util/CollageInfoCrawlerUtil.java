package yuanxin.crawer.university.util;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @author huyuanxin
 */
public class CollageInfoCrawlerUtil {

    /**
     * 获得学校的信息
     *
     * @param collageName  大学名称
     * @param provinceName 省份
     * @param curriculum   文理科
     * @param batchName    批次
     * @return JsonObject
     */
    public static JSONObject getCollageInfoJson(String collageName, String provinceName, String curriculum, String batchName) {
        String requestUrl = String.format("https://gaokao.baidu.com/gaokao/gkschool/scoreenroll?ajax=1&query=%s&province=%s&curriculum=%s&batchName=%s", collageName, provinceName, curriculum, batchName);
        String jsonString = HttpUtil.createGet(requestUrl).header(Header.USER_AGENT, "Mozilla/5.0").execute().body();
        // try的目的是防止出现参数错误导致返回的json字符串无法被转换为JsonObject
        try {
            return JSONObject.parseObject(jsonString);
        } catch (Exception e) {
            try {
                String retry = HttpUtil.createGet(requestUrl).header(Header.USER_AGENT, "Mozilla/5.0").execute().body();
                return JSONObject.parseObject(retry);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return new JSONObject();
    }

    /**
     * 获得jsonObject内指定名称jSONArray，存储到HashMap
     *
     * @param jsonObject 通过{@link #getCollageInfoJson(String, String, String, String)} 获取的{@link JSONObject}
     * @param arrayName  jsonObject 内 jsonArray 的名字
     * @return 包含结果的HashMap
     */
    public static JSONArray getCollageInfoJsonArray(JSONObject jsonObject, String arrayName) {
        Object data = jsonObject.get("data");
        if (null != data) {
            // 此次存在一种情况，无数据data可能是JsonArray类型，做一次判断
            if (data instanceof JSONObject) {
                JSONObject temp = (JSONObject) data;
                JSONArray info = temp.getJSONArray(arrayName);
                if (null != info) {
                    return info;
                }
            }
        }
        return new JSONArray();
    }

    /**
     * 将jsonObject内指定名称jSONArray存储到HashMap
     *
     * @param jsonObject 通过{@link #getCollageInfoJson(String, String, String, String)} 获取的{@link JSONObject}
     * @param arrayName  jsonObject 内 jsonArray 的名字
     * @return 包含结果的HashMap
     */
    public static HashMap<String, JSONArray> getCollageInfoMap(JSONObject jsonObject, String arrayName) {
        HashMap<String, JSONArray> map = new HashMap<>();
        JSONArray minScoreArray = getCollageInfoJsonArray(jsonObject, arrayName);
        minScoreArray.forEach(it -> {
            JSONObject json = (JSONObject) it;
            map.put(json.getString("key"), json.getJSONArray("value"));
        });
        return map;
    }

}
