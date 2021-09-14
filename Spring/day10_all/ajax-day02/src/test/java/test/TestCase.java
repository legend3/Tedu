package test;

import java.util.ArrayList;
import java.util.List;

import bean.Stock;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestCase {
	
	/**
	 * {"code":"000002","name":"万科A",
	 * "price":10}  
	 * 单个java对象转换成json字符串。
	 */
	public static void test1(){
		Stock s = new Stock();
		s.setCode("000002");
		s.setName("万科A");
		s.setPrice(10);
		//使用json官方提供的工具来转换
		JSONObject obj = 
				JSONObject.fromObject(s);
		String jsonStr = obj.toString();
		System.out.println(jsonStr);
	}
	
	/**
	 * 多个java对象组成的集合或者数组
	 * 转换成json字符串。
	 */
	public static void test2(){
		List<Stock> stocks = 
				new ArrayList<Stock>();
		for(int i = 0; i < 3; i ++){
			Stock s = new Stock();
			s.setCode("00000" + (i + 1));
			s.setName("万科A"+ (i + 1));
			s.setPrice(10+ i);
			stocks.add(s);
		}
		JSONArray  arr = 
				JSONArray.fromObject(stocks);
		String jsonStr = arr.toString();
		System.out.println(jsonStr);
	}
	

	public static void main(String[] args) {
		test2();
	}

}
