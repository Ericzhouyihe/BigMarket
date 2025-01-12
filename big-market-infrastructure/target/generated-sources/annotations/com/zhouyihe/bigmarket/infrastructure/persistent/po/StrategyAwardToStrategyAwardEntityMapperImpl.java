package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.strategy.model.entity.StrategyAwardEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-12T19:59:51+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class StrategyAwardToStrategyAwardEntityMapperImpl implements StrategyAwardToStrategyAwardEntityMapper {

    @Override
    public StrategyAwardEntity convert(StrategyAward arg0) {
        if ( arg0 == null ) {
            return null;
        }

        StrategyAwardEntity strategyAwardEntity = new StrategyAwardEntity();

        strategyAwardEntity.setStrategyId( arg0.getStrategyId() );
        strategyAwardEntity.setAwardId( arg0.getAwardId() );
        strategyAwardEntity.setAwardTitle( arg0.getAwardTitle() );
        strategyAwardEntity.setAwardSubtitle( arg0.getAwardSubtitle() );
        strategyAwardEntity.setAwardCount( arg0.getAwardCount() );
        strategyAwardEntity.setAwardCountSurplus( arg0.getAwardCountSurplus() );
        strategyAwardEntity.setAwardRate( arg0.getAwardRate() );
        strategyAwardEntity.setSort( arg0.getSort() );

        return strategyAwardEntity;
    }

    @Override
    public StrategyAwardEntity convert(StrategyAward arg0, StrategyAwardEntity arg1) {
        if ( arg0 == null ) {
            return arg1;
        }

        arg1.setStrategyId( arg0.getStrategyId() );
        arg1.setAwardId( arg0.getAwardId() );
        arg1.setAwardTitle( arg0.getAwardTitle() );
        arg1.setAwardSubtitle( arg0.getAwardSubtitle() );
        arg1.setAwardCount( arg0.getAwardCount() );
        arg1.setAwardCountSurplus( arg0.getAwardCountSurplus() );
        arg1.setAwardRate( arg0.getAwardRate() );
        arg1.setSort( arg0.getSort() );

        return arg1;
    }
}
