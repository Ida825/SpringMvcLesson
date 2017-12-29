<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
	<form action="${pageContext.request.contextPath}/user" method="post">
		姓名：<input type="text" name="name"/>
		性别：<input type="text" name="sex"/>
		年龄：<input type="text" name="age"/>
		描述：<input type="text" name="desci"/>
		<input type="submit" value="添加"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/user/1" method="get">
		ID：<input type="text" name="id"/>
		<input type="submit" value="查询"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/user/2" method="post">
	<input type="hidden" name="_method" value="put"/>
		<input type="submit" value="修改"/>
	</form>
	
	
	<form action="${pageContext.request.contextPath}/user/3" method="post">
	<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="删除"/>
	</form>
	
  </body>
</html>
