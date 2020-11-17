package com.chen.xb.entity;

import java.io.Serializable;


public class MeetingJoin implements Serializable {

    private Long uId;

    private Long mId;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }
}
