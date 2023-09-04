package Effective_Java.Eleven.递归;

public class Factorial {
    static int factorial(int n) {
        if(n != 0) {//终止条件
            return n * factorial(n - 1);//递归调用
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        int number = 4, result;
        result = factorial(number);
        System.out.println(number + "的阶乘=" + result);
    }
}
