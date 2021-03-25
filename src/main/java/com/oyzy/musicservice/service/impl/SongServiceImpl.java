package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.SongMapper;
import com.oyzy.musicservice.pojo.Song;
import com.oyzy.musicservice.pojo.User;
import com.oyzy.musicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    @Override
    public int insert(Song song) {
        return songMapper.insert(song);
    }

    @Override
    public List<Song> selectByName(String name) {
        return songMapper.selectByName(name);
    }

    @Override
    public int deleteByPrimaryKey(Integer songId) {
        return songMapper.deleteByPrimaryKey(songId);
    }

    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> selectByUserId(int userId) {
        return songMapper.selectByUserId(userId);
    }

    @Override
    public int updateByPrimaryKey(Song song) {
        return songMapper.updateByPrimaryKey(song);
    }

    @Override
    public Song selectByPrimaryKey(int songId) {
        return songMapper.selectByPrimaryKey(songId);
    }

    @Override
    public boolean updateSongImg(Song song) {
        return songMapper.updateSongImg(song) >0 ?true:false;
    }

    @Override
    public boolean updateSongUrl(Song song) {
        return songMapper.updateSongUrl(song) >0 ?true:false;
    }
}
