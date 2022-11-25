
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Page</title>
    <style>
        table {
            width: 75%;
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
            margin-left: 5px;
        }

        a{
            text-decoration: none;
        }

        button>a{
            font-weight: bold;
        }

        .header{
            display: flex;
            width: 75%;
            /*                margin: 0 auto 10px;*/
            margin-left: 13%;
            margin-bottom: 10px;
        }

        .form{
            margin-right: 10px;
        }

        input{
            padding: 5px 10px;
        }

        i{
            margin-left: 45%;
        }
    </style>
</head>
<body>
<h1>List All Products</h1>
<div class="header">
    <div class="form">
        <form action="searchUser" method="get">
            <input type="text" name="search" value="${search}">
            <input type="submit" value="Search">
        </form>
    </div>
    <div class="button">
        <button class="second"><a href="add_user.jsp">Add New</a></button>
    </div>

</div>
<table border="true">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Unit Price</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="p" items="${productList}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.unitPrice}</td>
            <td>Delete</td>
        </tr>
    </c:forEach>
    <h3><i style="color: red">${message}</i></h3>
</table>

</body>
</html>