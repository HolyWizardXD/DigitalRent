package com.xeno.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeno.domain.Rent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RentDao extends BaseMapper<Rent> {

    @Insert("insert into rent(user_id,objects_id,objects_name,amount,value,days,rent_time,return_time,status) values(#{user_id},#{objects_id},#{objects_name},#{amount},#{value},#{days},curdate(),date_add(curdate(),interval #{days} day),1)")
    int insertRent(Rent rent);

    @Update("update rent set objects_name=#{objects_name} where objects_id=#{objects_id}")
    int updateNameById(Integer objects_id,String objects_name);

    @Update("update rent set Status=0 where id=#{id}")
    int updateStatusById(Integer id);

    @Update("update rent set Status=0 where curdate()>return_time")
    int updateStatus();

    @Select("select count(*) from rent where curdate()>return_time and status = 1 and user_id=#{user_id}")
    int selectOverTimeNum(Integer user_id);

    @Update("update rent set value=value+#{value} where id=#{id}")
    int updateValueById(Integer id,float value);

    @Update("update rent set days=days+#{days} where id=#{id}")
    int updateDaysById(Integer id,Integer days);

    @Update("update rent set return_time=date_add(return_time,interval #{days} day) where id=#{id}")
    int updateReturnTimeById(Integer id,Integer days);
}


