package com.chen.xb.service.imp;

import com.chen.xb.dao.MeetingMapper;
import com.chen.xb.entity.Meeting;
import com.chen.xb.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.service.imp
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:43
 * @Version: 1.0
 */
@Service
public class MeetingServiceImp implements MeetingService {
    @Autowired
    public MeetingMapper meetingMapper;

    @Override
    public Page<Meeting> findByTitle(String title, Long status, Integer pageNum, Integer pageSize) {
        HighlightPage<Meeting> byTitle;
        if (title != null && title != "") {
            byTitle = meetingMapper.findByTitle(title, PageRequest.of(pageNum-1, pageSize));
            if (status != null) {
                byTitle = meetingMapper.findByTitleAndStatus(title, status, PageRequest.of(pageNum-1, pageSize));
            }
            List<HighlightEntry<Meeting>> highlighted = byTitle.getHighlighted();
            for (HighlightEntry<Meeting> goodsHighlightEntry : highlighted) {
                List<HighlightEntry.Highlight> highlights = goodsHighlightEntry.getHighlights();
                for (HighlightEntry.Highlight highlight : highlights) {
                    if ("title".equals(highlight.getField().getName())) {
                        goodsHighlightEntry.getEntity().setTitle(highlight.getSnipplets().get(0));
                    }
                }
            }
        } else {
            if (status != null) {
                byTitle = meetingMapper.findByStatus(status, PageRequest.of(pageNum-1, pageSize));
            } else {
                return meetingMapper.findAll(PageRequest.of(pageNum-1, pageSize));
            }
        }
        return byTitle;
    }
}
