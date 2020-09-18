package com.changgou.goods.service.impl;


import com.changgou.goods.dao.FileMapper;
import com.changgou.goods.pojo.DBFile;
import com.changgou.goods.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/18 10:15
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileMapper fileMapper;
    public Boolean save(DBFile dbFile){
        fileMapper.insertSelective(dbFile);
        return true;
    }
}
