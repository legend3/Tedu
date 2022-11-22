package effective_java.Eleven;

public class mobile {
    private final int mobileNumber;

    public mobile(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getMobile() {
        return mobileNumber;
    }

    @Override
    public String toString() {
        return "mobile{" +
                "mobileNumber=" + mobileNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        effective_java.Eleven.mobile that = (effective_java.Eleven.mobile) o;
        return getMobile() == that.getMobile();
    }

    @Override
    public int hashCode() {
        int result = 17;//只有一个域时
        result = 31 * result + Integer.hashCode(mobileNumber);
        return result;
    }
}
