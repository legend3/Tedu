package Chapter9_Closure

import groovy.transform.Canonical

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




@Canonical
class Student {
    String firstName
    String lastName
    int age
    String address
}

def student = new Student(firstName: "Zhang",
        lastName: "Sanfeng",
        age: 16,
        address: "China")

println student