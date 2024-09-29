package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Comment;
import com.example.inews.mapper.CommentMapper;
import com.example.inews.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addcomment(Comment comment1){
        return commentMapper.insert(comment1)>0;
    }

    @Override
    public boolean deleteById(String commentId){
        return commentMapper.deleteById(commentId)>0;
    }

    @Override
    public IPage<Comment> searchBynid(String id, int page){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id" , id);
        Page<Comment> commentPage = new Page<>(page,15);
        IPage<Comment> Result = commentMapper.selectPage(commentPage,queryWrapper);
        return Result;
    }

    @Override
    public IPage<Comment> searchBycid(String id, int page){
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_comment_id" , id);
        Page<Comment> commentPage = new Page<>(page,15);
        IPage<Comment> Result = commentMapper.selectPage(commentPage,queryWrapper);
        return Result;
    }

}
