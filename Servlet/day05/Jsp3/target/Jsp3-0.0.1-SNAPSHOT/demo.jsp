<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/lhh-tag" prefix="s"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>EL&JSTL</title>
	</head>
	<body>
		<h1>JSTL</h1>
		<!-- 1. if -->
		<p>
			<c:if test="${stu.sex=='M' }">男</c:if>
			<c:if test="${stu.sex=='F' }">女</c:if>
		</p>
		<!-- 2. choose -->
		<p>
			<c:choose>
				<c:when test="${stu.sex=='M' }">男</c:when>
				<c:otherwise>女</c:otherwise>
			</c:choose>
		</p>
		<!-- 3. forEach 
			Map map = new HashMap();
			for(Object itr : interests) {
				Integer index = map.get("index");
				if(index==null) {
					map.put("index",0);
				} else {
					map.put("index",index+1);
				}
				map.put("其他","");
			}
			每次循环JSTL会创建一个对象，用来存储循环次数等值。
			可以通过varStatus属性声明该对象的变量，
			从而来访问该对象，获取循环次数等值。
		-->
		<p>
			<c:forEach items="${stu.interests }" 
				var="itr" varStatus="s">
				${itr },${s.index },${s.count }<br>
			</c:forEach>
		</p>
		<!-- 4.自定义标签 -->
		<p>
			<s:sysdate/>
		</p>
		<p>
			<s:sysdate format="yyyy-MM-dd"/>
		</p>
	
		<h1>EL</h1>
		<!-- 
		1.获取bean属性
			stu.name ==
			request.getAttribute("stu").getName()
			stu.course.id ==
			request.getAttribute("stu")
				.getCourse().getId()
		-->
		<p>姓名:${stu.name }</p>
		<p>年龄:${stu["age"] }</p>
		<p>课程ID:${stu.course.id }</p>
		<!-- 
			EL默认从以下4个对象(范围)中依次取值：
				page,request(*),session(*),application
			即：
				-> page.getAttribute("stu")
				-> request.getAttribute("stu")
				-> session.getAttribute("stu")
				-> application.getAttribute("stu")
			取值对象(范围)也可以指定：
				sessionScope.stu.name
		-->
		<p>课程:${requestScope.stu.course.name }</p>
		<!-- 2.支持运算 -->
		<p>年龄+10:${stu.age+10 }</p>
		<p>是否大于20:${stu.age>20 }</p>
		<p>是否介于20-30:${stu.age>20 && stu.age<30 }</p>
		<p>是否为空:${empty stu }</p>
		<p>换个写法:${stu == null }</p>
		<!-- 3.获取请求参数：
			param.x ==
				request.getParameter("x")
			paramValues.y ==
				request.getParameterValues("y")
			 -->
		<p>参数:${param.x }</p>
	</body>
</html>











