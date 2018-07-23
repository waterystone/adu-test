package com.adu.netflix.hystrix;

import org.junit.Test;

import com.adu.BaseTest;
import com.netflix.hystrix.HystrixCircuitBreaker;

/**
 * @author yunjie.du
 * @date 2018/7/20 下午2:44
 */
public class HystrixCircuitBreakerTest extends BaseTest {
    private HystrixCircuitBreaker hystrixCircuitBreaker = HystrixCircuitBreaker.Factory.getInstance(null);

    @Test
    public void test() {

    }

}
