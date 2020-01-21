<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="controller.DemoController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Demo SOAP Web Service</title>
</head>
<body>

<a href="DemoController">Demo Web Service</a>

<%
String inptA = request.getParameter("inputA");
inptA = inptA == null ? "" : inptA;
String inptB = request.getParameter("inputB");
inptB = inptB == null ? "" : inptB;
%>
<br>
<br>
<form action="test" method="post">
	<input type="text" id="inputA" name="inputA">
	<input type="text" id="inputB" name="inputB">
	<input type="submit" value="계산">
</form>
</body>
</html>