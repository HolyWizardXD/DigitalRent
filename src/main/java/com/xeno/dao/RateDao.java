package com.xeno.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeno.domain.Rate;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RateDao extends BaseMapper<Rate> {

    @Insert("insert into rate(user_id,name,evaluate,text,time) values(#{user_id},#{name},#{evaluate},#{text},now())")
    int addRate(Rate rate);

    @Update("update rate set evaluate=#{evaluate},text=#{text},time=now() where user_id=#{user_id}")
    int updateRate(Rate rate);

    @Update("update rate set name=#{name} where user_id=#{user_id}")
    int updateNameById(Integer user_id,String name);

}
