package com.chen.xb.service.imp;

import com.chen.xb.dao.UserMapper;
import com.chen.xb.entity.User;
import com.chen.xb.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImp extends BaseServiceImp<User, Long> implements UserService<User, Long> {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateUserByEmail(String email, String password) {
        userMapper.updateUserByEmail(email, password);
    }

    @Override
    public PageInfo<User> selectUser(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectUser(name);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
