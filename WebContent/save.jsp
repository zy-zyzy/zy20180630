<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
在项目中所有的请求都要从工程名往下走
	<form action="/zy20180630/ProductServlet" method="post">
	商品名：<input type = "text" name="name" /> <br/>
	价格：<input type = "text" name="price" /> <br/>
	备注：<input type = "text" name="remark" /> <br/>
	<input type="submit" value = "提交"/>
	</form>
</body>
</html>