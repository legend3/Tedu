//import org.junit.Test


import Chapter12_Class.A
import Chapter12_Class.Account
import Chapter12_Class.B
import Chapter12_Class.propertiesGetSet
import Chapter9_Closure.Song
import org.testng.annotations.Test

class groovyTest {
    //Groovy单元测试
    @Test
    void test01() {
        def song4 = new Song(name: "雨一直下")
        assert song4.getName() == "雨一直下"
    }
    @Test
    void test02() {
        def song5 = new Song(name: "雨一直下")
        println song5.getArtist()
    }
    @Test
    void test04() {
        def acc1 = new Account(number: 'ABC123', balance: 1200)
        def acc2 = new Account(number: 'XYZ888', balance: 400)
        println "Accout ${acc1.number}has balance ${acc1.balance}"
        println "Accout ${acc2.number}has balance ${acc2.balance}"
    }
    @Test
    void test05() {
        def acc1 = new Account(number: 'ABC123', balance: 1200)
        def acc2 = new Account(number: 'XYZ888', balance: 400)
        //隐含的getxxx
        println "Accout ${acc1.getNumber()}has balance ${acc1.getBalance()}"
        acc1.balance = 200
        println "Accout ${acc1.getNumber()}has balance ${acc1.getBalance()}"
        //隐含的setxxx
        acc1.setBalance(600)
        println "Accout ${acc1.getNumber()}has balance ${acc1.getBalance()}"

    }
    @Test
    void test06() {
        def acc = new Account(number: 'ABC123', balance: 1200)
        acc.dispaly()
        acc.credit(200)
        acc.dispaly()
        acc.debit(900)
        acc.debit(700)
        acc.dispaly()
        acc.toString()
    }
    @Test
    void test07() {
//        def acc = new Account(number: 'ABC123', balance: 1200)//指定了构造器！
        def acc = new Account('ABC123', 1200)//自动生成构造器
    }
    @Test
    void test08() {
        def c = "c"
        def pgs = new propertiesGetSet(c)
        println pgs.a//getA方法名的A自动就是类的一个属性！(仅在Groovy脚本中可以这么调，(在Groovy脚本中)调java类也可以！)
    }
    @Test
    void test09() {
        A aa = new A(one: 1)
        B b = new B(2, aa)
        println b.getA()
    }
}
