<%@page pageEncoding="utf-8"
	import="java.util.*,entity.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>员工列表</title>
		<style>
			table {
				width: 40%;
				border: 1px solid #000;
				border-collapse: collapse;
			}
			th,td {
				border: 1px solid #000;
			}
		</style>
	</head>
	<body>
		<table>
			<tr>
				<th>员工列表-编号</th>
				<th>员工列表-姓名</th>
				<th>员工列表-职位</th>
				<th>员工列表-工资</th>
			</tr>
			<%
				List<Emp> list = (List<Emp>) request.getAttribute("emps");
				for(Emp e : list) {
			%>
				<tr>
					<td><%=e.getEmpno() %></td>
					<td><%=e.getEname() %></td>
					<td><%=e.getJob() %></td>
					<td><%=e.getSal() %></td>
				</tr>
			<%		
				}
			%>
		</table>
	</body>
</html>
