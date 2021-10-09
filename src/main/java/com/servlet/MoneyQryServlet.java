package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bean.Money;
import com.bean.Position;
import com.utils.Hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MoneyQryServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String accountNo = req.getParameter("account");
        String url = "http://101.226.207.134:8080/money/detail";
        String url2 = "http://101.226.207.134:8080/position/detail";


        InputStream path = this.getClass().getResourceAsStream("/money.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(path));
        String string = null;
        String str1 = "";
        while((string = reader.readLine()) != null){
//            System.out.println(string);
            str1 += string;
        }
        JSONObject jsonObject = JSON.parseObject(str1);
        //查资金汇总
//        JSONObject jsonObject = JSON.parseObject(Hello.sendGet(url, "accountNo=" + accountNo));
        JSONObject jsonObject0 = JSONObject.parseObject(jsonObject.get("op").toString());
        DecimalFormat df = new DecimalFormat("0.00");
        Money money = new Money();
        if (jsonObject0.get("code").toString().equals("Y")){
            JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.get("data").toString());
            money.setAccountNo(jsonObject1.get("accountNo").toString());
            money.setZye(floadtoString(jsonObject1.get("zye").toString()));
            money.setKyzj(floadtoString(jsonObject1.get("kyzj").toString()));
            money.setBzj(floadtoString(jsonObject1.get("bzj").toString()));
            money.setDjzj(floadtoString(jsonObject1.get("djzj").toString()));
            money.setZzc(floadtoString(jsonObject1.get("zzc").toString()));
            money.setLjyk(floadtoString(jsonObject1.get("ljyk").toString()));
            money.setDryk(floadtoString(jsonObject1.get("dryk").toString()));
            money.setZsz(floadtoString(jsonObject1.get("zsz").toString()));
            money.setRisk(df.format(jsonObject1.get("risk")));
            money.setZyk(floadtoString(jsonObject1.get("zyk").toString()));
            money.setFdyk(floadtoString(jsonObject1.get("fdyk").toString()));
            money.setBzjByRealTime(floadtoString(jsonObject1.get("bzjByRealTime").toString()));
            money.setProfitRatio(df.format(jsonObject1.get("profitRatio")));
        }
        req.setAttribute("moneyQry", money);




        //持仓汇总

        InputStream path2 = this.getClass().getResourceAsStream("/position.json");
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(path2));
        String string2 = null;
        StringBuffer sbuffer = new StringBuffer();
        while((string2 = reader2.readLine()) != null){
            sbuffer.append(string2);
        }
        JSONObject jsonObject1 = JSON.parseObject(sbuffer.toString());

//        JSONObject jsonObject1 = JSON.parseObject(Hello.sendGet(url2, "accountNo=" + accountNo));
        JSONObject jsonObject2 = JSONObject.parseObject(jsonObject1.get("op").toString());
        List<Position> list = new ArrayList<>();
        if (jsonObject2.get("code").toString().equals("Y")){
            JSONArray jsonArray = JSONArray.parseArray(jsonObject1.get("data").toString());
            if (jsonArray.size() > 0){
                for (int i=0; i<jsonArray.size(); i++){
                    Position position = new Position();
                    position.setAccountNo(jsonArray.getJSONObject(i).get("accountNo").toString());
                    position.setCode(jsonArray.getJSONObject(i).get("code").toString());
                    position.setPositionType(jsonArray.getJSONObject(i).get("positionType").toString());
                    position.setBzj(floadtoString(jsonArray.getJSONObject(i).get("bzj").toString()));
                    position.setExchange(jsonArray.getJSONObject(i).get("exchange").toString());
                    position.setKysl(Integer.valueOf(jsonArray.getJSONObject(i).get("kysl").toString()));
                    position.setZsl(Integer.valueOf(jsonArray.getJSONObject(i).get("zsl").toString()));
                    position.setStockName(jsonArray.getJSONObject(i).get("stockName").toString());
                    position.setCbj(floadtoString(jsonArray.getJSONObject(i).get("cbj").toString()));
                    position.setYk(floadtoString(jsonArray.getJSONObject(i).get("yk").toString()));
                    position.setNowPrice(floadtoString(jsonArray.getJSONObject(i).get("nowPrice").toString()));
                    position.setBzjByRealTime(floadtoString(jsonArray.getJSONObject(i).get("bzjByRealTime").toString()));
                    position.setRemainDay(Integer.valueOf(jsonArray.getJSONObject(i).get("remainDay").toString()));
                    position.setExerciseDate(jsonArray.getJSONObject(i).get("exerciseDate").toString());
                    position.setCallOrPut(jsonArray.getJSONObject(i).get("callOrPut").toString());
                    position.setUnderlyingCode(jsonArray.getJSONObject(i).get("underlyingCode").toString());
                    position.setExpectHoldDays(Integer.valueOf(jsonArray.getJSONObject(i).get("expectHoldDays").toString()));
                    list.add(position);
                }
            }
        }

        req.setAttribute("position", list);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    /**
     * 把返回的资金数据除以100万
     * @param str
     * @return
     */
    public Double floadtoString(String str) {
        double d = Float.valueOf(str) / 1000000.00;

        return d;
    }


}

