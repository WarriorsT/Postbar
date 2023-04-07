package com.postbar.backend;

import com.postbar.backend.core.refresh.VideoRefresh;
import com.postbar.backend.core.utils.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.config.annotation.EnableWebSocket;


@SpringBootApplication
@EnableScheduling
@EnableWebSocket
public class BackendApplication {
    @Autowired
    private VideoRefresh videoRefresh;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BackendApplication.class, args);
    }

    //每隔32000s刷新一次
    @Scheduled(fixedRate = 1000 * 32000)
    public void refreshVideoURL(){
        System.out.println("刷新成功");
        videoRefresh.refreshVideoURL();
    }
}
