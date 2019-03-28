package com.zzwch.manager.service.serviceimpl;

import com.zzwch.manager.entry.ResultEntry.VideoInfo;
import com.zzwch.manager.mapp.VideoMapp;
import com.zzwch.manager.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    VideoMapp videoMapp;


    @Override
    public List<VideoInfo> videoList(int pageindex, int pagesize) {
        return videoMapp.getVideoList(pageindex,pagesize);
    }
}
