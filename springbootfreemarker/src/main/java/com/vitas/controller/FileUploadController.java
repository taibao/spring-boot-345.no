package com.vitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
/*
* 文件上传
* */

@RestController
public class FileUploadController {
    @RequestMapping("/fileUpload")
    public String fileUpload( MultipartFile file) throws Exception{
        System.out.println(file.getOriginalFilename());
        file.transferTo(new File("N:/"+file.getOriginalFilename()));
        return "ok";
    }

}
