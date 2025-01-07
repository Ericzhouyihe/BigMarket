package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivitySku;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhouyihe
 * @since 2024-11-16
 * @description 商品sku dao
 */
@Mapper
public interface IRaffleActivitySkuDao {
    /**
     * 根据sku获得 抽奖活动sku 的对象
     * @param sku
     * @return
     */
    RaffleActivitySku queryActivitySku(Long sku);
    
    /**
     * 更新活动sku库存
     * @param sku
     */
    void updateActivitySkuStock(Long sku);
    
    /**
     * 清空数据库库存
     * @param sku
     */
    void clearActivitySkuStock(Long sku);
}
