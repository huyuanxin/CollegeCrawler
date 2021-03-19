package yuanxin.crawler.university.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import yuanxin.crawler.university.model.collegeinfo.EnrollNum;

/**
 * @author huyuanxin
 */
@Mapper
@Repository
public interface EnrollNumMapper extends BaseMapper<EnrollNum> {
}
