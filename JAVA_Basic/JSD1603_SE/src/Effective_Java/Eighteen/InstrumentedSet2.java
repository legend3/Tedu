package Effective_Java.Eighteen;

import java.util.Collection;
import java.util.Set;

/**
 * 转发类
 * @param <E>
 */
public class InstrumentedSet2<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet2(Set<E> s) {//1.通过创建现有类(父类)的实例引用
        super(s);//*.给新类增加一个私有属性，该属性是 现有类的实例引用(super等于父类型的子类实例！)ForwardingSet类型的InstrumentedSet2实例
    }

    @Override
    public boolean add(E e) {//转发方法
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {//转发方法
        addCount += c.size();
        return super.addAll(c);
    }

    /*构造方法只初始化出父类的实例，因为实例无法调用此方法*/
    public int getAddCount() {//转发方法
        return addCount;
    }
}
