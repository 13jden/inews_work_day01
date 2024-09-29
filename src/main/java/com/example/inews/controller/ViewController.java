package com.example.inews.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.View;
import com.example.inews.service.CollectionService;
import com.example.inews.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
//@Api(value = "浏览记录管理接口", tags = {"浏览"})
@RequestMapping("/view")
public class ViewController {
    @Autowired
    ViewService viewService;

    //添加阅读
    @PostMapping("/add")
    public String addNews(@RequestBody Map<String, String> view){
        String uid = view.get("uid");
        String nid = view.get("nid");
        View view1=new View();
        view1.setCreateTime(new Date());
        view1.setNId(Integer.valueOf(nid));
        view1.setUId(Integer.valueOf(uid));
        viewService.insertview(view1);
        return "成功";
    }

    //删除阅读记录
    @DeleteMapping("/delete/{viewId}")
    public boolean deleteNews(@PathVariable String viewId) {
        return viewService.deleteById(viewId);
    }

    //查询阅读记录
    @GetMapping("/search/{uid}/{page}")
    public Page<News> searchview(@PathVariable String uid,@PathVariable Integer page) {
        return viewService.searchByuid(page,uid);
    }

}

