package shuxian.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shuxian.crawler.university.mapper.EnrollNumMapper;
import shuxian.crawler.university.service.EnrollNumService;
import shuxian.crawler.university.model.collegeinfo.EnrollNum;

/**
 * @author huyuanxin
 */
@Service
public class EnrollNumServiceImpl extends ServiceImpl<EnrollNumMapper, EnrollNum> implements EnrollNumService {
}
