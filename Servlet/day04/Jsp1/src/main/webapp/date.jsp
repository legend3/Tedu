<!-- 
pageEncoding：设置JSP文件自身的编码。
contentType：设置向浏览器输出的内容的格式及编码。
-->
<%@page pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"
	import="java.util.*,java.text.*"%>
<!-- 此JSP不单独使用，而是被其他JSP引用。
	由于其他JSP内已经包含了head、body，
	所以该JSP可以省略这2个标签。 -->
<%
	Date date = new Date();
	SimpleDateFormat sdf = 
		new SimpleDateFormat("HH:mm:ss");
	String now = sdf.format(date);
%>
<div>
	<%=now %>
</div>










