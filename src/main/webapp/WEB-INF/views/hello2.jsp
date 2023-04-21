<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-21
  Time: 오전 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello2</title>
</head>
<body>
    <button onclick="fun1()">파라미터</button>
</body>
<script>
    const fun1 = () => {
        // location.href = "/hello-param1?name=a&age=1";
        const name = "a";
        const age = 1;
        location.href = "/hello-param1?name="+name+"&age="+age;
    }
</script>
</html>
