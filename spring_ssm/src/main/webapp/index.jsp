
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <a href="account/findAll">查询所有账户</a>

    <form action="account/transfer" method="post">
        转出id<input type="text" name="sourceId"><br>
        转入id<input type="text" name="targetId"><br>
        转出金额<input type="text" name="money"><br>
        <input type="submit" value="确定">
    </form>
</body>
</html>
