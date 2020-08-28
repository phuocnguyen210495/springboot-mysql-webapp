<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Demo</title>
<!-- latest version -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
* {
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

.form-signin {
	max-width: 380px;
	margin: 0 auto;
	background-color: #fff;
	padding: 15px 40px 50px;
	border: 1px solid #e5e5e5;
	border-radius: 10px;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 30px;
}

.form-signin input[type="text"], .form-signin input[type="password"] {
	margin-bottom: 10px;
}

.form-signin .form-control {
	padding: 10px;
}
</style>

</head>
<body>
	<div class="wrapper">
		<form class="form-signin" method="POST" action="/login">
			<h2 class="form-signin-heading text-center">Login Form</h2>
			<input type="text" class="form-control" name="email"
				placeholder="Email Address" required="" autofocus="" /> <input
				type="password" class="form-control" name="password"
				placeholder="Password" required=""> <label class="checkbox">
				<input type="checkbox" value="remember-me" id="rememberMe"
				name="rememberMe"> Remember Me
			</label>
			<button>Login</button>
			<form method="POST" action="/myWeb/front/home.jsp">
				<button>Back To Homepage</button>
			</form>
		</form>
	</div>
</body>
</html>