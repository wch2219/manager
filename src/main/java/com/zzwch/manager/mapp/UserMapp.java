package com.zzwch.manager.mapp;



import com.sun.istack.internal.NotNull;
import com.zzwch.manager.entry.ResultEntry.TUser;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


public interface UserMapp {
    @Select("select * from t_user where t_user.user_phone = #{user_phone}")
    TUser checkAcc(String phone);
    @Select("select * from t_user where t_user.user_phone = #{phone}and t_user.user_password = #{pass}")
//    @Select("select t_user.user_id,t_user.aa,t_user.bb from t_user")
    Map<String,Object> login(@NotNull() String phone, String pass);



}
