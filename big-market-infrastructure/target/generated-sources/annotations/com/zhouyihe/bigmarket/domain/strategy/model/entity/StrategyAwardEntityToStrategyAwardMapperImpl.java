package com.zhouyihe.bigmarket.domain.strategy.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.StrategyAward;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-23T16:53:01+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 1.8.0_401 (Oracle Corporation)"
)
@Component
public class StrategyAwardEntityToStrategyAwardMapperImpl implements StrategyAwardEntityToStrategyAwardMapper {

    @Override
    public StrategyAward convert(StrategyAwardEntity arg0) {
        if ( arg0 == null ) {
            return null;
        }

        StrategyAward strategyAward = new StrategyAward();

        strategyAward.setStrategyId( arg0.getStrategyId() );
        strategyAward.setAwardId( arg0.getAwardId() );
        strategyAward.setAwardTitle( arg0.getAwardTitle() );
        strategyAward.setAwardSubtitle( arg0.getAwardSubtitle() );
        strategyAward.setAwardCount( arg0.getAwardCount() );
        strategyAward.setAwardCountSurplus( arg0.getAwardCountSurplus() );
        strategyAward.setAwardRate( arg0.getAwardRate() );
        strategyAward.setSort( arg0.getSort() );

        return strategyAward;
    }

    @Override
    public StrategyAward convert(StrategyAwardEntity arg0, StrategyAward arg1) {
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
