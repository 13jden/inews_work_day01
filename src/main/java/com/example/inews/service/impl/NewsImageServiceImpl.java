package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.inews.mapper.NewsMapper;
import com.example.inews.pojo.NewsImage;
import com.example.inews.mapper.NewsImageMapper;
import com.example.inews.service.NewsImageService;
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
public class NewsImageServiceImpl extends ServiceImpl<NewsImageMapper, NewsImage> implements NewsImageService {


    @Autowired
    NewsImageMapper newsImageMapper;

    @Override
    public boolean addNewsImage(NewsImage newsImage){
        return newsImageMapper.insert(newsImage)>0;
    }

    @Override
    public boolean deleteById(String img_id){
        return  newsImageMapper.deleteById(img_id)>0;
    }

    @Override
    public List<NewsImage> searchByuid(String nid){
        QueryWrapper<NewsImage> queryWrapper =new QueryWrapper();
        queryWrapper.eq("n_id" , nid);
        return newsImageMapper.selectList(queryWrapper);
    }
}
