package yuanxin_shuxian.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin_shuxian.crawler.university.mapper.MinScoreOrderMapper;
import yuanxin_shuxian.crawler.university.service.MinScoreOrderService;
import yuanxin_shuxian.crawler.university.model.collegeinfo.MinScoreOrder;

/**
 * @author huyuanxin
 * @author guoshuxian
 */
@Service
public class MinScoreOrderServiceImpl extends ServiceImpl<MinScoreOrderMapper, MinScoreOrder> implements MinScoreOrderService {
}
