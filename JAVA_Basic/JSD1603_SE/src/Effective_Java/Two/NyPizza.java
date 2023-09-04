package Effective_Java.Two;

import java.util.Objects;

/**
 * 必需的参数:   "尺寸参数"
 */

public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        //这种技术，其一个子类的方法被声明为返回在超类中声明的返回类型的子类型，称为协变返回类型。它允许客户端使用这些builder，而不需要强转
        @Override public NyPizza build() {
            return new NyPizza(this);
        }

        @Override protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}
