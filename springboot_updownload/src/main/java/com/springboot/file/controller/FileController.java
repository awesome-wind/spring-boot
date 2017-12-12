package com.springboot.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/oneFile")
    public String oneFile() {
        return "oneFile";
    }

    @RequestMapping("/oneFileDo")
    @ResponseBody
    public String oneFileDo(@RequestParam("file")MultipartFile file) {
        /**
         * 获取到原始文件名，定义新的唯一的文件名，设置文件保存的位置
         */
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "-" + fileName;
        String path = "F:\\IdeaProjects\\springboot_updownload\\src\\main\\resources\\static\\images\\";
        String path1 = "/images/";  //此位置为与IdeaProjects同级的目录

        /**
         * 将文件流以字节码流上传指定的位置
         */
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        if(!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path+newFileName);
                InputStream in = file.getInputStream();

                int b = 0;
                while ((b = in.read())!=-1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("上传图片到："+path+newFileName);
        return "上传成功";
    }

    @RequestMapping("/showFiles")
    public String showFiles(ModelMap model) {
        String path = "F:\\IdeaProjects\\springboot_updownload\\src\\main\\resources\\static\\images\\";
        Map<String,File> fileNameMap = new HashMap<>();

        /**
         * 获取到所有的文件，并将文件名与文件以K-V对存放在map中
         */
        File[] fileList = new File(path).listFiles();
        for(File file:fileList) {
            fileNameMap.put(file.getName(),file);
            System.out.println(file.getName());
        }

        model.addAttribute("fileNameMap",fileNameMap);
        return "show";
    }

}
