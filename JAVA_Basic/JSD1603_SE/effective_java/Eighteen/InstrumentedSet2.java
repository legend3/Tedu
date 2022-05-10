package effective_java.Eighteen;

import java.util.Collection;
import java.util.Set;

public class InstrumentedSet2<E> extends ForwardingSet<E>{
    private int addCount = 0;

    public InstrumentedSet2(Set<E> s) {
        super(s);//ForwardingSet类型的InstrumentedSet2实例
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
