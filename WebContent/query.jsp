<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	
	<!-- 在项目中所有的请求都要从工程名往下走 -->
	<form action="${pageContext.request.contextPath}/ProductServlet" method="get">
	关键字：<input type = "text" name="keyword" value=${sessionScope.keyword} /> <br/>
	<input type="submit" value = "搜索"/>
	<input type="hidden" name="type" value="query">
	</form>
	<!--  
	req:<%=request.getAttribute("proList") %>
	ses:<%=session.getAttribute("proList") %>
	-->
	<table border=1>
		<tr>
		<th>编号</th>
		<th>名称</th>
		<th>价格</th>
		<th>备注</th>
		<th>日期</th>
		<th>操作</th>
		</tr>
		<!-- 循环显示查询的结果，为了不用java中的内容，采用JSTL标签 -->
		<c:forEach items="${requestScope.proList}" var="product">
		<tr>
		<td>${product.id}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td>${product.remark}</td>
		<td>${product.date}</td>
		<!-- 所有的a标签都是get请求 -->
		<td>更新|<a href="${pageContext.request.contextPath}/ProductServlet?id=${product.id}&type=delete">删除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>