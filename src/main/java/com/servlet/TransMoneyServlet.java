package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.utils.Hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TransMoneyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String url = "http://101.226.207.134:8080/lan/moneyTransfer";
        String accountNo = req.getParameter("accountNo");
        String money = req.getParameter("money");
        String side = req.getParameter("side");
        String param = "accountNo=" + accountNo + "&money=" + money + "&outAccountCounter=&outAccountNo=&side=" + side;
        String str = Hello.sendGet(url, param);
//        System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        JSONObject jsonObject1 = jsonObject.getJSONObject("op");
        if (jsonObject1.get("code").toString().equals("Y")){
            req.setAttribute("message", "success");
//            req.setAttribute("money", );
        }else{
            req.setAttribute("message", "fail");
        }
        req.getRequestDispatcher("/transMoney.jsp").forward(req, resp);
    }
}
