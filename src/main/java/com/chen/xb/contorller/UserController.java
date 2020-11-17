package com.chen.xb.contorller;

import com.chen.xb.entity.Result;
import com.chen.xb.entity.User;
import com.chen.xb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.contorller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    public Result login(User user) {
        List<User> users = userService.selectAll();
        boolean flag = users.contains(user);
        if (flag) {
            return new Result(flag, "登陆成功");
        }
        return new Result(flag, "账号密码不正确！");
    }
}
