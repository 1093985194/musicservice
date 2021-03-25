package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.SongInList;
import com.oyzy.musicservice.service.impl.SongInListServiceImpl;
import com.oyzy.musicservice.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class SongInListController {

    @Autowired
    private SongInListServiceImpl songInListService;

    //增加歌单与被收藏歌曲的联系
    @GetMapping("/collection/addlistsong")
    public Object insert(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        int songid = Integer.parseInt(request.getParameter("songid"));
        int listid = Integer.parseInt(request.getParameter("listid"));

        SongInList songInList = new SongInList();
        songInList.setSongId(songid);
        songInList.setSonglistId(listid);

        int res = songInListService.insert(songInList);
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
    //通过歌单id查看歌单中歌曲
    @GetMapping("/collection/songbylist/{id}")
    public List<Integer> selectBySongListId(@PathVariable("id") Integer id){
        List<Integer> songs = songInListService.selectBySongListId(id);
        return songs;
    }
    //根据指定歌曲id删除歌单中的歌曲
    @DeleteMapping("/collection/listsong/delete/{id}")
    public int deleteBySongid(@PathVariable("id") Integer id){
        int i = songInListService.deleteBySongid(id);
        return i;
    }

    //根据指定歌单id删除歌单中的所有歌曲
    @DeleteMapping("/collection/songlist/delete/{id}")
    public int deleteBySongListid(@PathVariable("id") Integer id){
        int i = songInListService.deleteBySongListid(id);
        return i;
    }

}
