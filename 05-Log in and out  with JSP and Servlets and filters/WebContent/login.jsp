<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/WebControllerServlet" method="post">
<%--form sent to servlet --%>

Username: <input type="text" name="username" ><br/>
Password: <input type="password" name="password"><br/>
<input type="hidden" name ="action" value="loginSubmit"><%--same thing then receiving by url ?acion=loginSubmit --%>
<input type="submit" value="submit">

</form>
</body>
</html>