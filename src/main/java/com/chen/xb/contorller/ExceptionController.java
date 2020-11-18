package com.chen.xb.contorller;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.chen.xb.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.controller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 16:07
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = KaptchaException.class)
    @ResponseBody
    public Result kaptchaExceptionHandler(KaptchaException kaptchaException) {
        if (kaptchaException instanceof KaptchaIncorrectException) {
            return new Result(false, "验证码不正确", null);
        } else if (kaptchaException instanceof KaptchaNotFoundException) {
            return new Result(false, "验证码未找到", null);
        } else if (kaptchaException instanceof KaptchaTimeoutException) {
            return new Result(false, "验证码过期", null);
        } else {
            return new Result(false, "验证码渲染失败", null);
        }

    }

    @ExceptionHandler
    @ResponseBody
    public Result exception(Exception e) {
        return new Result(false, e.getMessage(), null);
    }
}
