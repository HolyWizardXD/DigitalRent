package com.xeno.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeno.domain.Objects;
import com.xeno.domain.Rate;

import java.util.List;

public interface RateService {

    public boolean addRate(Rate rate);

    public boolean updateRate(Rate rate);

    public Rate selectByUserId(Integer user_id);

    public boolean updateNameById(Integer user_id,String name);

    public List<Rate> selectAll();

    public IPage<Objects> PageOrderById(Integer currentPage, Integer pageSize);

    public IPage<Objects> PageOrderByEvaluate(Integer currentPage, Integer pageSize);

    public IPage<Objects> PageOrderByTime(Integer currentPage, Integer pageSize);

}
