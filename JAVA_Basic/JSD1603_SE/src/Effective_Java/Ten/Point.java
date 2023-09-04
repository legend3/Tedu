package Effective_Java.Ten;

import java.util.HashSet;
import java.util.Set;

/**
 * 第8条：覆盖 equals 时请遵守通用约定
 *
 * 传递性
 *  考虑子类的情况
 */
public class Point {
    private final int x;
    private final int y;

    private static final Set<Point> unitCircle;

    static {//为验证equal相等，预备的point实例
            unitCircle = new HashSet<Point>();
            unitCircle.add(new Point(1, 0));
            unitCircle.add(new Point(0, 1));
            unitCircle.add(new Point(-1, 0));
            unitCircle.add(new Point(0, -1));
    }
    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    //如果 Point 类使用基于 getClass 的 equals 方法，则无论CounterPoint实例的x和y坐标如何，onUnitCircle方法都将返回 false,test07
    //1. onUnitCircle 方法使用的 HashSet）都使用 equals方法来测试是否包含元素
    //2. CounterPoint 实例并不等于任何 Point 实例（被onUnitCircle的hashcode结合使用）
//    @Override public boolean equals(Object o) {
//        if (o == null || o.getClass() != getClass())
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }

    //如果在 Point 上使用了适当的基于instanceof的equals方法，则在使用CounterPoint实例呈现时，
    // 同样的 onUnitCircle 方法可以正常工作,test07
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }

}
