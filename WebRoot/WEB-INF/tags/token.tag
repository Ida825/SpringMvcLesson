<%@tag language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@attribute name="tokenName" required="false"%>
<%
	//产生一个随机标识 
	String randomStr  = UUID.randomUUID().toString();
	String key = (tokenName==null?"myToken":tokenName);
	//将key设置到session中 
	session.setAttribute(key,randomStr);
 %>
<input type="hidden" name="<%=key %>" value="<%=randomStr%>"/>