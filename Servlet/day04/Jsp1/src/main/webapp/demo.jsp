<%@page pageEncoding="utf-8"%>
<%-- 1.jsp中可以直接写HTML、CSS、JS --%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>第1个JSP</title>
	</head>
	<body>
		<%-- 4.jsp中可以通过声明定义函数 --%>
		<%!
			public int lf(int n) {
				return n*n*n;
			}
		%>
		<ul>
			<%-- 2.jsp中可以通过脚本写Java片段 --%>
			<%
				for(int i=101;i<=110;i++) {
			%>
				<!-- 3.jsp中可以通过表达式输出 -->
				<li><%=lf(i) %></li>
			<%		
				}
			%>
		</ul>
		<!-- 通过include指令引入date.jsp -->
		<%@include file="date.jsp"%>
	</body>
</html>




