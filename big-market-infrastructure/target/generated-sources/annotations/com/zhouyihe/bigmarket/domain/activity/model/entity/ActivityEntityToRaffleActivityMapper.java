package com.zhouyihe.bigmarket.domain.activity.model.entity;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivity;
import com.zhouyihe.bigmarket.infrastructure.persistent.po.RaffleActivityToActivityEntityMapper;
import io.github.linpeilie.AutoMapperConfig__108;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__108.class,
    uses = {RaffleActivityToActivityEntityMapper.class},
    imports = {}
)
public interface ActivityEntityToRaffleActivityMapper extends BaseMapper<ActivityEntity, RaffleActivity> {
}
