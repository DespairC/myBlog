package com.hwh.common.util;

import com.alibaba.fastjson.JSON;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author HwH
 * @date 2021/9/16 21:34
 * @description 七牛云工具类
 */

@Component
public class QiniuUtils {

    public final String url = "http://qzj56etx2.hn-bkt.clouddn.com/";

    private final String accessKey = "VOtafZfABNCBSWXYiClANur6YgNvyWTj0EP_9GV_";
    private final String secretKey = "khi2Bkdjb5CRmqrZ4O2CvqC7sNBl2CwCmVqAucb0";
    private final String bucket = "blog255";

    public boolean upload(MultipartFile file, String fileName){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try{
            byte[] uploadByte = file.getBytes();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            Response response = uploadManager.put(uploadByte, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
