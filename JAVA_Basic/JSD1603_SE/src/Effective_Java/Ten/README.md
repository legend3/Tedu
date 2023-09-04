# 第8条：覆盖 equals 时请遵守通用约定

## 不需要重写equals方法的场景：
覆盖 equals 方法看起来很简单，但是有许多覆盖方式会导致错误，并且后果非常严重。最容
易避免这类问题的办法就是**不覆盖 equals 方法，在这种情况下，类的每个实例都只与它自身
相等**。如果满足了以下任何一个条件，这就正是所期望的结果：
- 类的每个实例本质上都是唯一的。对于代表活动实体而不是值（value）的类来说确实如
此。例如Thread 。 Object 提供的 equals 实现对于这些类来说正是正确的行为。  

- 不关心类是否提供了“逻辑相等（logical equality）”的测试功能。例
如， java.util.Random 覆盖了 equals ，以检查两个 Random 实例是否产生相同的随机数
序列，但是设计者并不认为客户端需要或者期望这样的功能。在这样的情况下，
从 Object 继承得到的 equals 实现已经足够了。

- 超类已经覆盖了 equals ，从超类继承过来的的行为对于子类也是合适的。例如，大多数
的 Set 实现都从 AbstractSet 继承 equals 实现， List 实现从 AbstractList 继
承 equals 实现, Map 实现从 AbstractMap 继承 equals 实现。  

- 类是私有的或是包级私有的，可以确定它的 equals 方法永远也不会被调用。在这种情况
下，无疑是应该覆盖 equals 方法的，以防它被意外调用：  


    @Override public boolean equals(Object o) {  
        throw new AssertionError(); // Method is never called  
    }  

##那么，什么时候应该覆盖 Object.equals 呢？
>**如果类具有自己特有的“逻辑相等”概念（不同于对象等同的概念），_而且父类还没有覆盖equals(还是Object的equals方法)以实现期望的行为_，这时我们就需要覆
盖 equals 方法。** 

适合场景：
1. 这通常属于"值类（value class）"的情形。值类仅仅是一个表示值的类，例
如 Integer 或者 Date 。程序员在利用 equals 方法来比较值对象的引用时，(意义:)**希望知道它们在
逻辑上是否相等，而不是想了解它们是否指向同一个对象**。  
2. 为了满足程序员的要求，不仅必需覆盖 equals 方法，而且这样做也使得这个类的实例可以被用作映射表（map）的键
（key），或者集合（set）的元素，使映射或者集合表现出预期的行为。    
不适合场景：有一种“值类”不需要覆盖 equals 方法，即用实例受控（见第1条）确保“每个值至多只存在一
个对象”的类。枚举类型（见第30条）就属于这种类。对于这样的类而言，逻辑相同与对象等

同是一回事，因此 Object 的 equals 方法等同于逻辑意义上的 equals 方法。  
在覆盖 equals 方法的时候，你必须要遵守它的通用约定。下面是约定的内容，来 自 Object 的规范[JavaSE6]：  
equals 方法实现了等价关系（equivalence relation）：    
- **自反性**（reflexive）。对于任何非 null 的引用值 x ， x.equals(x) 必须返回 true 。  
- **对称性**（symmetric）。对于任何非 null 的引用值 x 和 y ，当且仅当 y.equals(x) 返 回 true 时， x.equals(y) 必须返回 true 。  
- **传递性**（transitive）。对于任何非 null 的引用值 x 、 y 和 z 。如果 x.equals(y) 返 回 true，并且 y.equals(z) 也返回 true，
那么 x.equals(z) 也必须返回 true。
  - (问题)**考虑子类的情况**， 将新值组件（ value component）添加到其父类中。换句话说，子类添加了一个信息，它影响了 equals 方法比较
  - (原理)**事实证明，这是面向对象语言中关于等价关系的一个基本问题。 除非您愿意放弃面向对象抽象的好处，
    否则无法继承可实例化的类，并在保留 equals 约定的同时添加一个值组件**。
  - 
- **一致性**（consistent）。对于任何非 null 的引用值 x 和 y ，只要 equals 的比较操作 
在对象中所用的信息没有被修改，多次调用 x.equals(x) 就会一致地返回 true ，或者一 致的返回 false 。 
- 对于**任何非 null** 的引用值 x ， x.equals(null) 必须返回 false 。

除非你对数学特别感兴趣，否则这些规定看起来可能有点让人感到恐惧，但是绝对不要忽视
这些规定！如果你违反了它们，就会发现你的程序将会表现不正常，甚至崩溃，而且很难找
到失败的根源。用John Donne的话说，没有哪个类是孤立的。一个类的实例通常会被频繁地
传递给另一个类的实例。有许多类，包括所有的集合类（collection class）在内，都依赖于传
递给它们的对象是否遵守了 equals 约定。  