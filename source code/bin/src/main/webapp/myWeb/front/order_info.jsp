<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style type="text/css">
*{
    margin: 0;
    padding: 0;
}
body {
    background-color: #eee;
    font: normal 13px/1.5;
    font-family: 'Roboto Condensed', sans-serif;
    color: #333;
}
.wrapper {
    width: 705px;
    margin: 20px auto;
    padding: 20px;
}
h1 {
    display: inline-block;
    background-color: #fff;
    color: #ef4478;
    font-size: 16px;
    font-weight: normal;
    text-transform: uppercase;
    padding: 4px 20px;
    float: left;
    border-radius: 50px;
}
.clear {
    clear: both;
}
h2 {
    font-size: 12px;
    display: block;
    border-bottom: 1px solid #ccc;
    margin: 0 0 10px 0;
    padding: 0 0 5px 0;
}
button {
    border: 1px solid #ef4478;
    padding: 4px 14px;
    background-color: #ef4478;
    color: #fff;
    text-transform: uppercase;
    float: right;
    margin: 5px 0;
    font-weight: 400;
    cursor: pointer;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 50px;
    
}
button:focus {
    outline: none !important;
}
.card {
    display: inline-block;
    background: url(../img/cart.png) no-repeat 0 0;
    width: 24px;
    height: 24px;
    margin: 0 10px 0 0;
}
.form-signin{
  max-width: 380px;
  margin: 0 auto;
  background-color: #fff;
  padding: 15px 40px 50px;
  border: 1px solid #e5e5e5;
  border-radius: 10px;
}
.form-signin .form-signin-heading, .form-signin .checkbox{
  margin-bottom: 30px;
}
.form-signin input[type="text"], .form-signin input[type="password"]{
  margin-bottom: 10px;
}
.form-signin .form-control{
  padding: 10px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
	<br>
	<br>
	<br>
	<div class="wrapper">
	<form class="form-signin">
	<h2>Orders</h2>
	<div class="item">
	<form method="POST" action="/myWeb/front/add_review.jsp">
		<button>Add Review</button>
	</form>
	<form method="POST" action="shopper_info.jsp">
		<button>View Shopper</button>
	</form>
	<form method="POST" action="seller_info.jsp">
		<button>View Seller</button>
	</form>
	</div>
	</form>
	</div>
</body>
</html>