package com.qingyunqifu.controller;

import com.qingyunqifu.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@MultipartConfig
public class FileUploadController {
    @RequestMapping(value = "/upload/img" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object>  upload(HttpServletRequest servletRequest,
                         @RequestParam("file") MultipartFile file
                         ) throws IOException {

        //如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = "/home/jian/Desktop/qingyunV2/qingyunv2/src/main/resources/static/images";

            System.out.println("文件名称"+file.getOriginalFilename());
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
            Map<String, Object> res = new HashMap<>();
            res.put("url", file1);
            return res;

        } else {
            return Result.failure();
        }

    }
}
