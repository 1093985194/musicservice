package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.SingerInSong;
import com.oyzy.musicservice.pojo.Song;
import com.oyzy.musicservice.pojo.User;
import com.oyzy.musicservice.service.impl.SingerInSongServiceImpl;
import com.oyzy.musicservice.service.impl.SongInListServiceImpl;
import com.oyzy.musicservice.service.impl.SongServiceImpl;
import com.oyzy.musicservice.service.impl.UserSericeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    private SongServiceImpl songService;
    @Autowired
    private SongInListServiceImpl songInListService;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
        /// 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(10, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/song/**").addResourceLocations("file:C:/Users/LaterNight/IdeaProjects/MusicService/img/song/");
            registry.addResourceHandler("/song/**").addResourceLocations("file:C:/Users/LaterNight/IdeaProjects/MusicService/song/");
        }
    }



    //增加歌曲
    @GetMapping("/song/add")
    public Object addMusic(HttpServletRequest req,@RequestParam("file") MultipartFile mpfile){
        JSONObject jsonObject = new JSONObject();
        String userid = req.getParameter("userid").trim();
        String name = req.getParameter("name").trim();
        String pic = "/img/song/maomao.jpg";

        if (mpfile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "音乐上传失败！");
            return jsonObject;
        }
        String fileName = mpfile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/song/"+fileName;
        try {
            mpfile.transferTo(dest);
            Song song = new Song();
            song.setUserId(Integer.parseInt(userid));
            song.setName(name);
            song.setImg(pic);
            song.setUrl(storeUrlPath);
            int res = songService.insert(song);
            if (res==1) {
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeUrlPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            } else {
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        } finally {
            return jsonObject;
        }
    }

    //    更新歌曲图片
    @ResponseBody
    @RequestMapping(value = "/song/img/update", method = RequestMethod.POST)
    public Object updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();

        if (urlFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "音乐上传失败！");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis()+urlFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/img/song/"+fileName;
        try {
            urlFile.transferTo(dest);
            Song song = songService.selectByPrimaryKey(id);
            song.setImg(storeUrlPath);
            int res = songService.updateByPrimaryKey(song);
            if (res==1){
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeUrlPath);
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





    //查找所有歌曲
    @GetMapping("/allSong")
    public List<Song> allMusic(){
        return songService.allSong();
    }
    //删除歌曲
    @DeleteMapping("/song/delete/{id}")
    public Object delMusicById(@PathVariable("id") Integer id){
        int i = songInListService.deleteBySongid(id);
        return songService.deleteByPrimaryKey(id);
    }
    //更新歌曲
    @PutMapping(value = "/song/update")
    public int updateUser(@RequestBody Song song){
        return songService.updateByPrimaryKey(song);
    }
    //通过id查找歌曲
    @GetMapping( "/song/findByid/{id}")
    public Song selectByPrimaryKey(@PathVariable("id") Integer id){
        return songService.selectByPrimaryKey(id);
    }

    @GetMapping("/song/findByUserid/{id}")
    public List<Song> selectByUserId(@PathVariable("id") Integer id){
        return songService.selectByUserId(id);
    }


}
