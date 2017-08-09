<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="food.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order Statuses A</title>
</head>
<body>
    <h2>Order Statuses Administration</h2>

    <table>
        <thead>
            <tr>
                <th>Created</th>
                <th>Item </th>
                <th>Customer</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <form method="get">
                <c:forEach items="${list}" var="order">
                    <tr>
                        <td>"${order.created}"</td>
                        <td><img src="${order.item_img}" width="100" height="100"></td>
                        <td>"${order.castomer_name}" </td>
                        <td>"${order.statuse }"</td>    
                    </tr>
                </c:forEach>
                
                
                
            </form>
        </tbody>

    </table>


</body>
</html>