package shuxian.crawler.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import shuxian.crawler.university.mapper.MinScoreOrderMapper;
import shuxian.crawler.university.service.MinScoreOrderService;
import shuxian.crawler.university.model.collegeinfo.MinScoreOrder;

/**
 * @author huyuanxin
 */
@Service
public class MinScoreOrderServiceImpl extends ServiceImpl<MinScoreOrderMapper, MinScoreOrder> implements MinScoreOrderService {
}
