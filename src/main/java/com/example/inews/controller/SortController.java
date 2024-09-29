package com.example.inews.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inews.pojo.News;
import com.example.inews.pojo.Sort;
import com.example.inews.service.SortService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//@Api(value = "新闻分类管理接口", tags = {"分类"})
@RequestMapping("/sort")
public class SortController {
    @Autowired
    SortService sortService;

    //添加类别
    @PostMapping("/add")
    public String addNews(@RequestBody Map<String, String> newsort){
        Sort sort1 =new Sort();
        String sortname= newsort.get("sortname");
        sort1.setSortname(sortname);
        sortService.addsort(sort1);
        return "成功";
    }

    //删除类别
    @DeleteMapping("/delete/{sortId}")
    public boolean deleteNews(@PathVariable String sortId) {
        return sortService.deleteById(sortId);
    }

    //修改类别
    @PostMapping("/update")
    public boolean updateSort(@RequestBody Map<String , String> sort){
        String sortid = sort.get("id");
        String sortname = sort.get("sortname");
        Sort sort1 = sortService.getById(sortid);
        sort1.setSortname(sortname);
        return sortService.updateById(sort1);
    }

    //分类查询
    @GetMapping("/search/{sid}/{page}")
    public IPage<News> searchview(@PathVariable String sid,@PathVariable int page) {
        return sortService.getSortNews(sid,page);
    }
    //查询所有分类
    @GetMapping("/getlist")
    public List<Sort> sortList(){
        return sortService.list();
    }

}

