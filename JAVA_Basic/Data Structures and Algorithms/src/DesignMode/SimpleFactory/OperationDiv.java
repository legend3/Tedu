package DesignMode.SimpleFactory;

public class OperationDiv extends Operation{
    private double NumberA = 0;
    private double NumberB = 0;
    @Override
    public double getResult() {
        double result = 0;
        result = NumberA / NumberB;
        return result;
    }
}
