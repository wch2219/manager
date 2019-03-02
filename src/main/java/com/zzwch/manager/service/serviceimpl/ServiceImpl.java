package com.zzwch.manager.service.serviceimpl;


import com.alibaba.fastjson.JSON;
import com.zzwch.manager.entry.ReponceEnt.LoginRep;
import com.zzwch.manager.entry.ResultEntry.BaseResult;
import com.zzwch.manager.entry.ResultEntry.TUser;
import com.zzwch.manager.mapp.UserMapp;
import com.zzwch.manager.service.UserService;
import com.zzwch.manager.utils.CookieUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ServiceImpl implements UserService {
    @Resource
    private UserMapp testMapp;

    @Override
    public BaseResult login(LoginRep loginRep, HttpServletResponse response) {
        if (StringUtils.isEmpty(loginRep.getPhone())) {

            return new BaseResult(204, "账号空", null);
        }
        if (StringUtils.isEmpty(loginRep.getPassword())) {

            return new BaseResult(204, "密码空", null);
        }


        TUser tUser = testMapp.checkAcc(loginRep.getPhone());
        if (tUser == null) {

            return new BaseResult(204, "账号不存在", null);
        }
        try {
            Map<String,Object> login = testMapp.login(loginRep.getPhone(), loginRep.getPassword());
            if (login == null) {
                return new BaseResult(204, "账号密码错误", null);
            }
            String token = UUID.randomUUID().toString().replace("-", "");
            login.put("token",token);

            Map<String,Object> resultMap = new HashMap<>();

            String[] split = loginRep.getFields().split(",");

            for (int i = 0; i < split.length; i++) {

                resultMap.put(split[i],login.get(split[i]));
            }


            CookieUtil.set(response,token,token,30*60);
            return new BaseResult(200, "登录成功", resultMap);
        }catch (Exception e){
            System.out.println(e.toString()+"----------------");
            Throwable cause = e.getCause();
            String message = cause.getMessage();
            System.out.println(JSON.toJSONString(cause));
            return new BaseResult(204,"失败",message);
        }

    }
}
