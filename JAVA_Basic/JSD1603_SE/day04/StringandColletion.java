package day04;
import org.apache.commons.lang.StringUtils;
//import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;
/**
 * 字符串与集合互转
 */
public class StringandColletion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("春");
        list.add("夏");
        list.add("秋");
        list.add("冬");
        //集合与字符串互转
        String str = StringUtils.join(list, ",");//集合转字符串
        System.out.println(str);

        String str2 = "足球,篮球,排球";
        String[] strArray2 = str2.split(",");//字符串转数组
        List<String> list2 = Arrays.asList(strArray2);//数组转集合
        System.out.println(list2);
    }

}
