package net.messi.earlyadmin.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class TestLog {

    //String key = "product_info_:" + productId;
    public static void main(String[] args) {
        String path = "C:\\Users\\duncan\\Desktop\\log.log";
        String line = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"utf-8"));
            while ((line = reader.readLine()) != null){
                if (!line.contains("requestPath=product")){
                    System.out.println("false");
                }else {
                    line = line.split(",")[1].split(" ")[1].split("&")[1].split("=")[1];
                    System.out.println(line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (Exception eq){
                eq.printStackTrace();
            }
        }
    }
}
