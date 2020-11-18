package com.chen.xb.service.imp;

import com.chen.xb.dao.DeptMapper;
import com.chen.xb.entity.Dept;
import com.chen.xb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: xb
 * @Package: com.chen.xb.service.imp
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/11/17 19:43
 * @Version: 1.0
 */
@Service
public class DeptServiceImp extends BaseServiceImp<Dept, Long> implements DeptService<Dept, Long> {
    @Autowired
    private DeptMapper deptMapper;
    
}
