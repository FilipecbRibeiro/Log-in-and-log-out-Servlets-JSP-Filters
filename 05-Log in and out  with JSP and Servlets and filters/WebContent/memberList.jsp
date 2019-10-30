


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member List</title>
</head>
<body>
<p>Credentials<br>
Username  =<%= request.getSession().getAttribute("username").toString()%><br>
SessionID =<%= request.getSession().getId() %>
<form action="<%= request.getContextPath()%>/MemberAreaController" method="get">
<input type="hidden" name="action" value="destroy">
<input type="submit" value="Log Out">
</form>


</body>
</html>
