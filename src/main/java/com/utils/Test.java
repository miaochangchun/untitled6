package com.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        String path = "D:\\java\\account.txt";
        List<String> list = Hello.readTxtFileIntoStringArrList(path);
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
            int d = qryDate(list.get(i), "2021-10-11", "2021-11-19");
            System.out.println("账户：" + list.get(i) + ", 天数：" + d);
        }

    }

    /**
     *  查询历史成交中，某个账户的在某一时间段有成交的天数
     * @param accountNo     账户
     * @param beginDay      开始日期，日期格式为YYYY-MM-DD
     * @param endDay        结束日期，日期格式为YYYY-MM-DD
     *
     * @return 返回有成交的天数
     */
    public static int qryDate(String accountNo, String beginDay, String endDay){
        String url = "http://101.226.207.134:8080/cj/historyList";
        String param = "accountNo=" + accountNo + "&beginDay=" + beginDay +
                "&endDay=" + endDay + "&pageNo=" + "1" + "&pageSize=" + "100000";
        String str = Hello.sendGet(url, param);
//        System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        JSONObject jsonObject1 = jsonObject.getJSONObject("op");
        if (jsonObject1.get("code").toString().equals("Y")){
            JSONObject jsonObject2 = jsonObject.getJSONObject("data");
//                System.out.println(jsonObject2.get("count").toString());
            if (jsonObject2.get("count").toString() == "0"){
                System.out.println("没有历史成交数据");
                return 0;
            }else{
                JSONArray jsonArray = jsonObject2.getJSONArray("securityOrderList");
                if (jsonArray.size() == 0){
                    return 0;
                }
                Set set = new HashSet();
                for (int j=0; j<jsonArray.size(); j++){
                    String date = jsonArray.getJSONObject(j).get("cjsj").toString().substring(0, 10);
//                    System.out.println(date);
                    set.add(date);
                }
//                System.out.println("账户：" + list.get(i) + "，天数" + set.size());
                return set.size();
            }
        }
        return 0;
    }



    /**
     * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
     *
     * @param filePath
     *            文件路径[到达文件:如： D:\aa.txt]
     * @return 将这个文件按照每一行切割成数组存放到list中。
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath)
    {
        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

}
