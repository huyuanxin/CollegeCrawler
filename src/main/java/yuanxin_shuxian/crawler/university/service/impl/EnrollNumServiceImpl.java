package yuanxin_shuxian.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin_shuxian.crawler.university.mapper.EnrollNumMapper;
import yuanxin_shuxian.crawler.university.service.EnrollNumService;
import yuanxin_shuxian.crawler.university.model.collegeinfo.EnrollNum;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@Service
public class EnrollNumServiceImpl extends ServiceImpl<EnrollNumMapper, EnrollNum> implements EnrollNumService {
}
