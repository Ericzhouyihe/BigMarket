package com.zhouyihe.bigmarket.domain.activity.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T16:53:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class ActivityEntityToRaffleActivityMapperImpl implements ActivityEntityToRaffleActivityMapper {

    @Override
    public RaffleActivity convert(ActivityEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RaffleActivity raffleActivity = new RaffleActivity();

        if ( arg0.getActivityId() != null ) {
            raffleActivity.setActivityId( arg0.getActivityId().intValue() );
        }
        raffleActivity.setActivityName( arg0.getActivityName() );
        raffleActivity.setActivityDesc( arg0.getActivityDesc() );
        raffleActivity.setBeginDateTime( arg0.getBeginDateTime() );
        raffleActivity.setEndDateTime( arg0.getEndDateTime() );
        if ( arg0.getStrategyId() != null ) {
            raffleActivity.setStrategyId( arg0.getStrategyId().intValue() );
        }
        if ( arg0.getState() != null ) {
            raffleActivity.setState( arg0.getState().name() );
        }

        return raffleActivity;
    }

    @Override
    public RaffleActivity convert(ActivityEntity arg0, RaffleActivity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        if ( arg0.getActivityId() != null ) {
            arg1.setActivityId( arg0.getActivityId().intValue() );
        }
        else {
            arg1.setActivityId( null );
        }
        arg1.setActivityName( arg0.getActivityName() );
        arg1.setActivityDesc( arg0.getActivityDesc() );
        arg1.setBeginDateTime( arg0.getBeginDateTime() );
        arg1.setEndDateTime( arg0.getEndDateTime() );
        if ( arg0.getStrategyId() != null ) {
            arg1.setStrategyId( arg0.getStrategyId().intValue() );
        }
        else {
            arg1.setStrategyId( null );
        }
        if ( arg0.getState() != null ) {
            arg1.setState( arg0.getState().name() );
        }
        else {
            arg1.setState( null );
        }

        return arg1;
    }
}
