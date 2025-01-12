package com.zhouyihe.bigmarket.api.dto;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntityToRaffleAwardListResponseDTOMapper;
import io.github.linpeilie.AutoMapperConfig__109;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__109.class,
    uses = {StrategyAwardEntityToRaffleAwardListResponseDTOMapper.class},
    imports = {}
)
public interface RaffleAwardListResponseDTOToStrategyAwardEntityMapper extends BaseMapper<RaffleAwardListResponseDTO, StrategyAwardEntity> {
}
