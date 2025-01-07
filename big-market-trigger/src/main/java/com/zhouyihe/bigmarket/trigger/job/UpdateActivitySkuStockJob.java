package com.zhouyihe.bigmarket.trigger.job;

import com.zhouyihe.bigmarket.domain.activity.model.valobj.ActivitySkuStockKeyVO;
import com.zhouyihe.bigmarket.domain.activity.service.ISkuStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/23 16:06
 * @description 更新活动sku库存任务
 */
@Slf4j
@Component
public class UpdateActivitySkuStockJob {
    
    @Resource
    private ISkuStock skuStock;
    
    @Scheduled(cron = "0/5 * * * * ?")
    public void exec() {
        try {
            log.info("定时任务，更新活动sku库存【延迟队列获取，降低对数据库的更新频次，不要产生竞争】");
            ActivitySkuStockKeyVO activitySkuStockKeyVO = skuStock.takeQueueValue();
            if (null == activitySkuStockKeyVO) return;
            log.info("定时任务，更新活动sku库存 sku:{} activityId:{}", activitySkuStockKeyVO.getSku(),
                    activitySkuStockKeyVO.getActivityId());
            skuStock.updateActivitySkuStock(activitySkuStockKeyVO.getSku());
        } catch (Exception e) {
            log.error("定时任务，更新活动sku库存失败", e);
        }
    }
}
