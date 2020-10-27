package com.adu.org.jmh;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import com.adu.BaseTest;

/**
 * @author duyunjie
 * @date 2020-10-27 09:27
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class LogBenchmark extends BaseTest {
    AtomicLong counter = new AtomicLong(0);

    @Test
    public void test() throws RunnerException {
        Options options = new OptionsBuilder().include(LogBenchmark.class.getSimpleName()).threads(2).forks(1)
                .warmupIterations(3).measurementIterations(5).measurementTime(TimeValue.seconds(60))
                .output("/tmp/data/benchmark/log.txt").build();

        new Runner(options).run();
    }

    @Benchmark
    public void log() {
        // counter.incrementAndGet();
        // Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        logger.info("count={}", counter.incrementAndGet());
    }
}
