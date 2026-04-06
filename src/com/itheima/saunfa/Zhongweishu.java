package com.itheima.saunfa;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Zhongweishu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 最大堆存储较小的一半数字（堆顶为最大值）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 最小堆存储较大的一半数字（堆顶为最小值）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();

            if (maxHeap.size() == minHeap.size()) {
                // 当前总数为偶数 → 加入后应为奇数
                minHeap.offer(score);           // 先加入最小堆
                maxHeap.offer(minHeap.poll());   // 将最小堆的最小值转移到最大堆
                // 此时最大堆大小 = 最小堆大小 + 1
                System.out.printf("%.1f\n", (double) maxHeap.peek());
            } else {
                // 当前总数为奇数 → 加入后应为偶数
                maxHeap.offer(score);            // 先加入最大堆
                minHeap.offer(maxHeap.poll());   // 将最大堆的最大值转移到最小堆
                // 此时两堆大小相等
                double median = (maxHeap.peek() + minHeap.peek()) / 2.0;
                System.out.printf("%.1f\n", median);
            }
        }
    }
}
