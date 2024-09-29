package com.example.inews.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface CommentService extends IService<Comment> {

    boolean addcomment(Comment comment1);

    boolean deleteById(String commentId);

    IPage<Comment> searchBynid(String id, int page);

    IPage<Comment> searchBycid(String id, int page);
}
