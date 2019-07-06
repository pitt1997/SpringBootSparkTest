package com.cn.springboot04web.utils;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        System.out.println("filePath:"+filePath);
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }


//        File file = null;
//        File dir = new File("C:/");
//        file = File.createTempFile
//                ("JavaTemp", ".javatemp", dir);
//        System.out.println(file.getPath());
        System.out.println("---"+filePath+"/"+fileName);


        FileOutputStream out = new FileOutputStream(filePath+"/"+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
