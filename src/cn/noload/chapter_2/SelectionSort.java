package cn.noload.chapter_2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 选择排序
 * 时间复杂度 O(n^2)
 * @author caohao
 * @date 2020-06-16 15:32
 */
public class SelectionSort {

    private static final int size = 1024;

    private static final int[] bucket = new int[size];

    public static void main(String[] args) {
        Random random = new Random();
        IntStream.range(0, size).forEach(i -> bucket[i] = random.nextInt(size));

        // 最小数下标
        int miniIndex = -1;
        for (int i = 0; i < size; i++) {
            // 当前循环最小数
            int miniValue = bucket[i];
            for (int j = i; j < size; j++) {
                if(miniValue >= bucket[j]) {
                    miniValue = bucket[j];
                    miniIndex = j;
                }
            }
            int temp = bucket[i];
            bucket[i] = miniValue;
            bucket[miniIndex] = temp;
        }

        System.out.println(Arrays.toString(bucket));
    }
}
