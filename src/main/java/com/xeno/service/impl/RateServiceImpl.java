package com.xeno.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xeno.dao.RateDao;
import com.xeno.domain.Objects;
import com.xeno.domain.Rate;
import com.xeno.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDao rateDao;

    @Override
    public boolean addRate(Rate rate) {
        return rateDao.addRate(rate) > 0;
    }

    @Override
    public boolean updateRate(Rate rate) {
        return rateDao.updateRate(rate) > 0;
    }

    @Override
    public Rate selectByUserId(Integer user_id) {
        LambdaQueryWrapper<Rate> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Rate::getUser_id, user_id);
        return rateDao.selectOne(lqw);
    }

    @Override
    public boolean updateNameById(Integer user_id, String name) {
        return rateDao.updateNameById(user_id,name) > 0;
    }

    @Override
    public List<Rate> selectAll() {
        return rateDao.selectList(null);
    }

    @Override
    public IPage<Objects> PageOrderById(Integer currentPage, Integer pageSize) {
        IPage page = new Page(currentPage,pageSize);
        rateDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Objects> PageOrderByEvaluate(Integer currentPage, Integer pageSize) {
        LambdaQueryWrapper<Rate> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(Rate::getEvaluate);
        IPage page = new Page(currentPage,pageSize);
        rateDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Objects> PageOrderByTime(Integer currentPage, Integer pageSize) {
        LambdaQueryWrapper<Rate> lqw = new LambdaQueryWrapper<>();
        lqw.orderByDesc(Rate::getTime);
        IPage page = new Page(currentPage,pageSize);
        rateDao.selectPage(page,lqw);
        return page;
    }
}
