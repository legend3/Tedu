import com.sun.xml.internal.ws.server.provider.ProviderInvokerTube
import org.junit.Test

println("Hello World!")

for(i in 0..5){
    println i
}
println "-------------------"
for(i in 0..<5){
    println i
}
println("----------------------")
//声明一个Groovy的集合-1
def range = 0..4
println(range.class)
println "是否包含0: " + range.contains(0)
println range.containsAll(0..5)
assert range instanceof List
//声明一个Groovy的集合-2
def col = ["Groovy","Java","Python"]
println "类名字 : " + col.class.toString()//groovy -c GBK
assert col instanceof Collection
assert col instanceof ArrayList
//向集合中添加元素
col.add("Go")
col << "C++"
col[5] = "Perl"
//6会自动补null
col[7] = "C"
println col
//查找元素
assert col[1] == "Java"
//增加或去除元素
def numbers = [1,2,3,4]
assert numbers + 5 == [1,2,3,4,5]
assert numbers - [2,3] == [1,4]
//assert numbers - [2,3] == [1,5] : "fasle"//自定义异常信息

//集合转字符串
def num = ['a','b','c']
assert num.join(",") == "a,b,c"
println num.count('b')//统计给定值在此Iterable中出现的次数

//集合元素全部大写
def list = ["Groovy","Java","C"]*.toUpperCase()
println list
assert list == ["GROOVY","JAVA","C"]

//Map
//请注意，Groovy 映射中的键不必是 String。
//在这个示例中，name 看起来像一个变量，但是在幕后，Groovy 会将它变成 String。
def hash = [name:"Andy",age:45]
println hash.getClass()
//Set/Get-1
hash.put("id",23)
assert hash.get("name") == "Andy"
//Set/Get-2
hash.dob = "01/29/76"//自动Set
assert hash.dob == "01/29/76"
//Set/Get-3
hash["name"] == "Andy"
hash["gender"] = "male"
assert hash.gender == "male"
assert hash["gender"] == "male"

//闭包
def acoll = ["Groovy", "Java", "Ruby"]
acoll.each {
    println(it)//闭包中的 it 变量是一个关键字，指向被调用的外部集合的每个值 — 它是默认值，可以用传递给闭包的参数覆盖它
}
println "形参"
acoll.each {
    value ->
        println(value)
}
println "凡是集合或一系列的内容，都可以使用下面这样的代码进行迭代"
"amosli".each{
    println it.toUpperCase();
}
"amosli".each{
    content ->
    println content.toUpperCase();
}
// excite(延迟执行)的闭包
def s = {
    word-> println "this is ${word} "
}
//可以通过两种方法调用闭包：直接调用或者通过 call() 方法调用。
s("Java")
s.call("Groovy")

//println("闭包")
def clos = {println 'hello world!'}//创建一个闭包对象clos
clos.call()//用call函数调用
clos()//直接调用
//闭包的自带的隐参数it
def clos2 = {println "Hello ${it}"}
clos2('world!')
clos2.call('BeiJing')
//闭包声明中引入形参
def clos3 = {param -> println "Hello ${param}"}
clos3.call("LEGEND")//调用带形参的闭包
clos3("no call")
//闭包中访问属性值(闭包在定义后就能引用不同的对象)
def greeting = 'Hello'
def clos4 = {param -> println "${greeting} ${param}"}
clos4.call("World!")

greeting = 'Welcome'//第二次调用闭包之前，greeting已完成赋值
clos4('World!')

//闭包的作用范围
def demo(clos4) {
    def greeting = 'BonJour'//不影响clos4的调用(只有在闭包被定义且存在，而不是在被调用时，可以访问greeting的状态值；此时的greeting是在被调用时创建的)
    clos4.call('Ken')
}
demo(clos4)//闭包调用闭包
//按照执行顺序，其实也可以这样方式实现:
//demo()clos4//使用clos4闭包的引用，因此不能作为代码的一部分，抛出传递给所调用的闭包参数为空的错误信息
demo(){param -> println "Welcome ${param}"}//使用闭包字面值的方法在Groovy中时可行的
demo {param -> println "Welcome ${param}"}//将闭包作为实参，调用闭包的
demo clos4//将闭包作为实参，调用闭包的引用

//所有数字类型都支持upto方法
def factorial = 1
1.upto(5){ num2 -> factorial *= num2}//给factorial阶乘
println "Factorial(5): ${factorial}"

