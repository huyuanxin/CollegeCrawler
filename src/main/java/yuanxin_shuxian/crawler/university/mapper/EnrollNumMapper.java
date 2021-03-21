package yuanxin_shuxian.crawler.university.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yuanxin_shuxian.crawler.university.model.collegeinfo.EnrollNum;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@Mapper
@Repository
public interface EnrollNumMapper extends BaseMapper<EnrollNum> {
}
