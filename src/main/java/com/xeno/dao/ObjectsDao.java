package com.xeno.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xeno.domain.Objects;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ObjectsDao extends BaseMapper<Objects> {

    @Update("update objects set stock=#{stock} where id=#{id}")
    int updateStockById(Integer stock,Integer id);
}
