<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
	<s:property value="errors"/>  
	<table>
		<s:form action="register_action">
			<s:textfield name="userName" label="用户名"></s:textfield>
			<s:password name="password" label="密码"></s:password>
			<s:submit value="注册"></s:submit>
		</s:form>
	</table>
</body>
</html>