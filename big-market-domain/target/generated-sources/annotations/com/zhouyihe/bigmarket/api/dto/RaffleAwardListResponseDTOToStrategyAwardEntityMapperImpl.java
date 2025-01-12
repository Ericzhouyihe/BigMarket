package com.zhouyihe.bigmarket.api.dto;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T19:59:47+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class RaffleAwardListResponseDTOToStrategyAwardEntityMapperImpl implements RaffleAwardListResponseDTOToStrategyAwardEntityMapper {

    @Override
    public StrategyAwardEntity convert(RaffleAwardListResponseDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        StrategyAwardEntity strategyAwardEntity = new StrategyAwardEntity();

        strategyAwardEntity.setAwardId( arg0.getAwardId() );
        strategyAwardEntity.setAwardTitle( arg0.getAwardTitle() );
        strategyAwardEntity.setAwardSubtitle( arg0.getAwardSubtitle() );
        strategyAwardEntity.setSort( arg0.getSort() );

        return strategyAwardEntity;
    }

    @Override
    public StrategyAwardEntity convert(RaffleAwardListResponseDTO arg0, StrategyAwardEntity arg1) {
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
