package com.qingyunqifu.controller;

import com.qingyunqifu.base.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@MultipartConfig
public class FileUploadController {
    @RequestMapping(value = "/upload/img" , method = RequestMethod.POST)
    public Result  upload(HttpServletRequest servletRequest,
                         @RequestParam("file") MultipartFile file
                         ) throws IOException {

        //如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = servletRequest.getServletContext().getRealPath("/upload_img");

            System.out.println("文件名称"+file.getOriginalFilename());
            System.out.println("上传路径"+path);
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);


            //判断路径是否存在，没有就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            //将上传文件保存到一个目标文档中
            File file1 = new File(path + File.separator + filename);
            file.transferTo(file1);
            return Result.success();


        } else {
            return Result.failure();
        }

    }
}
