package com.itheima.saunfa;

import java.util.HashMap;

public class BinarySearch {
    
    /**
     * 二分查找算法（迭代实现）
     * @param arr 已排序的数组
     * @param target 要查找的目标值
     * @return 目标值在数组中的索引，如果不存在则返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
    
    /**
     * 二分查找算法（递归实现）
     * @param arr 已排序的数组
     * @param target 要查找的目标值
     * @param left 左边界
     * @param right 右边界
     * @return 目标值在数组中的索引，如果不存在则返回-1
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * 二分查找算法（递归实现的包装方法）
     * @param arr 已排序的数组
     * @param target 要查找的目标值
     * @return 目标值在数组中的索引，如果不存在则返回-1
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                hashMap.put(nums[i],1);
            }
        }
        for (int i = 1; i <2147483647; i++){
            if(hashMap.get(i)==null){
                return i;

            }
        }
        return 1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        // 测试迭代实现
        int target1 = 7;
        int result1 = binarySearch(arr, target1);
        System.out.println("迭代实现：查找 " + target1);
        if (result1 != -1) {
            System.out.println("找到了，索引为: " + result1);
        } else {
            System.out.println("未找到");
        }
        
        // 测试递归实现
        int target2 = 11;
        int result2 = binarySearchRecursive(arr, target2);
        System.out.println("递归实现：查找 " + target2);
        if (result2 != -1) {
            System.out.println("找到了，索引为: " + result2);
        } else {
            System.out.println("未找到");
        }
        
        // 测试不存在的元素
        int target3 = 6;
        int result3 = binarySearch(arr, target3);
        System.out.println("迭代实现：查找 " + target3);
        if (result3 != -1) {
            System.out.println("找到了，索引为: " + result3);
        } else {
            System.out.println("未找到");
        }
    }
}