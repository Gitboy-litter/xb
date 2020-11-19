package com.chen.xb.contorller;

import com.chen.xb.entity.Meeting;
import com.chen.xb.entity.Result;
import com.chen.xb.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.contorller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("meeting")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @GetMapping("/{pageNum}/{pageSize}")
    public Result selectAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize, String title, Long status) {
        Page<Meeting> byTitle = meetingService.findByTitle(title, status, pageNum, pageSize);
        return new Result(true, "查询成功", byTitle);
    }
}
