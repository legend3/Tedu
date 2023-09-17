package Template_method_pattern_25.firstDemo;

/**
 * CLassName: Template_method_pattern_25/SavingAccount
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/9/5 0:50
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/9/5 0:50      LEGEND        1.0         1.0 Version
 */
//定期账户类：具体子类
public class SavingAccount extends Account {
    //覆盖父类的抽象基本方法
    @Override
    public void calculateInterest() {
        System.out.println("按定期利率计算利息！");
    }
}
