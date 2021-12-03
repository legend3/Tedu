package Chapter12_Class
/**
 * Groovy脚本中(包括java中)的getter/setter,都会自动将getX的X小写属性名作为类属性，调用就相当于调用getter/setter方法！
 */
class propertiesGetSet {
    def c

    propertiesGetSet(c) {
        this.c = c
    }

    def getA() {
        return c
    }

    void setA(c) {
        this.c = c
    }
}
