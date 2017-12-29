<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>


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
	
	<script type="text/javascript">
		function checkSubmit(){
			document.forms[0].submit();
		}
	</script>
  </head>
  
  <body>
  	<a href="${pageContext.request.contextPath }/mid?a=zh_CN" ><s:message code="language1"></s:message></a>  <a href="${pageContext.request.contextPath }/mid?a=en_US"><s:message code="language2"></s:message></a>
	<form action="<%=path %>/myreg" method="post">
		<s:message code="userName"></s:message>：<input type="text" name="userName"/>
		<font color=red><form:errors path="user.userName"></form:errors></font>
		<br/>
		<s:message code="password"></s:message>：<input type="text" name="password"/>
		<font color=red><form:errors path="user.password"></form:errors></font>
		<br/>
		<s:message code="repassword"></s:message>：<input type="text" name="repassword"/>
		<font color=red><form:errors path="user.repassword"></form:errors></font>
		<br/>
		<s:message code="email"></s:message>：<input type="text" name="email"/>
		<font color=red><form:errors path="user.email"></form:errors></font>
		<br/>
		<s:message code="age"></s:message>：<input type="text" name="age"/>
		<font color=red><form:errors path="user.age"></form:errors></font>
		<br/>
		<s:message code="phone"></s:message>：<input type="text" name="phone"/>
		<font color=red><form:errors path="user.phone"></form:errors></font>
		<br/>
		<!-- 时间输入格式：yyyy-MM-dd  -->
		<s:message code="birthday"></s:message>:<input type="text" name="birthday"/>
		<font color=red><form:errors path="user.birthday"></form:errors></font>
		<br/>
		<!-- 个人网址 http://www.baidu.com  http://ip:端口/  -->
		<s:message code="web"></s:message>：<input type="text" name="web"/>
		<font color=red><form:errors path="user.web"></form:errors></font>
		
		<br/>
		<font color=red><input type="button" value="<s:message code='register'></s:message>" onclick="checkSubmit()"/>
	</form>
	
  </body>
</html>
