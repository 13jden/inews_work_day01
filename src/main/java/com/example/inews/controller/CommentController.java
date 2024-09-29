package com.example.inews.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Comment;
import com.example.inews.pojo.News;
import com.example.inews.service.CommentService;

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
//@Api(value = "评论管理接口", tags = {"评论"})
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    //添加评论
    @PostMapping("/add")
    public boolean addNews(@RequestBody Map<String, String> comment){
        Integer uid =Integer.valueOf(comment.get("uid")) ;
        Integer nid =Integer.valueOf(comment.get("nid")) ;
        String cContent = comment.get("ccontent");
        Comment comment1 = new Comment();
        comment1.setCContent(cContent);
        comment1.setNId(nid);
        comment1.setUId(uid);
        comment1.setCreateTime(new Date());
        if(comment.get("parentCommentId")!=null){
            comment1.setParentCommentId(Integer.valueOf(comment.get("parentCommentId")));
        }
        return commentService.addcomment(comment1);
    }
    //删除评论
    @DeleteMapping("/delete/{commentId}")
    public boolean deleteNews(@PathVariable String commentId) {
        return commentService.deleteById(commentId);
    }

    //评论查询
    @GetMapping("/nid/{id}/{page}")
    public IPage<Comment> searchcomment0(@PathVariable String id,@PathVariable int page) {
        return commentService.searchBynid(id,page);
    }

    //子评论查询
    @GetMapping("/pid/{pid}/{page}")
    public IPage<Comment> searchcomment(@PathVariable String pid , @PathVariable int page) {
        return commentService.searchBycid(pid,page);
    }

}

