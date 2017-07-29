<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="food.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Statuses</title>
</head>
<body>

<h2>Order Statuses</h2>
<table>
<thead>

<tr>
<th>Created</th>
<th>Item</th>
<th>Customer</th>
<th>Status</th>
</tr>
</thead>
<tbody>
<form method="get">
<c:forEach items = "${orders}" var="order">
<tr>
<td>"${order.getCreated()}"</td>
<td> 
<c:forEach items="${order.getItems() }" var="item">
<img src="${item.getImageUrl()}" width="100" height="100"> 

</c:forEach></td>

<td> ${order.getCustomName()}</td>
<td> ${order.getStatuses()}</td>
</tr>
</c:forEach>
</form>
<a href="MenuServlet">Back to menu
        page</a>
</body>
</html>