package com.postbar.backend.core.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;

import java.io.*;
import java.net.URL;
import java.util.Date;

public class OssUtil {
    // endpoint是访问OSS的域名
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // accessKeyId和accessKeySecret是OSS的访问密钥
    private static String accessKeyId = "null";
    private static String accessKeySecret = "null";
    //bucket的名称
    private static String bucketName = "videosbuckets";
    private static String objectName = "videos/";

    //创建oss实例
    private static OSS ossClient =new OSSClientBuilder()
            .build(endpoint, accessKeyId, accessKeySecret);

    //上传文件
    public static void uploadFiles(String fileName) throws Exception{
        String url = objectName + fileName;
        try {
            FileInputStream fileInputStream = new FileInputStream("E:\\JavaProject\\post_bar\\videos\\klay1.mp4");
            ossClient.putObject(bucketName, url, fileInputStream);
            System.out.println("上传成功");
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    //下载文件
    public static void downloadFiles(String fileName) throws Exception {
        String url = objectName + fileName;
        try {
            // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
            OSSObject ossObject = ossClient.getObject(bucketName, url);
            // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
            InputStream content = ossObject.getObjectContent();
            if (content != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    System.out.println("\n" + line);
                }
                // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
                content.close();
            }
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    //删除文件
    public static void deleteFiles(String fileName){
        String url = objectName + fileName;
        try {
            // 删除文件。
            ossClient.deleteObject(bucketName, url);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    //视频截帧
    public static String getPicture(String fileName){
        // 使用精确时间模式截取视频17s处的内容，输出为JPG格式的图片，宽度为800，高度为600。
        String style = "video/snapshot,t_17000,f_jpg";
        // 指定过期时间为1天。
        Date expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24);
        GeneratePresignedUrlRequest req =
                new GeneratePresignedUrlRequest(bucketName, objectName + fileName, HttpMethod.GET);
        req.setExpiration(expiration);
        req.setProcess(style);
        URL signedUrl = ossClient.generatePresignedUrl(req);
        System.out.println(signedUrl);
        // 关闭OSSClient。
        ossClient.shutdown();
        return signedUrl.toString();
    }

    //获取URL
    public static String getURL(String fileName){
        URL url = null;
        try {
            // 设置签名URL过期时间，单位为毫秒。
            Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
            // 生成以GET方法访问的签名URL，访客可以直接通过浏览器访问相关内容。
            url = ossClient.generatePresignedUrl(bucketName, objectName + fileName, expiration);
            System.out.println(url);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url.toString();
    }
}
