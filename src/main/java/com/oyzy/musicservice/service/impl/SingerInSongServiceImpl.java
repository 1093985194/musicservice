package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.SingerInSongMapper;
import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.service.SingerInSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerInSongServiceImpl implements SingerInSongService {

    @Autowired
    private SingerInSongMapper singerInSongMapper;


    @Override
    public int insert(SingerInSong record) {
        return singerInSongMapper.insert(record);
    }

    @Override
    public List<Integer> selectByUserId(int UserId) {
        return singerInSongMapper.selectByUserId(UserId);
    }

    @Override
    public int deleteBySongid(Integer songid) {
        return singerInSongMapper.deleteBySongid(songid);
    }

    @Override
    public int deleteByuserid(Integer userid) {
        return singerInSongMapper.deleteByuserid(userid);
    }
}
