package com.adu.lmax.disruptor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.util.concurrent.Uninterruptibles;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @author duyunjie
 * @date 2019-07-11 20:57
 */
public class DisruptorTest extends BaseTest {
    @Test
    public void test1() {
        // The factory for the event。初始时利用工厂创建实例填满ringBuffer,之后的消息会一直复用这些实例，而不是每次都创建。
        EventFactory<LogEvent> factory = new EventFactory<LogEvent>() {
            @Override
            public LogEvent newInstance() {
                logger.info("[factory]");
                return new LogEvent();
            }
        };

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 8;

        // Construct the Disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<LogEvent>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWith(new EventHandler<LogEvent>() {
            @Override
            public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
                logger.info("[consume]logEvent={},l={},b={}", logEvent, l, b);
            }
        });

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        // 发送消息
        AtomicInteger counter = new AtomicInteger(1);
        for (int i = 0; i < 100; i++) {
            ringBuffer.publishEvent(new EventTranslator<LogEvent>() {
                @Override
                public void translateTo(LogEvent logEvent, long l) {
                    String before = logEvent.toString();
                    logEvent.setMsg(String.valueOf(counter.getAndIncrement()));
                    logger.info("[produce]logEvent={},l={},before={}", logEvent, l, before);
                }
            });

            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
    }
}
