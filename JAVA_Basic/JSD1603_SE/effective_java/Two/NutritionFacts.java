package effective_java.Two;

/**
 * builder模式
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {//1.builder对象
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {//2.
            this.servingSize = servingSize;//必需参数设置
            this.servings = servings;
        }
        public Builder calories(int val) {//2.1 setter相似方法设置每个可选参数
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        public NutritionFacts build() {//3.无参的build方法生成NutritionFacts对象
            return new NutritionFacts(this);
        }
    }
        private NutritionFacts(Builder builder) {//4.
            servingSize = builder.servingSize;
            servings = builder.servings;
            calories = builder.calories;
            fat = builder.fat;
            sodium = builder.sodium;
            carbohydrate = builder.carbohydrate;
        }

    public static void main(String[] args) {
        //通过内部静态类Builder设置(构造方法)参数，通过build方法创建NutritionFacts实例！
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }
}
