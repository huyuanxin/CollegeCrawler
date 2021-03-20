package shuxian.crawler.university.model.collegeinfo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@TableName("enrollnum")
public class EnrollNum {

    /**
     * 大学名称
     */
    @TableField("college_name")
    String collegeName;

    /**
     * 人数
     */
    @TableField("num")
    String num;

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

    public EnrollNum(String collegeName, String num, String year, String province, String curriculum, String batch, String type) {
        this.collegeName = collegeName;
        this.num = num;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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
}
