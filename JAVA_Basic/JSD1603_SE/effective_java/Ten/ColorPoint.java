package effective_java.Ten;

import java.util.Objects;

/**
 * 新增组件+子类情况
 */
//public class ColorPonit extends Point{
public class ColorPoint {//test08
    private final Color color;//(增加的)值组件
    private final Point point;//代表是ColorPoint的父类，应用组合优于继承，test08

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x,y);//通过组合的方式创建一个父类实例,test08
        this.color = Objects.requireNonNull(color);//检查指定的对象引用不为空。此方法主要用于在方法和构造函数中进行参数验证
    }

    public Color getColor() {
        return color;
    }

    public Point asPoint() {//用来返回具有相同位置的ColorPoint对象
        return point;
    }
    //不满足对称性
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof ColorPonit)) return false;
//        ColorPonit that = (ColorPonit) o;
//        return super.equals(o) && (Color)((ColorPonit) o).color == color;
//    }
    //提供了对称性
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) return false;
//        if (!(o instanceof ColorPonit)) return o.equals(this);
//        return super.equals(o) && ((ColorPonit) o).color == color;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof ColorPonit)) return false;
//        if (!super.equals(o)) return false;
//        ColorPonit that = (ColorPonit) o;
//        return color == that.color;
//    }

    /*
        虽然没有一种令人满意的办法可以既扩展不可实例化的类，又增加值组件，但还是有一种不
        错的权宜之计（workaround）。根据第16条的建议：复合优先于继承。我们不再
        让 CounterPoint 扩展 Point ，而是在 CounterPoint 中加入一个私有的 Point 域，以及一个公
        有的视图（view）方法（见第5条），此方法返回一个与该有色点处在相同位置的普
        通 Point 对象
     */
//    @Override public boolean equals(Object o) {//test08
//        if (!(o instanceof ColorPoint))
//            return false;
//        ColorPoint cp = (ColorPoint) o;
//        return cp.point.equals(point) && cp.color.equals(color);
//    }

    /*
        最终equals编写
     */
    @Override
    public boolean equals(Object o) {//5. 不要将 equals 声明中的 Object 对象替换为其他的类型；不然就是一个重载（overload）了 的Object.equals
        if (this == o) return true;//1.使用 == 操作符检查“参数是否为这个对象的引用”    ——引用、内存地址
        if (!(o instanceof ColorPoint)) return false;//2.使用 instanceof 操作符检查“参数是否为正确的类类型”   ——类
        ColorPoint that = (ColorPoint) o;//3.把参数转换成正确的类型    ——强转成类实例
        return color == that.color && Objects.equals(point, that.point);//4.类中每个“关键（significant）域(field)的比较    ——比较实例属性
    }
}
