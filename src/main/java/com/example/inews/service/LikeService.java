package com.example.inews.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Like;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.inews.pojo.News;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface LikeService extends IService<Like> {

    boolean addlike(Like like1);

    boolean deleteById(String likeId);

    IPage<Like> searchBynid(String uid,int page);


    String countlike(String nid);
}
