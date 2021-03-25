package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.MasterMapper;
import com.oyzy.musicservice.pojo.Master;
import com.oyzy.musicservice.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterMapper masterMapper;
    @Override
    public boolean veritypasswd(String name, String password) {
        int i = masterMapper.verifyPassword(name, password);
        System.out.println("i="+i);
        return masterMapper.verifyPassword(name,password)>0?true:false;
    }

    @Override
    public int insert(Master master) {
        return masterMapper.insert(master);
    }

    @Override
    public int findMaster(String username, String password) {
        return masterMapper.findMaster(username,password);
    }

    @Override
    public Master selectByPrimaryKey(Integer mid) {
        return masterMapper.selectByPrimaryKey(mid);
    }
}
