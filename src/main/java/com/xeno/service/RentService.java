package com.xeno.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeno.domain.Rent;

public interface RentService {

    public boolean insertRent(Rent rent);

    public boolean updateNameById(Integer objects_id,String objects_name);

    public boolean updateStatusById(Integer id);

    public boolean updateReturnTimeById(Integer id,Integer days);

    public boolean updateValueById(Integer id,float value);

    public boolean updateDaysById(Integer id,Integer days);

    public int updateStatus();

    public int selectOverTimeNum(Integer user_id);

    public IPage<Rent> selectRentByPage(Integer currentPage, Integer pageSize, Integer user_id);

    public IPage<Rent> selectRentByPageAndName(Integer currentPage, Integer pageSize, Integer user_id, String objects_name);

    public Rent selectOneById(Integer id);

}
