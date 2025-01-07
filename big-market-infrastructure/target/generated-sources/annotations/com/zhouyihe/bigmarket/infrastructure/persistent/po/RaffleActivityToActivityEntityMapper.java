package com.zhouyihe.bigmarket.infrastructure.persistent.po;

import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntity;
import com.zhouyihe.bigmarket.domain.activity.model.entity.ActivityEntityToRaffleActivityMapper;
import io.github.linpeilie.AutoMapperConfig__108;
import io.github.linpeilie.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(
    config = AutoMapperConfig__108.class,
    uses = {ActivityEntityToRaffleActivityMapper.class},
    imports = {}
)
public interface RaffleActivityToActivityEntityMapper extends BaseMapper<RaffleActivity, ActivityEntity> {
}
