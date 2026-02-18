<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<form action="login" method="post">
    <h2>Login</h2>
    <input name="username" required>
    <input type="password" name="password" required>
    <button type="submit">Login</button>
    <a href="register.jsp">Register</a>
</form>

<br>

<a href="register.jsp">Belum punya akun? Register</a>

</body>
</html>