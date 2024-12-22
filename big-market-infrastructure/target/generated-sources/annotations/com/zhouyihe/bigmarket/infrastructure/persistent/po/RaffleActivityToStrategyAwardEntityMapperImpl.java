package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T23:19:09+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class RaffleActivityToStrategyAwardEntityMapperImpl implements RaffleActivityToStrategyAwardEntityMapper {

    @Override
    public StrategyAwardEntity convert(RaffleActivity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        StrategyAwardEntity strategyAwardEntity = new StrategyAwardEntity();

        if ( arg0.getStrategyId() != null ) {
            strategyAwardEntity.setStrategyId( arg0.getStrategyId().longValue() );
        }

        return strategyAwardEntity;
    }

    @Override
    public StrategyAwardEntity convert(RaffleActivity arg0, StrategyAwardEntity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        if ( arg0.getStrategyId() != null ) {
            arg1.setStrategyId( arg0.getStrategyId().longValue() );
        }
        else {
            arg1.setStrategyId( null );
        }

        return arg1;
    }
}
