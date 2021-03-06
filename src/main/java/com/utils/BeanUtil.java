package com.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {
    public static void main(String[] args) {
        System.out.println(getBeanFilesList("com.bean.cj.SecurityOrderList"));

        System.out.println(genCreateTableSql("com.bean.cj.SecurityOrderList"));
    }

    public static String getBeanName(String bean){
        try {
            Class clz = Class.forName(bean);
            String clzStr = clz.toString();
            //得到类名
            String beanName = clzStr.substring(clzStr.lastIndexOf(".")+1).toLowerCase();
            return beanName;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> getBeanPropertyList(String bean){
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            List<String> propertyList = new ArrayList<String>();
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();
                propertyList.add(protype.substring(protype.lastIndexOf(".")+1)+"`"+strs[i].getName());
            }
            return propertyList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成建表语句
     * @param bean
     * @return
     */
    public static String genCreateTableSql(String bean){
        List<String> beanPropertyList = getBeanPropertyList(bean);
        StringBuffer sb = new StringBuffer("create table cj_"+getBeanName(bean)+"(\n");
        for (String string : beanPropertyList) {
            String[] propertys = string.split("`");
            if (!propertys[1].equals("tableName")&&!propertys[1].equals("param")&&!propertys[0].equals("List")) {
                if (propertys[1].equals("id")) {
                    sb.append(" id bigint ,\n");
                } else {
                    if (propertys[0].equals("int")) {
                        sb.append(" " + propertys[1] + " int default 0 comment '',\n");
                    } else if (propertys[0].equals("String")) {
                        sb.append(" " + propertys[1] + " varchar(2000) default '' comment '',\n");
                    } else if (propertys[0].equals("double")) {
                        sb.append(" " + propertys[1] + " double(10,2) default 0.0 comment '',\n");
                    } else if (propertys[0].equals("Date")) {
                        sb.append(" " + propertys[1] + " datetime comment '',\n");
                    }
                }
            }
        }
        sb.append(")");
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }


    public static String getBeanFilesList(String bean){
        try {
            Class clz = Class.forName(bean);
            Field[] strs = clz.getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < strs.length; i++) {
                String protype = strs[i].getType().toString();
                if (!strs[i].getName().equals("tableName")&&!strs[i].getType().equals("List")) {
                    sb.append(strs[i].getName()+",");
                }
            }
            sb.deleteCharAt(sb.toString().lastIndexOf(","));
            return sb.toString();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
