package yuanxin_shuxian.crawler.university.model.range;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
public enum Curriculum {

    /**
     * 理科
     */
    Sciences("理科"),

    /**
     * 文科
     */
    Art("文科");
    private final String name;

    Curriculum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
