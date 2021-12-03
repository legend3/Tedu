package Chapter9_Closure
/**
 * Groovy的类：
 * Groovy 自动提供一个构造函数，构造函数接受一个名称-值对的映射，这些名称-值对与类的属性相对应。
 * 这是 Groovy 的一项开箱即用的功能 — 用于类中定义的任何属性，Groovy 允许将存储了大量值的映射传给构造函数。
 * 映射的这种用法很有意义，例如，您不用初始化对象的每个属性。
 */
class Song {
    def name
    def artist
    def genre

    def getArtist() {
        //加个?可以防止空指针的错误：
        return artist?.toUpperCase()
    }

    @Override
    public String toString() {
        "${name},${artist},${genre}"
    }
}
