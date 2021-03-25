package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.pojo.UserInList;

import java.util.List;

public interface UserInListService {


    //增加用户收藏创造歌单
    int insert(UserInList record);
    //根据用户id查找收藏/创造的歌单的id
    List<Integer> selectByUserId(int UserId);



    int deleteBySongListid(Integer listid);

    int deleteByuserid(Integer userid);
}
