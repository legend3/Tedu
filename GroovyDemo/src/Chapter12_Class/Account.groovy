package Chapter12_Class

/**
 * 一、
 * 1.def xxx -> publice xxx
 * 2.属性消除了某个实例字段与方法之间的差别,
 * 属性不仅和实例字段，而且和其getter、setter方法非常相似；
 * 比如，acc.number所示的属性引用方法实际上是通过acc.getNumber()实现的
 * 二、
 * 类是创建对象实例的模板
 * 三、
 * 总结: 实例.属性 等于 实例.getxxx()/setxxx(),
 * 每个Groovy类都有与之相应的Java等价类。这也就是说，方法getter和setter方法都是Groovy的隐含方法
 * 四、
 * 没有定义构造器时，编译器将创建默认的构造器(自动匹配属性-值映射对！)
 * 自定义了构造器，编译器将不会自动生成构造器
 *
 */
class Account {
    def number
    def balance

    //自定义的构造器
    Account(number, balance) {
        this.number = number
        this.balance = balance
    }

    def credit(amount) {
        balance += amount
    }
    def debit(amount) {
        if(balance >=amount) {
            balance = amount
        }
    }
    def dispaly() {
        println "Account:${number}with balance:${balance}"
    }

    @Override
    public String toString() {
        return "Account:${number}with balance:${balance}"
    }
}
