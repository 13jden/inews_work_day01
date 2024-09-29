package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.Sort;
import com.example.inews.mapper.SortMapper;
import com.example.inews.service.SortService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@Service
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements SortService {
    @Autowired
    SortMapper sortMapper;

    @Autowired
    NewsServiceImpl newsService;

    @Override
    public boolean addsort(Sort sort){
        return sortMapper.insert(sort)>0;
    }

    @Override
    public boolean deleteById(String sortId){
        return sortMapper.deleteById(sortId)>0;
    }

    @Override
    public IPage<News> getSortNews(String sid, int page){
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("s_id",sid);
        return newsService.newsPage(page,10,queryWrapper);
    }
}
