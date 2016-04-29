<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>

		<s:debug></s:debug>
		<br> <br> You chose total
		${sessionScope.shoppingCart.totalBookNumber } books <br> <br>
		Should pay：$ ${sessionScope.shoppingCart.totalCost } <br> <br>
		<c:if test="${errors != null}">
			<font color="red">${errors }</font>
		</c:if>
		<br> <br>

		<s:form action="cart-cashing" method="post">
			<table cellpadding="1">
				<tr>
					<s:textfield label="CardUserName" name="userName"></s:textfield>
				</tr>
				<tr>
					<s:textfield label="CardId" name="accountId"></s:textfield>
				</tr>
				<tr>
					<s:submit value="CkeckOut"></s:submit>
				</tr>
			</table>

		</s:form>
	</center>
</body>
</html>