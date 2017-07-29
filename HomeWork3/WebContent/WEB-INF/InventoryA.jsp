<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="food.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory</title>
</head>
<body>


<h2>Existing food items</h2>
<table>
<thead>
<tr>
<th>Created</th>
<th>Item</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items = "${items}" var="item">
<tr>
<td><fmt:formatDate value="${date}" type="time" /></td>
<td> <img src="${item.getImageUrl()}" width="100" height="100"> <br> ${item.getName()}</td>
<td><form method="get"> <button name="Submit" value="${item.getName()}">Delete</button></form></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="CreatFoodA">Create new food</a>
</br>
</br>
<a href="MenuServlet">go back to menu</a>

</body>
</html>