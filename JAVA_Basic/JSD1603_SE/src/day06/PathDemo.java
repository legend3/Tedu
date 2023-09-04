package day06;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PathDemo {
    public static void main(String[] args) {
        /**
         * Java的System.getProperty()方法获取大全
         * 主要介绍了Java的System.getProperty()方法获取大全,罗列了System.getProperty()方法获取各类信息的用法,具
         * 有一定的参考借鉴价值,需要的朋友可以参考下
         * 本文实例汇总了Java的System.getProperty()方法获取信息的用法。分享给大家供大家参考。具体如下：
         * 复制代码 代码如下:
         * */
        System.out.println("java版本号：" + System.getProperty("java.version")); // java版本号
        System.out.println("Java提供商名称：" + System.getProperty("java.vendor")); // Java提供商名称
        System.out.println("Java提供商网站：" + System.getProperty("java.vendor.url")); // Java提供商网站
        System.out.println("jre目录：" + System.getProperty("java.home")); // Java，哦，应该是jre目录
        System.out.println("Java虚拟机规范版本号：" + System.getProperty("java.vm.specification.version")); // Java虚拟机规范版本号
        System.out.println("Java虚拟机规范提供商：" + System.getProperty("java.vm.specification.vendor")); // Java虚拟机规范提供商
        System.out.println("Java虚拟机规范名称：" + System.getProperty("java.vm.specification.name")); // Java虚拟机规范名称
        System.out.println("Java虚拟机版本号：" + System.getProperty("java.vm.version")); // Java虚拟机版本号
        System.out.println("Java虚拟机提供商：" + System.getProperty("java.vm.vendor")); // Java虚拟机提供商
        System.out.println("Java虚拟机名称：" + System.getProperty("java.vm.name")); // Java虚拟机名称
        System.out.println("Java规范版本号：" + System.getProperty("java.specification.version")); // Java规范版本号
        System.out.println("Java规范提供商：" + System.getProperty("java.specification.vendor")); // Java规范提供商
        System.out.println("Java规范名称：" + System.getProperty("java.specification.name")); // Java规范名称
        System.out.println("Java类版本号：" + System.getProperty("java.class.version")); // Java类版本号
        System.out.println("Java类路径：" + System.getProperty("java.class.path")); // Java类路径
        System.out.println("Java lib路径：" + System.getProperty("java.library.path")); // Java lib路径
        System.out.println("Java输入输出临时路径：" + System.getProperty("java.io.tmpdir")); // Java输入输出临时路径
        System.out.println("Java编译器：" + System.getProperty("java.compiler")); // Java编译器
        System.out.println("Java执行路径：" + System.getProperty("java.ext.dirs")); // Java执行路径
        System.out.println("操作系统名称：" + System.getProperty("os.name")); // 操作系统名称
        System.out.println("操作系统的架构：" + System.getProperty("os.arch")); // 操作系统的架构
        System.out.println("操作系统版本号：" + System.getProperty("os.version")); // 操作系统版本号
        System.out.println("文件分隔符：" + System.getProperty("file.separator")); // 文件分隔符
        System.out.println("路径分隔符：" + System.getProperty("path.separator")); // 路径分隔符
        System.out.println("直线分隔符：" + System.getProperty("line.separator")); // 直线分隔符
        System.out.println("操作系统用户名：" + System.getProperty("user.name")); // 用户名
        System.out.println("操作系统用户的主目录：" + System.getProperty("user.home")); // 用户的主目录
        System.out.println("当前程序所在目录：" + System.getProperty("user.dir")); // 当前程序所在目录

//或
        Properties props = System.getProperties();
        System.out.println("Java的运行环境版本："+props.getProperty("java.version"));
        System.out.println("Java的运行环境供应商："+props.getProperty("java.vendor"));
        System.out.println("Java的运行环境供应商URL："+props.getProperty("java.vendor.url"));
        System.out.println("Java的安装路径："+props.getProperty("java.home"));
        System.out.println("Java的虚拟机规范名称："+props.getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本："+props.getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商："+props.getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称："+props.getProperty("java.vm.name"));
        System.out.println("Java的类格式版本号："+props.getProperty("java.class.version"));
        System.out.println("Java的类路径："+props.getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表："+props.getProperty("java.library.path"));
        System.out.println("默认的临时文件路径："+props.getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径："+props.getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称："+props.getProperty("os.name"));
        System.out.println("操作系统的构架："+props.getProperty("os.arch"));
        System.out.println("操作系统的版本："+props.getProperty("os.version"));
        System.out.println("分件分隔符："+props.getProperty("file.separator"));//在 unix 系统中是＂／＂
        System.out.println("路径分隔符："+props.getProperty("path.separator"));//在 unix 系统中是＂:＂
        System.out.println("行分隔符："+props.getProperty("line.separator"));//在 unix 系统中是＂/n＂
        System.out.println("用户的账户名称："+props.getProperty("user.name"));
        System.out.println("用户的主目录："+props.getProperty("user.home"));
        System.out.println("用户的当前工作主目录："+props.getProperty("user.dir"));


        Path path = Paths.get("user.dir", "day06");
        System.out.println(path);
    }
}
