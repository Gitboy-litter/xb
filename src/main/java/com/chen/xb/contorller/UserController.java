package com.chen.xb.contorller;

import com.chen.xb.entity.Result;
import com.chen.xb.entity.User;
import com.chen.xb.entity.UserFocus;
import com.chen.xb.service.UserFocusService;
import com.chen.xb.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.contorller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/18 13:26
 * @Version: 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserFocusService userFocusService;

    @RequestMapping("/{pageNum}/{pageSize}")
    public Result getUserList(@PathVariable Integer pageNum, @PathVariable Integer pageSize, String name) {
        if (name == null) {
            name = "";
        }
        PageInfo pageInfo = userService.selectUser(pageNum, pageSize, name);
        return new Result(true, "操作成功", pageInfo);
    }

    @RequestMapping("myfocus")
    public Result getMyFocus(HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(1L);
        List<UserFocus> select = userFocusService.select(userFocus);
        return new Result(true, "查询成功", select);
    }

    @RequestMapping(value = "changeFocus/{id}", method = RequestMethod.POST)
    public Result changeFocus(@PathVariable Long id, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(1L);
        userFocus.setUserFocusId(id);
        userFocusService.insert(userFocus);
        return new Result(true, "关注成功");
    }

    @RequestMapping(value = "deleteFocus/{id}", method = RequestMethod.DELETE)
    public Result deleteFocus(@PathVariable Long id, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(1L);
        userFocus.setUserFocusId(id);
        userFocusService.delete(userFocus);
        return new Result(true, "取关成功");
    }
    @RequestMapping(value = "abc/{id}", method = RequestMethod.DELETE)
    public Result abc(@PathVariable Long id, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        UserFocus userFocus = new UserFocus();
        userFocus.setUserId(1L);
        userFocus.setUserFocusId(id);
        userFocusService.delete(userFocus);
        return new Result(true, "取关成功");
    }
}
