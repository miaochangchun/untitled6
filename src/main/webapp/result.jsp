<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.bean.Money"%>
<%@ page import="com.bean.Position"%>
<%@ page import="java.util.ArrayList"%>
<html>
<body>
<h2>Hello World!</h2>
    <%
        Money money = (Money) request.getAttribute("moneyQry");
        ArrayList<Position> list = (ArrayList) request.getAttribute("position");
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
    <br>
    <br>
    <table border=1px align="center">
        <tr>
            <th>合约代码</th>
            <th>合约名称</th>
            <th>可用数量</th>
            <th>持仓数量</th>
            <th>持仓类型</th>
            <th>持仓保证金</th>
            <th>交易所</th>
            <th>成本价</th>
            <th>盈亏金额</th>
            <th>现价</th>
            <th>实时保证金</th>
            <th>到期天数</th>
            <th>到期日</th>
            <th>认购or认沽</th>
            <th>标的代码</th>
            <th>持仓天数</th>
        </tr>
        <% for(int i=0; i<list.size(); i++){ %>
        <tr>
            <th><%=list.get(i).getCode()%></th>
            <th><%=list.get(i).getStockName()%></th>
            <th><%=list.get(i).getKysl()%></th>
            <th><%=list.get(i).getZsl()%></th>
            <th><%=list.get(i).getPositionType()%></th>
            <th><%=list.get(i).getBzj()%></th>
            <th><%=list.get(i).getExchange()%></th>
            <th><%=list.get(i).getCbj()%></th>
            <th><%=list.get(i).getYk()%></th>
            <th><%=list.get(i).getNowPrice()%></th>
            <th><%=list.get(i).getBzjByRealTime()%></th>
            <th><%=list.get(i).getRemainDay()%></th>
            <th><%=list.get(i).getExerciseDate()%></th>
            <th><%=list.get(i).getCallOrPut()%></th>
            <th><%=list.get(i).getUnderlyingCode()%></th>
            <th><%=list.get(i).getExpectHoldDays()%></th>
        </tr>
        <% } %>
    </center>

</body>
</html>
