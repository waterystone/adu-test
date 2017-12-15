package com.adu.jdk.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.adu.BaseTest;

public class StreamTest extends BaseTest {

    private Stream<BigDecimal> stream = Stream.of(new BigDecimal("10"), new BigDecimal("30"),
            new BigDecimal("17"), new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12"));

    @Test
    public void filter() {
        Stream<BigDecimal> res = stream.filter(price -> price.compareTo(new BigDecimal(10)) > 0);
        print(res);
    }

    @Test
    public void forEach() {
        stream.forEach(e -> logger.debug("{}", e));
    }

    @Test
    public void map() {
        Stream<BigDecimal> res = stream.map(e -> e.multiply(new BigDecimal(0.5)));
        print(res);
    }

    @Test
    public void collect() {
        List<BigDecimal> res = stream.collect(Collectors.toList());
        print(res);
    }

    @Test
    public void sorted() {
        Stream<BigDecimal> res = stream.sorted((e1, e2) -> e1.compareTo(e2));
        print(res);
    }

    @Test
    public void limit() {
        Stream<BigDecimal> res = stream.skip(3).limit(2);
        print(res);
    }

    @Test
    public void count() {
        long res = stream.count();
        logRes(res);
    }

    @Test
    public void min() {
        Optional<BigDecimal> res = stream.min((e1, e2) -> e1.compareTo(e2));
        logRes(res);
    }

    @Test
    public void distinct() {
        Stream<BigDecimal> res = stream.distinct();
        print(res);
    }

    @Test
    public void mapToDouble() {
        DoubleStream res = stream.mapToDouble(e -> e.doubleValue());
        print(res);
    }

    @Test
    public void allMatch() {
        boolean res = stream.allMatch(e -> e.compareTo(new BigDecimal(0)) > 0);
        logRes(res);
    }

    @Test
    public void anyMatch() {
        boolean res = stream.anyMatch(e -> e.compareTo(new BigDecimal(0)) <= 0);
        logRes(res);
    }

    @Test
    public void noneMatch() {
        boolean res = stream.noneMatch(e -> e.compareTo(new BigDecimal(0)) <= 0);
        logRes(res);
    }

}
