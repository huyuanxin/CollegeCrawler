package yuanxin.crawer.university.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import yuanxin.crawer.university.mapper.MinScoreOrderMapper;
import yuanxin.crawer.university.model.collegeinfo.MinScoreOrder;
import yuanxin.crawer.university.service.MinScoreOrderService;

/**
 * @author huyuanxin
 */
@Service
public class MinScoreOrderServiceImpl extends ServiceImpl<MinScoreOrderMapper, MinScoreOrder> implements MinScoreOrderService {
}
