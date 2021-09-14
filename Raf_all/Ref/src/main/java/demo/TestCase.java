package demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.Test;

/**
 * Test 测试  Case 案例
 */
public class TestCase {
	
	@Test //测试
	//被测试的方法：公有，无参数，无返回值
	public void testHello(){
		System.out.println("Hello World!");
	}
	
	@Test
	public void testKitty(){
		System.out.println("Hello Kitty!");
	}
	
	@Test
	//测试: 动态加载类
	public void testClassForName()
		throws Exception{
		//Junit 不支持线程阻塞，不要使用
		//in.nextLine()
		//被动态加载的类名
		String className = "demo.Koo";
		Class cls = Class.forName(className);
		System.out.println(cls); 
	}
	
	@Test
	//测试动态获取类的属性信息
	public void testFields() throws Exception{
		//动态加载类
		String className = "demo.Koo";
		Class cls = Class.forName(className);
		//动态获取类的 属性信息
		Field[] flds=cls.getDeclaredFields();
		//flds代表类的全部属性
		//Field类来自包：java.lang.reflect
		//利用增强for显示全部的属性信息
		for(Field f : flds){
			//f 代表类的中每个属性 信息
			System.out.println(f); 
		}
 
	}
	
	@Test
	// 动态获取类中的方法信息
	public void testMethods()
		throws Exception{
		//动态加载类
		String className = "demo.Koo";
		Class cls = Class.forName(className);
		//动态获取类信息
		//Method来自反射包：java.lang.reflect.*
		// Declared: 声明的
		Method[] methods=
				cls.getDeclaredMethods();
		//利用循环输出方法信息
		for(Method m : methods ){
			//m 代表类的每个方法信息
			System.out.println(m); 
		}
	}
	
	@Test
	//动态创建对象演示
	public void testNewInstance()
		throws Exception{
		String className = "demo.Koo";
		//java.io.BufferedInputStream 类没有无参数构造器
		//动态加载类
		Class cls = Class.forName(className);
		//动态创建对象
		//被创建对象的类必须有无参数构造器！
		//否则将出现无此方法的异常！
		Object obj = cls.newInstance();
		System.out.println(obj); 
	}
	
	@Test
	/*
	 * 业务问题： 
	执行一个类中全部的以test为开头的无参数方法。
	(test开头的方法不是固定数量的方法)
	 */
	public void testMethodName() throws Exception{
		//1. 动态加载类
		String[] className = {"demo.Koo"};
		String className2 = "";
		for(int i=0;i<1;i++) {
			className2 = className[i];
			System.out.println(className2);
		}
		Class cls = Class.forName(className2);
		//2. 动态获取方法信息
		Method[] methods = cls.getDeclaredMethods();
		//4.1 动态创建对象 Instance：实例（对象）
		Object obj = cls.newInstance();
		//Object obj = "ABC";
		//3. 获取方法的名字
		for(Method m: methods){
			//m.getName() 获取方法的名称
			//方法名是String类型的数据
			//System.out.println(m.getName());
			String name = m.getName();
			//检查方法名name是否以test为开头
			//利用了String API 的startsWith方法
			//m? 类中所有的方法
			//获取方法参数的个数
			int length = 
				m.getParameterTypes().length;
			//如果length是0，就是无参数方法
			if(name.startsWith("test")
					&& length==0){
				System.out.println(name);
				//找到了 test为开头的方法 m
				//m 是类中全部以test为开头的方法
				//4.2 执行m方法
				//在obj对象上执行m方法
				// m 和 obj是有关系的，obj对象上
				// 一定包含m方法，否则执行期间
				// 将抛出无此方法异常！！！
				m.invoke(obj, null);
			}
		}
	}
	
	
	@Test
	//检查一个类全部方法的参数类型
	public void testParamterTypes()
		throws Exception{
		//动态加载类
		String className = "demo.Koo";
		Class cls = Class.forName(className);
		//动态类的方法信息
		Method[] methods = cls.getDeclaredMethods();
		//调用 m.getParamterTypes(), 获取
		//方法的参数信息
		for(Method m:methods){
			//m 代表类中每个方法信息
			//getParameterTypes返回一个数组
			// 每个元素代表参数的类型, 每个元素
			// 是Class类型的对象，Class对象在
			// Java 中代表类型信息
			// m.getParameterTypes() 用于获取
			// 一个方法的全部参数信息
			Class[] types = m.getParameterTypes();
			//输出参数数组的全部内容
			String s=Arrays.toString(types);
			System.out.println(s);
		}
	}
	
	
	@Test
	//使用反射调用私有方法
	public void testPrivateMethod()
		throws Exception{
		//动态加载类
		String className = "demo.Xoo";
		Class cls = Class.forName(className);
		//为了调用方法，需要先创建对象
		Object obj = cls.newInstance();
		//获取全部的方法信息
		Method[] methods=
			cls.getDeclaredMethods();
		for(Method m:methods){
			//System.out.println(m); 
			//m.setAccessible(true);“破坏了” 
			//原有的封装，在类的外部访问执行
			// "私有方法", 使用不多！！！ 
			m.setAccessible(true);
			m.invoke(obj, null);
		}
		
	}
	
	@Test 
	//用反射调用一个类的特定方法
	public void testCallMethod()
		throws Exception{
		//动态加载类
		String className = "demo.Yoo";
		Class cls = Class.forName(className);
		//动态创建对象
		Object obj = cls.newInstance();
		//找到一个特定方法
		Method m=cls.getDeclaredMethod(
			"add", long.class, int.class);
		//m 代表找到的特定方法信息。
		//执行方法
		Object val = m.invoke(obj, 5L, 5);
		//val 代表方法的执行结果。
		System.out.println(m); 
		System.out.println(val); 
	}
}












