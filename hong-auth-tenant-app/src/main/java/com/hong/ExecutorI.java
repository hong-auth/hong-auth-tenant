package com.hong;

/**
 * @author chenhongbo
 */
public interface ExecutorI<R, E> {
    /**
     * 执行
     *
     * @param e
     * @return
     */
    R execute(E e);
}
