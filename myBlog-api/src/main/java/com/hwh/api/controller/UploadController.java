package com.hwh.api.controller;

import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.util.QiniuUtils;
import com.hwh.common.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author HwH
 * @date 2021/9/16 21:30
 * @description 七牛云上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private QiniuUtils qiniuUtils;

    @PostMapping
    public Result upload(@RequestParam("image") MultipartFile file){
        //获取初始名字
        String originalFilename = file.getOriginalFilename();
        //唯一名称
        String fileName = UUID.randomUUID().toString() + "."
                + StringUtils.substringAfterLast(file.getOriginalFilename(),".");
        boolean upload = qiniuUtils.upload(file, fileName);
        if(upload){
            return Result.success(true, CodeEnum.SUCCESS, qiniuUtils.url + fileName);
        }
        return Result.error(CodeEnum.FILE_UPLOAD_FAIL);
    }

}
