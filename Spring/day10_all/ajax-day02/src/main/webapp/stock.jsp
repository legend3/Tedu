<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
<style>
	#d1{
		width:400px;
		height:300px;
		background-color:black;
		margin-left:400px;
		margin-top:40px;
	}
	#d2{
		color:yellow;
		height:32px;
		background-color:red;
	}
	table{
		color:white;
		font-size:21px;
		font-style:italic;
	}
</style>
<%-- Jquery方式 --%>
<script type="text/javascript" src="js/jquery-1.4.3.js"></script>

<script type="text/javascript">
	$(function(){
		//当页加载完成，会执行这儿的代码。
		setInterval(invoke,3000);
	});
	function invoke(){
		//异步地向服务器发请求，并且依据
		//服务器返回的结果(json字符串)更新股票数据。
		$.ajax({
			url:'quoto.do',
			type:'get',
			dataType:'json',
			success:function(data){
				//data:是服务器返回的数据,
				//如果返回的是json字符串，
				//会自动转换成相应的js对象
				//或者js对象组成的数组。
				$('#tb1').empty(); //先清空tbody
				for(i = 0; i < data.length; i ++){
					var s = data[i];
					$('#tb1').append(
							'<tr><td>' + s.code
							+ '</td><td>' + s.name 
							+ '</td><td>' + s.price
							+ '</td></tr>');
				}
			}
		});
	}
</script>
</head>
<body style="font-size:30px;">
	<div id="d1">
		<div id="d2">股票实时行情</div>
		<div id="d3">
			<table width="100%">
				<thead>
					<tr><td>代码</td><td>名称</td>
					<td>价格</td></tr>
				</thead>
				<tbody id="tb1">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>