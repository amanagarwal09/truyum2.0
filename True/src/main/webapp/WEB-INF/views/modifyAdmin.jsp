<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT MENU ITEM</title>
    <link href="style.css" type="text/css" rel="stylesheet">
  <style type="text/css">
	*{
    padding: 0;
    margin: 0;
    font-family: cursive;
}
a{
    color: darkblue;
    text-decoration: none;
}
a:active{
    color: red;
}
header{
    background: cornflowerblue;
    padding: 30px;
    font-weight: bold;
    width: 840px;
    height: 40px;
}
nav{
    float: right;
    line-height: 40px;
}
#truyumtitle{
    color: white;
    float: left;
    line-height: 40px;
    font-size: 1.8em;
    padding-left: 20px;
}
#truyumspoon{
    color: white;
    height: 40px;
    float: left;
}
footer{
    background-color: cornflowerblue;
    padding: 30px;
    font-weight: bold;
    color: white;
    font-size: 1.4em;
}
body{
    width: 900px;
    margin: 0px auto;
    border: 1px solid black;
}
#container{
    height: 400px;
    clear: both;
    padding-left: 40px;
    overflow: auto;
}
#container h3 a{
    font-weight: 100px;
    text-decoration: none;
    color: darkblue;
}
header nav a{
    font-weight: 100px;
    text-decoration: none;
    color: white;
}
#container h3 a:active{
    color: red;
}
#header nav a:active{
    color: red;
}
#getMenuCustomer{
    border: 1px solid black;
    font-size: 14px;
    width: 820px;
}
#getMenuCustomer td{
    padding: 10px;
    text-align: center;
}

#getMenuCustomer td a:active{
    color: red;
}
#msg{
    background-color: aquamarine;
    margin-left: 45%;
    border-radius: 50px;
}
input[type="text"]{
    padding: 10px;
    margin-left: 20px;
}
input[type="submit"]{
    padding: 10px;
    width: 270px;
}
input[type="date"]{
    padding: 10px;
    margin-left: 20px;
    width: 198.5px;
}
input[type="radio"]{
    margin-left: 10px;
}
input[type="checkbox"]{
    margin-left: 20px;
}
select{
    padding: 10px;
    margin-left: 20px;
}
#getMenuAdmin{
    font-size: 12px;
    text-align: center;
}
#getMenuAdmin td a{
    font-weight: 100px;
    text-decoration: none;
    color: darkblue;
}
#getMenuAdmin td{
    padding: 6.5px;
}
#addToCart{
    border: 1px solid black;
    width: 820px;
    text-align: center;
}
#addToCart td, th{
    border: 1px solid black;
    font-size: 0.8em;
    padding: 5px;
}
#addToCart #del,#addToCart #tot{
    border: 1px solid white;
}
#addToCart #del{
    background-color: red;
    color: white;
    font-weight: 600;
    text-shadow: 1px 2px black;
    border-radius: 5px;
}
#addToCart #del a{
    color: white;
    text-decoration: none;
}
#addToCart #del a:active{
    color: black;
    text-shadow: 1px 2px white;
}

        h1{
            text-align: center;
        }
        input[type="submit"]{
            width: 100%;
        }
        table{
            margin: 0px auto;
        }
    </style>
</head>
<body>
    <header>
        <img src="spoon.png"id="truyumspoon">
        <span id="truyumtitle">
            TRUYUM WEB APP
        </span>
        <nav>
            <a href="getMenuAdmin">MENU</a>
        </nav>
    </header>
    <div id="container"><br>
	<h1>EDIT MENU ITEM</h1>
        <br>
	<form method="post" action="updateAdmin">
        <table>
            <tr>
                <input type="text" name="id" value="${id }" readonly="readonly" hidden="true">
                <td>NAME : </td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>PRICE : </td>
                <td><input type="text" name="price"></td>
            </tr>
            <tr>
                <td>ACTIVE : </td>
                <td>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    YES <input type="radio" name="active" value="Yes"> 
                    NO <input type="radio" name="active" value="No">
                </td>
            </tr>
            <tr>
                <td>DATE OF LAUNCH : </td>
                <td>
                    <input type="text" name="dateOfLaunch" placeholder="MM/dd/yyyy">
                </td>
            </tr>
            <tr>
                <td>CATEGORY : </td>
                <td>
                    <select name="category">
                        <option value="Starter">STARTER</option>
                        <option value="Main Course">MAIN COURSE</option>
                        <option value="Desert">DESERT</option>
                        <option value="Drink">DRINK</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>FREE DELIVERY : </td>
                <td>
                    <input type="checkbox" name="freeDelivery"><br>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="submit" value="Save"></td>
            </tr>
        </table>
		
	</form>
    </div>
	<footer>&copy; Copyright 2020 TruYum Pvt. Ltd. </footer>
</body>
</html>