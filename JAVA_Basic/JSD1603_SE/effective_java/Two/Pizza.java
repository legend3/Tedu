package effective_java.Two;

// Builder pattern for class hierarchies
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 2.抽象类的builder模式
 */
public abstract class Pizza {
    //必需的参数:    标准的纽约风格的披萨(参数)
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {//1.builder对象
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {//2.参数设置
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();//3.无参的build方法生成Pizza类型实例

        // Subclasses must override this method to return "this",而无需强转。
        // Java缺乏自我类型的这种变通解决方法被称为模拟自我类型(simulated self-type)的习惯用法
        protected abstract T self();
    }

    //?未知的具体子类，等价Builder<? extend Builder>，因为之前Buider声明为<T extend Builder<T>>就保证了T一定是Builder的子类型，
    // 这里就没有必要再重复限制一次了。
    Pizza(Builder<?> builder) {//4.(Pizza的)构造方法
        toppings = builder.toppings.clone(); // See Item 50
    }
}
