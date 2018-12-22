package com.org.data.domain;

import com.org.data.server.HttpServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by huajun.wang01 on 2018/12/18.
 */
public class Response {
    private static final int BUFFER_SIZE = 2048;
    private OutputStream outputStream;
    private Request request;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fileInputStream=null;
        try {
            File file=new File(HttpServer.WEB_ROOT,request.getUrl());
            if (file.exists()){
                fileInputStream=new FileInputStream(file);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
