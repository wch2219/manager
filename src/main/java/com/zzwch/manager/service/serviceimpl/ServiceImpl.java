package com.zzwch.manager.service.serviceimpl;


import com.zzwch.manager.entry.ReponceEnt.LoginRep;
import com.zzwch.manager.entry.ResultEntry.BaseResult;
import com.zzwch.manager.entry.ResultEntry.TUser;
import com.zzwch.manager.mapp.UserMapp;
import com.zzwch.manager.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class ServiceImpl implements UserService {
    @Resource
    private UserMapp testMapp;

    @Override
    public BaseResult login(LoginRep loginRep) {
        if (StringUtils.isEmpty(loginRep.getPhone())) {

            return new BaseResult(204, "账号空", null);
        }
        if (StringUtils.isEmpty(loginRep.getPsaaword())) {

            return new BaseResult(204, "密码空", null);
        }


        TUser tUser = testMapp.checkAcc(loginRep.getPhone());
        if (tUser == null) {

            return new BaseResult(204, "账号不存在", null);
        }

        TUser login = testMapp.login(loginRep.getPhone(), loginRep.getPsaaword());
        if (login == null) {
            return new BaseResult(204, "账号密码错误", null);
        }
        return new BaseResult(200, "登录成功", login);
    }
}
