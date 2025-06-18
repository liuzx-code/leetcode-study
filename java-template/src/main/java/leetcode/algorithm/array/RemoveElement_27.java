package leetcode.algorithm.array;


/**
 * @author liuzx
 * @date 2025/6/18 9:39
 * @Description: 27.移除元素
 */
public class RemoveElement_27 {

    /**
     * 拷贝覆盖数组
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }

}
