package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.Comment;
import com.oyzy.musicservice.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    //删除评论
    @DeleteMapping("/comm/delete/{id}")
    public Object deleteByPrimaryKey(@PathVariable("id") Integer id){
        return commentService.deleteByPrimaryKey(id);
    }
    //增加评论
    @PostMapping("/comm/add")
    public Object insertComm(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int userid = Integer.parseInt(request.getParameter("userid"));
        int songid = Integer.parseInt(request.getParameter("songid"));
        int good = Integer.parseInt(request.getParameter("good"));
        String contxt = request.getParameter("contxt");

        Comment comment = new Comment();
        comment.setGood(good);
        comment.setUserId(userid);
        comment.setSongId(songid);
        comment.setContent(contxt);
        int insert = commentService.insert(comment);
        if (insert==0){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "评论成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "评论失败");
            return jsonObject;
        }

    }

    //更新评论
    @PostMapping("/comm/updata")
    public Object updateByPrimaryKeyWithBLOBs(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int commid = Integer.parseInt(request.getParameter("commid"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        int songid = Integer.parseInt(request.getParameter("songid"));
        int good = Integer.parseInt(request.getParameter("good"));
        String contxt = request.getParameter("contxt");

        Comment comment = new Comment();
        comment.setCommentId(commid);
        comment.setGood(good);
        comment.setUserId(userid);
        comment.setSongId(songid);
        comment.setContent(contxt);

        int res = commentService.updateByPrimaryKeyWithBLOBs(comment);
        if (res==1){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }

    }

    //显示所有评论
    @GetMapping("/comm")
    public Object allComment(){
        return commentService.allComment();
    }

    //显示所在歌曲评论
    @GetMapping("/comm/song/{id}")
    public Object commentOfSongId(@PathVariable("id") Integer id){
        return commentService.commentOfSongId(id);
    }

    //显示所在用户评论
    @GetMapping("/comm/user/{id}")
    public Object commentOfUserId(@PathVariable("id") Integer id){
        return commentService.commentOfUserId(id);
    }


}
