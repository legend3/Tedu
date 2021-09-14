package DesignMode.SimpleFactory;

/**
 * 简单工厂模式：到底要实例化谁，将来会不会增加 实例化的对象，应该考虑用一个单独的类来做这个创建实例的过程，这就是工厂。
 */
public class OperationFactory {
    public static Operation OperationCreate(String operation){
        Operation oper = null;
        switch (operation)
        {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;//返回最终被实例的对象
    }

    public static void main(String[] args) {
        Operation oper = new Operation();
        oper.setNumberA(2);
        oper.setNumberB(3);
        oper = OperationFactory.OperationCreate("+");
        System.out.println(oper.getResult());
    }
}
