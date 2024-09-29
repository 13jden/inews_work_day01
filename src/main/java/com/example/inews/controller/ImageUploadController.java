package com.example.inews.controller;
import com.example.inews.common.Uploadimage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class ImageUploadController {

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("收到文件上传请求");
        if (file.isEmpty()) {
            return "上传失败，文件为空";
        }

        return Uploadimage.uploadImage(file);
    }
}