package com.xeno.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeno.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserDao extends BaseMapper<User> {

    @Update("update user set money=#{money} where id=#{id}")
    int updateMoneyById(Integer id,float money);

    @Update("update user set username=#{username},password=#{password},phone=#{phone},address=#{address} where id=#{id}")
    int updateUserById(Integer id,String username,String password,String phone,String address);
}
