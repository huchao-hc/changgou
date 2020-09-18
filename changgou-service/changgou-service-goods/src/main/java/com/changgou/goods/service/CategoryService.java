package com.changgou.goods.service;

import com.changgou.goods.pojo.Category;
import com.github.pagehelper.PageInfo;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/11 10:40
 */
public interface CategoryService {
    /**
     * 根据id查找
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     * 分页查找
     * @param category
     * @param pageNum
     * @param size
     * @return
     */
    PageInfo<Category> findPage(Category category,Integer pageNum,Integer size);
}
