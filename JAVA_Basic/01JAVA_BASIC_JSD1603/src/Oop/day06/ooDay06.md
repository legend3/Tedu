回顾:
1.static final常量:
   不能改，必须声明同时初始化，类名点来访问
   建议所有字母大写
   在编译时被自动替换为具体的值
2.抽象方法:
   abstract修饰
   只有方法的定义，没有方法的具体实现
3.抽象类:
   abstract修饰
   包含抽象方法的类必须是抽象类
   不能被实例化
   需要被继承的，子类:
     要么也声明为抽象类
     要么重写所有抽象方法
   意义:
     封装共有，给所有子类提供了一种统一的类型
     包含抽象方法，为所有子类提供统一的入口

4.接口:
   标准、规范
   interface定义
   *只能包含常量和抽象方法
   不能被实例化
   需要被实现的，实现类：必须重写所有抽象方法
   一个类可以实现多个接口，
   *若又继承又实现时，要先继承后实现
   *接口可以继承接口

class Shape{
  protected double c;
}

class Six extends Shape{
  public Six(double c){
    this.c = c;
  }
  public double area(){
    return 0.0721*c*c;
  }
}


interface CCB extends UnionPay{
  public void payFire(double money);
}
class CCBImpl implements CCB{
  重写4个方法
}


接口不能有构造方法
抽象类可以有构造方法





正课:
1.多态:
  1)多态的意义:
    1.1)同一类型的引用指向不同的对象时，(同一方法/功能)有不同的实现 ——对象决定方法的实现！
        ----行为的多态:cut(),run()
    1.2)同一个对象被造型为不同的类型时，有不同的功能(方法)  ——类型决定能有什么功能(方法)！
        ----对象的多态:我,水
  2)向上造型:
    2.1)父类型的引用指向子类的对象
    2.2)能造型成的类型: 
          父类型、实现的接口
    2.3)能点出来什么，看引用的类型*
  3)强制类型转换，成功的条件:
    3.1)引用所指向的对象，就是该类型
    3.2)引用所指向的对象，实现了该接口
  4)若不符合强转的条件，则发生类型转换异常ClassCastException
    建议:强转之前通过instanceof来判断引用指向的对象是否是某种类型

2.内部类:单独使用的几率不大,作用：1、扩充功能 2、*实现多重继承 3、减少了类文件编译后产生的字节码文件大小  
2.1.成员内部类:**扩充的普通成员属性**(比普通属性功能强大)  
  1)类中套类，外面的叫外部类，里面的叫内部类  
  2)内部类通常只服务于外部类，对外不具备可见性  
  3)内部类对象通常只在外部类中创建(要通过外部类才能被创建出！)  
  4)内部类可以直接访问外部类的成员(所有变量、方法)  
    4.1)访问外部类非静态:  
        a.内部类有个隐式的引用指向了创建它的外部类对象 外部类名.this.属性 外部类名.this.方法  
        b.直接访问: 属性、方法  
    4.2)访问外部类的静态：外部类类名.静态方法名、外部类类名.静态属性名  

3.静态内部类:**扩充的静态成员属性**(比静态属性功能强大)  
    1)使用staitc声明，可以通过外部类.内部类来访问  
    2)使用场合:内部类不需要外部类的实例(区分成员内部类)，为外部类提供服务，且可以独立存在。  
    3)a.不会有外部类隐式的引用; b.直接访问外部类的静态属性; c.通过外部类的实例访问外部类的成员属性  

4.局部内部类：扩充类方法的功能  
    1) 在外部类的方法中添加一个内部类，通过自动调用内部类中方法达到扩充外部类方法的功能

5.**匿名内部类**: 一次性(临时实现)用一次类或接口的**功能(方法)**   
  1)若想创建一个类的对象，并且对象只被创建一次，此时该类不必命名，称之为**匿名内部类**   
    注意:类必须是子类!（某个类的实例对象的类）:  
    1.匿名类是子类,虽然你是匿名类，但你仍然需要一个具体类型来保存引用以及创建对象，单靠匿名类是不可能new出一个对象的，因为你连名字都没有，  
        new谁呢。这个具体类型就是父类，或者实现的接口。  
    2.应该是对的，因为创建匿名类的时候必然会new xxx(){}; xxx可能是类名也可能是接口，这时候该匿名类就继承了xxx，
        我们可以在匿名类的方法进行扩展，所以*匿名类必然会是某个类的子类或者某个接口的实现对象*。  
  2)**匿名内部类中若想访问外部的变量，该变量必须是final的**：（Java 8更加智能：如果局部变量被匿名内部类访问，
