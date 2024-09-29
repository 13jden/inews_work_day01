package com.example.inews.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.pojo.NewsImage;
import com.example.inews.service.NewsImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@RestController
//@Api(value = "新闻图片管理接口", tags = {"新闻img"})
@RequestMapping("/news-image")
public class NewsImageController {

    @Autowired
    NewsImageService newsImageService;


    //添加图片
    @PostMapping("/add")
    public String addImage(@RequestBody Map<String, String> image){
        String imageurl = image.get("imageurl");
        Integer nid = Integer.valueOf(image.get("nid"));
        NewsImage newsImage = new NewsImage();
        newsImage.setImageUrl(imageurl);
        newsImage.setNId(nid);
        newsImageService.addNewsImage(newsImage);
        return "成功";
    }

    //删除图片
    @DeleteMapping("/delete/{img_Id}")
    public boolean deleteNews(@PathVariable String img_Id) {
        return newsImageService.deleteById(img_Id);
    }

    //查图片
    @GetMapping("/search/{nid}")
    public List<NewsImage> searchimage(@PathVariable String nid) {
        return newsImageService.searchByuid(nid);
    }
}

