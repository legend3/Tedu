package Chapter12_Class

class A {
    def one

    A(one) {
        this.one = one
    }

    def getOne() {
        return one
    }

    void setOne(one) {
        this.one = one
    }

    @Override
    public String toString() {
        return "A{" +
                "one=" + one +
                '}';
    }
}
