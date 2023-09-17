package Template_method_pattern_25.secondDemo;

/**
 * CLassName: Template_method_pattern_25.secondDemo/SubDataViewer
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/9/9 3:53
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/9/9 3:53      LEGEND        1.0         1.0 Version
 */
public class SubDataViewer extends DataViewer {
    @Override
    public void getData() {
        System.out.println("从XML文件中获取数据。");
    }

    @Override
    public void displayData() {
        System.out.println("以为状图显示数据");
    }

    //显示父类的钩子方法
    public boolean isNotXMLData() {
        return false;//返回false，表示该数据已为XML格式，无须执行数据转换方法convertData()——"实现子类控制父类的行为"
    }
}
