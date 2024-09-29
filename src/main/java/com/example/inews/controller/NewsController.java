package com.example.inews.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.News;
import com.example.inews.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Frontend Controller for managing News
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
@RestController
//@Api(value = "新闻管理接口", tags = {"新闻"})
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    // 添加 news
    @PostMapping("/add")
    public String addNews(@RequestBody News news) {
        news.setCreateTime(new Date());
        boolean success = newsService.save(news);
        return success ? "添加成功" : "添加失败";
    }

    // 修改 news
    @PostMapping("/update")
    public String updateNews(@RequestBody News news) {
        news.setUpdateTime(new Date());
        boolean success = newsService.updateById(news);
        return success ? "更新成功" : "更新失败";
    }

    // 删除news
    @DeleteMapping("/delete/{newsId}")
    public boolean deleteNews(@PathVariable Integer newsId) {
        return newsService.removeById(newsId);
    }

    // 模糊查询
    @GetMapping("/search/{word}/{page}")
    public IPage<News> searchNews(@PathVariable String word,@PathVariable int page) {
        return newsService.searchNews(word,page);
    }

    // 分页查询
    @GetMapping("/list/{page}/{size}")
    public IPage<News> getPaginatedNews(
            @PathVariable int page,
            @PathVariable int size,
            @RequestParam(required = false, defaultValue = "createTime") String sortBy) {
        return newsService.getPaginatedNews(page, size, sortBy);
    }

    // 根据id查询
    @GetMapping("/get/{id}")
    public News getNews(@PathVariable Integer id) {
        return newsService.getById(id);
    }
}
