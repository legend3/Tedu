package day12.day12;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM解析xml文档
 * @author adminitartor
 *
 */
public class ParseXmlDemo {
	public static void main(String[] args) {
		try {
			/*
			 * 解析XML大致流程
			 * 1:创建SAXReader
			 * 2:使用SAXReader读取数据源(xml文档信息)
			 *   并生成一个Document对象，该对象即表示
			 *   xml文档内容。DOM耗时耗内存资源也是在
			 *   这一步体现的。因为会对整个XML文档进行
			 *   读取并载入内存。
			 * 3:通过Document对象获取根元素
			 * 4:根据XML文档结构从根元素开始逐层获取
			 *   子元素最终以达到遍历XML文档内容的目的
			 *     
			 */
			//1
			SAXReader reader = new SAXReader();
			
			//2
			Document doc
			 = reader.read(new File("emplist.xml"));
			
			/*
			 * 3
			 * Document提供了方法:
			 * Element getRootElement()
			 * 该方法是用来获取XML文档中的根元素，
			 * 对于emplist.xml文档而言，根元素就是
			 * <list>标签。
			 * 
			 * Element类
			 * 每一个Element实例都可以表示XML文档中的
			 * 一个元素，即:一对标签。
			 */
			Element root = doc.getRootElement();
			/*
			 * Element提供了方法:
			 * String getName()
			 * 该方法可以获取当前元素的名字(标签名)
			 */
			System.out.println(
				"获取了根元素:"+root.getName()
			);
			//4
			/*
			 * 获取一个元素中的子元素
			 * Element提供了相关方法:
			 * 
			 * 1
			 * Element element(String name)
			 * 获取当前元素下指定名字的子元素。
			 * 
			 * 2:
			 * List elements()
			 * 获取当前元素下所有子元素
			 * 
			 * 3:
			 * List elements(String name)
			 * 获取当前元素下所有同名子元素
			 * 
			 * 2,3返回的集合中的每一个元素都是Element
			 * 的实例，每个实例表示其中的一个子元素。
			 * 
			 */
			//获取所有emp标签
			List<Element> list = root.elements();
			for(Element empEle : list){
				System.out.println(empEle.getName());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * 使用DOM解析xml文档
     * @author adminitartor
     *
     */
//    public static class ParseXmlDemo {
//        public static void main(String[] args) {
//            try {
//                /*
//                 * 解析XML大致流程
//                 * 1:创建SAXReader
//                 * 2:使用SAXReader读取数据源(xml文档信息)
//                 *   并生成一个Document对象，该对象即表示
//                 *   xml文档内容。DOM耗时耗内存资源也是在
//                 *   这一步体现的。因为会对整个XML文档进行
//                 *   读取并载入内存。
//                 * 3:通过Document对象获取根元素
//                 * 4:根据XML文档结构从根元素开始逐层获取
//                 *   子元素最终以达到遍历XML文档内容的目的
//                 *
//                 */
//                //1
//                SAXReader reader = new SAXReader();
//
//                //2
//                Document doc
//                 = reader.read(new File("emplist.xml"));
//
//                /*
//                 * 3
//                 * Document提供了方法:
//                 * Element getRootElement()
//                 * 该方法是用来获取XML文档中的根元素，
//                 * 对于emplist.xml文档而言，根元素就是
//                 * <list>标签。
//                 *
//                 * Element类
//                 * 每一个Element实例都可以表示XML文档中的
//                 * 一个元素，即:一对标签。
//                 */
//                Element root = doc.getRootElement();
//                /*
//                 * Element提供了方法:
//                 * String getName()
//                 * 该方法可以获取当前元素的名字(标签名)
//                 */
//                System.out.println(
//                    "获取了根元素:"+root.getName()
//                );
//                //4
//                /*
//                 * 获取一个元素中的子元素
//                 * Element提供了相关方法:
//                 *
//                 * 1
//                 * Element element(String name)
//                 * 获取当前元素下指定名字的子元素。
//                 *
//                 * 2:
//                 * List elements()
//                 * 获取当前元素下所有子元素
//                 *
//                 * 3:
//                 * List elements(String name)
//                 * 获取当前元素下所有同名子元素
//                 *
//                 * 2,3返回的集合中的每一个元素都是Element
//                 * 的实例，每个实例表示其中的一个子元素。
//                 *
//                 */
//                //获取所有emp标签
//                List<Element> list = root.elements();
//                for(Element empEle : list){
//                    System.out.println(empEle.getName());
//                }
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}




