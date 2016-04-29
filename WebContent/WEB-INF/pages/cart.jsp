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
		$(".delete").click(function() {
			var $tr = $(this).parent().parent();
			var title = $.trim($tr.find("td:first").text());
			var flag = confirm("确定要移除" + title + "吗?");
			if (flag) {
				return true;
			}
			return false;
		});
		
		$(".clear").click(function() {
			var flag = confirm("您确定要清空购物车吗？");
			if (flag) {
				return true;
			}
			return false;
		});
		$(":text").change(function() {
			var quantityVal = $.trim(this.value);
			var flag = false;
			var reg = /^\d+$/g;
			var quantity = -1;
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

			if (quantity == 0) {
				var flag2 = confirm("确定要移除" + title + "吗?");
				if (flag2) {
					//得到 a 节点
					var $a = $tr.find("td:last").find("a");
					//执行 a 节点的 click 响应函数. 
					$a[0].onclick();
					return;
				}
			}

			var flag = confirm("确定要修改" + title + "的数量吗?");
			if (!flag) {
				$(this).val($(this).attr("class"));
				return;
			}
			//2. 请求地址为: cart-updateItemQuantity
			var url = "cart-updateItemQuantity";
			//3. 请求参数为:  id:name属性值, quantity:val, time:new Date()
			var idVal = $.trim(this.name);
			var args = {
				"id" : idVal,
				"quantity" : quantityVal,
				"time" : new Date()
				};

			//4. 在 updateItemQuantity 方法中, 获取 quanity, id, 再获取购物车对象, 调用 service 的方法做修改
			//5. 传回 JSON 数据: totalNumber:xx, totalBill

			//6. 更新当前页面的 totalNumber 和 totalBill
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
		<h1>Shopping Cart</h1>
		<br>
		<br>
		<br>  
		There are <font color="red" id="totalNumber">
			${shoppingCart.totalBookNumber } </font> books in your cart
		<br>
		<br>
		<br>
		<table cellpadding="10">
			<tr>
				<td>Title</td>
				<td>Price</td>
				<td>Quantity</td>
			</tr>
			<s:iterator value="#session.shoppingCart.shoppingCartItems"
				var="item">
				<tr>
					<td>${item.book.title }</td>
					<td>${item.book.price }</td>
					<td><input type="text" name="${item.book.id }" value="${item.quantity }"
						size="1" class="${item.quantity}"/></td>
					<td><a href="cart-deleteItem?bookId=${item.book.id }" class="delete">Delete</a></td>
				</tr>
			</s:iterator>
			<tr>
				<td>Total Bill</td>
				<td>$ <font class="red" id="totalBill"> ${shoppingCart.totalCost } </font></td>
			</tr>
			<tr>
				<td><a href="book-listBooks">Continue</a></td>
				<td><a href="cart-clearCart" class="clear">Clear Cart</a></td>
				<td><a href="cart-goCashing">Go To Cash</a></td>
			</tr>

		</table>
	</center>
</body>
</html>