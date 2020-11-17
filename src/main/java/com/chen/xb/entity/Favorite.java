package com.chen.xb.entity;

import java.io.Serializable;

public class Favorite implements Serializable {

    private Long uId;

    private Long aId;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
        this.aId = aId;
    }
}
