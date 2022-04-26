package effective_java;

import org.testng.annotations.Test;

import java.util.Objects;

public class ColorPonit extends Point{
    private final Color color;

    public ColorPonit(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPonit)) return false;
        ColorPonit that = (ColorPonit) o;
        return super.equals(o) && (Color)((ColorPonit) o).color == color;
    }

    @Test
    public void test01() {

    }
    @Test
    public void test02() {

    }
}
