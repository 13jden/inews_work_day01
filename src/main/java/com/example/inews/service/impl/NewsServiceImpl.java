package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.mapper.NewsMapper;
import com.example.inews.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public IPage<News> getPaginatedNews(int page, int size, String sortBy) {
        // 创建查询条件
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();

        if ("createTime".equalsIgnoreCase(sortBy)) {
            sortBy = "create_time"; // 修改为数据库中的列名
        }
        //时间降序排列
        queryWrapper.orderByDesc(sortBy);
        return newsPage(page,size,queryWrapper);
    }

    public IPage<News> newsPage(int page , int size , QueryWrapper<News> queryWrapper){
        Page<News> newsPage = new Page<>(page, size);
        IPage<News> Result = newsMapper.selectPage(newsPage,queryWrapper);
        return Result;
    }

    @Override
    public IPage<News> searchNews(String word,int page){
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("n_title",word).or().like("n_content",word);
        return newsPage(page,10,queryWrapper);
    }



}
