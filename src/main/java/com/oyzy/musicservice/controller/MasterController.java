package com.oyzy.musicservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.oyzy.musicservice.pojo.Master;
import com.oyzy.musicservice.service.impl.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class MasterController {

    @Autowired
    private MasterServiceImpl masterService;

    //新增管理员
    @GetMapping("/master/add")
    public Object addMaster(HttpServletRequest req){
        //JSONObject:把其他对象转换成JSONObject对象。
        JSONObject jsonObject = new JSONObject();
        //trim():去掉字符串两端的多余的空格
        String mastername = req.getParameter("mastername");
        String password = req.getParameter("password");
        if (mastername.equals("") || mastername == null){
            jsonObject.put("code", 0);
            jsonObject.put("msg", "管理员名错误");
            return jsonObject;
        }
        Master master = new Master();
        master.setName(mastername);
        master.setPassword(password);
        int insert = masterService.insert(master);
        if (insert==1){
            jsonObject.put("code", 1);
            jsonObject.put("msg", "注册成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "注册失败");
            return jsonObject;
        }


    }


    //    判断是否登录成功
    @RequestMapping(value = "/master/login/status", method = RequestMethod.POST)
    public Object loginStatus(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        int mid = masterService.findMaster(name, password);

        boolean res = masterService.veritypasswd(name, password);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "登录成功");
            jsonObject.put("mid", mid);
            session.setAttribute("name", name);
            session.setAttribute("mid", mid);
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }

    }

    @GetMapping("/master/findMaster")
    public Object findMaster(HttpServletRequest req, HttpSession session){
        JSONObject jsonObject = new JSONObject();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        int res = masterService.findMaster(name, password);
        if (res!=0) {
            jsonObject.put("code", res);
            jsonObject.put("msg", "登录成功");
            session.setAttribute("name", name);
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "用户名或密码错误");
            return jsonObject;
        }
    }

    @GetMapping("/master/findByid/{id}")
    public Master selectByPrimaryKey(@PathVariable("id") Integer id){
        return masterService.selectByPrimaryKey(id);
    }
}
