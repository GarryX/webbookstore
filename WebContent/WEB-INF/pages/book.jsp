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
		/* 为了保证使用条件查询之后返回到书目列表页中查询条件依然有效，
		在点击当前页面中的每个链接的时候，都追加隐藏域中的minPrice及
		maxPrice参数。 */
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
		<!-- 两个隐藏域分别保存从上一个页面传过来的minPrice及maxPrice参数 -->
		<input type="hidden" name="minPrice" value="${param.minPrice }" /> 
		<input type="hidden" name="maxPrice" value="${param.maxPrice }" />
		<table cellpadding="10">
			<tr>
				<td>书名</td>
				<td>:&nbsp;&nbsp; ${book.title }</td>
			</tr>
			<tr>
				<td>作者</td>
				<td>:&nbsp;&nbsp; ${book.author }</td>
			</tr>
			<tr>
				<td>单价</td>
				<td>:&nbsp;&nbsp; ${book.price }</td>
			</tr>
			<tr>
				<td>发行日期</td>
				<!-- 使用Struts2的date标签格式化出版日期的输出 -->
				<td>:&nbsp;&nbsp; <s:date name="#attr.book.publishingDate" format="yy-MM-dd" /></td>
			</tr>
		</table>
		<a href="book-listBooks?">返回购物</a>
	</center>
</body>
</html>