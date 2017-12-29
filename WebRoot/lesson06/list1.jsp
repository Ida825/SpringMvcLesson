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
		/**
			封装一个sendAjax方法
		**/
		function sendAjax(url,methodType,param,retnFunction){
			//无刷新调用http://localhost:8080/s/queryFood，获取到数据，数据通过dom方式添加到table中
			//用异步AJAX获取数据 
			//AJAX 创建 XMLHttpRequest（XHR） 对象
			var xmlhttp = null;
			//兼容所有的浏览器创建这类对象 XHR对象 
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			//回调函数 （不需要自己调用）当请求发送后会自动调用该函数
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					//将返回的json传入回调函数中 
					retnFunction(xmlhttp.responseText);
				}
			}
			
			if(methodType=="get" || methodType=="GET"){
				xmlhttp.open("GET",url+"?"+param, true);
				xmlhttp.send();
			}else{
				//用post传值
				xmlhttp.open("POST",url, true);
				xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
				xmlhttp.send(param);
			
			}	
		}
	
	
	function query(){
			var foodname = document.getElementsByName("foodname")[0].value;
			sendAjax("${pageContext.request.contextPath}/queryFood","GET","foodname="+foodname,function(responseText){							
				//接收到字符串的json数据  
				var resultJson = responseText;
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
					
					//添加按钮 
					var td2 = document.createElement("td");
					
					//删除按钮
					var ib = document.createElement("button");
					ib.innerText="X";
					
					//修改按钮
					var ib1 = document.createElement("button");
					ib1.innerText="U";
					
					td2.appendChild(ib);
					td2.appendChild(ib1);
					
					//创建tr标签，并将td放入tr中
					var tr = document.createElement("tr");
					//将food对象赋给按钮 
					ib.foodObj = obj;
					//将tr绑定到按钮 
					ib.myLineTr = tr;
					//给按钮添加事件 （删除按钮事件）
					ib.addEventListener("click",function(){
						//事件中有一个内置对象event,event.srcElement就是按钮（获取当前按钮）
						var eventSrc = event.srcElement;
						//删除当前行+发送AJAX请求到后台，删除数据库中数据 
						table.removeChild(eventSrc.myLineTr);
						sendAjax("${pageContext.request.contextPath}/food/"+ib.foodObj.foodid,"POST","_method=delete",function(responseText){
							if(responseText==1){
								alert("删除成功");
							}else{
								alert("删除失败");
							}	
						
						});
					});
					
					//将json数据绑定到按钮上
					ib1.foodObj=obj;
					ib1.addEventListener("click",function(){
						//获取当前按钮
						var eventSrc=event.srcElement;
						document.getElementById('updateDiv').style.display='block';
						document.getElementsByName("umyFoodName")[0].value=eventSrc.foodObj.foodname;
						document.getElementsByName("umyFoodPrice")[0].value=eventSrc.foodObj.price;
						document.getElementsByName("umyFoodId")[0].value=eventSrc.foodObj.foodid;
					})
					
					//将键为name的值放入作用域中 
					tr.setAttribute("name", "dataTr");
					//将td放入tr
					tr.appendChild(td);
					tr.appendChild(td1);
					tr.appendChild(td2);
					//将tr放入table 
					table.appendChild(tr)		
			
				}
				
			});
		}
	
		/**
			添加菜品
		**/
		function addFood(){
			var myFoodName = document.getElementsByName("myFoodName")[0].value;
			var myFoodPrice = document.getElementsByName("myFoodPrice")[0].value;
			sendAjax("${pageContext.request.contextPath}/food","POST","foodname="+myFoodName+"&price="+myFoodPrice,function(responseText){
				if(responseText==1){
					//添加成功就将添加的div关闭
					document.getElementById('addDiv').style.display='none';
					//添加完再查寻一遍
					query();
					alert("添加成功");
				}else{
					alert("添加失败");
				}	
			
			});
			
		}
		
		
		/**
			修改菜品
		**/
		function updateFood(){
			var myFoodName = document.getElementsByName("umyFoodName")[0].value;
			var myFoodPrice = document.getElementsByName("umyFoodPrice")[0].value;
			var myFoodId = document.getElementsByName("umyFoodId")[0].value;
			sendAjax("${pageContext.request.contextPath}/food/"+myFoodId,"POST","_method=put&foodname="+myFoodName+"&price="+myFoodPrice,function(responseText){
				if(responseText==1){
					//修改成功就将修改的div关闭
					document.getElementById('updateDiv').style.display='none';
					//修改完再查寻一遍
					query();
					alert("修改成功");
				}else{
					alert("修改失败");
				}	
			
			});
			
		}
			
	
	</script>
	</head>
	<body>
		<input type="text" name="foodname" />
		<input type="button" value="查询" onclick="query()" /><input type="button" value="添加" onclick="document.getElementById('addDiv').style.display='block'" />
		<table id="myTable">
			<tr>
				<th>菜品名</th><th>价格</th><th>操作</th>
			</tr>
		</table>
	</body>
	<div id="addDiv" style="display:none;position:absolute;left:45%;top:45%;z-index: 100;border:1px solid black;width:240px;height:240px">
		菜名：<input type="text" name="myFoodName"/><br/>
		价格：<input type="text" name="myFoodPrice"/><br/>
		<input type="button" value="保存" onclick="addFood()"/>
		<input type="button" value="关闭" onclick="document.getElementById('addDiv').style.display='none';"/>	
	</div>
	
	<div id="updateDiv" style="display:none;position:absolute;left:45%;top:45%;z-index: 100;border:1px solid black;width:240px;height:240px">
		<input type="hidden" name="umyFoodId"/>
		菜名：<input type="text" name="umyFoodName"/><br/>		
		价格：<input type="text" name="umyFoodPrice"/><br/>
		<input type="button" value="修改" onclick="updateFood()"/>
		<input type="button" value="关闭" onclick="document.getElementById('updateDiv').style.display='none';"/>	
	</div>
</html>