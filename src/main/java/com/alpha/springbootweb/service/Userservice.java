package com.alpha.springbootweb.service;


import com.alpha.springbootweb.model.User;

import java.util.List;

public  interface  Userservice{
    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

}