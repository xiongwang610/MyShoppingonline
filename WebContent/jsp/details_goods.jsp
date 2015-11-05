<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.* ,Javabean.Goods,Javabean.User " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		float: left;
	}
</style>
</head>
<body>
	<%
		Goods goods = (Goods)request.getAttribute("goods");
	    User user = goods.getUser();
	%>
	<div>
			<img src="../Images/<%=goods.getUrl()%>" width="200" height="200" border="1"/>
	</div>
	<div>
		<table>
			<tr><p><%=goods.getName() %></p></tr>
			<tr><p>交易地址：<%=goods.getAddress() %></p></tr>
			<tr><p>价格:<%=goods.getPrice() %></p></tr>
			<tr><p>卖家:<a href="details_user_action?id=<%=user.getId()%>"><%=user.getUsername() %></a></p></tr>
			<tr><p>手机：<%=goods.getPhonenumber() %></p></tr>
		</table>
	</div>
</body>
</html>