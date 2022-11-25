
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Page</title>
    <style>
        input, select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4c4c4c;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #939393;
        }

        label{
            font-weight: bold;
        }

        div {
            background-color: #f2f2f2;
            margin:auto;
            width: 50%;
            padding: 20px;
            border-radius: 10px;
        }
        h1{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>${msg}</h1>
<div>
    <form action="${action}" method="post">
        <label >Order Date</label><br>
        <input type="date" name="orderDate" placeholder="Enter Order Date"><br><br>
        <label >Customer Name</label><br>
        <input type="text" name="name" placeholder="Enter Customer Name"><br><br>
        <label >Quantity</label><br>
        <input type="number" name="quantity" placeholder="Enter Quantity"><br><br>
        <label >Name Product</label><br>
        <select name = "nameProduct">
            <c:forEach var="p" items="${productList}">
                <option value="${p.id}">${p.name}</option>
            </c:forEach>
        </select><br><br>
        <input type="submit" value="Add">
    </form>
    <h3><i style="color: orange">${message}</i></h3>
</div>
</body>
</html>
