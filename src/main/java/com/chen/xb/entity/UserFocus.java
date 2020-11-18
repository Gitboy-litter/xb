package com.chen.xb.entity;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "userfocus")
public class UserFocus implements Serializable {

    private Long userId;

    private Long userFocusId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserFocusId() {
        return userFocusId;
    }

    public void setUserFocusId(Long userFocusId) {
        this.userFocusId = userFocusId;
    }
}
