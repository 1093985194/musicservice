package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.Master;

public interface MasterService {
    boolean veritypasswd(String name, String password);
    int insert(Master master);
    int findMaster(String username, String password);

    Master selectByPrimaryKey(Integer mid);
}
