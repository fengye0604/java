<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>点点通页面</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  	<h1>点点通接口</h1>
  	<form action="http://127.0.0.1:8080/knowledge_mobile_api/click/hotWord" method="post">
  	<input name="hotWordId">
  	<input name="type1">
  	<input name="optionId">
  	<input name="optionType">
  	<input name="infoId">
  	<input type="submit">
  	</form>
  	
  </body>
</html>