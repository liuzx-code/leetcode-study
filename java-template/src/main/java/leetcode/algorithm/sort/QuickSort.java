package leetcode.algorithm.sort;


import java.util.Arrays;

/**
 * 快速排序（Quick Sort）是一种高效的基于分治思想的排序算法，
 * 其核心思路是通过一个**基准值（pivot）**将数组分为两部分：
 * 一部分小于基准值，另一部分大于基准值，
 * 然后递归地对这两部分继续排序。
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            // 排左边
            quickSort(arr, left, pivotIndex - 1);
            // 排右边
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * 算法：
      * 1. 找到一个 pivot，一般选取最右边的元素作为 pivot。
     * 2. 遍历数组，将比 pivot 小的元素放到左边，比 pivot 大的元素放到右边。
     * 3. 将 pivot 放到正确的位置，即 pivot 左边的元素都小于 pivot，右边的元素都大于 pivot。
     * 4. 返回 pivot 的正确位置。
     */
    private static int partition(int[] arr, int left, int right) {
        // 选取最右边的为基准值
        int pivot = arr[right];
        // i 是比 pivot 小的边界
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // 把 pivot 放到正确的位置
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试代码
    public static void main(String[] args) {
        int[] nums = {6, 3, 8, 2, 9, 1};
        quickSort(nums, 0, nums.length - 1);
        // 输出 [1, 2, 3, 6, 8, 9]
        System.out.println(Arrays.toString(nums));
    }
}

