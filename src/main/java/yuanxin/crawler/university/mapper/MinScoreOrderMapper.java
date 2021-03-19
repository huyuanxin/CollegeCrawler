package yuanxin.crawler.university.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yuanxin.crawler.university.model.collegeinfo.MinScoreOrder;

/**
 * @author huyuanxin
 */
@Repository
@Mapper
public interface MinScoreOrderMapper extends BaseMapper<MinScoreOrder> {
}