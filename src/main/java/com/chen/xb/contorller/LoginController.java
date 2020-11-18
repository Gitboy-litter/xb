package com.chen.xb.contorller;

import com.baomidou.kaptcha.Kaptcha;
import com.chen.xb.entity.Result;
import com.chen.xb.entity.User;
import com.chen.xb.service.UserService;
import com.chen.xb.utlis.Code;
import com.chen.xb.utlis.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.contorller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:38
 * @Version: 1.0
 */
@RestController
@RequestMapping("index")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private Kaptcha kaptcha;

    @GetMapping("/render")
    public void render() {
        kaptcha.render();
    }

    @GetMapping("login")
    public Result login(String username, String password, String code) {
        boolean validate = kaptcha.validate(code);
        if (!validate) {
            return new Result(false, "验证码不准确！");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = (User) userService.selectOne(user);
        if (loginUser != null) {
            return new Result(true, "登陆成功");
        }
        return new Result(false, "账号密码不正确！");
    }

    @PostMapping("register")
    public Result register(@RequestBody User user) {
        userService.insertSelective(user);
        return new Result(true, "注册成功");
    }

    @GetMapping("sendEmail")
    public Result sendEmail(String email, HttpSession session) {
        String code = Code.code();
        session.setAttribute("code", code);
        EmailUtil.sendEmail(email, code);
        return new Result(true, "发送成功，注意查看邮箱");
    }

    @GetMapping("forgetPassword")
    public Result forgetPassword(String email, String password, String code, HttpSession session) {
        String emailCode = (String) session.getAttribute("code");
        if (email != "" && emailCode.length() > 0) {
            if (!emailCode.equals(code)) {
                return new Result(false, "验证码不准确");
            }
            userService.updateUserByEmail(email, password);
        }
        return new Result(true, "修改成功");
    }
}
