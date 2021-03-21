# README

CollegeCrawler

# Quick Start

## Dependencies

* Java 8 and up
* Maven 3.6.3 and up
* SqlServer 2008 and up, Mysql 5.7 and up
* IDEA

## How To Start

### DownLoad Source Code

```shell
git clonehttps://gitee.com/huyuanxin/CollegeCrawler
```

### Import Code To IDEA

### Run Sql

    * Mysql: resources/Mysql
    * SQL server: resources/SQL server

### Configuration Database Information

```properties
spring.datasource.url=jdbc:sqlserver://{database ip}:{port};DatabaseName={databaseName}
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.datasource.username={username}
spring.datasource.password={password}
```

### Run Application

* Run CollegeCrawlerApplication.java

# References

If you used College Crawler in your research, please quote it in the following format:

```
@Software{CollegeCrawler,
  author = {huyuanxin},
  title = {{CollegeCrawler: CollegeCrawler}},
  year = {2021},
  url = {https://gitee.com/huyuanxin/CollegeCrawlers},
}
```

# Disclaimers

Please do not apply College Crawler to any work that may violate the legal provisions and moral constraints. Please use
College Crawler friendly, abide by the spider agreement, and do not use College Crawler for any illegal purpose. If you
choose to use College Crawler, you will abide by this agreement. The author will not bear any legal risks and losses
caused by your violation of this agreement, and all consequences will be borne by you.
