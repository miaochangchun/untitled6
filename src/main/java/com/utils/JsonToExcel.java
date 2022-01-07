package com.utils;

import com.alibaba.fastjson.JSON;
import com.bean.cj.CjHistory;
import com.bean.cj.SecurityOrderList;
import com.db.util.DBUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

public class JsonToExcel {
    public static void main(String[] args) throws Exception {
        String json = readTxt("src/main/resources/dd.json");
        CjHistory bean = JSON.parseObject(json, CjHistory.class);

//        String json = readTxt("src/main/resources/order.json");
//        OrderHistory bean;
//        bean = JSON.parseObject(json, OrderHistory.class);

        System.out.println(bean);
        Connection connection = DBUtil.getConn();
        String sql = "insert into cj_securityorderlist values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        List<SecurityOrderList> lists = bean.getData().getSecurityOrderList();
        for(int i=0; i<lists.size(); i++){
            pstmt.setString(1, lists.get(i).getId());
            pstmt.setString(2, lists.get(i).getAccountNo());
            pstmt.setTimestamp(3, new Timestamp(lists.get(i).getCjsj().getTime()));
            pstmt.setString(4, lists.get(i).getCode());
            pstmt.setString(5,lists.get(i).getCombPositionId());
            pstmt.setString(6, lists.get(i).getSide());
            pstmt.setInt(7, lists.get(i).getCjsl());
            pstmt.setInt(8, lists.get(i).getCjjj());
            pstmt.setString(9, lists.get(i).getCjbh());
            pstmt.setLong(10, lists.get(i).getQsDay());
            pstmt.setString(11, lists.get(i).getExchange());
            pstmt.setString(12, lists.get(i).getHtbh());
            pstmt.setString(13,lists.get(i).getStockName());
            pstmt.setTimestamp(14, new Timestamp(lists.get(i).getUpdateTime().getTime()));
            pstmt.setTimestamp(15, new Timestamp(lists.get(i).getCreateTime().getTime()));
            pstmt.setString(16, lists.get(i).getCjType());
            pstmt.setInt(17, lists.get(i).getUnit());
            pstmt.execute();
        }


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
