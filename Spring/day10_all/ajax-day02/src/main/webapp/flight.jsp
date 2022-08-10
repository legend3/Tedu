<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
	<%--	Jquery方式--%>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>

<script type="text/javascript">
	$(function(){
		$('a.s1').click(f1);
	});
	function f1(){
		//找到航班号。
		var flight = $(this).parent()
		.siblings().eq(0).text();
		//发送异步请求。并将服务器返回的数据添加到div。
		$(this).next().load('getFlights.do',
				'flight=' + flight);
	}
</script>
</head>
<body style="font-size:30px;">
	<table width="60%" border="1" 
	cellpadding="0" cellspacing="0">
		<tr>
			<td>航班号</td><td>机型</td>
			<td></td><td>经济舱价格</td>
		</tr>
		<tr>
			<td>CA1204</td>
			<td><a href="">波音730</a></td>
			<td><a href="javascript:;" class="s1">
			查看所有票价</a><div></div>
			</td>
			<td>￥1200</td>
		</tr>
		<tr>
			<td>MU7747</td>
			<td><a href="">空客330</a></td>
			<td><a href="javascript:;" class="s1">
			查看所有票价</a><div></div>
			</td>
			<td>￥800</td>
		</tr>
	</table>
</body>
</html>