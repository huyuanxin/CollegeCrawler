package shuxian.crawler.university.model.range;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
public enum Batch {

    /**
     * 本科批
     */
    Undergraduate("本科批"),

    /**
     * 本科一批
     */
    UndergraduateFirst("本科一批"),

    /**
     * 本科二批
     */
    UndergraduateSecond("本科二批"),

    /**
     * 本科三批
     */
    UndergraduateThird("本科三批"),

    /**
     * 专科批
     */
    Vocational("专科批"),

    /**
     * 专科一批
     */
    VocationalFirst("专科一批"),

    /**
     * 专科二批
     */
    VocationalSecond("专科二批"),

    /**
     * 专科三批
     */
    VocationalThird("专科三批"),

    /**
     * 地方专项计划本科批
     */
    LocalSpecialUndergraduate("地方专项计划本科批"),

    /**
     * 地方专项计划专科批
     */
    LocalSpecialVocational("地方专项计划专科批"),

    /**
     * 提前批
     */
    BeforeBatch("提前批");

    private final String name;

    Batch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
