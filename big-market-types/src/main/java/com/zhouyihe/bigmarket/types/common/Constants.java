package com.zhouyihe.bigmarket.types.common;

public class Constants {
    
    public final static String SPLIT = ",";
    public final static String COLON = ":";
    public final static String SPACE = " ";
    public final static String UNDERLINE = "_";
    
    public static class RedisKey {
        
        // 存放 策略id 对应的策略信息(也是就strategy表中对应strategyId的一些基本信息--id,抽奖策略描述,策略的规则模型)
        public static String STRATEGY_KEY = "big_market_strategy_key_";
        public static String STRATEGY_AWARD_KEY = "big_market_strategy_award_key_";
        // 存放 策略id 对应的 奖品列表(strategy_award表中对应strategyId的一些基本信息,转成StrategyAwardEntity再存放)
        public static String STRATEGY_AWARD_LIST_KEY = "big_market_strategy_award_list_key_";
        // 存放 奖品的列表(按照每个奖品的概率形成的按比例的一定数量的集合,其中每种奖品都是按照概率的比例来的)乱序之后的列表
        public static String STRATEGY_RATE_TABLE_KEY = "big_market_strategy_rate_table_key_";
        // 存放 策略对应的奖品抽奖范围(奖品的份数) key:strategyId(策略id) value: 抽奖时随机的范围(策略下奖品的份数)
        public static String STRATEGY_RATE_RANGE_KEY = "big_market_strategy_rate_range_key_";
        // 存放 treeId 对应的 规则树对象
        public static String RULE_TREE_VO_KEY = "rule_tree_vo_key_";
        // 存放 奖品的库存总量 key: awardId(奖品的id) value:奖品的库存总量
        public static String STRATEGY_AWARD_COUNT_KEY = "strategy_award_count_key_";
        // 延迟队列,进行延迟减少库存量
        public static String STRATEGY_AWARD_COUNT_QUEUE_KEY = "strategy_award_count_queue_key";
        
        // 存放活动id 对应的 活动的实体 ActivityEntity
        public static String ACTIVITY_KEY = "big_market_activity_key_";
        // 存放活动id 对应的 活动的实体 ActivityEntity
        public static String ACTIVITY_SKU_KEY = "big_market_activity_sku_key_";
        // 存放活动数量ID activityCountId 对应的 活动数量实体类 ActivityCountEntity
        public static String ACTIVITY_COUNT_KEY = "big_market_activity_count_key_";
        // 延迟队列 进行sku商品库存数量的扣减 申明延迟队列的key
        public static final String ACTIVITY_SKU_COUNT_QUEUE_KEY = "activity_sku_count_queue_key";
        // 存放 sku 对应的物品的库存
        public static final String ACTIVITY_SKU_STOCK_COUNT_KEY = "activity_sku_stock_count_key_";
        
    }
}