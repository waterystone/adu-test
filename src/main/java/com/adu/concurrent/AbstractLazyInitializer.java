package com.adu.concurrent;

import java.util.function.Supplier;

/**
 * 线程安全的延迟实例化抽象模板。
 * <p><b>只在第一次使用时才实例化，如果没有使用就不会实例化，从而提升应用性能。</b>
 * <pre> {@code
 * public class AbstractLazyInitializerTest {
 *     private final Logger logger = LoggerFactory.getLogger(this.getClass());
 *     private static final AbstractLazyInitializer<Date> LAZY_DATE = new AbstractLazyInitializer<Date>() {
 *         @Override
 *         protected Date initialize() {
 *             System.out.println("op=start_initialize");
 *             return new Date();
 *         }
 *     };
 *
 *     @Test
 *     public void test() {
 *         for (int i = 0; i < 10; i++) {
 *             logger.info("[{}]person={}", i, LAZY_DATE.get());
 *         }
 *
 *     }
 * }}</pre>
 *
 * @author duyunjie
 * @date 2019-12-12 17:28
 */
public abstract class AbstractLazyInitializer<T> implements Supplier<T> {
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
