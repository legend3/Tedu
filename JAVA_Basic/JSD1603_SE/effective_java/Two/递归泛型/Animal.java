package effective_java.Two.递归泛型;

/**
 * 限制实现方法的参数类型，达到精准匹配，
 * 允许方法链在子类中正常工作，而不需要强制转换。
 *
 * Java 缺乏自我类型的这种变通解决
 * 方法被称为模拟自我类型（simulated self-type）的习惯用法
 * @param <T>
 */
public abstract class Animal<T extends Animal<T>> {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void mating(T t);//

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Dog extends Animal<Dog> {

    public Dog(String name) {
        super(name);
    }

    @Override
    void mating(Dog dog) {
        System.out.println(this + "和" + dog + "生小狗");
    }
}

class Cat extends Animal<Cat> {

    public Cat(String name) {
        super(name);
    }

    @Override
    void mating(Cat cat) {
        System.out.println(this + "和" + cat + "生小猫");
    }
}