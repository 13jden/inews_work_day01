package com.example.inews.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inews.pojo.Collection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dzk
 * @since 2024-09-25
 */
public interface CollectionService extends IService<Collection> {

    boolean addcollection(Collection collection1);

    boolean deleteById(String collectionId);

    IPage<Collection> searchByuid(String uid, int page);

    String countcollection(String nid);
}
