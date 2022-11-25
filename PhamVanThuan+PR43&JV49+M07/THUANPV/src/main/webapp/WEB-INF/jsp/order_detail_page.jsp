
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Detail Page</title>
    <style>
        table {
            width: 100%;
            margin: auto;
        }

        tr {
            height: 50px;
        }

        thead>tr>th {
            background: #00397f;
            vertical-align: middle;
            border: 1px solid #4c4c4c;
            text-align: center;
            font-size: 16px;
            font-family: fontM;
            line-height: normal;
            color: #fff;
            text-transform: none;
        }

        tbody {
            font-size: 16px;
            font-family: fontL;
            line-height: normal;
            color: #252525;
            text-transform: none;
        }

        td, th {
            padding: 0;
            border: 1px solid #4c4c4c;
            text-align: center;
            background: #f0f0f0;
        }

        tbody>tr:nth-child(odd) {
            background: #f9f9f9;
        }
        h1{
            text-align: center;
        }

        .home{
            padding: 5px 10px;
        }

        .first,.second{
            padding: 5px 10px;
            margin-right: 5px;
        }

        a{
            text-decoration: none;
        }

        button>a{
            font-weight: bold;
        }

        .header{
            display: flex;
            width: 100%;
            margin-bottom: 10px;
        }

        .form{
            margin-left: 5px;
        }

        input{
            padding: 5px 10px;
        }

        i{
            margin-left: 45%;
        }

        .container{
            width: 75%;
            margin: auto;
        }
    </style>
</head>
<body>
<h1>List All Order Details</h1>
<div class="container">
    <div class="header">
        <div class="button">
            <button class="first"><a href="/">Home</a></button>
            <button class="second"><a href="/newOrder">Add New</a></button>
        </div>
        <div class="form">
            <form:form action="search" method="get">
                <input type="text" name="searchInput" value="${searchInput}" placeholder="Search by customer name">
                <input type="submit" value="Search">
            </form:form>
        </div>
    </div>
    <table>
        <tr>
            <th>Order Detail ID</th>
            <th>Quantity</th>
            <th>Order ID</th>
            <th>Product Name</th>
            <th>Product Unit Price</th>
        </tr>
        <c:forEach items="${orderDetails}" var="d">
        <tr>
            <td>${d.id}</td>
            <td>${d.quantity}</td>
            <td>${d.order.id}</td>
            <td>${d.product.name}</td>
            <td>$${String.format("%.0f",d.product.unitPrice)}</td>
            </c:forEach>
        </tr>
    </table>
</div>

</body>
</html>
