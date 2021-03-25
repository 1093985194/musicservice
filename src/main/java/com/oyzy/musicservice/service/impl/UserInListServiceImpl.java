package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.UserInListMapper;
import com.oyzy.musicservice.pojo.UserInList;
import com.oyzy.musicservice.service.UserInListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInListServiceImpl implements UserInListService {
    @Autowired
    private UserInListMapper userInListMapper;

    @Override
    public int insert(UserInList record) {
        return userInListMapper.insert(record);
    }

    @Override
    public List<Integer> selectByUserId(int UserId) {
        return userInListMapper.selectByUserId(UserId);
    }

    @Override
    public int deleteBySongListid(Integer listid) {
        return userInListMapper.deleteBySongListid(listid);
    }

    @Override
    public int deleteByuserid(Integer userid) {
        return userInListMapper.deleteByuserid(userid);
    }
}
