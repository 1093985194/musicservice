package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.SingerInSong;

import java.util.List;

public interface SingerInSongService {

    //增加用户收藏创造歌曲
    int insert(SingerInSong record);
    //根据用户id查找收藏/创造的歌曲的id
    List<Integer> selectByUserId(int UserId);

    int deleteBySongid(Integer songid);

    int deleteByuserid(Integer userid);

}
