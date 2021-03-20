package shuxian.crawler.university.model;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
public class College {

    /**
     * id
     */
    Long id;

    /**
     * 大学名称
     */
    String collegeName;

    /**
     * 大学排名
     */
    String collegeRank;

    /**
     * 省份
     */
    String province;

    /**
     * 城市
     */
    String city;

    /**
     * 批次
     */
    String batch;

    /**
     * 类别
     */
    String character;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeRank() {
        return collegeRank;
    }

    public void setCollegeRank(String collegeRank) {
        this.collegeRank = collegeRank;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
