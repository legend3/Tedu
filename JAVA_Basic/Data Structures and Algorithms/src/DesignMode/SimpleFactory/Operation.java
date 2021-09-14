package DesignMode.SimpleFactory;

public abstract class Operation {
    private double NumberA = 0;
    private double NumberB = 0;

    public double getNumberA() {
        return NumberA;
    }

    public void setNumberA(double numberA) {
        NumberA = numberA;
    }

    public double getNumberB() {
        return NumberB;
    }

    public void setNumberB(double numberB) {
        NumberB = numberB;
    }

    public double getResult(){
        double result = 0;
        return result;
    }
}
