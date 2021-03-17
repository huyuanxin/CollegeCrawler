package yuanxin.crawer.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin.crawer.university.mapper.EnrollNumMapper;
import yuanxin.crawer.university.model.collegeinfo.EnrollNum;
import yuanxin.crawer.university.service.EnrollNumService;

/**
 * @author huyuanxin
 */
@Service
public class EnrollNumServiceImpl extends ServiceImpl<EnrollNumMapper, EnrollNum> implements EnrollNumService {
}
