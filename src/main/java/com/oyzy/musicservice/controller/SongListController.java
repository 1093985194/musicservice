package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.Songlist;
import com.oyzy.musicservice.pojo.User;
import com.oyzy.musicservice.service.impl.SongListServiceImpl;
import com.oyzy.musicservice.service.impl.UserSericeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class SongListController {

    @Autowired
    private SongListServiceImpl songListService;


    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songlist/**").addResourceLocations("file:C:/Users/LaterNight/IdeaProjects/MusicService/img/songlist/");
        }
    }


    @GetMapping(value = "/songlist/all")
    public List<Songlist> allSongtList(){
        return songListService.allSongtList();
    }

    //增加歌单
    @PostMapping("/songlist/add")
    public Object insertsonglist(@RequestBody Songlist songlist){
        String img = "/img/songlist/list.jpg";
        songlist.setImg(img);
        return songListService.insert(songlist);
    }

    //删除歌单
    @DeleteMapping("/songlist/del/{id}")
    public Object deleteByPrimaryKey(@PathVariable("id") Integer id){
        return songListService.deleteByPrimaryKey(id);
    }

    //更新歌单
    @PutMapping("/songlist/update")
    public Object updateByPrimaryKey(@RequestBody Songlist songlist){
        return songListService.updateByPrimaryKey(songlist);
    }


    //通过title查询歌单
    @GetMapping("/songlist/title")
    public Object selectByName(HttpServletRequest request){
        String title = request.getParameter("title");
        return songListService.selectByName(title);
    }

    //通过id查询歌单属性信息
    @GetMapping("/songlist/findByid/{id}")
    public Songlist selectByPrimaryKey(@PathVariable("id") Integer id){
        return songListService.selectByPrimaryKey(id);
    }

    //根据style分类歌单
    @GetMapping("/songlist/style")
    public Object SonglistStyle(HttpServletRequest request){
        String style = request.getParameter("style");
        return songListService.SonglistStyle(style);
    }


    //    更新歌单图片
    @ResponseBody
    @RequestMapping(value = "/songList/img/update", method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();

        if (avatorFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "文件上传失败！");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songlist" ;
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatorPath = "/img/songlist/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Songlist songList = songListService.selectByPrimaryKey(id);
            songList.setImg(storeAvatorPath);
            int res = songListService.updateByPrimaryKey(songList);
            if (res==1){
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeAvatorPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            }else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        }catch (IOException e){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }
}
