<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.util.*"%>
<html>
<body>
<h2>Hello World!</h2>
    <%
        String zye = request.getParameter("zye");
        String accountNo = request.getParameter("account");
    %>
    <form action="<%=request.getContextPath()%>/servlet/transMoneyServlet" method="post">
        账户<input type ="text" name="accountNo" value="<%=accountNo%>" /><br>
        划拨方向
        <select name="side">
            <option value="1">划入资金</option>
            <option value="0">划出资金</option>
        </select><br>
        可  划 入<input type="text" name="khr" value="10000000000" disabled /><br>
        可  划 出<input type ="text" name="khc" value="<%=zye%>" disabled /><br>
        资金划拨<input type="text" name="money" /><br>
        <input type="submit" value="划拨" />
    </form>


</body>
</html>
