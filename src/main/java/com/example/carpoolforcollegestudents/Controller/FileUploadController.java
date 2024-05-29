package com.example.carpoolforcollegestudents.Controller;

import com.example.carpoolforcollegestudents.Pojo.Result;
import com.example.carpoolforcollegestudents.Utils.AliOssUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upLoad")
    public Result<String> upLoad(MultipartFile file){

        try {

            String originalFilename=file.getOriginalFilename();
            String filename= UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
           // file.transferTo(new File("C:\\Users\\86133\\Downloads\\"+filename));
            String url=AliOssUtil.upLoad(filename,file.getInputStream());
            return Result.success(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
