package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityToStrategyAwardEntityMapper;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAwardToStrategyAwardEntityMapper;
import io.github.linpeilie.AutoMapperConfig__101;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__101.class,
    uses = {StrategyAwardToStrategyAwardEntityMapper.class,RaffleActivityToStrategyAwardEntityMapper.class,StrategyAwardEntityToStrategyAwardMapper.class},
    imports = {}
)
public interface StrategyAwardEntityToRaffleActivityMapper extends BaseMapper<StrategyAwardEntity, RaffleActivity> {
}
