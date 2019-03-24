package com.lee.world.service;


import com.lee.world.model.User;
import com.lee.world.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper usermapper;

    public User query(Integer id)
    {
        return usermapper.selectByPrimaryKey(id);
    }

    public String testApplicationContext()
    {
        return "applicationContext#####";
    }
}
