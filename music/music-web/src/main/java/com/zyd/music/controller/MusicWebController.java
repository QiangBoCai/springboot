/**
 * Copyright [2016-2017] [yadong.zhang]
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zyd.music.controller;

import com.zyd.music.business.api.WangyiApi;
import com.zyd.music.business.model.WangyiPlay;
import com.zyd.music.business.vo.ResponseVO;
import com.zyd.music.business.service.WangyiPlayService;
import com.zyd.music.util.ResultUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yadong.zhang email:yadong.zhang0415(a)gmail.com
 * @version 1.0
 * @date 2018/3/5 19:05
 * @since 1.0
 */
@Slf4j
@Controller
public class MusicWebController {

    @Autowired
    private WangyiPlayService wangyiPlayService;

    @RequestMapping("/")
    public ModelAndView player() {
        return ResultUtil.view("index");
    }

    @RequestMapping("/index.html")
    public ModelAndView index() {
        return ResultUtil.view("index");
    }

    @RequestMapping("/music.html")
    public ModelAndView music() {
        return ResultUtil.view("music");
    }

    @RequestMapping("/playList")
    @ResponseBody
    public Object list() {
        WangyiPlay wangyiPlay = wangyiPlayService.getDefault();
        log.debug("playId="+wangyiPlay.getPlayId());
        return WangyiApi.getPlaylist(wangyiPlay.getPlayId());
    }

    @RequestMapping("/lrc/{musicId}")
    @ResponseBody
    public ResponseVO getLrc(@PathVariable("musicId") String musicId) {
        return WangyiApi.getLyric(musicId);
    }

}