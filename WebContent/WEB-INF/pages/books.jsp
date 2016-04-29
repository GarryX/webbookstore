<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:if test="${param.title != null }">
			您已经将<font color="red">${param.title }</font>添加到购物车中
			<br>
			<br>
		</c:if>
		<c:if test="${!empty sessionScope.shoppingCart.shoppingCartItems }">
			您的购物车中共有${sessionScope.shoppingCart.totalBookNumber }件商品，<a
				href="book-checkCart?bookId=${book.id }&pageNo=${page.pageNo}">查看购物车</a>
			<br>
		</c:if>
		<input type="hidden" name="minPrice" value="${param.minPrice }" /> <input
			type="hidden" name="maxPrice" value="${param.maxPrice }" /> <br>
		<br>
		<s:form action="book-listBooks" method="get" theme="simple">
			Price: <s:textfield name="minPrice" size="1"></s:textfield>
				   - <s:textfield name="maxPrice" size="1"></s:textfield>
			<s:submit value="Check"></s:submit>
		</s:form>
		<table cellpadding="10">
			<s:iterator value="#request.page.list" var="book">
				<tr>
					<td><a href="book-listBook?bookId=${book.id }">${book.title }</a><br>${book.author }</td>
					<td>${book.price }</td>
					<td><a href="book-addToCart?bookId=${book.id }&pageNo=
						${page.pageNo}&title=${book.title }">
						Add To Cart</a></td>
				</tr>
			</s:iterator>
		</table>
		<br> <br> 共 ${request.page.totalPageNumber} 页&nbsp;&nbsp;
		当前第 ${request.page.pageNo } 页 &nbsp;&nbsp;
		<s:if test="%{#request.page.pageNo != 1}">
			<a href="book-listBooks?pageNo=1">首页</a>
			<a href="book-listBooks?pageNo=${page.prevPage }">上一页</a>
		</s:if>
		<s:if test="%{#request.page.pageNo != #request.page.totalPageNumber}">
			<a href="book-listBooks?pageNo=${page.nextPage }">下一页</a>
			<a href="book-listBooks?pageNo=${page.totalPageNumber }">尾页</a>
		</s:if>
		<br> <br>
		<s:form action="book-listBooks" theme="simple" method="get">
			Jump To Page <s:textfield name="pageNo" size="1"></s:textfield>
			<input type="hidden" name="minPrice" value="${param.minPrice }" />
			<input type="hidden" name="maxPrice" value="${param.maxPrice }" />
			<s:submit value="Go"></s:submit>
		</s:form>
	</center>
</body>
</html>