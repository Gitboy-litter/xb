package com.chen.xb.dao;

import com.chen.xb.entity.Meeting;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MeetingMapper extends SolrCrudRepository<Meeting, Long> {
    @Highlight(fields = {"title"}, prefix = "<font color='red'>", postfix = "</font>")
    HighlightPage<Meeting> findByTitle(String title, Pageable pageable);

    @Highlight(fields = {"title"}, prefix = "<font color='red'>", postfix = "</font>")
    HighlightPage<Meeting> findByTitleAndStatus(String title, Long status, Pageable pageable);

    HighlightPage<Meeting> findByStatus(Long status, Pageable pageable);
}
