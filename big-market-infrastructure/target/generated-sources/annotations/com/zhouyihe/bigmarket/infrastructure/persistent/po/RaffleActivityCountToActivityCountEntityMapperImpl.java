package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T16:53:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class RaffleActivityCountToActivityCountEntityMapperImpl implements RaffleActivityCountToActivityCountEntityMapper {

    @Override
    public ActivityCountEntity convert(RaffleActivityCount arg0) {
        if ( arg0 == null ) {
            return null;
        }

        ActivityCountEntity activityCountEntity = new ActivityCountEntity();

        activityCountEntity.setActivityCountId( arg0.getActivityCountId() );
        activityCountEntity.setTotalCount( arg0.getTotalCount() );
        activityCountEntity.setDayCount( arg0.getDayCount() );
        activityCountEntity.setMonthCount( arg0.getMonthCount() );

        return activityCountEntity;
    }

    @Override
    public ActivityCountEntity convert(RaffleActivityCount arg0, ActivityCountEntity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        arg1.setActivityCountId( arg0.getActivityCountId() );
        arg1.setTotalCount( arg0.getTotalCount() );
        arg1.setDayCount( arg0.getDayCount() );
        arg1.setMonthCount( arg0.getMonthCount() );

        return arg1;
    }
}
