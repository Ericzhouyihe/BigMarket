package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAward;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAwardToStrategyAwardEntityMapper;
import io.github.linpeilie.AutoMapperConfig__108;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__108.class,
    uses = {StrategyAwardToStrategyAwardEntityMapper.class},
    imports = {}
)
public interface StrategyAwardEntityToStrategyAwardMapper extends BaseMapper<StrategyAwardEntity, StrategyAward> {
}
