package yuanxin.crawer.university;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yuanxin.crawer.university.util.CollageInfoCrawlerUtil;
import yuanxin.crawer.university.util.CollegeNameCrawlerUtil;
import yuanxin.crawer.university.util.CrawlerUtil;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class UniversityCrawlerApplicationTests {

    @Autowired
    CrawlerUtil crawlerUtil;

    @Test
    void getUniversityNameJson() {
        JSONObject jsonObject = CollegeNameCrawlerUtil.getCollegeNameJson(1);
        System.out.println(jsonObject);
    }

    @Test
    void getUniversityNameJsonArray() {
        JSONArray jsonArray = CollegeNameCrawlerUtil.getCollegeNameJsonArray(1);
        System.out.println(jsonArray);
    }

    @Test
    void getUniversityName() {
        List<String> universityNameList = CollegeNameCrawlerUtil.getCollegeNameList(1);
        universityNameList.forEach(System.out::println);
    }

    @Test
    void getCollageMinScoreJsonArray() {
        JSONObject jsonObject = CollageInfoCrawlerUtil.getCollageInfoJson("广东医科大学", "广东", "文科", "本科批");
        HashMap<String, JSONArray> map = CollageInfoCrawlerUtil.getCollageInfoMap(jsonObject, "minScore");
        System.out.println(map.get("2017"));
    }

    @Test
    void getMinScore() {
        crawlerUtil.saveCollegeInfo();
    }

}
