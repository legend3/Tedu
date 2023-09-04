package day02;
/**
 * 中文在unicode的范围:
 * 4e00---9fa5 
 * \u4e00
 * @author Administrator
 *
 */
public class Test06 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		for(char c='\u4e00', i=1;c<='\u95af';c++, i++){//知道c的范围，不知道i的范围
			builder.append(c);
			if(i%50==0){
				builder.append("\n");//换行
			}
		}
		System.out.println(builder.toString());
	}
}


