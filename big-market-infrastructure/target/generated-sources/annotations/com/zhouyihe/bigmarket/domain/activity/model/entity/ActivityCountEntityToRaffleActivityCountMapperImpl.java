package com.zhouyihe.bigmarket.domain.activity.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityCount;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T19:59:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class ActivityCountEntityToRaffleActivityCountMapperImpl implements ActivityCountEntityToRaffleActivityCountMapper {

    @Override
    public RaffleActivityCount convert(ActivityCountEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RaffleActivityCount raffleActivityCount = new RaffleActivityCount();

        raffleActivityCount.setActivityCountId( arg0.getActivityCountId() );
        raffleActivityCount.setTotalCount( arg0.getTotalCount() );
        raffleActivityCount.setDayCount( arg0.getDayCount() );
        raffleActivityCount.setMonthCount( arg0.getMonthCount() );

        return raffleActivityCount;
    }

    @Override
    public RaffleActivityCount convert(ActivityCountEntity arg0, RaffleActivityCount arg1) {
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
