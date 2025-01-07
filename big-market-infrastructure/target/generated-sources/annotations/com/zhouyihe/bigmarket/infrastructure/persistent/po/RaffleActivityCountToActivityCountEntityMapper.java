package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityCountEntityToRaffleActivityCountMapper;
import io.github.linpeilie.AutoMapperConfig__108;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__108.class,
    uses = {ActivityCountEntityToRaffleActivityCountMapper.class},
    imports = {}
)
public interface RaffleActivityCountToActivityCountEntityMapper extends BaseMapper<RaffleActivityCount, ActivityCountEntity> {
}
