<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

/**
使用AJAX：1.尽量使用true异步模式（防假死）
		 2.尽量将获取数据之后的逻辑处理（页面渲染）放在回调函数中  	


**/
	function query() {
		//无刷新调用http://localhost:8080/s/queryFood，获取到数据，数据通过dom方式添加到table中
		//用异步AJAX获取数据 
		
		//AJAX 创建 XMLHttpRequest（XHR） 对象
		var xmlhttp = null;
		//兼容所有的浏览器创建这类对象 XHR对象 
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		}/* else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}*/
	
		
		//回调函数 （不需要自己调用）当请求发送后会自动调用该函数
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				//接收到字符串的json数据  
				var resultJson = xmlhttp.responseText;
				//将接收到的字符串数据通过json转换成js对象
				var resultObj = JSON.parse(resultJson);
				//alert(resultObj.length);
	
				//获取table表格对象
				var table = document.getElementById("myTable");
				
				//将所有名字是dataTr的tr全部删除 
				var allDataTr = document.getElementsByName("dataTr");
				var len = allDataTr.length;
				for ( var i = 0; i < len; i++) {
					//每次都删除第一个元素 
					table.removeChild(allDataTr[0]);
				}
	
				//遍历数据放入table中，根据json的行数追加多个tr
				for ( var i = 0; i < resultObj.length; i++) {
					//有几条数据，就有几个tr标签 
					var obj = resultObj[i];
					//创建td标签，并将值放入 
					var td = document.createElement("td");
					td.innerText = obj.foodname;
	
					var td1 = document.createElement("td");
					td1.innerText = obj.price;
	
					//创建tr标签，并将td放入tr中
					var tr = document.createElement("tr");
					//将键为name的值放入作用域中 
					tr.setAttribute("name", "dataTr");
					//将td放入tr
					tr.appendChild(td);
					tr.appendChild(td1);
					//将tr放入table 
					table.appendChild(tr)
				}
			}
		}
	
		var foodname = document.getElementsByName("foodname")[0].value;
		//open方法表示产生一个请求的关联（get 提交）
		/*xmlhttp.open("GET","${pageContext.request.contextPath}/queryFood?foodname="+ foodname, true);
		xmlhttp.send();	*/
	
		/**
			一个ajax线程是否执行完成 可以通过回调函数xmlhttp.onreadystatechange是否执行完成来判断 
			异步多个线程同时执行 无法判断 谁先执行 true
			同步一次只允许一个线程执行false 页面会假死
		**/
		//用post传值
		xmlhttp.open("POST","${pageContext.request.contextPath}/queryFood", true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
		xmlhttp.send("foodname="+ foodname);
		
		console.log("哈哈");
	}
</script>
	</head>

	<body>
		<input type="text" name="foodname" />
		<input type="button" value="查询" onclick="query()" />
		<table id="myTable">
			<tr>
				<th>菜品名</th><th>价格</th>
			</tr>
		</table>
	</body>
</html>
