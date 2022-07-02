package effective_java.Sixteen;

/**
 * 虽然公共类直接暴露属性并不是一个好主意，但是如果属性是不可变的，那么危害就不那么大了。
 * 当一个属性是只读的时候，除了更改类的 API 外，你不能改变类的内部表示形式，也不能采取一些辅助的行为，但是可以加强不变性。
 * 例如，下面的例子中保证每个实例表示一个有效的时间
 */
class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    /**公共类暴露属性*/
    public final int hour;
    public final int minute;

    private int age;

    public Time(int hour, int minute, Person person) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if (minute < 0 || minute >= MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Min: " + minute);
        this.hour = hour;
        this.minute = minute;
        this.age = person.age;//包级私有类暴露属性
    }
// Remainder omitted


}
