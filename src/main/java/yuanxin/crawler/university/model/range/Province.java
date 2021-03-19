package yuanxin.crawler.university.model.range;

/**
 * 省份
 *
 * @author huyuanxin
 */
public enum Province {
    /**
     * 北京市
     */
    BeiJing("北京"),

    /**
     * 天津市
     */
    TianJin("天津"),

    /**
     * 上海市
     */
    ShangHai("上海"),

    /**
     * 重庆市
     */
    ChongQing("重庆"),

    /**
     * 河北省
     */
    HeBei("河北"),

    /**
     * 山西省
     */
    ShanXi("山西"),

    /**
     * 辽宁省
     */
    LiaoNing("辽宁"),

    /**
     * 吉林省
     */
    JiLin("吉林"),

    /**
     * 黑龙江省
     */
    HeiLongJiang("黑龙江"),

    /**
     * 江苏省
     */
    JiangSu("江苏"),

    /**
     * 浙江省
     */
    ZheJiang("浙江"),

    /**
     * 安徽省
     */
    AnHui("安徽"),

    /**
     * 福建省
     */
    FuJian("福建"),

    /**
     * 江西省
     */
    JiangXi("江西"),

    /**
     * 山东省
     */
    ShanDong("山东"),

    /**
     * 河南省
     */
    HeNan("河南"),

    /**
     * 湖北省
     */
    HuBei("湖北"),

    /**
     * 湖南省
     */
    HuNan("湖南"),

    /**
     * 广东省
     */
    GuangDong("广东"),

    /**
     * 海南省
     */
    HaiNan("海南"),

    /**
     * 四川省
     */
    SiChuan("四川"),

    /**
     * 贵州省
     */
    HuiZhou("贵州"),

    /**
     * 云南省
     */
    YunNan("云南"),

    /**
     * 陕西省
     */
    ShannXi("陕西"),

    /**
     * 甘肃省
     */
    GanSu("甘肃"),

    /**
     * 青海省
     */
    QingHai("青海"),

    /**
     * 台湾省
     */
    TaiWan("台湾"),

    /**
     * 内蒙古省
     */
    NeiMengGu("内蒙古"),

    /**
     * 广西省
     */
    GuangXi("广西"),

    /**
     * 西藏省
     */
    XiZang("西藏"),

    /**
     * 宁夏省
     */
    NingXia("宁夏"),

    /**
     * 新疆
     */
    XinJiang("新疆"),

    /**
     * 香港
     */
    HongKong("香港"),

    /**
     * 澳门
     */
    MaCao("澳门");

    private final String name;

    Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


