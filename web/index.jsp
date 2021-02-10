<%--
  Created by IntelliJ IDEA.
  User: kwin
  Date: 2021/2/8
  Time: 上午3:06
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.kkk.test.service.StudentService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kkk.test.entity.StudentEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>列表页</title>
  </head>
  <body>
  <div>
    <ul>
      <li>
        <a href="./student/add.jsp">
          新增
        </a>
      </li>
    </ul>
  </div>
  <div>
    <%
      StudentService studentService = new StudentService();

      List<StudentEntity> students = studentService.getList();
    %>

    <table width="960px">
      <tr>
        <th>id</th>
        <th>名字</th>
        <th>年龄</th>
        <th>操作</th>
      </tr>

      <%
        if (!students.isEmpty()) {
      %>
      <%
        for (StudentEntity student: students) {
      %>
      <tr>
        <td>1</td>
        <td>张三</td>
        <td>10</td>
        <td>
          删除
        </td>
      </tr>
      <%
        }
      %>
      <%
        }
      %>
    </table>
  </div>
  </body>
</html>
