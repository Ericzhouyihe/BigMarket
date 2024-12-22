package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-13T23:19:09+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class StrategyAwardEntityToRaffleActivityMapperImpl implements StrategyAwardEntityToRaffleActivityMapper {

    @Override
    public RaffleActivity convert(StrategyAwardEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RaffleActivity raffleActivity = new RaffleActivity();

        if ( arg0.getStrategyId() != null ) {
            raffleActivity.setStrategyId( arg0.getStrategyId().intValue() );
        }

        return raffleActivity;
    }

    @Override
    public RaffleActivity convert(StrategyAwardEntity arg0, RaffleActivity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        if ( arg0.getStrategyId() != null ) {
            arg1.setStrategyId( arg0.getStrategyId().intValue() );
        }
        else {
            arg1.setStrategyId( null );
        }

        return arg1;
    }
}
