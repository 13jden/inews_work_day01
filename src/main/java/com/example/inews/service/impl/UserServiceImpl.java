package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.inews.pojo.User;
import com.example.inews.mapper.UserMapper;
import com.example.inews.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUsername(String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean addUser(User user){
        return userMapper.insert(user)>0;
    }

    @Override
    public boolean deleteById(String userId){
        return userMapper.deleteById(userId)>0;
    }

    @Override
    public List<User> searchuser(String word){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", word);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public boolean updateUser(User user){
        return userMapper.updateById(user)>0;
    }

}
