package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.Song;
import com.oyzy.musicservice.pojo.User;

import java.util.List;

public interface SongService {

    //增加歌曲
    int insert(Song song);

    //依靠姓名查找歌曲
    List<Song> selectByName(String name);

    //删除歌曲
    int deleteByPrimaryKey(Integer songId);

    //查找所有歌曲
    List<Song> allSong();

    //通过用户id查询歌曲
    List<Song> selectByUserId(int userId);

    int updateByPrimaryKey(Song song);
    Song selectByPrimaryKey(int songId);


    boolean updateSongImg(Song song);
    boolean updateSongUrl(Song song);

}
