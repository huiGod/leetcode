package com.huigod.链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 好理解的双指针
 * 定义两个指针： prepre 和 curcur ；prepre 在前 curcur 在后。
 * 每次让 prepre 的 nextnext 指向 curcur ，实现一次局部反转
 * 局部反转完成之后，prepre 和 curcur 同时往前移动一个位置
 * 循环上述过程，直至 prepre 到达链表尾部
 *
 */
public class _206_反转链表 {

  /**
   * 非递归的方法
   */
  public ListNode reverseList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = null;

    while (head != null) {

      ListNode next = head.next;

      head.next = newHead;

      newHead = head;

      head = next;

    }

    return newHead;

  }

  /**
   * 递归的方式
   *
   * 递归的方式比较抽象，需要先明白方法所实现的功能，然后再考虑细节问题
   */
  public ListNode reverseList2(ListNode head) {

    //反转后这里的 newHead 指向的是链表的第一个节点
    ListNode newHead = reverseList2(head.next);

    head.next.next = head;

    head.next = null;

    return newHead;

  }

  /**
   * 在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用
   */
  public ListNode reverseList3(ListNode head) {

    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;

  }

  /**
   * 反转值
   */
  public ListNode reverseList4(ListNode head) {
    ListNode ans = null;
    for (ListNode x = head; x != null; x = x.next) {
      ans = new ListNode(x.val, ans);
    }
    return ans;
  }

}
