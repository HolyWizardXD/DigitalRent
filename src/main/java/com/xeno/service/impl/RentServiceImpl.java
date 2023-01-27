package com.xeno.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xeno.dao.RentDao;
import com.xeno.domain.Rent;
import com.xeno.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Override
    public boolean insertRent(Rent rent) {
        return rentDao.insertRent(rent) > 0;
    }

    @Override
    public boolean updateNameById(Integer objects_id, String objects_name) {
        return rentDao.updateNameById(objects_id,objects_name) > 0;
    }

    @Override
    public boolean updateStatusById(Integer id) {
        return rentDao.updateStatusById(id) > 0;
    }

    @Override
    public boolean updateReturnTimeById(Integer id, Integer days) {
        return rentDao.updateReturnTimeById(id,days) > 0;
    }

    @Override
    public boolean updateValueById(Integer id, float value) {
        return rentDao.updateValueById(id,value) > 0;
    }

    @Override
    public int updateStatus() {
        return rentDao.updateStatus();
    }

    @Override
    public int selectOverTimeNum(Integer user_id) {
        return rentDao.selectOverTimeNum(user_id);
    }

    @Override
    public boolean updateDaysById(Integer id, Integer days) {
        return rentDao.updateDaysById(id,days) > 0;
    }

    @Override
    public Rent selectOneById(Integer id) {
        LambdaQueryWrapper<Rent> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Rent::getId,id);
        return rentDao.selectOne(lqw);
    }

    @Override
    public IPage<Rent> selectRentByPage(Integer currentPage, Integer pageSize, Integer user_id) {
        LambdaQueryWrapper<Rent> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Rent::getStatus,1).eq(Rent::getUser_id,user_id);
        IPage page = new Page(currentPage,pageSize);
        rentDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Rent> selectRentByPageAndName(Integer currentPage, Integer pageSize, Integer user_id, String objects_name) {
        LambdaQueryWrapper<Rent> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Rent::getStatus,1).eq(Rent::getUser_id,user_id);
        lqw.like(Rent::getObjects_name,objects_name);
        IPage page = new Page(currentPage,pageSize);
        rentDao.selectPage(page,lqw);
        return page;
    }
}
