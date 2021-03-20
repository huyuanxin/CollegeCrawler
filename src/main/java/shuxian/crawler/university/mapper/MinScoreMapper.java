package shuxian.crawler.university.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import shuxian.crawler.university.model.collegeinfo.MinScore;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@Repository
@Mapper
public interface MinScoreMapper extends BaseMapper<MinScore> {

}
