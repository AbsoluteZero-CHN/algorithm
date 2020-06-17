package cn.noload.chapter_4;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 快速排序
 * @author caohao
 * @date 2020-06-16 17:10
 */
public class QuickSort {

    private static final int size = 1024;

    private static final int[] bucket = new int[size];

    public static void main(String[] args) {
        Random random = new Random();
        IntStream.range(0, size).forEach(i -> bucket[i] = random.nextInt(size));
        sort(0, size - 1);
        System.out.println(Arrays.toString(bucket));
    }

    private static void sort(int l, int r) {
        if (l < r) {
            // 将中间的这个数和第一个数交换
            int i = l, j = r, x = bucket[l];
            while (i < j) {
                while(i < j && bucket[j] >= x) {
                    // 从右向左找第一个小于x的数
                    j--;
                }
                if(i < j) {
                    bucket[i++] = bucket[j];
                }
                while(i < j && bucket[i] < x) {
                    // 从左向右找第一个大于等于x的数
                    i++;
                }
                if(i < j) {
                    bucket[j--] = bucket[i];
                }
            }
            bucket[i] = x;
            sort(l, i - 1);
            sort(i + 1, r);
        }
    }
}
