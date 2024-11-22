package com.zhouyihe.bigmarket.api;

import com.zhouyihe.bigmarket.api.dto.RaffleAwardListRequestDTO;
import com.zhouyihe.bigmarket.api.dto.RaffleAwardListResponseDTO;
import com.zhouyihe.bigmarket.api.dto.RaffleRequestDTO;
import com.zhouyihe.bigmarket.api.dto.RaffleResponseDTO;
import com.zhouyihe.bigmarket.types.model.Response;

import java.util.List;

/**
 * @author ZhouYihe 1552951165@qq.com
 * @create 2024/11/19 15:57
 * @description 抽奖服务的接口
 */
public interface IRaffleService {
    
    /**
     * 策略装配接口
     * @param strategyId 策略id
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);
    
    /**
     * 查询抽奖奖品商品列表配置
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);
    
    /**
     * 随机抽奖接口
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);
}
