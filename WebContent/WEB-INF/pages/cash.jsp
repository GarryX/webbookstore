<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>

		<br> <br> 您一共选择了 ${sessionScope.shoppingCart.totalBookNumber } 本书 <br> <br>
		应付：￥ <s:property value="#session.shoppingCart.totalCost"/> <br> <br>
		<s:if test="#request.errors != null">
			<s:property value="#request.errors"/>
		</s:if>
		<br> <br>
		
		<!-- 提交付款用户名及卡号的表单 -->
		<s:form action="cart-cashing" method="post">
			<table cellpadding="1">
				<tr>
					<s:textfield label="用户名" name="userName"></s:textfield>
				</tr>
				<tr>
					<s:textfield label="卡    号" name="accountId"></s:textfield>
				</tr>
				<tr>
					<s:submit value="提交"></s:submit>
				</tr>
			</table>

		</s:form>
	</center>
</body>
</html>