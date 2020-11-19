package com.chen.xb.service;

import com.chen.xb.entity.Meeting;
import org.springframework.data.domain.Page;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/18 13:14
 * @Version: 1.0
 */
public interface MeetingService {

    Page<Meeting> findByTitle(String title, Long status, Integer pageNum, Integer pageSize);
}
