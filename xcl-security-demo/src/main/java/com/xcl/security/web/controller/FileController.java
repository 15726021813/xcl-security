package com.xcl.security.web.controller;

import com.xcl.security.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * FileController
 *
 * @author 徐长乐
 * @date 2020/4/21
 */
@RestController
@RequestMapping("/file")
public class FileController {
    String folder = "D:\\IdeaProject\\xcl-security\\xcl-security-demo\\src\\main\\java\\com\\xcl\\security\\web\\controller";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        File localFile = new File(folder,System.currentTimeMillis()+".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }
    @GetMapping("{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
        try(
                InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
                OutputStream outputStream = response.getOutputStream();
                ) {
            response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=test.txt");
           IOUtils.copy(inputStream,outputStream);
           outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
