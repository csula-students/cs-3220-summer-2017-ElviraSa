<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="food.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>
</head>
<body>
	<h2>Menu</h2>

	<table id ="menu">
		<thead>
			<tr>
				<th>Image</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Add</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td><img src="${item.getImageUrl()}" width="100" height="100"></td>
					<td>${item.getName()}</td>
					<td>${item.getDescription()}</td>
					<td>${item.getPrice()}</td>
					<td><form method="post">
							<button name="Add" value="${item.getName()}">Add</button>
						</form></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
<a href="InventoryA">go to inventory page</a>
</body>
</html>