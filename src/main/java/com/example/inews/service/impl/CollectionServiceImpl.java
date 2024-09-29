package com.example.inews.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Collection;
import com.example.inews.mapper.CollectionMapper;
import com.example.inews.pojo.Like;
import com.example.inews.service.CollectionService;
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
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public boolean addcollection(Collection collection1){
        return collectionMapper.insert(collection1)>0;
    }

    @Override
    public boolean deleteById(String collectionId){
        return collectionMapper.deleteById(collectionId)>0;
    }

    @Override
    public IPage<Collection> searchByuid(String uid, int page){
        QueryWrapper<Collection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",uid);
        Page<Collection> collectionPage = new Page<>(page,10);
        return collectionMapper.selectPage(collectionPage,queryWrapper);
    }

    @Override
    public String countcollection(String nid){
        QueryWrapper<Collection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("n_id" , nid);
        Long count = collectionMapper.selectCount(queryWrapper);
        if (count >= 1000) {
            double formattedCount = count / 1000.0;
            return String.format("%.1fk", formattedCount);
        } else {
            return String.valueOf(count);
        }
    }
}
