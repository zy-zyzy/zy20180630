<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<!-- java代码声明 
	application:存储到该对象中的数据与项目的生命周期相同，如果项目重启，
		则application的数据将会消失。一般用来存一些系统公共的数据和经常要访问的数据，
		减少访问数据库的数量。类似于内存的缓存区。
	session:会话，每个用户都有独立的区域，只要会话结束，则session消失。
		会话结束只有两种情况：1、默认情况下30分钟没有与服务器交互，会会话结束。可以修改。
					2、浏览器关闭
	request：代表用户与服务器端的一次请求，每次请求都会产生一个request对象，
		如果当前用户产生一个新的request对象，则原来的request对象将会自动销毁。
	
	-->
	<%
	request.setAttribute("req", "request");
	session.setAttribute("ses", "session");
	application.setAttribute("app", "application");
	%>
	<a href = "query.jsp">query.jsp</a>
在项目中所有的请求都要从工程名往下走
	<form action="/zy20180630/ProductServlet" method="post">
	商品名：<input type = "text" name="name" /> <br/>
	价格：<input type = "text" name="price" /> <br/>
	备注：<input type = "text" name="remark" /> <br/>
	<input type="submit" value = "提交"/>
	</form>
</body>
</html>