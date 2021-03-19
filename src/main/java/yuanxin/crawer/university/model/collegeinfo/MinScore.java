package yuanxin.crawer.university.model.collegeinfo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author huyuanxin
 */
@TableName("min_score")
public class MinScore {

    /**
     * 大学名称
     */
    @TableField("college_name")
    String collegeName;

    /**
     * 分数线
     */
    @TableField("score")
    String score;

    /**
     * 年份
     */
    @TableField("year")
    String year;

    /**
     * 省份
     */
    @TableField("province")
    String province;

    /**
     * 文理科
     */
    @TableField("curriculum")
    String curriculum;

    /**
     * 批次
     */
    @TableField("batch")
    String batch;

    /**
     * 类别
     */
    @TableField("type")
    String type;

    public MinScore(String collegeName, String score, String year, String province, String curriculum, String batch, String type) {
        this.collegeName = collegeName;
        this.score = score;
        this.year = year;
        this.province = province;
        this.curriculum = curriculum;
        this.batch = batch;
        this.type = type;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MinScore{" +
                "collegeName='" + collegeName + '\'' +
                ", score='" + score + '\'' +
                ", year='" + year + '\'' +
                ", province='" + province + '\'' +
                ", curriculum='" + curriculum + '\'' +
                ", batch='" + batch + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
