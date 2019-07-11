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
        // The factory for the event
        EventFactory<LogEvent> factory = new EventFactory<LogEvent>() {
            @Override
            public LogEvent newInstance() {
                return new LogEvent();
            }
        };

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<LogEvent>(factory, bufferSize, DaemonThreadFactory.INSTANCE);

        // Connect the handler
        disruptor.handleEventsWith(new EventHandler<LogEvent>() {
            @Override
            public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
                logger.info("[consumer]logEvent={}", logEvent);
            }
        });

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        AtomicInteger counter = new AtomicInteger(1);
        for (int i = 0; i < 100; i++) {
            ringBuffer.publishEvent(new EventTranslator<LogEvent>() {
                @Override
                public void translateTo(LogEvent logEvent, long l) {
                    logEvent.setMsg(String.valueOf(counter.getAndIncrement()));
                    logger.info("[produce]logEvent={}", logEvent);
                }
            });

            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        }
    }
}
