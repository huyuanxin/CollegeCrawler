package yuanxin.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin.crawler.university.mapper.EnrollNumMapper;
import yuanxin.crawler.university.model.collegeinfo.EnrollNum;
import yuanxin.crawler.university.service.EnrollNumService;

/**
 * @author huyuanxin
 */
@Service
public class EnrollNumServiceImpl extends ServiceImpl<EnrollNumMapper, EnrollNum> implements EnrollNumService {
}
