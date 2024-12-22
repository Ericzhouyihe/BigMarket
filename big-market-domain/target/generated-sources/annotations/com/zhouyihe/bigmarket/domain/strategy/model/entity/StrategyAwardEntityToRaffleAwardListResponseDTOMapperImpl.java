package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.api.dto.RaffleAwardListResponseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-19T23:51:21+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class StrategyAwardEntityToRaffleAwardListResponseDTOMapperImpl implements StrategyAwardEntityToRaffleAwardListResponseDTOMapper {

    @Override
    public RaffleAwardListResponseDTO convert(StrategyAwardEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RaffleAwardListResponseDTO raffleAwardListResponseDTO = new RaffleAwardListResponseDTO();

        raffleAwardListResponseDTO.setAwardId( arg0.getAwardId() );
        raffleAwardListResponseDTO.setAwardTitle( arg0.getAwardTitle() );
        raffleAwardListResponseDTO.setAwardSubtitle( arg0.getAwardSubtitle() );
        raffleAwardListResponseDTO.setSort( arg0.getSort() );

        return raffleAwardListResponseDTO;
    }

    @Override
    public RaffleAwardListResponseDTO convert(StrategyAwardEntity arg0, RaffleAwardListResponseDTO arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        arg1.setAwardId( arg0.getAwardId() );
        arg1.setAwardTitle( arg0.getAwardTitle() );
        arg1.setAwardSubtitle( arg0.getAwardSubtitle() );
        arg1.setSort( arg0.getSort() );

        return arg1;
    }
}
