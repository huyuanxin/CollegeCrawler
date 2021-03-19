package yuanxin.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin.crawler.university.mapper.MinScoreOrderMapper;
import yuanxin.crawler.university.model.collegeinfo.MinScoreOrder;
import yuanxin.crawler.university.service.MinScoreOrderService;

/**
 * @author huyuanxin
 */
@Service
public class MinScoreOrderServiceImpl extends ServiceImpl<MinScoreOrderMapper, MinScoreOrder> implements MinScoreOrderService {
}
