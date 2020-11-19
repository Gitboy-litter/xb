package com.chen.xb.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.util.Date;

@SolrDocument(collection = "collection1")
public class Meeting implements Serializable {

    @Id
    @Field("id")
    private Long id;
    @Field("dept_name")
    private String deptName;
    @Field("dept_id")
    private Long deptId;
    @Field
    private String title;
    @Field
    private String content;
    @Field("publish_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date publishDate;
    @Field("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @Field("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    @Field
    private Long status;
    @Field("make_user")
    private String makeUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getMakeUser() {
        return makeUser;
    }

    public void setMakeUser(String makeUser) {
        this.makeUser = makeUser;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", makeUser='" + makeUser + '\'' +
                '}';
    }
}
