package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.pojo.Song;
import com.oyzy.musicservice.pojo.SongInList;
import com.oyzy.musicservice.service.impl.SingerInSongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SingerInSongController {

    @Autowired
    private SingerInSongServiceImpl singerInSongService;

    //增加用户与收藏歌曲的联系
    @RequestMapping("/collection/addusersong")
    public Object insertSong(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        int songid = Integer.parseInt(req.getParameter("songid"));
        int userid = Integer.parseInt(req.getParameter("userid"));

        SingerInSong singerInSong = new SingerInSong();
        singerInSong.setUserId(songid);
        singerInSong.setSongId(userid);


        int res = singerInSongService.insert(singerInSong);
        if (res==1){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "添加成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
            return jsonObject;
        }

    }

    //根据用户id查找收藏/创造的歌曲的id
    @GetMapping("/collection/songbyuser/{id}")
    public Object selectByUserId(@PathVariable("id") Integer id){
        return singerInSongService.selectByUserId(id);
    }

    //根据歌曲id删除用户收藏的歌曲
    @DeleteMapping("/collection/usersong/delete/{id}")
    public int deleteBySongid(@PathVariable("id") Integer id){
        int i = singerInSongService.deleteBySongid(id);
        return i;
    }

    //根据用户id删除指定用户收藏的所有歌曲
    @DeleteMapping("/collection/songuser/delete/{id}")
    public int deleteByuserid(@PathVariable("id") Integer id){
        int i = singerInSongService.deleteByuserid(id);
        return i;
    }

}
