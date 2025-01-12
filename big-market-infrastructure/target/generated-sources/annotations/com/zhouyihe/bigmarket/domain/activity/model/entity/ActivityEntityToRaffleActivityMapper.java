package com.zhouyihe.bigmarket.domain.activity.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityToActivityEntityMapper;
import io.github.linpeilie.AutoMapperConfig__110;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__110.class,
    uses = {RaffleActivityToActivityEntityMapper.class},
    imports = {}
)
public interface ActivityEntityToRaffleActivityMapper extends BaseMapper<ActivityEntity, RaffleActivity> {
}
