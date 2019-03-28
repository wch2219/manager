package com.zzwch.manager.mapp;


import com.zzwch.manager.entry.ResultEntry.TUser;
import com.zzwch.manager.mapp.SqlUtils.UserSelect;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Map;


public interface UserMapp {
    @Select("select * from t_user where t_user.user_phone = #{user_phone}")
    TUser checkAcc(String phone);

    @SelectProvider(type = UserSelect.class,method = "selectUser")
    Map<String,Object> login( @Param("phone") String phone, @Param("pass") String pass,@Param("fieleds") String fieleds);



}