那么该局部变量相当于自动使用了final修饰。）   
        这要从闭包说起，匿名内部类和外部方法形成了一个闭包，因此，匿名内部类能够访问外部方法的变量，看起来是一种“天经地义”的事情，
        Java语言当然也需要实现这种特性，但是这里遇到了一个问题。    
        _匿名内部类的生命周期可能比外部的类要长，因此访问外部局部变量有可能是访问不到的。_   
        那怎么办呢？   
            1.Java语言为了实现这种特性， 只好将外部的局部变量偷偷的赋值了一份给匿名内部类。   
            那这样匿名内部类就可以肆无忌惮的访问外部局部变量了。  
        _问题又来了，这种通过赋值的形式有一个缺陷，匿名内部类不可以修改“原来的局部变量”，因为是一份“复制品”，修改复制品对原变量没什么影响啊。_  
        那怎么办？  
            2.Java语言干脆强制要求被匿名内部类访问的外部局部变量必须是final的，什么意思呢？就是“一刀切”，不让修改了。   
    3)匿名内部类不能有构造方法  
    4)匿名内部类不能定义任何静态成员、静态方法  
    5)匿名内部类不能是public,protected,private,static  
    6)只能创建匿名内部类的一个实例  
    7)_一个匿名内部类一定是在new的后面，用其隐含实现一个接口或继承一个类_（*作用、过程）  
    8)_因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效_  
    9)**匿名内部类的使用场景**: 当类或接口类型作为参数传递时，可以直接使用匿名内部类方式创建对应的对象!  

面向对象总结:
1.封装:
  1)类:封装对象的属性和行为
  2)方法:封装的是具体的实现过程
  3)访问修饰符:封装的是访问的权限
2.继承:
  1)作用:避免代码重复，有利于代码的复用
  2)父类:所有子类所共有的属性和行为
    子类:子类所特有的属性和行为
  3)子继承父后，子具有: 父+子
  4)单一继承、传递性
3.多态:
  1)意义:
    1.1)行为的多态:同一类型引用指向不同的对象时，有不同的实现
    1.2)对象的多态:同一对象被造型为不同的类型时，有不同的功能
  2)向上造型、强制类型转换、instanceof
  3)多态的表现形式:
    3.1)重写
    3.2)重载



面向对象课程内容:
第一天:
  1.什么是类？什么是对象？
  2.如何创建类？如何创建对象？
  3.引用类型画等号
  4.null和NullPointerException
第二天:
  1.方法的重载
  2.构造方法
  3.this
  4.引用类型数组
第三天:
  1.内存管理:堆、栈、方法区
  2.继承:
  3.super:
  4.向上造型:
第四天:
  1.方法的重写
    重写与重载的区别
  2.package和import
  3.访问控制修饰符
  4.static
  5.final
  6.static final常量
第五天:
  1.抽象方法
  2.抽象类
  3.接口
第六天:
  1.多态:
      意义、向上造型、强转、instanceof
  2.内部类:
      成员内部类、匿名内部类



任务:
1.熟练完成课上的ATM系统
2.完成完整的农行ATM系统
3.运行Shoot项目















System.out.println();
System.out.println(1);
System.out.println(2.5);
System.out.println(true);
System.out.println('b');











常见面试题:
 问:内部类有自己独立的.class吗?
 答:有















NstInnerClassDemo$1.class
NstInnerClassDemo$2.class
NstInnerClassDemo$3.class




每一个类(类型)都有一个字节码文件











NstInnerClassDemo












class Test{
  main(){
    Aoo o1 = new Aoo(); //正确
    Boo o2 = new Boo(); //编译错误
  }
}
class Aoo{ //外部类
  private int a;
  void test(){
    Boo o = new Boo(); //正确
  }
  class Boo{ //内部类
    void show(){
      System.out.println(a);
      System.out.println(Aoo.this.a);
      System.out.println(this.a); //编译错误
    }
  }
}


InnerClassDemo
















class Test{
  public static void main(String[] args){
    Aoo o1 = new Aoo(); //正确
    Boo o2 = new Boo(); //编译错误
  }
}


