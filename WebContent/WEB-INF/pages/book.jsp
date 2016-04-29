<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.12.0.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {
			var serializeVal = $(":hidden").serialize();
			window.location.href = this.href + "&" + serializeVal;
			return false;
		})
	})
</script>
</head>
<body>
	<center>
		<s:debug></s:debug>
		<input type="hidden" name="minPrice" value="${param.minPrice }" /> 
		<input type="hidden" name="maxPrice" value="${param.maxPrice }" />
		<table cellpadding="10">
			<tr>
				<td>Title</td>
				<td>: ${book.title }</td>
			</tr>
			<tr>
				<td>Author</td>
				<td>: ${book.author }</td>
			</tr>
			<tr>
				<td>Price</td>
				<td>: ${book.price }</td>
			</tr>
			<tr>
				<td>Launched Date</td>
				<td>: <s:date name="#attr.book.publishingDate" format="yy-MM-dd" /></td>
			</tr>
		</table>
		<a href="book-listBooks?">Return To Shop</a>
	</center>
</body>
</html>