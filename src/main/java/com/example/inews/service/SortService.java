package com.example.inews.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.Sort;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface SortService extends IService<Sort> {

    boolean addsort(Sort sort);

    boolean deleteById(String sortId);

    IPage<News> getSortNews(String sid, int page);
}
