package com.chen.xb;

import com.chen.xb.dao.MeetingMapper;
import com.chen.xb.entity.Meeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.HighlightPage;

@SpringBootTest
class XbApplicationTests {

    @Autowired
    MeetingMapper meetingMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        HighlightPage<Meeting> ab = meetingMapper.findByTitleAndStatus("关于", 1L, PageRequest.of(0, 5));
        System.out.println(ab);
        System.out.println("abcd");
    }
}
