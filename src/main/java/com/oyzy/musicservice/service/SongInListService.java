package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.pojo.SongInList;

import java.util.List;

public interface SongInListService {

    //增加歌单-歌曲
    int insert(SongInList record);
    //根据歌单id查找收藏的歌曲的id
    List<Integer> selectBySongListId(int SongListId);

    int deleteBySongid(int SongId);

    int deleteBySongListid(int SongListId);

    int insertSelective(SongInList songInList);
}
