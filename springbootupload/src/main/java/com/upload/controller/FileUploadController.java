package com.upload.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
/*
* 文件上传
* */
public class FileUploadController {
    @PostMapping("/fileUpload")
    public String fileUpload( MultipartFile file) throws Exception{
        //System.out.println(file.getOriginalFilename());
        //file.transferTo(new File("N:/"+file.getOriginalFilename()));
        return "ok";
    }

}
