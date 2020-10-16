package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.entity.FileUpload;
import com.example.service.FileUploadService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/14 9:40
 * @description V1.0 文件上传控制器  @RequestMapping("${server.servlet.context-path}/upload") 等价于
 * http://localhost:8092/test/test/upload/toUpload
 * 若设置了server.servlet.context-path=/test
 * 控制器也不需要加${server.servlet.context-path=/test}
 * springboot 默认追加了。
 */
@RequestMapping("/upload")
@Controller
@Slf4j
@Api(tags = "1.2", description = "文件管理", value = "文件管理")
public class UploadController {

    @Autowired
    FileUploadService fileUploadService;

   /* @Value("${server.servlet.context-path}")
    protected String adminPath;*/

    /**
     * @return java.lang.String
     * @author xiaobu
     * @date 2018/11/14 10:23
     * @descprition 进入上传页面
     * @version 1.0
     */
    @GetMapping("/toUpload")
    public String toUpload(Model model) {
        return "upload";
    }

    /**
     * @param file, request
     * @return java.util.Map<java.lang.String                                                                                                                               ,                                                                                                                               java.lang.String>
     * @author xiaobu
     * @date 2018/11/14 11:38
     * @descprition 上传单个文件
     * @version 1.0
     */
    @PostMapping("/upload1")
    @ResponseBody
    public Map<String, String> upload1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //获取项目的路径
        String uploadDir = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        System.out.println("uploadDir:" + uploadDir);
        uploadDir = uploadDir.substring(1);
        String path = "static/upload/";
        String filepath = uploadDir + path;
        System.out.println("uploadDir ==========" + uploadDir);
        log.info("[文件大小]:=============" + file.getSize());
        log.info("[文件名称]:=============" + file.getOriginalFilename());
        log.info("[文件类型]:=============" + file.getContentType());
        try {
            file.transferTo(new File(filepath + file.getOriginalFilename()));
            FileUpload fileUpload = new FileUpload();
            fileUpload.setName(file.getOriginalFilename());
            fileUpload.setPath(filepath + file.getOriginalFilename());
            fileUploadService.save(fileUpload);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("文件大小", file.getSize() + "");
        map.put("文件名称", file.getOriginalFilename());
        map.put("文件类型", file.getContentType());
        return map;
    }


    /**
     * @param files 上传的文件
     * @return java.lang.String
     * @author xiaobu
     * @date 2018/11/14 11:38
     * @descprition 上传多个文件
     * @version 1.0
     */
    @PostMapping("/upload2")
    @ResponseBody
    public String upload2(@RequestParam("file") MultipartFile[] files) {
        String sep = System.getProperty("file.separator");
        String uploadDir = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        System.out.println("uploadDir:" + uploadDir);
        uploadDir = uploadDir.substring(1);
        String path = "static/upload/";
        String filepath = uploadDir + path;
        System.out.println("static" + sep + "upload");
        List<Map<String, String>> list = new ArrayList<>();
        for (MultipartFile file : files) {
            log.info("[文件大小]:=============" + file.getSize());
            log.info("[文件名称]:=============" + file.getOriginalFilename());
            log.info("[文件类型]:=============" + file.getContentType());
            try {
                file.transferTo(new File(filepath + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, String> map = new HashMap<>();
            map.put("文件大小", file.getSize() + "");
            map.put("文件名称", file.getOriginalFilename());
            map.put("文件类型", file.getContentType());
            list.add(map);
        }
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(list));
        return jsonArray.toString();
    }


    /**
     * @param base64 base64字符串
     * @author xiaobu
     * @date 2018/11/14 11:36
     * @descprition base64转图片
     * @version 1.0
     */
    @PostMapping("/upload3")
    @ResponseBody
    public String upload3(String base64) {
        System.out.println("base64的长度==========>>" + base64.length());
        String uploadDir = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        System.out.println("uploadDir:" + uploadDir);
        uploadDir = uploadDir.substring(1);
        String path = "static/upload/";
        String filepath = uploadDir + path;
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File(filepath + "test.jpg");
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        try {
            FileCopyUtils.copy(bytes, tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "图片上传成功！";

    }


    /**
     * @param res HttpServletResponse对象
     * @return void
     * @author xiaobu
     * @date 2018/11/22 11:41
     * @descprition 文件下载
     * @version 1.0
     */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse res) {
        String downLoadDir = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        System.out.println("downLoadDir:" + downLoadDir);
        downLoadDir = downLoadDir.substring(1);
        String path = "static/img/";
        String downLoadPath = downLoadDir + path;
        String fileName = "777.png";
        String realFileName = downLoadPath + fileName;
        System.out.println("图片的真实路径：" + realFileName);
        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(realFileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }
}
