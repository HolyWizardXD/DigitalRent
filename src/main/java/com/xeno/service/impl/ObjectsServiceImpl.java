package com.xeno.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xeno.dao.ObjectsDao;
import com.xeno.domain.Objects;
import com.xeno.service.ObjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectsServiceImpl implements ObjectsService {

    @Autowired
    ObjectsDao objectsDao;

    @Override
    public List<Objects> selectAll() {
        return objectsDao.selectList(null);
    }

    @Override
    public Objects selectById(Integer id) {
        return objectsDao.selectById(id);
    }

    @Override
    public boolean addObject(Objects objects) {
        return objectsDao.insert(objects) > 0;
    }

    @Override
    public boolean deleteObject(Integer id) {
        return objectsDao.deleteById(id) > 0;
    }

    @Override
    public boolean updateObject(Objects objects) {
        return objectsDao.updateById(objects) > 0;
    }

    @Override
    public boolean updateStockById(Integer stock, Integer id) {
        return objectsDao.updateStockById(stock,id) > 0;
    }

    @Override
    public IPage<Objects> selectByBrand(Integer currentPage, Integer pageSize, String brand) {
        LambdaQueryWrapper<Objects> lqw = new LambdaQueryWrapper<>();
        lqw.gt(Objects::getStock,0);
        lqw.eq(Objects::getBrand,brand);
        IPage page = new Page(currentPage,pageSize);
        objectsDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Objects> selectByType(Integer currentPage, Integer pageSize, String type) {
        LambdaQueryWrapper<Objects> lqw = new LambdaQueryWrapper<Objects>();
        lqw.gt(Objects::getStock,0);
        lqw.eq(Objects::getType,type);
        IPage page = new Page(currentPage,pageSize);
        objectsDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Objects> selectByName(Integer currentPage, Integer pageSize, String name) {
        LambdaQueryWrapper<Objects> lqw = new LambdaQueryWrapper<Objects>();
        lqw.like(Objects::getName,name);
        IPage page = new Page(currentPage,pageSize);
        objectsDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Objects> selectByPage(Integer currentPage,Integer pageSize) {
        LambdaQueryWrapper<Objects> lqw = new LambdaQueryWrapper<Objects>();
        lqw.gt(Objects::getStock,0);
        IPage page = new Page(currentPage,pageSize);
        objectsDao.selectPage(page,lqw);
        return page;
    }

    @Override
    public IPage<Objects> selectByBrandAndType(Integer currentPage, Integer pageSize, String type, String brand) {
        LambdaQueryWrapper<Objects> lqw = new LambdaQueryWrapper<Objects>();
        IPage page = new Page(currentPage,pageSize);
        if(type.equals("0") && brand.equals("0")){
            objectsDao.selectPage(page,lqw);
        }else if(type.equals("0")){
            lqw.eq(Objects::getBrand,brand);
        }else if(brand.equals("0")){
            lqw.eq(Objects::getType,type);
        }else{
            lqw.eq(Objects::getType,type);
            lqw.eq(Objects::getBrand,brand);
        }
        return page;
    }
}
