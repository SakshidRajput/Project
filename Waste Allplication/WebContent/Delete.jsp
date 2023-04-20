<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
    <%@page import="com.rcpit.data.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id=Integer.parseInt(request.getParameter("id"));
try
{
	Connection con=CoonnectionDB.connect();
	PreparedStatement ps1=con.prepareStatement("delete from vehicle where id=?");
	ps1.setInt(1, id);
	int rs=ps1.executeUpdate();
	if(rs == 0)
	{
		response.sendRedirect("error.html");
	}
	else
	{
		response.sendRedirect("view.jsp");
	}
}
catch(Exception e1)
{
	e1.printStackTrace();
}
%>
</body>
</html>