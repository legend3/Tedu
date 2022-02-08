<%@ page  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<script type="text/javascript" 
	src="js/ajax.js">
	</script>
	<script type="text/javascript">
		//利用ajax对象异常地向服务器发送请求，
		//并且利用服务器返回的数据更新当前页面。
		function check_uname(){
			//step1. 获得ajax对象。
			var xhr = getXhr();
			//step2. 利用ajax对象发请求。
			xhr.open('get', 'check_uname.do?username=' + $F('username'),true);
			xhr.onreadystatechange=function(){
				//step4 处理服务器返回的数据
				if(xhr.readyState == 4 && 
						xhr.status == 200){
					//获得服务器返回的数据
					var txt = xhr.responseText;
					//更新页面
					$('username_msg').innerHTML = txt;
				}
			};
			xhr.send(null);
		}
		
		
	</script>
</head>
<body style="font-size:30px;">
	<form action="" method="post">
		用户名:<input id="username" 
		name="username" 
		onblur="check_uname();"/>
		<span style="color:red;" 
		id="username_msg"></span>
		<br/>
		密码:<input type="password" name="pwd"/>
		<br/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>