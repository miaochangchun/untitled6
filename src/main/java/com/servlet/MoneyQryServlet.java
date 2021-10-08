package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bean.Money;
import com.utils.Hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class MoneyQryServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String accountNo = req.getParameter("account");
        String url = "http://101.226.207.134:8080/money/detail";
        String url2 = "http://101.226.207.134:8080/position/detail";
        JSONObject jsonObject = JSON.parseObject(Hello.sendGet(url, "accountNo=" + accountNo));
        JSONObject jsonObject0 = JSONObject.parseObject(jsonObject.get("op").toString());
        DecimalFormat df = new DecimalFormat("0.00%");
        Money money = new Money();
        if (jsonObject0.get("code").toString().equals("Y")){
            JSONObject jsonObject1 = jsonObject.parseObject(jsonObject.get("data").toString());
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

