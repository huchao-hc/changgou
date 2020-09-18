package com.changgou.goods.controller;

import com.changgou.goods.pojo.DBFile;
import com.changgou.goods.service.FileService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huchao
 * @description: TODO
 * @date 2020/9/18 10:19
 */
@RestController
@ControllerAdvice
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping(value = "/upload")
    public Result<Boolean> uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Result<Boolean> result=new Result();
        MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
        MultipartFile mf=multipartHttpServletRequest.getFile("file");
        String orgname=mf.getOriginalFilename();
        DBFile fileBean=new DBFile();
        fileBean.setFilename(orgname);
        if(orgname.contains(".")){
            fileBean.setFileext(orgname.split("\\.")[1]);
        }else {
            fileBean.setFileext(orgname);
        }
        fileBean.setContent(mf.getBytes());
        Boolean flag=fileService.save(fileBean);
        result.setMessage("上传成功");
        result.setCode(StatusCode.OK);
        result.setData(flag);
        return result;
    }
}
