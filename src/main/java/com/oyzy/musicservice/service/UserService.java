package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.User;

import java.util.List;

public interface UserService {
    //严格增加，user可为空属性不许为空
    boolean addUser (User user);
    //模糊增加，user可为空属性可以为空
    int insertUser (User user);

    boolean veritypasswd(String name, String password);

    //依靠姓名查找用户
    List<User> selectByName(String username);
    //依靠id查找用户
    User selectByPrimaryKey(int id);

    //依靠id删除用户
    int deleteByPrimaryKey(int id);

    //根据id修改用户信息
    int updateByPrimaryKeyWithBLOBs(User user);

    //查找所有歌手
    List<User> allSinger(String issinger);
    //根据性别分类歌手
    List<User> genderSinger(String issinger,String gender);
    //查找所有用户
    List<User> allUser();


    boolean updateUserImg(User user);


}
