package com.changgou.goods.controller;

import com.changgou.goods.pojo.Category;
import com.changgou.goods.service.CategoryService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/11 10:35
 */
@RestController
@ControllerAdvice
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/getCategoryById")
    public Result<Category> getCategoryById(Integer id){
        Category category=categoryService.getCategoryById(id);
        Result<Category> result=new Result<>();
        result.setData(category);
        result.setFlag(true);
        result.setCode(StatusCode.OK);
        return result;
    }

    @GetMapping(value = "/getCategoryData")
    public Result<PageInfo> getCategoryData(Category category,Integer pageNum, Integer size){
        PageInfo<Category> pageInfo=categoryService.findPage(category,pageNum,size);
        Result<PageInfo> result=new Result<>();
        result.setData(pageInfo);
        result.setCode(StatusCode.OK);
        result.setMessage("分页查询成功");
        return result;
    }

}
