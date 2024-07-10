package com.example.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.pojo.Result;
import com.example.demo.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

   //本地上传文件方法
   /*
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException {
        //获取原始文件名
        String filename = file.getOriginalFilename();
        //构造唯一文件名
        //获取.处的索引值
        int index = filename.lastIndexOf(".");
        //对索引处的文件名进行切割
        String extname = filename.substring(index);
        //用UUID随机生成值在字符串拼接创建新的文件名
        String newFileName = UUID.randomUUID().toString() + extname;
        file.transferTo(new File("C:\\Users\\12944\\Pictures\\bh3rd"+newFileName));
        return Result.success();
    }
    */

    /**
     * 阿里云OSS上传方法
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException, ClientException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
