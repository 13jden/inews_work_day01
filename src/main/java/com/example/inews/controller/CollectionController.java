package com.example.inews.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Collection;
import com.example.inews.pojo.News;
import com.example.inews.service.CollectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */

//@Api(value = "收藏管理接口", tags = {"新闻"})
@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    CollectionService collectionService;

    //添加收藏
    @PostMapping("/add")
    public boolean addNews(@RequestBody Map<String, String> collection){
        Integer uid =Integer.valueOf(collection.get("uid")) ;
        Integer nid =Integer.valueOf(collection.get("nid")) ;
        Collection collection1 =new Collection();
        collection1.setNId(nid);
        collection1.setUId(uid);
        return collectionService.addcollection(collection1);
    }

    //删除收藏
    @DeleteMapping("/delete/{collectionId}")
    public boolean deleteNews(@PathVariable String collectionId) {
        return collectionService.deleteById(collectionId);
    }

    //收藏查询
    @GetMapping("/search/{uid}/{page}")
    public IPage<Collection> searchuser(@PathVariable String uid , @PathVariable int page) {
        return collectionService.searchByuid(uid,page);
    }

    //news收藏数查询
    @GetMapping("/count/{nid}")
    public String  count(@PathVariable String nid) {
        return collectionService.countcollection(nid);
    }





}

