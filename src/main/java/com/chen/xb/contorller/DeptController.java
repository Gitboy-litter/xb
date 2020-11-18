package com.chen.xb.contorller;

import com.chen.xb.entity.Dept;
import com.chen.xb.entity.Result;
import com.chen.xb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.contorller
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/18 13:14
 * @Version: 1.0
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("/{pageNum}/{pageSize}")
    public Result getDeptAll(@PathVariable Integer pageNum,@PathVariable Integer pageSize){
        List<Dept> list = deptService.selectAll();
        return new Result(true,"操作成功",list);
    }
}
