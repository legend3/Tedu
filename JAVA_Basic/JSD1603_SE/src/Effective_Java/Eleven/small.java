package Effective_Java.Eleven;

public class small extends Effective_Java.Eleven.mobile {
    private int smallNumber;

    public small(int smallNumber) {
        super(smallNumber);
        this.smallNumber = smallNumber;
    }

    public int getSmallNumber() {
        return smallNumber;
    }

    public void setSmallNumber(int smallNumber) {
        this.smallNumber = smallNumber;
    }

    @Override
    public String toString() {
        return "small{" +
                "smallNumber=" + smallNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof small)) return false;
        small small = (small) o;
        return small.smallNumber == smallNumber;

//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        small small = (small) o;
//        return smallNumber == small.smallNumber;
    }

    @Override
    public int hashCode() {
        int result = 17;//只有一个field
        result = 31 * result  + Integer.hashCode(smallNumber);
        return result;
    }
}
