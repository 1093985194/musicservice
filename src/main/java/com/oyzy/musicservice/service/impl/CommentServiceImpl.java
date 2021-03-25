package com.oyzy.musicservice.service.impl;

import com.oyzy.musicservice.dao.CommentMapper;
import com.oyzy.musicservice.pojo.Comment;
import com.oyzy.musicservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Comment record) {
        return commentMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Integer SongId) {
        return commentMapper.commentOfSongId(SongId);
    }

    @Override
    public List<Comment> commentOfUserId(Integer UserId) {
        return commentMapper.commentOfUserId(UserId);
    }

}
