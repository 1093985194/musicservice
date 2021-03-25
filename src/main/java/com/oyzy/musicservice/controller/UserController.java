package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.User;
import com.oyzy.musicservice.service.impl.UserSericeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserSericeImpl userSerice;

    @Configuration
    public class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/user/**").addResourceLocations("file:C:/Users/LaterNight/IdeaProjects/MusicService/img/user/");
        }
    }

    //显示所有用户
    @GetMapping(value = "/allUser")
    public List<User> allUser(){
        return userSerice.allUser();
    }
    //显示所有歌手
    @GetMapping(value = "/allSinger")
    public List<User> allSinger(){
        return userSerice.allSinger("T");
    }
    //显示所有非歌手
    @GetMapping(value = "/NoSinger")
    public List<User> NoSinger(){
        return userSerice.allSinger("F");
    }

    //新增用户
    @PostMapping(value = "/user/add")
    public int addUser(@RequestBody User user){
        String img = "/img/user/user.jpg";
        user.setImg(img);
        return userSerice.insertUser(user);

    }

    //通过name查找用户
    @GetMapping(value = "/user/detail_name")
    public Object selectUserByName(HttpServletRequest request){
        String username = request.getParameter("username");
        return userSerice.selectByName(username);
    }

    //通过id查找用户
    @GetMapping( "/user/findByid/{id}")
    public User selectUserById(@PathVariable("id") Integer id){
        User user = userSerice.selectByPrimaryKey(id);
        return user;
    }

    //根据性别分类歌手
    @PostMapping(value = "/user/gender")
    public Object selectUserByGender(HttpServletRequest request){
        String gender = request.getParameter("gender");
        return userSerice.genderSinger("T",gender);
    }

    //删除用户
    @DeleteMapping(value = "/user/delete/{id}")
    public Object deletUser(@PathVariable("id") Integer id){
        return userSerice.deleteByPrimaryKey(id);
    }

    //更新用户
    @PutMapping(value = "/user/update")
    public int updateUser(@RequestBody User user){

        return userSerice.updateByPrimaryKeyWithBLOBs(user);
    }

    //    判断是否登录成功
    @RequestMapping(value = "/user/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session){

        JSONObject jsonObject = new JSONObject();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        System.out.println(username+"  "+password);
        boolean res = userSerice.veritypasswd(username, password);

        if (res){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            jsonObject.put("userMsg", userSerice.selectByName(username));
            session.setAttribute("username", username);
            return jsonObject;
        }else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }

    }


    //    更新用户头像
    @ResponseBody
    @RequestMapping(value = "/user/img/update", method = RequestMethod.POST)
    public Object updateUserPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        System.out.println("id="+id);

        if (avatorFile.isEmpty()) {
            System.out.println("1pass");
            jsonObject.put("code", 0);
            jsonObject.put("msg", "文件为空！");
            return jsonObject;
        }
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")+ "img" + System.getProperty("file.separator") + "user" ;
        File file1 = new File(filePath);
        if (!file1.exists()){
            file1.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeAvatorPath = "/img/user/"+fileName;
        try {
            avatorFile.transferTo(dest);
            User user = userSerice.selectByPrimaryKey(id);
            user.setImg(storeAvatorPath);
            int res = userSerice.updateByPrimaryKeyWithBLOBs(user);
            System.out.println("res="+res);
            if (res==1){
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeAvatorPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            }else {
                System.out.println("2pass");
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        }catch (IOException e){
            System.out.println("3pass");
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败"+e.getMessage());
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }
}

