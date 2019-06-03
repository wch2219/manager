package com.zzwch.manager.mapp;

import com.github.pagehelper.Page;
import com.zzwch.manager.entry.ResultEntry.VideoInfo;
import com.zzwch.manager.mapp.SqlUtils.VideoSql;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface VideoMapp {

    @Select("select * from video_info")
    @SelectProvider(type = VideoSql.class,method = "getVideoList")
    Page<VideoInfo> getVideoList(int pageindex, int pagesize);
}
