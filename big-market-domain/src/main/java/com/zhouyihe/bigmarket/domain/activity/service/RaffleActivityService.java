package com.zhouyihe.bigmarket.domain.activity.service;

import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 23:23
 * @description 抽奖活动服务
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity {
    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }
}
