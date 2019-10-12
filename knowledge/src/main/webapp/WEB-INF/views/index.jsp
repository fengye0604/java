<%--
  Created by IntelliJ IDEA.
  User: yanggaoli
  Date: 2019/10/10
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <link  rel="stylesheet" href="./css/myCss.css" type="text/css">
    <script type="text/javascript" src="./jquery-1.4.2.min.js"></script>
    <script language="JavaScript" type="application/javascript">
        $(function(){
            alert(11);
        })
        function sub_mit(){
            alert("111");

            var username = $("#username").val();
            console.info(username)

            $("#login_form").submit();
        }
    </script>
</head>
<body>
    我是${name}<%=path%><br>
    <c:forEach items="${list}" var="info">
        ${info},
    </c:forEach>
    <form id="login_form" action="<%=path%>/index" >
        <table>
            <tr>
                <td>
                    用户名：<input id="username" type="text" name="username" value=""/>
                </td>
                <td>
                    密码：<input type="password" name="password" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" value="提交" onclick="sub_mit()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
