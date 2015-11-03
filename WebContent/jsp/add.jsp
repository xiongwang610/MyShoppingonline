<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发布商品</title>
<style type="text/css">
	#file{
		border: 1px ;
		height: 10px;
		width: 100px;
	}
</style>
</head>
<body>
	<s:form action="goodsupdown_action" method="post" enctype="multipart/form-data">
		<s:div>
		<img alt="加载中" src="img/1.jpg" height="100px" width="100px">
		<s:text name="商品发布"></s:text>
	</s:div>
	<s:div>
		<s:file border="1px" height="30px" width="30px" name="file"/>
	</s:div>
	<s:div>
		<s:textarea name="name" label="名称"  ></s:textarea>
	</s:div>
	<s:div>
		<s:textarea name="introduction" label="描述"  ></s:textarea>
	</s:div>
	<s:div>
		<s:textarea name="address" label="交易地址"  ></s:textarea>
	</s:div>
	<s:div>
		<s:textarea name="type" label="类型"  ></s:textarea>
	</s:div>
	<s:actionerror/>
	<s:div>
		<s:textarea name="phoneNumber" label="电话号码"  ></s:textarea>
	</s:div>
	<s:div>
		<s:textarea name="qq" label="qq"  ></s:textarea>
	</s:div>
	<s:div>
		<s:textarea name="price" label="价格"  ></s:textarea>
	</s:div>
	<s:submit value=""></s:submit>
	</s:form>
	
</body>
</html>