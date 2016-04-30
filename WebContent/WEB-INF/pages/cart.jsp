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
		//点击"删除"链接，弹出确认框
		$(".delete").click(function() {
			var $tr = $(this).parent().parent();
			var title = $.trim($tr.find("td:first").text());
			var flag = confirm("确定要移除" + title + "吗?");
			if (flag) {
				return true;
			}
			return false;
		});
		
		//点击"清空购物车"链接，弹出确认框
		$(".clear").click(function() {
			var flag = confirm("您确定要清空购物车吗？");
			if (flag) {
				return true;
			}
			return false;
		});
		
		 // 根据商品数量的变化，得用Ajax异步请求返回新的总账单	
		$(":text").change(function() {
			var quantityVal = $.trim(this.value);
			var flag = false;
			var reg = /^\d+$/g;
			var quantity = -1;
			//验证修改的数量是否是合法值
			if (reg.test(quantityVal)) {
				quantity = parseInt(quantityVal);
				if (quantity >= 0) {
					flag = true;
				}
			}
			if (!flag) {
				alert("输入的数量不合法!");
				$(this).val($(this).attr("class"));
				return;
			}
			var $tr = $(this).parent().parent();
			var title = $.trim($tr.find("td:first").text());
			//如果数量被修改为0，则提示从购物车中删除该购物项
			if (quantity == 0) {
				//得到 a 节点
				var $a = $tr.find("td:last").find("a");
				//执行 a 节点的 click 响应函数. 
				$a[0].click();
				return;
			}
			var flag = confirm("确定要修改" + title + "的数量吗?");
			if (!flag) {
				$(this).val($(this).attr("class"));
				return;
			}
			// 请求地址为: cart-updateItemQuantity
			var url = "cart-updateItemQuantity";
			// 请求参数为:  id:name属性值, quantity:val, time:new Date()
			var idVal = $.trim(this.name);
			var args = {
				"id" : idVal,
				"quantity" : quantityVal,
				"time" : new Date()
				};

			/* 
				在 updateItemQuantity 方法中, 获取 quanity, id, 再获取购物车对象, 
				调用 CartService的相关方法做修改
				传回 字符串 数据: totalBill
				更新当前页面的 totalNumber 和 totalBill 
			*/
			$.post(url, args, function(data) {
				$("#totalBill").text(data);
				$("#totalNumber").text(quantityVal);
			}, "text");

		});
	})
</script>
</head>
<body>
	<center>
		<h1>购物车</h1>
		<br>
		<br>
		<br>  
		目前您的购物车中共有 <font color="red" id="totalNumber">
			${shoppingCart.totalBookNumber } </font> 本书
		<br>
		<br>
		<br>
		<table cellpadding="10">
			<tr>
				<td>书名</td>
				<td>单价</td>
				<td>数量</td>
			</tr>
			<!-- 遍历购物车中的购物项，并输出书名，单价，数量等信息 -->
			<s:iterator value="#session.shoppingCart.shoppingCartItems"
				var="item">
				<tr>
					<td>${item.book.title }</td>
					<td>${item.book.price }</td>
					<td><input type="text" name="${item.book.id }" value="${item.quantity }"
						size="1" class="${item.quantity}"/></td>
					<td><a href="cart-deleteItem?bookId=${item.book.id }" class="delete">删除</a></td>
				</tr>
			</s:iterator>
			<tr>
				<td>总金额</td>
				<td>￥ <font class="red" id="totalBill"> ${shoppingCart.totalCost } </font></td>
			</tr>
			<tr>
				<td><a href="book-listBooks">继续购物</a></td>
				<td><a href="cart-clearCart" class="clear">清空购物车</a></td>
				<td><a href="cart-goCashing">结账</a></td>
			</tr>

		</table>
	</center>
</body>
</html>