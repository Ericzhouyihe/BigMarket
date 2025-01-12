package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.api.dto.RaffleAwardListResponseDTO;
import com.zhouyihe.bigmarket.api.dto.RaffleAwardListResponseDTOToStrategyAwardEntityMapper;
import io.github.linpeilie.AutoMapperConfig__109;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__109.class,
    uses = {RaffleAwardListResponseDTOToStrategyAwardEntityMapper.class},
    imports = {}
)
public interface StrategyAwardEntityToRaffleAwardListResponseDTOMapper extends BaseMapper<StrategyAwardEntity, RaffleAwardListResponseDTO> {
}