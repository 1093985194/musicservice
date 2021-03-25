package com.oyzy.musicservice.service;

import com.oyzy.musicservice.pojo.Comment;

import java.util.List;

public interface CommentService {
    //根据id删除
    int deleteByPrimaryKey(Integer id);
    //增加评论
    int insert(Comment record);
    //根据id选择评论
    Comment selectByPrimaryKey(Integer id);
    //更新评论
    int updateByPrimaryKeyWithBLOBs(Comment record);
    //显示所有评论
    List<Comment> allComment();
    //显示所在歌曲评论
    List<Comment> commentOfSongId(Integer SongId);
    //显示所在用户评论
    List<Comment> commentOfUserId(Integer UserId);

}
