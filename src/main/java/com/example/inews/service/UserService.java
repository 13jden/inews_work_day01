package com.example.inews.service;

import com.example.inews.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface UserService extends IService<User> {

    User findByUsername(String username);

    boolean addUser(User user);

    boolean deleteById(String userId);

    List<User> searchuser(String word);

    boolean updateUser(User user);
}