class Aoo{ //外部类
  class Boo{ //内部类---不是独立的
    
  }
}













农行的ATM机系统:
1.什么卡都能插
2.只有农行卡才能支付电话费


ABCATM atm = new ABCATM(); //atm机
UnionPay card = new ABCImpl(); //银联卡--农行卡
atm.insertCard(card); //插卡


class ABCATM{ //农行ATM机
  private UnionPay card; //银联卡
  public void insertCard(UnionPay card){ //插卡
    this.card = card;
  }
  public void payTelBill(){ //支付电话费
    if(card instanceof ABC){ //农行卡
      ABC abcCard = (ABC)card;
      abcCard.payTellBill("12345678945",500);
    }else{
      System.out.println("不是农行卡，不能支付电话费");
    }
  }
}

1.ATM只提供无参无返回值的方法作为入口
2.在方法中实质上操作的是card















Aoo o1 = new Boo(); //向上造型
Boo o2 = (Boo)o1; //符合条件1
Inter1 o3 = (Inter1)o1; //符合条件2
if(o1 instanceof Coo){ 
  Coo o4 = (Coo)o1;
}

System.out.println(o1 instanceof Boo); //true
System.out.println(o1 instanceof Inter1); //true
System.out.println(o1 instanceof Coo); //false


interface Inter1{
}
class Aoo{
}
class Boo extends Aoo implements Inter1{
}
class Coo extends Aoo{
}













数据类型转换:
1)自动类型转:从小到大
2)强制类型转:从大到小


父类大，子类小

Person p1 = new Student(); //向上造型(自动类型转换)
Person p2 = new Teacher();

Student p3 = new Person();














ICBC card1     = new ICBCImpl();
UnionPay card1 = new ICBCImpl();



父类的东西少，子类东西多
向上造型之后，能点出来的东西----少了




我 me = new 我();
讲师        o1 = me;
孩子他妈    o2 = me;
老公的老婆  o3 = me;

o1.授课();
o2.揍他();
o3.咬他();
o3.收工资();


interface 讲师{
  授课();
}
interface 孩子他妈{
  揍他();
}
interface 老公的老婆{
  咬他();
  收工资();
}
class 我 implements 讲师，孩子他妈，老公的老婆{
  授课(){}
  揍他(){}
  咬他(){}
  收工资(){}
}


Animal o1 = new Tiger();
Animal o2 = new Fish();
Animal o3 = new Bird();

o1.run();
o2.run();
o3.run();

abstract class Animal{
  abstract void run();
}
class Tiger extends Animal{
  void run(){在地上跑}
}
class Fish extends Animal{
  void run(){在水里游}
}
class Bird extends Animal{
  void run(){在天上飞}
}


cut():多态的

人 p1 = new 理发师();
人 p2 = new 外科医生();
人 p3 = new 演员();

p1.cut(); //剪发
p2.cut(); //开刀
p3.cut(); //停止表演



abstract class 人{
  abstract void cut();
}
class 理发师 extends 人{
  void cut(){ 剪发 }
}
class 外科医生 extends 人{
  void cut(){ 开刀 }
}
class 演员 extends 人{
  void cut(){ 停止表演 }
}
























设计规则:
1)所有子类共有的封装到父类中
2)所有子类行为都一样----普通方法
  所有子类行为不一样----抽象方法
3)符合既是也是原则时，使用接口



















抽象类-----父类
接口-------父类(既是也是)






需求:
 教学副总裁:
   培训员工()、解决问题()、编辑稿件()
 达内讲师:
   培训员工()、解决问题()、编辑稿件()
 达内项目经理:
   编辑稿件()

interface 企业技术顾问{
  培训员工()、解决问题()
}
interface 技术图书作者{
  编辑稿件()
}
abstract class 达内职员{
  姓名、年龄、工资
  上班打卡(){ 按个手纹、拍个照 }
  下班打卡(){ 按个手纹、拍个照 }
  abstract 完成工作();
}
class 教学副总裁 extends 达内职员 implements 企业技术顾问，技术图书作者{
}
class 讲师 extends 达内职员 implements 企业技术顾问，技术图书作者{
}
class 项目经理 extends 达内职员 implements 技术图书作者{
}
class 班主任 extends 达内职员{
}












