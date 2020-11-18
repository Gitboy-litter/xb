package com.chen.xb.service;

import com.chen.xb.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:39
 * @Version: 1.0
 */
public interface UserService<T, ID> extends BaseService<T, ID> {
    void updateUserByEmail(String email, String password);

    PageInfo<User> selectUser(Integer pageNum, Integer pageSize, String name);
}
