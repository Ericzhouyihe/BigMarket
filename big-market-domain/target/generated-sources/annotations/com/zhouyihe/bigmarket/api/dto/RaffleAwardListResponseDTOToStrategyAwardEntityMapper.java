package com.zhouyihe.bigmarket.api.dto;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntityToRaffleAwardListResponseDTOMapper;
import io.github.linpeilie.AutoMapperConfig__103;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__103.class,
    uses = {StrategyAwardEntityToRaffleAwardListResponseDTOMapper.class},
    imports = {}
)
public interface RaffleAwardListResponseDTOToStrategyAwardEntityMapper extends BaseMapper<RaffleAwardListResponseDTO, StrategyAwardEntity> {
}
