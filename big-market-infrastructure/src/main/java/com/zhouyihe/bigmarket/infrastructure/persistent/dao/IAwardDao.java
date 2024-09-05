package com.zhouyihe.bigmarket.infrastructure.persistent.dao;

import com.zhouyihe.bigmarket.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.stream.BaseStream;

/**
 * @ClassName IAwardDao
 * @author: ZhouYihe
 * @qq: 1552951165
 * @date: 2024/9/5
 * @description: 奖品表DAO
 */
@Mapper
public interface IAwardDao {
    
    List<Award> queryAwardList();
}
