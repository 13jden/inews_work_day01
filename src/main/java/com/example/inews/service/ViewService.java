package com.example.inews.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.View;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface ViewService extends IService<View> {

    void insertview(View view1);

    boolean deleteById(String viewId);

    Page<News> searchByuid(Integer page,String uid);
}
