package com.xeno.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeno.domain.Objects;

import java.util.List;

public interface ObjectsService {
    public List<Objects> selectAll();

    public Objects selectById(Integer id);

    public IPage<Objects> selectByPage(Integer currentPage, Integer pageSize);

    public boolean addObject(Objects objects);

    public boolean deleteObject(Integer id);

    public boolean updateObject(Objects objects);

    public boolean updateStockById(Integer stock,Integer id);

    public IPage<Objects> selectByBrand(Integer currentPage, Integer pageSize, String brand);

    public IPage<Objects> selectByType(Integer currentPage, Integer pageSize, String type);

    public IPage<Objects> selectByName(Integer currentPage, Integer pageSize, String name);

    public IPage<Objects> selectByBrandAndType(Integer currentPage, Integer pageSize, String type, String brand);
}
