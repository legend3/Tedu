package effective_java.Eighteen;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * ——组合优于继承
 * 组合(转发类): 包装需要被继承的类,将要被继承的类作为私有属性添加进组合中,作为一个包装的类.
 * 转发: 组合的每个实例方法调用(重写)现有类的包含实例(被继承的类)上的相应方法并返回结果    (都是被继承类的方法。没有别的方法).
 * 转发方法: 组合中的方法.
 * 现有类: 继承组合的类.
 *
 * 适用:
 *  1. 传统机车的父类可能随版本发布会有变动的(影响子类)，父类便于扩充
 *  2. 传统继承父类的方法间存在关联关系；这些方法对于私有属性(被继承的类)来说总是一致的，不会受(直接)继承子类的影响(super等于父类型的子类实例！)
 * @param <E>
 */
public class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return s.equals(obj);
    }

    @Override
    public String toString() {
        return s.toString();
    }

    @Override
    public int size() {
        return s.size();
    }

    @Override
    public boolean isEmpty() {
        return s.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return s.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return s.iterator();
    }

    @Override
    public Object[] toArray() {
        return s.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return s.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    @Override
    public void clear() {
        s.clear();
    }
}
