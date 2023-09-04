package Effective_Java.Seven;

import java.util.Arrays;
import java.util.EmptyStackException;

// Can you spot the "memory leak"?
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /*pop时存在内存泄漏风险*/
    public Object pop() {
        /*当一个类自己管理内存时，程序员应该警惕内存泄漏问题。
            每当一个元素被释放时，元素中包含的任何对象引用都应该被清除。（设置成null则会被垃圾回收，不然会引发内存泄漏！）
        */
        if (size == 0)
            throw new EmptyStackException();
//        return elements[--size];

        //改进
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference  置为null让其垃圾回收
        return result;
    }
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)//siez: 2 element: [0,1]
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}

