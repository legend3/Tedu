package Template_method_pattern_25.secondDemo;

/**
 * CLassName: Template_method_pattern_25.secondDemo/DataViewer
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/9/9 3:47
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/9/9 3:47      LEGEND        1.0         1.0 Version
 */
public abstract class DataViewer {
    //抽象方法: 获取数据
    public abstract void getData();

    //具体方法：转换数据
    public void convertData() {
        System.out.println("将数据转换未XML格式。");
    }

    //抽象发给发：显示数据
    public abstract void displayData();

    //钩子方法：显示数据
    public boolean isNotXMLData() {
        return true;
    }

    //模板方法
    public void process() {
        getData();
        //如果不是XML格式的数据则进行数据转换
        if(isNotXMLData()) {
            convertData();
        }
        displayData();
    }
}
