package com.xeno.service;

import com.xeno.domain.User;

public interface UserService {

    public User selectById(Integer id);

    public boolean addNewUser(User user);

    public boolean updateUser(User user);

    public User selectByNameAndPassword(String username, String password);

    public User selectByName(String username);

    public boolean rentById(User user);

    public boolean updateMoneyById(Integer id,float money);

    public boolean updateUserById(Integer id, String username, String password, String phone, String address);
}