package com.zhouyihe.bigmarket.domain.activity.service;

import com.zhouyihe.bigmarket.domain.activity.model.aggregate.CreateOrderAggregate;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivitySkuEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.SkuRechargeEntity;
import com.zhouyihe.bigmarket.domain.activity.repository.IActivityRepository;
import com.zhouyihe.bigmarket.domain.activity.service.rule.IActionChain;
import com.zhouyihe.bigmarket.domain.activity.service.rule.factory.DefaultActivityChainFactory;
import com.zhouyihe.bigmarket.types.enums.ResponseCode;
import com.zhouyihe.bigmarket.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/12/13 21:49
     * @description 抽奖活动抽象类，定义标准的流程
 */
@Slf4j
public abstract class AbstractRaffleActivity extends RaffleActivitySupport implements IRaffleOrder {
    
    public AbstractRaffleActivity(
            DefaultActivityChainFactory defaultActivityChainFactory,
            IActivityRepository activityRepository) {
        super(defaultActivityChainFactory, activityRepository);
    }
    
    /**
     * 创建 sku 账户充值订单，给用户增加抽奖次数
     *
     * 1. 在【打卡、签到、分享、对话、积分兑换】等行为动作下，创建出活动订单，给用户的活动账户【日、月】充值可用的抽奖次数。
     * 2. 对于用户可获得的抽奖次数，比如首次进来就有一次，则是依赖于运营配置的动作，在前端页面上。用户点击后，可以获得一次抽奖次数。
     *
     * @param skuRechargeEntity 活动商品充值实体对象
     * @return 活动ID
     */
    @Override
    public String createSkuRechargeOrder(SkuRechargeEntity skuRechargeEntity) {
        // 1. 参数校验
        String userId = skuRechargeEntity.getUserId();
        Long sku = skuRechargeEntity.getSku();
        String outBusinessNo = skuRechargeEntity.getOutBusinessNo();
        if (null == sku || StringUtils.isBlank(userId) || StringUtils.isBlank(outBusinessNo)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }
        
        // 2. 查询基础信息
        // a. 通过sku查询活动信息
        ActivitySkuEntity activitySkuEntity = queryActivitySku(sku);
        // b. 通过活动id 查询 活动信息
        ActivityEntity activityEntity = queryRaffleActivityByActivityId(activitySkuEntity.getActivityId());
        // c. 通过次数id 查询 次数信息
        ActivityCountEntity activityCountEntity = queryRaffleActivityCountByActivityCountId(
                activitySkuEntity.getActivityCountId());
        
        // 3. 活动动作规则校验(通过责任链的方式进行校验) todo 后续处理规则过滤流程，暂时也不处理责任链结果
        IActionChain actionChain = defaultActivityChainFactory.openActionChain();
        boolean success = actionChain.action(activitySkuEntity, activityEntity, activityCountEntity);
        
        // 4. 构建订单聚合对象
        CreateOrderAggregate createOrderAggregate = buildOrderAggregate(skuRechargeEntity, activitySkuEntity,
                activityEntity, activityCountEntity);
        
        // 5. 保存订单
        doSaveOrder(createOrderAggregate);
        
        // 6. 返回单号
        return createOrderAggregate.getActivityOrderEntity().getOrderId();
    }
    
    protected abstract CreateOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity,
            ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity,
            ActivityCountEntity activityCountEntity);
    
    protected abstract void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}
