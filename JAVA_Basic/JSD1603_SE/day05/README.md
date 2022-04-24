#前提：
 **hash是什么**(hash表的范围)  
 hash是一个函数，该函数中的实现就是一种算法，就是通过一系列的算法来得到一个hash值，这个时候，我们就需要知道另一个东西，hash表，
 通过hash算法得到的hash值就在这张hash表中，也就是说，hash表就是所有的hash值组成的，有很多种hash函数，也就代表着有很多种算法得到hash值, 编写散列函数是老生常谈的研究课题，是数学家和理论方面的计算机科学家的研究任务, 我们只需要知道那些比较好用, 大概为啥好用就可以了.  

 **hashcode是啥**
 hashcode就是通过hash函数得来的，通俗的说，就是通过某一种算法得到的，hashcode就是在hash表中有对应的位置。 

 **hash碰撞**
 数组(散列表)的同一位置的存在key的hash值一样的情况，称为hash碰撞  

## 为什么要重写equals()与 hashcode()?  
**前提：**
在java中，所有的对象都是继承于Object类。Ojbect类中有两个方法equals（定义、判断对象是否相等）、hashCode(决定对象在散列表中的位置)，这两个方法都是用来比较两个对象是否相等的。  
    - 不被重写（原生）的hashCode值是根据对象内存地址换算出来的一个值。  
    - 不被重写（原生）的equals方法是严格判断一个对象是否相等的方法（object1 == object2）。  
**结论**：_所以如果我们对equals方法进行了重写，建议一定要对hashCode方法重写，以保证相同的对象返回相同的hash值，不同的对象返回不同的hash值。_  

1. 重写equals方法时需要重写hashCode方法，_主要是针对Map、Set等集合类型的使用_:   
   - Map、Set等集合类型存放的对象必须是唯一的;  
   - 集合类判断两个对象是否相等，是先判断equals是否相等，如果equals返回True，还要再判断HashCode返回值是否ture,
   只有两者都返回ture,才认为该两个对象是相等的。  
2. 由于Object的hashCode返回的是对象的hash值，所以即使equals返回TRUE，集合也可能判定两个对象不等，所以必须重写hashCode方法,
  以保证当equals返回TRUE时，hashCode也返回Ture，这样才能使得集合中存放的对象唯一。  


