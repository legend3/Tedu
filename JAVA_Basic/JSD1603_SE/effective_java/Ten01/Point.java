package effective_java.Ten01;


import java.util.HashSet;
import java.util.Set;

/**
 * 第8条：覆盖 equals 时请遵守通用约定
 *
 * 传递性
 */
public class Point {
    private final int x;
    private final int y;

    private static final Set<Point> unitCircle;
    static {
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
    //    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point)) return false;
//        Point point = (Point) o;
//        return x == point.x && y == point.y;
//    }

    @Override public boolean equals(Object o) {//被onUnitCircle的hashcode结合使用
        if (o == null || o.getClass() != getClass())
            return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}
