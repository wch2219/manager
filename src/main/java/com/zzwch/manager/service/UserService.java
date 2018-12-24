package com.zzwch.manager.service;


import com.zzwch.manager.entry.ReponceEnt.LoginRep;
import com.zzwch.manager.entry.ResultEntry.BaseResult;

import javax.servlet.http.HttpServletResponse;

public interface UserService {

    public BaseResult login(LoginRep loginRep, HttpServletResponse response);
}
