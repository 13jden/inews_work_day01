package com.example.inews.common;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class Uploadimage {
    public static final String ALI_YUN="https://{自己的阿里云bucketname}.oss-rg-china-mainland.aliyuncs.com/";


    public static String uploadImage(MultipartFile file) throws IOException {
        String oldname = file.getOriginalFilename();
        String ext ="." + oldname.split("\\.")[1];
        String uuid = UUID.randomUUID().toString().replace("-","");
        String fileName = uuid + ext;

        String endpoint="";//地域节点
        String accesskeyId = "ALIYUN_ACCESS_KEY_I";
        String accesskeySecret ="ALIYUN_ACCESS_KEY_SECRET";

        OSS ossClient = new OSSClientBuilder().build(endpoint,accesskeyId,accesskeySecret);
        ossClient.putObject(
                "{自己的bucketname}",
                fileName,
                file.getInputStream()
        );
        ossClient.shutdown();
        return ALI_YUN+fileName;

    }

}
