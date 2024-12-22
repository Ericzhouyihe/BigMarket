package com.zhouyihe.bigmarket.domain.activity.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityCount;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityCountToActivityCountEntityMapper;
import io.github.linpeilie.AutoMapperConfig__104;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__104.class,
    uses = {RaffleActivityCountToActivityCountEntityMapper.class},
    imports = {}
)
public interface ActivityCountEntityToRaffleActivityCountMapper extends BaseMapper<ActivityCountEntity, RaffleActivityCount> {
}
