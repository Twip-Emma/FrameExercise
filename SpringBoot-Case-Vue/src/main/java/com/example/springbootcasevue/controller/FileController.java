package com.example.springbootcasevue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

@Controller
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("imgFile") MultipartFile file, @RequestParam("imgName") String name)
        throws ExecutionException, IOException {
        File dir = new File("uploadFile");
        if(!dir.exists()){
            dir.mkdirs();
        }
        file.transferTo(new File(dir.getAbsolutePath() + File.separator + name + ".png"));
        return "上传完成！文件名：" + name;
    }
}
