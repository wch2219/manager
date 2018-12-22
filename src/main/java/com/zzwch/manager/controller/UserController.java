package com.zzwch.manager.controller;


import com.alibaba.fastjson.JSON;
import com.zzwch.manager.entry.ReponceEnt.LoginRep;
import com.zzwch.manager.entry.ResultEntry.BaseResult;
import com.zzwch.manager.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.net.InetAddress;
import java.util.*;

@RestController
@RequestMapping("/manager/user")
public class UserController extends BaseController{

    @Value("${spring.resources.static-locations}")
    private String uploadPath;

    @Value("${spring.mvc.static-path-pattern}")
    private String imagDownPath;

    private String Ip;
    @Resource
    private UserService service;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResult login(@RequestBody LoginRep loginRep){
//        LoginRep loginRep = new LoginRep();
//        loginRep.setPhone((String) map.get("phone"));
//        loginRep.setPsaaword((String) map.get("password"));

        BaseResult user = service.login(loginRep);
        System.out.println(JSON.toJSON(user));
        return user;
    }

    @PostMapping("/upload")
    public BaseResult upPic(@RequestParam("files")MultipartFile[] files){
        List<String> url = new ArrayList<>();

        if (files.length == 0) {
            return new BaseResult(204,"空",null);
        }
        for (MultipartFile file : files) {
            File targetFile = null;
            String imgPath = "";// 返回存储路径
            String fileName = file.getOriginalFilename();// 获取文件名加后缀
            if (fileName != null && fileName != "") {
                String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());// 文件后缀
                fileName = new Date().getTime() + "_" + new Random().nextInt(1000) + fileF;// 新的文件名
                // 先判断文件是否存在
                File dest = new File(uploadPath);
                // 如果文件夹不存在则创建
                if (!dest.exists() && !dest.isDirectory()) {
                    dest.mkdir();
                }
                targetFile = new File(dest, fileName);
                try {
                    file.transferTo(targetFile);
                    imgPath = uploadPath + fileName;
                    Ip = "http://"+InetAddress.getLocalHost().getHostAddress();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return new BaseResult(204,"失败",null);
                }
            }
            imgPath = Ip+":8080/"+imagDownPath + fileName;
            url.add(imgPath);

        }
        return new BaseResult(200,"成功",url);
    }
}