//闭包、集合和字符串
//闭包作为参数的each方法: 常用于列表、映射和字符串，以遍历每个元素，并将闭包应用于每个元素
[1,2,3,4].each {println it}//列表
['Ken':21,'John':22].each {println it}//映射
['lilei':22,'hangmeimei':23].each {println "${it.key} maps to: ${it.value}"}
//条件元素
[1,2,3,4].each {num3 -> if(num3 % 2 ==0){
    println num3
    }
}
//形参为Map.Entry
['Ken':21,'John':22].each{staff -> if(staff.value >=20){
    println staff.key
    }
}
//形参分别为Key于Value
['Ken':21,'John':22].each{staffName, staffAge -> if(staffAge >=20){
    println staffName
    }
}
//闭包作为参数的find方法
def value = [1,3,5,7,9].find{element -> element > 6}
println "Found: ${value}"
value = [1,3,5,7,9].find{element -> element > 10}
println "Found: ${value}"

value = ['Ken':21,'John':22].find {staff -> staff.value > 21}
println "Found: ${value}"
//不能使用一组参数值表示键及其对应的值，会不确定所返回的值到底是键，还是与之相对应的值
//value = ['Ken':21,'John':22].find {key,value -> value > 21}
//println "Found: ${value}"

//闭包作为参数的findAll方法
def values = [1,2,3,4].findAll {element -> element < 4}
println "FoundAll: ${values}"
values = ['Ken':21,'John':22].findAll {staff -> staff.value > 18}
println "FoundAll: ${values}"
values.each {println it}

//闭包作为参数的any方法: 判断对象中是否有符合要求的元素
def anyElement = [11,12,13,14].any {element -> element > 12}
println "anyElement: ${anyElement}"

//闭包作为参数的every方法: 判断对象中所有元素是否都符合要求
def everyElement = [11,12,13,14].every {element -> element > 10}
println "everyElement: ${everyElement}"

def anyStaff = ['Ken':21,'John':22].any {staff -> staff.value > 22}
println "anyStaff: ${anyStaff}"

//闭包作为参数的collect方法: 按照闭包代码逻辑修改集合中所有元素
def l = [1,2,3,4].collect {element -> return element * element}//非映射，无需return
println "l: ${l}"
l = [1,2,3,4].collect {element -> element * element}
println "l: ${l}"
list = (0..<5).collect {element -> 2 * element}
println "list: ${list}"
def staff = ['Ken':21,'John':22].collect {entry -> ++entry.value}
println("staff: ${staff}")//收集return一个映射中value值的新列表
def oldStaff = ['Ken':21,'John':22].collect {entry -> ++entry.value;return entry}
println "oldStaff: ${oldStaff}"

//闭包作为参数的方法inject: 第一个参数是第二个参数（闭包）的立即返回值，无需引入额外的变量就能实现累积计算
//第一个参数: 一个起初值
//第二个参数: 一个闭包
//方法规定的闭包的两个形参: prevour,element,集合中两个元素值
//assert 1*1*2*3*4 == [1,2,3,4].inject(1) { acc, val -> acc * val }
//assert 0+1+2+3+4 == [1,2,3,4].inject(0) { acc, val -> acc + val }
def factor = [2,3,4,5].inject(1) {prevour,element -> prevour * element}
//1*2*3*4*5
println("Factor的累加结果: ${factor}")

//闭包的其他特性: 闭包作为方法的参数
//声明一个集合
def table = [11,12,13,14]
//定义两个闭包
def isEven = {x -> return (x % 2 ==0)}
def isOdd = {x -> return !isEven(x)}
//定义一个将闭包作为参数的方法,通过方法来验证闭包
def filter(l, p) {
    return l.findAll(p)
}
println "evens: " + filter(table, isEven)
println "odds: " + filter(table, isOdd)

//闭包作为另一个闭包的参数
def takeWhile = {p,ll ->
    def result = []
    for(element in ll) {
        if (p(element)) {
            result << element
        } else {
            return result
        }
        return result
    }
}
def table2 = [12,14,15,18]
def table3 = [11,13,15,16,18]
println "evens: " + takeWhile.call(isEven, table2)
println "odds: " + takeWhile(isOdd, table3)

//闭包作为返回值
//方法返回闭包
def multiply(x) {
    return {y -> return x * y}
}
def twice = multiply(2)//x=2
println "twice(4): ${twice(4)}"//y=4
//闭包返回闭包
def multiplication = {x -> return {y -> return x * y}}
def quadruple = multiplication(4)
println "quadruple(3): ${quadruple(3)}"

//嵌套闭包
def c1 = {x1 ->
    def c2 = {x2 ->
        return x2
    }
    def c3 = {x3 ->
        return x3
    }
//    println "嵌套闭包结果: " + c3(c2(x1+1))
    println "嵌套闭包结果: ${c3(c2(x1+1))}"//$取值运算
}
c1(1)