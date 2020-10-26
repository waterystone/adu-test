package com.adu.codahale.metrics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.adu.BaseTest;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.codahale.metrics.Slf4jReporter;
import com.codahale.metrics.Timer;
import com.google.common.util.concurrent.Uninterruptibles;

/**
 * @author duyunjie
 * @date 2020-10-26 10:31
 */
public class MetricTest extends BaseTest {
    private static final MetricRegistry metricRegistry;
    private static final ScheduledReporter reporter;
    static {
        metricRegistry = new MetricRegistry();

        reporter = Slf4jReporter.forRegistry(metricRegistry).outputTo(LoggerFactory.getLogger("com.example.metrics"))
                .convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build();
        reporter.start(5, TimeUnit.SECONDS);
    }

    /**
     * type=METER, name=meterTest, count=39, m1_rate=0.3450455459147379, m5_rate=0.3803143621010243,
     * m15_rate=0.39265886025885827, mean_rate=0.3391462572501634, rate_unit=events/second
     */
    @Test
    public void meterTest() {
        Meter meter = metricRegistry.meter("meterTest");
        for (int i = 0; i < 100; i++) {
            logger.info("i={}", i);
            meter.mark();

            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
    }

    /**
     * type=GAUGE, name=gaugeTest, value=4
     */
    @Test
    public void gaugeTest() {
        AtomicLong counter = new AtomicLong(0);
        Gauge gauge = metricRegistry.gauge("gaugeTest", () -> new Gauge<Long>() {
            @Override
            public Long getValue() {
                return counter.longValue();
            }
        });

        for (int i = 0; i < 100; i++) {
            logger.info("i={}", i);
            counter.incrementAndGet();

            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
    }

    /**
     * type=COUNTER, name=counterTest, count=4
     */
    @Test
    public void counterTest() {
        Counter counter = metricRegistry.counter("counterTest");
        for (int i = 0; i < 100; i++) {
            logger.info("i={}", i);
            counter.inc();

            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
    }

    /**
     * type=HISTOGRAM, name=histogramTest, count=8, min=0, max=3, mean=1.2781088757652275, stddev=0.8374187436335896,
     * p50=1.0, p75=2.0, p95=3.0, p98=3.0, p99=3.0, p999=3.0
     */
    @Test
    public void histogramTest() {
        Histogram histogram = metricRegistry.histogram("histogramTest");
        for (int i = 0; i < 100; i++) {
            logger.info("i={}", i);
            histogram.update(1);
            histogram.update(i);

            Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        }
    }

    /**
     * type=TIMER, name=timerTest, count=3, min=3003.374931, max=3015.109523, mean=3010.4511638708427,
     * stddev=5.220538283543353, p50=3013.399721, p75=3015.109523, p95=3015.109523, p98=3015.109523, p99=3015.109523,
     * p999=3015.109523, m1_rate=0.2, m5_rate=0.2, m15_rate=0.2, mean_rate=0.30019102740082143, rate_unit=events/second,
     * duration_unit=milliseconds
     */
    @Test
    public void timerTest() {
        Timer timer = metricRegistry.timer("timerTest");
        for (int i = 0; i < 100; i++) {
            try (Timer.Context context = timer.time()) {
                logger.info("i={}", i);

                Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
            }
        }
    }
}
