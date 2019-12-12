package com.adu.concurrent;

import java.util.function.Supplier;

/**
 * @author duyunjie
 * @date 2019-12-12 15:23
 */
public abstract class LazyInitializer<T> implements Supplier<T> {
    private T object;

    @Override
    public T get() {
        if (object == null) {
            synchronized (this) {
                if (object == null) {
                    object = initialize();
                }
            }
        }

        return object;
    }

    protected abstract T initialize();
}
