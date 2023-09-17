package Template_method_pattern_25.firstDemo;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * CLassName: Template_method_pattern_25/XMLUtil
 * Description:
 * Copyright:   Copyright (c)2023
 *
 * @author: LEGEND
 * @version: 1.0
 * Create at:   2023/9/5 0:54
 * <p>
 * Modification History:
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2023/9/5 0:54      LEGEND        1.0         1.0 Version
 */

public class XMLUtil {
    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
    public static Object getBean() {
        try {
            //创建文档对象
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File("./Design_Pattern/config.xml"));

            //获取包含类名的文本节点
            NodeList nodeList = doc.getElementsByTagName("className");
            Node classNode = nodeList.item(0).getFirstChild();
            String cName = classNode.getNodeValue();

            //通过类名生成实例对象并将其返回
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
