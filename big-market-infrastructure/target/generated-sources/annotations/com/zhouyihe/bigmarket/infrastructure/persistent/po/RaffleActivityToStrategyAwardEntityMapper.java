package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntityToRaffleActivityMapper;
import io.github.linpeilie.AutoMapperConfig__101;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__101.class,
    uses = {StrategyAwardEntityToRaffleActivityMapper.class},
    imports = {}
)
public interface RaffleActivityToStrategyAwardEntityMapper extends BaseMapper<RaffleActivity, StrategyAwardEntity> {
}
