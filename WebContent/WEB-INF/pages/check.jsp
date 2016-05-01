<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<!-- 提交查询购物记录的表单 -->
		<s:form action="user-checking" method="post">
			<s:textfield label="用户名" name="userName"></s:textfield>
			<s:submit value="查询"></s:submit>
		</s:form>
	</center>
</body>
</html>