package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysdateTag 
	extends SimpleTagSupport {

	private String format = 
			"yyyy/MM/dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//创建系统时间
		Date date = new Date();
		SimpleDateFormat sdf = 
			new SimpleDateFormat(format);
		String now = sdf.format(date);
		//输出给浏览器
		//本方法声明返回的类型为JspContext，
		//但实际上返回的类型是PageContext。
		//而PageContext extends JspContext
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter w = ctx.getOut();
		w.println(now);
		//此处不能关闭流，因为JSP上其他
		//标签也要使用它，Tomcat会自动关。
	}

	
	
}











