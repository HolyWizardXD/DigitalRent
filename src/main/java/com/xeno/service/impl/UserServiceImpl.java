package com.xeno.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xeno.dao.UserDao;
import com.xeno.domain.User;
import com.xeno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addNewUser(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User selectByNameAndPassword(String username, String password) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username).eq(User::getPassword, password);
        return userDao.selectOne(lqw);
    }

    @Override
    public User selectByName(String username) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, username);
        return userDao.selectOne(lqw);
    }

    @Override
    public boolean rentById(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public boolean updateMoneyById(Integer id, float money) {
        User user = userDao.selectById(id);
        money = money + user.getMoney();
        return userDao.updateMoneyById(id,money) > 0;
    }

    @Override
    public boolean updateUserById(Integer id, String username, String password, String phone, String address) {
        return userDao.updateUserById(id,username,password,phone,address) > 0;
    }
}
