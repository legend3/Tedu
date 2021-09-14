<%@page pageEncoding="utf-8"
import="java.util.*,entity.*,dao.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>员工查询</title>
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
				<th>员工查询-编号</th>
				<th>员工查询-姓名</th>
				<th>员工查询-职位</th>
				<th>员工查询-工资</th>
			</tr>
			<%
				EmpDao dao = new EmpDao();
				List<Emp> list = dao.findAll();
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












