<%--
  Created by IntelliJ IDEA.
  User: kwin
  Date: 2021/2/8
  Time: 上午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
      Hello World!!
  </div>
  <div>
    <form action="/bms/student/store" method="post">
      <p>
        <input type="text" name="name" placeholder="用户名" />
      </p>
      <p>
        <input type="text" name="num" placeholder="学号" />
      </p>
      <p>
        <input type="number"  name="age" placeholder="年龄" />
      </p>
      <p>
        <button type="submit">提交</button>
      </p>
    </form>
  </div>
  </body>
</html>
