package com.example.carpoolforcollegestudents.Utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class AliOssUtil {
    private static final String endPoint="https://oss-cn-beijing.aliyuncs.com";
    private static final String ACCESS_KEY_ID="LTAI5tSgXN4oX46JzboKqVgW";
    private static final String ACCESS_KEY_SECRET="FuyKnh2grXw4sEW73aZFPIWOxJIg2v";
    private static final String bucketName="carsharingproject";
    public static String upLoad(String objectName, InputStream inputStream) throws Exception{
        OSS ossClient=new OSSClientBuilder().build(endPoint,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
        String url="";
        try{
            PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName,objectName,inputStream);
            PutObjectResult result=ossClient.putObject(putObjectRequest);
            url="https://"+bucketName+"."+endPoint.substring(endPoint.lastIndexOf("/")+1)+"/"+objectName;

        }catch(OSSException oe){
            System.out.println(oe);

        }
        return url;
    }



}
