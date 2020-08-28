<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700i" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    
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
.items {
    display: block;
    margin: 20px 0;
}
.item {
    background-color: #fff;
    float: left;
    margin: 0 10px 10px 0;
    width: 205px;
    padding: 10px;
     
}
.item img {
    display: block;
    margin: auto;
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
span {
    float: right;
}
        
p {
    font-size: 14px;
}
.card {
    display: inline-block;
    background: url(../img/cart.png) no-repeat 0 0;
    width: 24px;
    height: 24px;
    margin: 0 10px 0 0;
}
</style>

</head>
<body>
   <br><br><br>
    <!-- wrapper -->
<div class="wrapper">
     <h1>HOME</h1>
     <form method="POST" action="/logout">
	 <button>Logout</button>
	 </form>
     <form method="POST" action="/myWeb/front/login.jsp">
     <button>LOGIN</button>
     </form>
     <form method="POST" action="/createUser">
     <button>REGISTER</button>
     </form>
     <form method="GET" action="/testGetApi">
     <button>View Store</button>
     </form>
 <span><i class="card"></i></span>

    <div class="clear"></div>
    <!-- items -->
    <div class="items">
    
        <div class="item">
            <br>
            <h2>Personal Info</h2>
            <form method="GET" action="/show/user">
            <button>View</button>
            </form>
        </div>

        <div class="item">
            <br>
            <h2>Search Product</h2>
            <form method="POST" action="/search">
            <input type="text" name="product" placeholder="Product"/>
            <button>Search</button>
            </form>
        </div>
        
        <div class="item">
            <br>
            <h2>Add Product</h2>
            <form method="POST" action="/search">
            <input type="text" name="product" placeholder="Product"/>
            <button >Add to cart</button>
            </form>
            
        </div>
    </div>
    <!--/ items -->
</div>
<!--/ wrapper -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</body>