package com.demo.core.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.demo.core.mapper.BaseMapper;
import com.demo.core.mapper.UserMapper;
import com.demo.core.service.BaseService;

@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {

    @Resource
    protected BaseMapper baseMapper;
    @Resource
    protected UserMapper userMapper;

    @PostConstruct
    public void init() throws Exception {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class clazz = (Class) type.getActualTypeArguments()[0];
        // 1: 根据具体的泛型, 获取相应的Field字段
        String clazzName = clazz.getSimpleName();
        String clazzDaoName = clazzName.substring(0, 1).toLowerCase() + clazzName.substring(1) + "Mapper";
        Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDaoName);
        // 2: 获取baseMapper Filed字段
        Field baseField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
        // 3: 把TDao的值赋值给baseDao
        baseField.set(this, clazzField.get(this));
        System.out.println("baseDao:" + baseMapper);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return (T) baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

}
