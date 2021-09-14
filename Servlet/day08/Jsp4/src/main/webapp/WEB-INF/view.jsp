<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>VIEW</title>
	</head>
	<body>
		<!-- 使用EL可以直接获取cookie，
			语法：cookie.key.value -->
		<p>用户：${cookie.user.value }</p>
		<p>城市：${cookie.city.value }</p>
		<p>公司：${cookie.company.value }</p>
	</body>
</html>







