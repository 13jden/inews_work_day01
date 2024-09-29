package com.example.inews.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inews.pojo.User;
import com.example.inews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@RestController
//@Api(value = "用户信息管理接口", tags = {"user"})
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //用户登录
    @PostMapping("/login")
    public String userLogin(@RequestBody Map<String , String> user){
        String username = user.get("username");
        String password = user.get("password");
        User user1 = userService.findByUsername(username);
        System.out.println("正在查询");
        if (user1 == null) {
            return "用户不存在"; // 用户名不存在
        } else if (!user1.getPassword().equals(password)) {
            return "密码错误"; // 密码错误
        } else {
            return "登录成功";
        }
    }
    //用户注册
    @PostMapping("/add")
    public String addUeser(@RequestBody Map<String, String> user){
    String username = user.get("username");
    String password = user.get("password");
    User user1 = userService.findByUsername(username);
    if(user1!=null){
        return "用户名重复";
        }
    User user2 = new User();
    user2.setUsername(username);
    user2.setPassword(password);
    //插入时间
    user2.setCreateTime(new Date());
    boolean success = userService.addUser(user2);

        return success ? "用户添加成功" : "用户添加失败";
    }

    @PostMapping("/update")
    public String updateuser(@RequestBody Map<String,String> updateUser){
        User user1 = userService.getById(Integer.valueOf(updateUser.get("uid")));
        if (updateUser.get("password") != null) {
            user1.setPassword(updateUser.get("password"));
        }
        if (updateUser.get("nickname") != null) {
            user1.setNickName(updateUser.get("nickname"));
        }
        if (updateUser.get("avatar") != null) {
            user1.setAvatar(updateUser.get("avatar"));
        }
        if (updateUser.get("introduction") != null) {
            user1.setIntroduction(updateUser.get("introduction"));
        }
        if (updateUser.get("sex") != null) {
            user1.setSex(updateUser.get("sex"));
        }

        boolean success = userService.updateUser(user1); // 假设 updateUser 是你服务层的方法
        return success ? "用户信息更新成功" : "用户信息更新失败";
    }


    //删除用户
    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return userService.deleteById(userId);
    }

    //模糊查询
    @GetMapping("/search/{word}")
    public List<User> searchuser(@PathVariable String word) {
        return userService.searchuser(word);
    }
    //uid查询
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable String id){
        return userService.getById(id);
    }

}

