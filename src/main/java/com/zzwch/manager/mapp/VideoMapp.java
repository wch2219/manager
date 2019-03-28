package com.zzwch.manager.mapp;

import com.github.pagehelper.Page;
import com.zzwch.manager.entry.ResultEntry.VideoInfo;
import org.apache.ibatis.annotations.Select;

public interface VideoMapp {

    @Select("select * from video_info")
    Page<VideoInfo> getVideoList(int pageindex, int pagesize);
}
