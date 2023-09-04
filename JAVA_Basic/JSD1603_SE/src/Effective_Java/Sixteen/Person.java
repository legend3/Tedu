package Effective_Java.Sixteen;


import java.util.Objects;

/**
 * 如果一个类是包级私有的，或者是一个私有的内部类，那么暴露它的数据属性就没有什么本质上的错误
 * ——假设它们提供足够描述该类提供的抽象。 在类定义和使用它的客户端代码中，这种方法比访问方法产生更少的视
 * 觉混乱。 虽然客户端代码绑定到类的内部表示，但是这些代码仅限于包含该类的包
 */
class Person {//包级私有类
    /**包级私有类暴露属性*/
    public String name;
    public Integer age;
    public String sex;

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Person) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name)
                && Objects.equals(age, person.age)
                && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        int result = this.name.hashCode();
        result = 31 * result + Integer.hashCode(this.age);
        result = 31 * result + this.sex.hashCode();
        return result;
    }
    public void cook() {
        System.out.println("做饭....");
    }

    public static void wash() {
        System.out.println("洗衣服....");
    }

    Baby createBaby(){
        return new Baby(2); //内部类对象通常在外部类中创建
    }

    int getBabyAge() {
        /**内部类暴露属性*/
        return createBaby().age;
    }

    class Baby {
        private int age;//成员内部类自己的私有属性

        public Baby(int age) {
            this.age = age;
        }

        public String showPerson(){
//			Person.this.cook();//隐式调用外部类的非静态方法
            cook();//直接调用外部类的非静态方法
            Person.wash();//调外部类静态方法
            name = "Baby`s name!";//1.可直接访问、修改外部类成员变量
            System.out.println("直接访问外部类成员变量：" + name);
            System.out.println("隐式的引用指向创建的它的外部类对象访问成员变量：" + Person.this.name);//2.内部类有个隐式的引用指向了创建它的外部类对象
            // 外部类名.this.
            //System.out.println(this.name); //编译错误，Baby类中不包含name
            System.out.println("外部类的age属性值：" + Person.this.age);
            System.out.println("成员内部类的age属性值: " + this.age);
            System.out.println("成员内部类的age属性值: " + age);
            return name;
        }
    }
}
