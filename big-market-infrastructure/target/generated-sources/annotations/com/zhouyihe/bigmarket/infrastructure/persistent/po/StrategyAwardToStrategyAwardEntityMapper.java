package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntityToStrategyAwardMapper;
import io.github.linpeilie.AutoMapperConfig__104;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__104.class,
    uses = {StrategyAwardEntityToStrategyAwardMapper.class},
    imports = {}
)
public interface StrategyAwardToStrategyAwardEntityMapper extends BaseMapper<StrategyAward, StrategyAwardEntity> {
}
