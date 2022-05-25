# 使用私有构造方法执行非实例化
1. 起因：试图通过创建抽象类来强制执行非实例化是行不通的
2. 解决：因此可以通过包含一个私有构造方法来实现类的非实例化
`// Noninstantiable utility class  
   public class UtilityClass {  
   // Suppress default constructor for noninstantiability  
   private UtilityClass() {  
   throw new AssertionError();  
   }  
   ... // Remainder omitted  
   }  
   `
   1. AssertionError 异常不是严格要求的，但是它提
       供了一种保证，以防在类中意外地调用构造方法。它保证类在任何情况下都不会被实例化。这个习惯用法有点违反直
       觉，好像构造方法就是设计成不能调用的一样。因此，如前面所示，添加注释是种明智的做法。
