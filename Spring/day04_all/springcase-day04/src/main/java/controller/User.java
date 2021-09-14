package controller;
/**
 * 将请求参数封装成一个javabean。(容器组件将自动识别为一个bean对象！)
 * 该类有如下要求：
 * a. 类的属性与请求参数名保持一致
 * (名称一样，类型一致)
 * b. 这些属性应该提供相应的get/set方法。
 */
public class User {
	private String username;
	private String pwd;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
