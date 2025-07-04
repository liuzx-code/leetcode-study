package leetcode.algorithm.sort;


import java.util.Arrays;

/**
 * 归并排序（Merge Sort）是一种典型的分治算法（Divide and Conquer），
 * 它将一个数组分成两个子数组，分别排序后再合并成一个有序数组。
 * 它是稳定排序算法，且在最坏情况下的时间复杂度为 O(n log n)。
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // 分解左右子数组
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 合并已排序的子数组
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // 拷贝数据到临时数组
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // 合并临时数组回原数组
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // 拷贝剩余的左半部分
        while (i < n1)
            arr[k++] = leftArr[i++];

        // 拷贝剩余的右半部分
        while (j < n2)
            arr[k++] = rightArr[j++];
    }

    // 测试代码
    public static void main(String[] args) {
        int[] nums = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums)); // 输出 [3, 9, 10, 27, 38, 43, 82]
    }
}

