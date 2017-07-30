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
            <c:forEach items="${list}" var="list">
                <tr>
                    <td><img src="${list.image}" width="100" height="100"></td>
                    <td>${list.item}</td>
                    <td>${list.description}</td>
                    <td>${list.price}</td>
                    <td><form method="post">
                            <button name="Add" value="${list.id}">Add</button>
                        </form></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
<a href="CreatMenuServlet">Create new food</a>
</body>
</html>