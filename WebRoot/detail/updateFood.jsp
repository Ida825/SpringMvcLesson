﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath}/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/detail/style/css/index_1.css" />
</head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
	
			<img border="0" width="13" height="13" src="style/images/title_arrow.gif"/> 更新新菜品	
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">

	<!-- 文件上传
		1.表单特点：post
		2.设置编码格式：enctype="multipart/form-data"
		3.文件选择框 <input type="file" name="imageUrl"/>
	 -->
	<!-- 表单内容 -->
	<form action="${pageContext.request.contextPath }/food/${param.foodid}" method="post" enctype="multipart/form-data">
		<input type="hidden" name="_method" value="put"/>
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
               
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="foodname" class="InputStyle" value="${param.foodname}"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="price" class="InputStyle" value="${param.price}"/> *</td>
						</tr>
								
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								
									<img style='width:68px;height:68px' 
									src="${pageContext.request.contextPath}/images/${param.img}">
									
									<input type="hidden" name="img" value="${param.img}"/>
								
								<input type="file" name="imageUrl"/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
		
					 <input type="submit" value="修改" class="FunctionButtonInput">

            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>
</body>
</html>
