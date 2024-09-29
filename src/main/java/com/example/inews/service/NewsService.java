package com.example.inews.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inews.pojo.News;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface NewsService extends IService<News> {

    IPage<News> getPaginatedNews(int page, int size, String sortBy);


    IPage<News> searchNews(String word,int page);
}
