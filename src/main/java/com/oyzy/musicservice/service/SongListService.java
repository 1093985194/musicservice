package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.Songlist;
import com.oyzy.musicservice.pojo.User;

import java.util.List;

public interface SongListService {

    //增加歌单
    int insert(Songlist songlist);
    //删除歌单
    int deleteByPrimaryKey(Integer songlistId);
    //更新歌单
    int updateByPrimaryKey(Songlist record);
    //通过title查询歌单
    List<Songlist> selectByName(String title);
    //通过id查询歌单
    Songlist selectByPrimaryKey(Integer songlistId);
    //根据style分类歌手
    List<Songlist> SonglistStyle(String style);

    List<Songlist> allSongtList();
}
