<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.* ,Javabean.Goods " %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<frameset rows="20%,*" > 
	<frame name="topFrame" scrolling="NO" noresize width="20%" src="top.jsp" frameborder="0">
	<frameset cols="18%,*" > 
		<frame name="leftFrame" scrolling="no" noresize src="leftFrame.jsp" frameborder="0">
		<frame name="mainFrame" scrolling="YES" src="main.jsp" frameborder="0">
	</frameset>
</frameset>

<body>
</body>
</html>