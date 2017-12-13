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

    @RequestMapping("/multiFiles")
    public String multiFiles() {
        return "multiFiles";
    }

    @RequestMapping("/oneFileDo")
    public String oneFileDo(@RequestParam("file") MultipartFile file) {
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
        if (!f.exists())
            f.mkdir();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();

                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("上传图片到：" + path + newFileName);
        return "index";
    }

    @RequestMapping("/multiFilesDo")
    public String multiFilesDo(@RequestParam("files")MultipartFile []files) {

        String path = "F:\\IdeaProjects\\springboot_updownload\\src\\main\\resources\\static\\images\\";
        File f = new File(path);
        if(!f.exists())
            f.mkdir();

        for (int i=0;i<files.length;i++ ) {
            String fileName = files[i].getOriginalFilename();
            String newFileName = UUID.randomUUID() + "-"+fileName;

            if(!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path+newFileName);
                    InputStream in = files[i].getInputStream();

                    int b=0;
                    while((b=in.read())!=-1) {
                        fos.write(b);
                    }

                    fos.close();
                    in.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("上传图片到：" + path + newFileName);
        }

        return "index";
    }

    @RequestMapping("/showFiles")
    public String showFiles(ModelMap model) {
        String path = "F:\\IdeaProjects\\springboot_updownload\\src\\main\\resources\\static\\images\\";
        Map<String, String> fileNameMap = new HashMap<>();

        /**
         * 获取到所有的文件，并将文件路径与文件真实名以K-V对存放在map中
         */
        File[] fileList = new File(path).listFiles();
        for (File file : fileList) {
            String realName = getRealName(file.getName());
            fileNameMap.put("/images/" + file.getName(), realName);
//            System.out.println(file.getName()+" "+realName);
        }

        model.addAttribute("fileNameMap", fileNameMap);
        return "show";
    }

    private String getRealName(String name) {
        String[] str = name.split("-");

        String realName = str[5];
        for (int i = 6; i < str.length; i++)
            realName += str[i];
        return realName;
    }


}
