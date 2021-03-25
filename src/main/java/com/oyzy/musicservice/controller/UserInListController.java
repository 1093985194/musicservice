package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.pojo.UserInList;
import com.oyzy.musicservice.service.impl.UserInListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserInListController {

    @Autowired
    private UserInListServiceImpl userInListService;

    //增加用户与收藏歌单的联系
    @RequestMapping("/collection/adduserlist")
    public Object insert(HttpServletRequest req){
        JSONObject jsonObject = new JSONObject();
        int listid = Integer.parseInt(req.getParameter("listid"));
        int userid = Integer.parseInt(req.getParameter("userid"));

        UserInList userInList = new UserInList();
        userInList.setUserId(userid);
        userInList.setSonglistId(listid);


        int res = userInListService.insert(userInList);
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

    //根据用户id查找收藏/创造的歌单的id
    @GetMapping("/collection/listbyuser/{id}")
    public Object selectByUserId(@PathVariable("id") Integer id){
        return userInListService.selectByUserId(id);
    }

    //根据歌单id删除用户收藏的歌单
    @DeleteMapping("/collection/userlist/delete/{id}")
    public int deleteBySongListid(@PathVariable("id") Integer id){
        int i = userInListService.deleteBySongListid(id);
        return i;
    }

    //根用户id删除用户收藏的所有歌单
    @DeleteMapping("/collection/listuser/delete/{id}")
    public int deleteByuserid(@PathVariable("id") Integer id){
        int i = userInListService.deleteByuserid(id);
        return i;
    }

}
