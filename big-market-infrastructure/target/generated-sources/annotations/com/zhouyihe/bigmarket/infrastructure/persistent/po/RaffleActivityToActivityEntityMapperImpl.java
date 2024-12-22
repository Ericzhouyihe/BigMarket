package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.valobj.ActivityStateVO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-19T23:51:25+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class RaffleActivityToActivityEntityMapperImpl implements RaffleActivityToActivityEntityMapper {

    @Override
    public ActivityEntity convert(RaffleActivity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ActivityEntity activityEntity = new ActivityEntity();

        if ( arg0.getActivityId() != null ) {
            activityEntity.setActivityId( arg0.getActivityId().longValue() );
        }
        activityEntity.setActivityName( arg0.getActivityName() );
        activityEntity.setActivityDesc( arg0.getActivityDesc() );
        activityEntity.setBeginDateTime( arg0.getBeginDateTime() );
        activityEntity.setEndDateTime( arg0.getEndDateTime() );
        if ( arg0.getStrategyId() != null ) {
            activityEntity.setStrategyId( arg0.getStrategyId().longValue() );
        }
        if ( arg0.getState() != null ) {
            activityEntity.setState( Enum.valueOf( ActivityStateVO.class, arg0.getState() ) );
        }

        return activityEntity;
    }

    @Override
    public ActivityEntity convert(RaffleActivity arg0, ActivityEntity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        if ( arg0.getActivityId() != null ) {
            arg1.setActivityId( arg0.getActivityId().longValue() );
        }
        else {
            arg1.setActivityId( null );
        }
        arg1.setActivityName( arg0.getActivityName() );
        arg1.setActivityDesc( arg0.getActivityDesc() );
        arg1.setBeginDateTime( arg0.getBeginDateTime() );
        arg1.setEndDateTime( arg0.getEndDateTime() );
        if ( arg0.getStrategyId() != null ) {
            arg1.setStrategyId( arg0.getStrategyId().longValue() );
        }
        else {
            arg1.setStrategyId( null );
        }
        if ( arg0.getState() != null ) {
            arg1.setState( Enum.valueOf( ActivityStateVO.class, arg0.getState() ) );
        }
        else {
            arg1.setState( null );
        }

        return arg1;
    }
}