1.在应用程序的执行期间，只要对象的equals方法的比较操作所用到的信息没有被修改，那么对这个（同一对象调用多次），
 hashCode方法必须始终如一地返回同一个整数。  
 在（同一个应用程序的多次执行过程中），每次执行所返回的整数可以不一致。  
 2.如果两个对象根据equals(Object)方法比较是相等的，那么调用这两个对象中任意一个对象的hashCode方法都必须产生同样的整数结果。  
 反之，如果两个对象hashCode方法返回整数结果一样，则不代表两个对象相等，因为equals方法可以被重载。  
 3.如果两个对象根据equals(Object)方法是不相等的，那么调用这两个对象中任一个对象的hashCode方法，不要求必须产生不同的整数结果！！！  
 然而，程序员应该意识到这样的事实，对于不相等的对象产生截然不同的整数结果，有可能提高散列表（hash table）的性能。  
 上述（实现hashCode方法的通用约定）  
 所以，如果只重写了equals方法而没有重写hashCode方法的话（根据内存地址换算出来的一个值,内存地址不一样，equals一样），
 则会违反约定的第二条：相等的对象必须具有相等的散列码（hashCode）  

 如何重写hashCode散列码计算(来自：Effective Java):
 把某个非零的常数值，比如17，保存在一个名为result的int类型的变量中。
 对于对象中每个关键域f(指equals方法中涉及的每个域)，完成以下步骤：

 为该域计算int类型的散列码c：

 如果该域是boolean类型，则计算(f?1:0)。

 如果该域是byte，char，short或者int类型，则计算(int)f。

 如果该域是long类型，则计算(int)(f^(f>>>32))。

 如果该域是float类型，则计算Float.floatToIntBits(f)。

 如果该域是double类型，则计算Double.doubleToLongBits(f)，然后按照步骤2.1.3，为得到的long类型值计算散列值。

 如果该域是一个对象引用，并且该类的equals方法通过递归地调用equals的方式来比较这个域，则同样为这个域递归地调用hashCode。
 如果需要更复杂的比较，则为这个域计算一个范式(canonical representation)，然后针对这个范式调用hashCode。如果这个域的值为null，则返回0(其他常数也行)。

 如果该域是一个数组，则要把每一个元素当做单独的域来处理。也就是说，递归地应用上述规则，对每个重要的元素计算一个散列码，
 然后根据步骤2.2中的做法把这些散列值组合起来。如果数组域中的每个元素都很重要，可以利用发行版本1.5中增加的其中一个Arrays.hashCode方法。

 按照下面的公式，把步骤2.1中计算得到的散列码c合并到result中：result = 31 * result + c; //此处31是个奇素数，并且有个很好的特性，即用移位和减法来代替乘法，
 可以得到更好的性能：`31*i == (i<<5) - i， 现代JVM能自动完成此优化。

 返回result
 检验并测试该hashCode实现是否符合通用约定。
 @Override
    public int hashCode() {
         int result = 17;
         result = 31 * result + mInt;
         result = 31 * result + (mBoolean ? 1 : 0);
         result = 31 * result + Float.floatToIntBits(mFloat);
         result = 31 * result + (int)(mLong ^ (mLong >>> 32));
         long mDoubleTemp = Double.doubleToLongBits(mDouble);
         result =31 * result + (int)(mDoubleTemp ^ (mDoubleTemp >>> 32));
         result = 31 * result + (mString == null ? 0 : mMsgContain.hashCode());
         result = 31 * result + (mObj == null ? 0 : mObj.hashCode());
         return result;
     }



 哈希值的作用：
  同时对于HashSet和HashMap这些基于散列值（hash）实现的类。HashMap的底层处理机制是以数组的方法保存放入的数据的(Node<K,V>[] table)，其中的关键是数组下标的处理。
  数组的下标是根据传入的元素hashCode方法的返回值再和特定的值异或决定的。
  如果该数组位置上已经有放入的值了，且传入的键值相等则不处理，若（键值）不相等则覆盖原来的值，如果数组位置没有条目，则插入，并加入到相应的链表中。
  检查键是否存在也是根据hashCode值来确定的。所以如果不重写hashCode的话，可能导致HashSet、HashMap不能正常的运作、
  如果我们将某个自定义对象存到HashMap或者HashSet及其类似实现类中的时候，如果该对象的属性参与了hashCode的计算，那么就不能修改该对象参数hashCode计算的属性了。
  有可能会移除不了元素，导致内存泄漏

 目的：
 当一个类作为HashMap中的key使用时，它的equals方法与hashcode方法的结果  直接影响散列表的查询性能。
 案例：
 	现在有两个Student对象：
     	Student s1=new Student("小明",18);
 		Student s2=new Student("小明",18);
 		此时s1.equals(s2)一定返回true，但是s1 != s2，内存地址不一样，如果不重写hashcode()的话，会得到不同哈希值，但是实际重写后的equals()定义的是两个相同的对象

 哈希冲突：由于通过哈希函数产生的哈希值是有限的，而数据可能比较多，导致经过哈希函数处理后仍然有不同的数据对应相同的哈希值。
 这时候就产生了哈希冲突--（重写equals()、hashcode()后，得到的相同的对象计算出的哈希值仍可能相同（不同地key得出相同的哈希）
 		哈希算法存在一个缺点就是哈希冲突。例如，我们进行数据存储时，我们通过对关键字进行hash时得到的地址已经存储过数据了，这时就会出现哈希冲突。
 		因此，哈希函数的设计至关重要，好的哈希函数会尽可能地保证 计算简单和散列地址分布均匀。但是，我们需要清楚的是，数组是一块连续的固定长度的内存空间，
 		再好的哈希函数也不能保证得到的存储地址绝对不发生冲突。那么哈希冲突如何解决呢？哈希冲突的解决方案有多种:开放定址法（发生冲突，继续寻找下一块未被占用的存储地址），
 		再散列函数法，链地址法，而HashMap即是采用了链地址法，也就是数组+链表的方式
 链表的作用<解决哈希冲突>：
 		有可能哈希值相同，对象的key(equal值)不同的情况——>可能存在同一hash值的元素已经被放在数组同一位置了，这时就添加到同一hash值的元素的后面，
 		他们在数组的同一位置，但是形成了链表，同一各链表上的Hash值是相同的，所以说数组存放的是链表。而当链表长度太长时，链表就转换为红黑树，这样大大提高了查找的效率。）


 API手册中明确说明:当我们重写一个类的equals方法时就应当连同重写hashCode方法。
 重写hashCode方法时应遵循:
 1:稳定性:当参与equals比较的属性的值没有发生
         过改变的前提下，多次调用hashCode
         方法返回的数字应当相同。
 2:一致性:当两个对象equals比较为true时，
         那么hashcode方法返回的数字必须相同
         反过来虽然不强制，但也尽量保证一致。
 		      因为若两个对象hashcode值相同，但是
         equal方法比较为false,在散列表中会
         产生链表，影响查询性能
 @author Administrator
