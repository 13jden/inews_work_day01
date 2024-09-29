package com.example.inews.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.NewsImage;
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
public interface NewsImageService extends IService<NewsImage> {

    boolean addNewsImage(NewsImage newsImage);

    boolean deleteById(String img_id);

    List<NewsImage> searchByuid(String nid);
}
