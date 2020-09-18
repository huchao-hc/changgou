package com.changgou.goods.service.impl;

import com.changgou.goods.dao.CategoryMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/11 10:43
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Category> findPage(Category category, Integer pageNum, Integer size) {
        //静态分页
        PageHelper.startPage(pageNum,size);
        Example example=createExample(category);
        List<Category> list=categoryMapper.selectByExample(example);
        return new PageInfo<Category>(list);
    }

    public tk.mybatis.mapper.entity.Example createExample(Category category) {
        //动态构建条件Example,criteria:动态组装条件
        tk.mybatis.mapper.entity.Example example = new tk.mybatis.mapper.entity.Example(Category.class);
        tk.mybatis.mapper.entity.Example.Criteria criteria = example.createCriteria();

        //组装条件
        if(category!=null){
            //id
            if(!StringUtils.isEmpty(category.getId())){
                criteria.andEqualTo("id",category.getId());
            }

            if(!StringUtils.isEmpty(category.getName())){

                criteria.andLike("name","%"+category.getName()+"%");
            }

            if(!StringUtils.isEmpty(category.getParentId())){
                //2)输入了ParentId-根据ParentId查询
                criteria.andEqualTo("letter",category.getParentId());
            }
        }
        return example;
    }


}
