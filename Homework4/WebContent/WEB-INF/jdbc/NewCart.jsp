<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="food.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
</head>
<body>
    <h2>Cart</h2>
    
    
        <table>
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${cartItems}" var="food">
                    <tr>
                        <td><img src="${food.getImage()}" width="100" height="100"><br>${food.getName()}</td>
                        <td>${food.getPrice()}</td>
                        <td> ${food.getQuantity()}</td>
                        <td><form method="get"><button name ="delete" value="${food.getId()}">Delete</button></form>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    <a href="MenuNewServlet">Back to menu
        page</a>
            <form method="post">
        <label for="customer name">Please enter your name: </label> <br>
        <input name="customerName" id="customerName" type="text"><br>
    <input type="submit" value= "Place order">
</form>
</body>
</html>