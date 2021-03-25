package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.UserMapper;
import com.oyzy.musicservice.pojo.User;
import com.oyzy.musicservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSericeImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user) > 0? true:false;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean veritypasswd(String name, String password) {
        return userMapper.verifyPassword(name,password)>0?true:false;
    }

    @Override
    public List<User> selectByName(String username) {
        return userMapper.selectByName(username);
    }

    @Override
    public User selectByPrimaryKey(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(User user) {
        return userMapper.updateByPrimaryKeyWithBLOBs(user);
    }

    @Override
    public List<User> allSinger(String issinger) {
        return userMapper.allSinger(issinger);
    }

    @Override
    public List<User> genderSinger(String issinger, String gender) {
        return userMapper.genderSinger(issinger,gender);
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public boolean updateUserImg(User user) {
        return userMapper.updateUserImg(user) >0 ?true:false;
    }

}
