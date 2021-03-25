package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.SongMapper;
import com.oyzy.musicservice.dao.SonglistMapper;
import com.oyzy.musicservice.pojo.Songlist;
import com.oyzy.musicservice.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceImpl implements SongListService {

    @Autowired
    private SonglistMapper songlistMapper;

    @Override
    public int insert(Songlist songlist) {
        return songlistMapper.insert(songlist);
    }

    @Override
    public int deleteByPrimaryKey(Integer songlistId) {
        return songlistMapper.deleteByPrimaryKey(songlistId);
    }

    @Override
    public int updateByPrimaryKey(Songlist songlist) {
        return songlistMapper.updateByPrimaryKey(songlist);
    }

    @Override
    public List<Songlist> selectByName(String title) {
        return songlistMapper.selectByName(title);
    }

    @Override
    public Songlist selectByPrimaryKey(Integer songlistId) {
        return songlistMapper.selectByPrimaryKey(songlistId);
    }

    @Override
    public List<Songlist> SonglistStyle(String style) {
        return songlistMapper.SonglistStyle(style);
    }

    @Override
    public List<Songlist> allSongtList() {
        return songlistMapper.allSongList();
    }
}
