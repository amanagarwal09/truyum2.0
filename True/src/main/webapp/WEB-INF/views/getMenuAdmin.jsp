<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MENU ADMIN</title>
<link href="style.css" type="text/css" rel="stylesheet">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-family: cursive;
}

a {
	color: darkblue;
	text-decoration: none;
}

a:active {
	color: red;
}

header {
	background: cornflowerblue;
	padding: 30px;
	font-weight: bold;
	width: 840px;
	height: 40px;
}

nav {
	float: right;
	line-height: 40px;
}

#truyumtitle {
	color: white;
	float: left;
	line-height: 40px;
	font-size: 1.8em;
	padding-left: 20px;
}

#truyumspoon {
	color: white;
	height: 40px;
	float: left;
}

footer {
	background-color: cornflowerblue;
	padding: 30px;
	font-weight: bold;
	color: white;
	font-size: 1.4em;
}

body {
	width: 900px;
	margin: 0px auto;
	border: 1px solid black;
}

#container {
	height: 400px;
	clear: both;
	padding-left: 40px;
	overflow: auto;
}

#container h3 a {
	font-weight: 100px;
	text-decoration: none;
	color: darkblue;
}

header nav a {
	font-weight: 100px;
	text-decoration: none;
	color: white;
}

#container h3 a:active {
	color: red;
}

#header nav a:active {
	color: red;
}

#getMenuCustomer {
	border: 1px solid black;
	font-size: 14px;
	width: 820px;
}

#getMenuCustomer td {
	padding: 10px;
	text-align: center;
}

#getMenuCustomer td a:active {
	color: red;
}

#msg {
	background-color: aquamarine;
	margin-left: 45%;
	border-radius: 50px;
}

input[type="text"] {
	padding: 10px;
	margin-left: 20px;
}

input[type="submit"] {
	padding: 10px;
	width: 270px;
}

input[type="date"] {
	padding: 10px;
	margin-left: 20px;
	width: 198.5px;
}

input[type="radio"] {
	margin-left: 10px;
}

input[type="checkbox"] {
	margin-left: 20px;
}

select {
	padding: 10px;
	margin-left: 20px;
}

#getMenuAdmin {
	font-size: 12px;
	text-align: center;
	width: 820px;
}

#getMenuAdmin td a {
	font-weight: 100px;
	text-decoration: none;
	color: darkblue;
}

#getMenuAdmin td {
	padding: 6.5px;
}

#addToCart {
	border: 1px solid black;
	width: 820px;
	text-align: center;
}

#addToCart td, th {
	border: 1px solid black;
	font-size: 0.8em;
	padding: 5px;
}

#addToCart #del, #addToCart #tot {
	border: 1px solid white;
}

#addToCart #del {
	background-color: red;
	color: white;
	font-weight: 600;
	text-shadow: 1px 2px black;
	border-radius: 5px;
}

#addToCart #del a {
	color: white;
	text-decoration: none;
}

#addToCart #del a:active {
	color: black;
	text-shadow: 1px 2px white;
}
</style>
</head>
<body>
	<header>
		<img src="spoon.png" id="truyumspoon"> <span id="truyumtitle">
			TRUYUM WEB APP </span>
		<nav>
			<a href="#">MENU</a>
		</nav>
	</header>
	<div id="container">
		<br>
		<h1>Get Menu Admin</h1>
		<br>
		<table id="getMenuAdmin" border="1">
			<thead>
				<tr>
					<th>NAME</th>
					<th>PRICE</th>
					<th>ACTIVE</th>
					<th>DATE OF LAUNCH</th>
					<th>CATEGORY</th>
					<th>FREE DELIVERY</th>
					<th>ACTION</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${adminlist }" var="admin">
					<tr>
						<td>${admin.name }</td>
						<td>Rs.${admin.price }/-</td>
						<td>${admin.active }</td>
						<td>${admin.dateOfLaunch }</td>
						<td>${admin.category }</td>
						<td>${admin.freeDelivery }</td>
						<td><a href="modify?id=${admin.id }">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer>&copy; Copyright 2020 TruYum Pvt. Ltd. </footer>
</body>
</html>