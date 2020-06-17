package cn.noload.chapter_1;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * 二分查找法
 * @author caohao
 * @date 2020-06-16 10:31
 */
public class Dichotomy {

    private static final int size = 1024;

    private static final int[] bucket = new int[size];

    public static void main(String[] args) {
        IntStream.range(0, size).forEach(i -> bucket[i] = i);
        Random random = new Random();
        int found = random.nextInt(size);
        System.out.println(found);
        int index = find(found, 0, size, size / 2);
        System.out.println(index);
    }


    /**
     * 时间复杂度为 O(log n)
     * */
    private static int find(int found, int start, int end, int middle) {
        if(bucket[middle] == found) {
            // 找到了
            return middle;
        } else if(middle == start || middle == end) {
            return -1;
        } else if(bucket[middle] > found) {
            end = middle;
            middle = (start + middle) / 2;
            return find(found, start, end, middle);
        } else {
            start = middle;
            middle = (end + middle) / 2;
            return find(found, start, end, middle);
        }
    }
}
