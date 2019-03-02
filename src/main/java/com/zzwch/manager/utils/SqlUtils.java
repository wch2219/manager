package com.zzwch.manager.utils;

public class SqlUtils {

    public  static String Login ="select * from t_user where t_user.user_phone = #{phone}and t_user.user_password = #{pass}";
}
