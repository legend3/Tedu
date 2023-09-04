package Effective_Java.Two;

/**
 * 传统方式
 */
public class NutritionFacts01 {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional

    public NutritionFacts01(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts01(int servingSize, int servings,
                            int calories) {
        this(servingSize, servings, calories, 0);
    }
    public NutritionFacts01(int servingSize, int servings,
                            int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }
    public NutritionFacts01(int servingSize, int servings,
                            int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    public NutritionFacts01(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts01{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionFacts01 cocaCola = new NutritionFacts01(240, 8, 100, 0, 35, 27);
        System.out.println(cocaCola);
    }
}
