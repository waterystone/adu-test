package com.adu.google.common.hash;

import org.junit.Test;

import com.adu.BaseTest;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * @author yunjie.du
 * @date 2017/9/13 下午4:19
 */
public class HashingTest extends BaseTest {
    @Test
    public void murmur3_128() {
        HashFunction hashFunction = Hashing.murmur3_128();
        HashCode hashCode = hashFunction.hashLong(System.currentTimeMillis());
        logRes(hashCode.asInt());

    }
}
