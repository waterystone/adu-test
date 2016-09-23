package com.adu.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.math3.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 权重随机算法的实现。
 * 如有4个元素A、B、C、D，权重分别为1、2、3、4。
 * <p>
 * 总体思路:
 * 累加每个元素的权重A(1)-B(3)-C(6)-D(10)，然后随机出一个(0,10)之间的随机数，落在哪个区间,则该区间之后的元素即为按权重命中的元素。
 * <p>
 * 实现算法：
 * 利用TreeMap，则构造出的一个树为:
 * B(3)
 * /    \
 * /       \
 * A(1)      D(10)
 * /
 * /
 * C(6)
 *
 * @author yunjie.du
 * @date 2016/7/26 15:06
 */
public class WeightRandom<K,V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();
    private static final Logger logger = LoggerFactory.getLogger(WeightRandom.class);

    public WeightRandom(List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

}
