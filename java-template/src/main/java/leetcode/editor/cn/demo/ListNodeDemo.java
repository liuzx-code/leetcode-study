package leetcode.editor.cn.demo;

import leetcode.editor.common.ListNode;

public class ListNodeDemo {
    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        createLinkedList(nums);
    }

    public static ListNode createLinkedList(int[] arr) throws InterruptedException {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            System.out.println("i:" + i + " cur:" + cur);
            System.out.println("arr[" + i + "]:" + arr[i]);
            cur.next = new ListNode(arr[i]);
            System.out.println("cur.next:" + cur.next);
            // 表示当前的下一个节点指向新的节点
            // 因为next的数据类型也是ListNode
            cur = cur.next;
            System.out.println("cur:" + cur);
            Thread.sleep(100000);
        }
        return head;
    }

}
