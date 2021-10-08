<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<html>
<body>
<h2>Hello World!</h2>
<form action="<%=request.getContextPath()%>/servlet/moneyQryServlet" method="post">
    请输入账户<input type="text" name="account" />
    <input type="submit" value="查询资金" />
    <input type="submit" value="查持仓" />
    <br>

</form>

</body>
</html>
