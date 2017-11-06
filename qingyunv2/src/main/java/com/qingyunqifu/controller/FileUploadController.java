package com.qingyunqifu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@MultipartConfig
public class FileUploadController {

//    springMVC会将上传文件绑定到MultipartFile对象中.而这个对象提供了获取上传文件内容，文件名等方法。并且
    //通过本身的方法可以经文件保存到硬件中
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView upload(HttpServletRequest servletRequest,
                         @RequestParam("file") MultipartFile file,
                         ModelAndView mv) throws IOException {

        //如果文件内容不为空，则写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = servletRequest.getServletContext().getRealPath("/upload_img");

            System.out.println("上传路径"+path);
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);


            //判断路径是否存在，没有就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            //将上传文件保存到一个目标文档中
            file.transferTo(new File(path + File.separator + filename));


            mv.setViewName("file");
            mv.addObject("file",new File(path + File.separator + filename));

            return mv;

        } else {
            mv.addObject("file","error");
            return mv;
        }
    }
}
