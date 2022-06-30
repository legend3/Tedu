package effective_java.Ten;

import org.testng.annotations.Test;

import java.util.*;

public class testCase {
    @Test
    public void test01() {
        /*CaseInsensitiveString-01*/
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
        String s = "polish";
        System.out.println(cis.equals(cis2));
        System.out.println(cis.getS().equals(s));

        System.out.println(s.equals(cis.getS()) + ": 违反了对称性");
        List<String> list = new ArrayList<String>();
        list.add(cis.getS());
        System.out.println(list.contains(s) + ": 违反了自反性");
    }

    @Test
    public void test02(){
        /*CaseInsensitiveString-02*/
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        CaseInsensitiveString cis2 = new CaseInsensitiveString("polish");
        String s = "polish";
        System.out.println(cis.equals(cis2));
        System.out.println(cis2.equals(cis));
    }
    @Test
    public void test03(){
        /*Color*/
        System.out.println(Color.RED);
    }
    @Test
    public void test04(){
        /*ColorPonit-不满足对称性*/
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1,2, Color.RED);
        System.out.println(p.equals(cp));//true
        System.out.println(cp.equals(p));//false,不符合传递性
    }
    @Test
    public void test05(){
        /*ColorPonit-提供了对称性*/
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1,2, Color.RED);
        System.out.println(p.equals(cp));//true
        System.out.println(cp.equals(p));//true
    }
    @Test
    public void test06(){
        /*ColorPonit-满足了传递性
        *
        * 这种方法确实提供了对称性，但是丧失了传递性
        * */
        ColorPoint p1 = new ColorPoint(1,2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1,2, Color.BLACK);
        System.out.println(p1.equals(p2));//false
        System.out.println(p2.equals(p3));//false
        System.out.println(p1.equals(p3));//false
    }
    @Test
    public void test07(){
        /*
            因为像 onUnitCircle 方法所用的 HashSet 这样的集合，
            利用 equals 方法检验包含条件，没有任何 CounterPoint 实例与任何 Point 对应
         */
        CounterPoint cp = new CounterPoint(1,0);
//        CounterPoint cp2 = new CounterPoint(1,0);
//        System.out.println(cp.numberCreated());
        Point point = new Point(1,0);
        System.out.println(point.equals(cp));
        System.out.println(Point.onUnitCircle(cp));//onUnitCircle + equals
    }
    @Test
    public void test08() {
        ColorPoint colorPoint = new ColorPoint(1,2, Color.RED);
        ColorPoint colorPoint2 = new ColorPoint(1,2, Color.RED);
        System.out.println(colorPoint.equals(colorPoint2));//true
    }
}
