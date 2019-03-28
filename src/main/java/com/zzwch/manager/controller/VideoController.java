package com.zzwch.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzwch.manager.entry.ResultEntry.BaseResult;
import com.zzwch.manager.entry.ResultEntry.VideoInfo;
import com.zzwch.manager.service.VideoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController extends BaseController{
    @Resource
    VideoService mVideoService;
        @RequestMapping(value = "/videolist",method = RequestMethod.POST)
        public BaseResult getVideoList(@RequestParam("pageindex") int pageindex,@RequestParam("pagesize") int pagesize){
            PageHelper.startPage(pageindex, pagesize);
            List<VideoInfo> maps = mVideoService.videoList(pageindex,pagesize);
            PageInfo<VideoInfo> pageInfo = new PageInfo<>(maps);
            return new BaseResult(200,"成功",
                    pageInfo);
        }
}
