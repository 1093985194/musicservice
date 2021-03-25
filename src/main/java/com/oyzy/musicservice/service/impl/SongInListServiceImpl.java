package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.SongInListMapper;
import com.oyzy.musicservice.pojo.SongInList;
import com.oyzy.musicservice.service.SongInListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongInListServiceImpl implements SongInListService {

    @Autowired
    private SongInListMapper songInListMapper;

    @Override
    public int insert(SongInList record) {
        return songInListMapper.insert(record);
    }

    @Override
    public List<Integer> selectBySongListId(int SongListId) {
        return songInListMapper.selectBySongListId(SongListId);
    }

    @Override
    public int deleteBySongid(int SongId) {
        return songInListMapper.deleteBySongid(SongId);
    }

    @Override
    public int deleteBySongListid(int SongListId) {
        return songInListMapper.deleteBySongListid(SongListId);
    }

    @Override
    public int insertSelective(SongInList record) {
        return songInListMapper.insertSelective(record);
    }
}
