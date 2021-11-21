//import org.junit.Test
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
}
