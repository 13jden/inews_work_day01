package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.mapper.NewsMapper;
import com.example.inews.pojo.News;
import com.example.inews.pojo.View;
import com.example.inews.mapper.ViewMapper;
import com.example.inews.service.ViewService;
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
public class ViewServiceImpl extends ServiceImpl<ViewMapper, View> implements ViewService {

    @Autowired
    ViewMapper viewMapper;

    @Autowired
    NewsMapper newsMapper;

    @Override
    public void insertview(View view){
        viewMapper.insert(view);
    }

    @Override
    public boolean deleteById(String viewId){
        return viewMapper.deleteById(viewId)>0;
    }

    @Override
    public Page<News> searchByuid(Integer page , String uid){
        // 创建查询条件
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();

        //创建时间排序
        queryWrapper.orderByDesc("create_time");

        // 创建分页对象
        Page<News> newsPage = new Page<>(page, 10);

        // 调用分页查询，并传入查询条件
        IPage<News> pagedResult = newsMapper.selectPage(newsPage, queryWrapper);

        return (Page<News>) pagedResult;
    }
}
