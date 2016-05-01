<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<br>
		用户: <font color="red">${user.userName }</font>
		<br>
		<table cellpadding="5" cellspacing="0" border="1">
			<c:forEach items="${trades }" var="trade">
				<tr ><td colspan="3"><c:out value="交易时间: ${trade.tradeTime }"></c:out></td></tr>
				<tr>
					<td>书名</td>
					<td>单价</td>
					<td>数量</td>
				</tr>
				<c:forEach items="${trade.items }" var="item">
					<tr>
						<td><c:out value="${item.book.title }"></c:out></td>
						<td><c:out value="${item.book.price }"></c:out></td>
						<td><c:out value="${item.quantity }"></c:out></td>
					</tr>
				</c:forEach>
				<br>
				<br>
			</c:forEach>
		</table>
		<br>
		<a href="book-listBooks">继续购物</a>
	</center>
</body>
</html>