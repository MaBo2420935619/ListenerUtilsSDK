package com.mabo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
@RestController
@RequestMapping("download")
public class ListenerSdkDownload {
    //下载文件地址  http://localhost:8081/download/listenerSdk
    private  static Logger log = LoggerFactory.getLogger(ListenerSdkDownload.class);
    @GetMapping("listenerSdk")
    public void listenerSdk(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String ip = request.getRemoteHost();
        log.info("开始下载listenerSdk,ip:"+ip);
        String fileName="ListenerSdk-1.0-SNAPSHOT.jar";
        File file=new File(fileName);
        // 以流的形式下载文件。
        InputStream fis = new BufferedInputStream(new FileInputStream(file.getAbsoluteFile()));
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        fis.close();
        // 清空response
        response.reset();
        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes()));
        response.addHeader("Content-Length", "" + file.length());
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

}
