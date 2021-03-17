package yuanxin.crawer.university.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yuanxin.crawer.university.model.collegeinfo.MinScore;

/**
 * @author huyuanxin
 */
@Repository
@Mapper
public interface MinScoreMapper extends BaseMapper<MinScore> {

}
