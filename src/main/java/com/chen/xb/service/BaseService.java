package com.chen.xb.service;

import java.util.List;

/**
 * @ProjectName: guguanjia
 * @Package: com.chen.service
 * @Author: ChenZengWen
 * @Description: 描述
 * @Date: 2020/10/22 15:49
 * @Version: 1.0
 */
public interface BaseService<T, ID> {

    int deleteByPrimaryKey(ID id);


    int delete(T t);


    int insert(T t);


    int insertSelective(T t);


    boolean existsWithPrimaryKey(ID id);


    List<T> selectAll();


    T selectByPrimaryKey(ID id);


    int selectCount(T t);


    List<T> select(T t);


    T selectOne(T t);


    int updateByPrimaryKey(T t);


    int updateByPrimaryKeySelective(T t);


}
