package shuxian.crawler.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import shuxian.crawler.university.util.CrawlerUtil;

import javax.annotation.PostConstruct;

/**
 * @author huyuanxin
 */
@SpringBootApplication
public class UniversityCrawlerApplication {

    final CrawlerUtil crawlerUtil;
    static CrawlerUtil staticCrawlerUtil = null;

    @Autowired
    public UniversityCrawlerApplication(CrawlerUtil crawlerUtil) {
        this.crawlerUtil = crawlerUtil;
    }

    @PostConstruct
    void init() {
        staticCrawlerUtil = crawlerUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(UniversityCrawlerApplication.class, args);
        staticCrawlerUtil.saveCollegeInfo();
    }
}
