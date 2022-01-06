package com.utils;

import com.alibaba.fastjson.JSON;
import com.bean.CjHistory;

import java.io.*;

public class JsonToExcel {
    public static void main(String[] args) throws Exception {
        String json = readTxt("D:\\java\\dd.json");
        CjHistory bean = JSON.parseObject(json, CjHistory.class);
        System.out.println(bean);
    }

    public static String readTxt(String string) throws Exception {
        File file = new File(string);
        String json = "";
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try{
            fis = new FileInputStream(file);
            reader = new InputStreamReader(fis, "utf-8");
            bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                json += line;
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedReader.close();
            reader.close();
            fis.close();
        }
        return json;
    }
}
