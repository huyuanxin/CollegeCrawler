# README

大学信息爬虫软件

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

如果你在研究中使用了CollegeCrawler，请按如下格式引用：

```
@software{CollegeCrawler,
  author = {huyuanxin},
  title = {{CollegeCrawler: CollegeCrawler}},
  year = {2021},
  url = {https://gitee.com/huyuanxin/CollegeCrawlers},
}
```

