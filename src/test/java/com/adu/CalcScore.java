package com.adu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalcScore {
    private static float[] nums = new float[] { 96.67833333F, 97.33333333F, 91.59F, 92F, 91.59F, 91.66666667F,
            86.66666667F, 96.66666667F, 96.67833333F, 91.59F, 96.67833333F, 97.33333333F, 96.67833333F, 91.59F,
            96.67833333F, 97.16666667F, 96.67833333F, 97.26666667F, 97.2F, 96.67833333F, 97.16666667F, 97.1F,
            96.67833333F, 97.06666667F, 96.67833333F, 96.67833333F, 97.16666667F, 96.67833333F, 91.59F, 97.43333333F,
            97.13333333F, 97.03333333F, 96.67833333F, 97F, 97F, 98F, 94F, 97F, 97F, 97F, 93F, 97F, 97F };
    private static int count = 11;
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.print("main");
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = getList(nums[i]);

            System.out.print(nums[i] + ",");
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + ",");
                sum += list.get(j);
            }
            double avg = sum * 1.0 / count;
            double delta = Math.abs(avg - nums[i]);
            System.out.println(sum + "," + avg + "," + delta);
        }
    }

    private static List<Integer> getList(float avg) {
        int min = Math.round(avg - 5), max = Math.min(Math.round(avg + 5), 100), interval = max - min;

        int total = Math.round(avg * count);
        int remain = total - min * count;

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            res.add(min);
        }

        while (true) {
            for (int i = 0; i < count; i++) {
                int oldValue = res.get(i);
                int randomValue = random.nextInt(interval);
                int newValue = oldValue + randomValue;

                if (newValue > max) {
                    continue;
                }

                if (randomValue < remain) {
                    res.set(i, newValue);
                    remain -= randomValue;
                } else {
                    res.set(i, oldValue + remain);
                    return res;
                }
            }
        }
    }
}
