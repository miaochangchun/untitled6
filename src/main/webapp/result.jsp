<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.bean.Money"%>
<html>
<body>
<h2>Hello World!</h2>
    <%
        Money money = (Money) request.getAttribute("moneyQry");
    %>
<form action="<%=request.getContextPath()%>/servlet/moneyQryServlet" method="post">
    请输入账户<input type="text" name="account"  value=<%=money.getAccountNo()%>/>
    <input type="submit" value="查询" />
    <br>
</form>

    <table border=1px align="center">
                        <tr>
                            <th>总余额</th>
                            <th>可用保证金</th>
                            <th>占用保证金</th>
                            <th>冻结资金</th>
                            <th>总资产</th>
                            <th>累计盈亏</th>
                            <th>当日盈亏</th>
                            <th>总市值</th>
                            <th>风险度</th>
                            <th>总盈亏</th>
                            <th>浮动盈亏</th>
                            <th>实时已用保证金</th>
                            <th>总收益率</th>
                        </tr>
                        <tr>
                            <th><%=money.getZye()%></th>
                            <th><%=money.getKyzj()%></th>
                            <th><%=money.getBzj()%></th>
                            <th><%=money.getDjzj()%></th>
                            <th><%=money.getZzc()%></th>
                            <th><%=money.getLjyk()%></th>
                            <th><%=money.getDryk()%></th>
                            <th><%=money.getZsz()%></th>
                            <th><%=money.getRisk()%></th>
                            <th><%=money.getZyk()%></th>
                            <th><%=money.getFdyk()%></th>
                            <th><%=money.getBzjByRealTime()%></th>
                            <th><%=money.getProfitRatio()%></th>
                        </tr>
                    </table>


</body>
</html>
