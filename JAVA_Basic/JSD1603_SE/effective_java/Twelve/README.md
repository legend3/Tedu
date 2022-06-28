# 12. 始终重写 toString 方法
- 宗旨：
  - toString 的通用约定要求，返回的字符串应该是“一个简洁但内容丰富的表示，对人们来说是很容易阅读的  
  - toString 通用约定“建议所有的子类重写这个方法”。
- 好处：
  - 提供一个很好的 toString 方法的好处不仅包括类的实例，同样有益于包含实例引用的对象，特别是集合。 打印 map 对象时你会看到哪一个， {Jenny=PhoneNumber@163b91} 还是 {Jenny=707-867-5309} ?
- 要求：
  - 实际上，toString 方法应该返回对象中包含的所有需要关注的信息，如电话号码示例中所示  
  - 实现 toString 方法时，必须做出的一个重要决定是：在文档中指定返回值的**格式**
    - _如果指定了格式_，通常提供一个匹配的**静态工厂**或**构造方法**，是个好主意，所以程序员可以轻松地*在对象和字符串表示之间来回转换*(包括 BigInteger，BigDecimal大部分基本类型包装类的valueOf方法)
    - 格式化带来的缺点：
      - 指定 toString 返回值的格式的缺点是，假设你的类被广泛使用，一旦指定了格式，就会终身使用；
      - 不格式化的好处：
        - 但通过选择不指定格式，就可以保留在后续版本中添加信息或改进格式的灵活性
- 适用场合：
  - 在**静态工具类**（条目 4）中编写 toString 方法是**_没有意义的_**
  - **_不应该_**在**大多数枚举类型**（条目 34）中写一个 toString 方法，因为 Java 为你提供了一个非常好的方法
  - 应该在**任何抽象类**中定义 toString 方法，该类的子类共享一个公共字符串表示形式




# 字符串格式化
## 问题
在开发的时候一段字符串的中间某一部分是需要可变的 比如一个Textview需要显示”XXX用户来自 上海 年龄 21 性别 男”  
其中的 XXX 是用户名 每个用户也是不一样的  
地区 上海 为可变的string数据  
年龄 21 为可变的int数据  
性别 男 为可变的string数据  
遇到这种情况你们是怎么样解决的呢?把这段字符串保存在常量类里吗?不!我们应该遵循Google的开发模式  

### XML  
> <string name="user_info'> %1$s</span> 用户来自 <span class="hljs-variable">%2</span><span class="hljs-variable">$s  年龄 %3$d</span>  性别 <span class="hljs-variable">%4</span><span class="hljs-variable">$s</string>  

### JAVA

`String userName="XXX";  
String userProvince="上海";  
int userAge=21;  
String userSex="男";  
String string=getResources().getString(R.string.user_info);  
String userInfo=String.format(string,userName,userProvince,userAge,userSex);`  

>String.format()字符串常规类型格式化的两种重载方式  

- format(String format, Object… args) 新字符串使用本地语言环境，制定字符串格式和参数生成格式化的新字符串。  
- format(Locale locale, String format, Object… args) 使用指定的语言环境，制定字符串格式和参数生成格式化的字符串。  
上个例子有用到了字符类型和整数类型的格式化 下面我把常用的类型例举出来  
转换符	详细说明	示例  
%s	字符串类型	“喜欢请收藏”  
%c	字符类型	‘m’  
%car	布尔类型	true  
%d	整数类型（十进制）	88  
%x	整数类型（十六进制）	FF  
%o	整数类型（八进制）	77  
%f	浮点类型	8.888  
%a	十六进制浮点类型	FF.35AE  
%e	指数类型	9.38e+5  
%g	通用浮点类型（f和e类型中较短的）	不举例(基本用不到)  
%h	散列码	不举例(基本用不到)  
%%	百分比类型	％(%特殊字符%%才能显示%)  
%n	换行符	不举例(基本用不到)  
%tx	日期与时间类型（x代表不同的日期与时间转换符)	不举例(基本用不到)  
为了方便理解还是举个例子  
String str=null;    
str=String.format("Hi,%s", "小超");    
System.out.println(str);    
str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");              
System.out.println(str);                           
System.out.printf("字母c的大写是：%c %n", 'C');  
System.out.printf("布尔结果是：%car %n", "小超".equal("帅哥"));  
System.out.printf("100的一半是：%d %n", 100/2);  
System.out.printf("100的16进制数是：%x %n", 100);  
System.out.printf("100的8进制数是：%o %n", 100);  
System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);  
System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);  
System.out.printf("上面价格的指数表示：%e %n", 50*0.85);  
System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);  
System.out.printf("上面的折扣是%d%% %n", 85);  
System.out.printf("字母A的散列码是：%h %n", 'A');  
输出结果：  

Hi,小超  
Hi,小超 是个 大帅哥    
字母c的大写是：C   
布尔的结果是：false   
100的一半是：50   
100的16进制数是：64   
100的8进制数是：144   
50元的书打8.5折扣是：42.500000 元  
上面价格的16进制数是：0x1.54p5   
上面价格的指数表示：4.250000e+01   
上面价格的指数和浮点数结果的长度较短的是：42.5000   
上面的折扣是85%   
字母A的散列码是：41  
###搭配转换符还有实现高级功能 第一个例子中有用到 $  

标志	说明	示例	结果  
+	为正数或者负数添加符号	(“%+d”,15)	+15  
     0	数字前面补0(加密常用)	(“%04d”, 99)	0099  
     空格	在整数之前添加指定数量的空格	(“% 4d”, 99)	99  
     ,	以“,”对数字分组(常用显示金额)	(“%,f”, 9999.99)	9,999.990000  
     (	使用括号包含负数	(“%(f”, -99.99)	(99.990000)  
#	如果是浮点数则包含小数点，如果是16进制或8进制则添加0x或0	(“%#x”, 99)(“%#o”, 99)	0x63 0143  
<	格式化前一个转换符所描述的参数	(“%f和%<3.2f”, 99.45)	99.450000和99.45  
d,%2$s”, 99,”abc”)	99,abc	 	 
第一个例子中有说到 %tx x代表日期转换符 我也顺便列举下日期转换符  

标志	说明	示例  
c	包括全部日期和时间信息	星期六 十月 27 14:21:20 CST 2007  
F	“年-月-日”格式	2007-10-27  
D	“月/日/年”格式	10/27/07  
r	“HH:MM:SS PM”格式（12时制）	02:25:51 下午  
T	“HH:MM:SS”格式（24时制）	14:28:16  
R	“HH:MM”格式（24时制）	14:28  
来个例子方便理解  

Date date=new Date();                                  
//c的使用  
System.out.printf("全部日期和时间信息：%tc%n",date);          
//f的使用  
System.out.printf("年-月-日格式：%tF%n",date);  
//d的使用  
System.out.printf("月/日/年格式：%tD%n",date);  
//r的使用  
System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);  
//t的使用  
System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);  
//R的使用  
System.out.printf("HH:MM格式（24时制）：%tR",date);  
输出结果：  

全部日期和时间信息：星期三 九月 21 22:43:36 CST 2016  
年-月-日格式：2016-09-21  
月/日/年格式：16/10/21    
HH:MM:SS PM格式（12时制）：10:43:36 下午    
HH:MM:SS格式（24时制）：22:43:36  
HH:MM格式（24时制）：22:43  
其实还有很多其他有趣的玩法 我这边只列举一些常用的 有兴趣的朋友可以自己再去多了解了解