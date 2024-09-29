package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Like;
import com.example.inews.mapper.LikeMapper;
import com.example.inews.pojo.News;
import com.example.inews.service.LikeService;
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
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like> implements LikeService {

    @Autowired
    LikeMapper likeMapper;

    @Autowired
    NewsServiceImpl newsService;

    @Override
    public boolean addlike(Like like1){
        return likeMapper.insert(like1)>0;
    }

    @Override
    public boolean deleteById(String likeId){
        return likeMapper.deleteById(likeId)>0;
    }

    @Override
    public IPage<Like> searchBynid(String uid,int page){
        QueryWrapper<Like> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",uid);
        Page<Like> likePage = new Page<>(page,10);
        return  likeMapper.selectPage(likePage,queryWrapper);
    }

    @Override
    public String countlike(String nid) {
        Long count = likeMapper.selectCount(new QueryWrapper<Like>().eq("nid", nid));

        if (count >= 1000) {
            double formattedCount = count / 1000.0; // 转为千的格式
            return String.format("%.1fk", formattedCount);
        } else {
            return String.valueOf(count); // 返回实际数量
        }
    }



}
