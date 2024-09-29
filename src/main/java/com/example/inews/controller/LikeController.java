package com.example.inews.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Comment;
import com.example.inews.pojo.Like;
import com.example.inews.pojo.News;
import com.example.inews.service.CommentService;
import com.example.inews.service.LikeService;

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
//@Api(value = "点赞管理接口", tags = {"点赞"})
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    //添加点赞
    @PostMapping("/add")
    public String addNews(@RequestBody Map<String, String> like){
        Integer uid =Integer.valueOf(like.get("uid")) ;
        Integer nid =Integer.valueOf(like.get("nid")) ;
        Like like1 = new Like();
        like1.setNId(nid);
        like1.setUId(uid);
        like1.setCreateTime(new Date());
        likeService.addlike(like1);
        return "成功";
    }
    //删除点赞
    @DeleteMapping("/delete/{LikeId}")
    public boolean deleteNews(@PathVariable String LikeId) {
        return likeService.deleteById(LikeId);
    }

    //个人点赞查询
    @GetMapping("/get/{uid}/{page}")
    public IPage<Like> searchlike(@PathVariable String uid,@PathVariable int page) {
        return likeService.searchBynid(uid,page);
    }

    //news点赞数查询
    @GetMapping("/count/{nid}")
    public String  count(@PathVariable String nid) {
        return likeService.countlike(nid);
    }

}

