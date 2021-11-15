package com.huigod.链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 原理就是将一个节点插入一个链表中
 * 这里只是另外一个新的链表，从头开始插入
 *
 */
public class _206_反转链表 {

  /**
   * 非递归的方法
   * @param head
   * @return
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
   * @param head
   * @return
   */
  public ListNode reverseList2(ListNode head) {

    //反转后这里的 newHead 指向的是链表的第一个节点
    ListNode newHead = reverseList2(head.next);

    head.next.next = head;

    head.next = null;

    return newHead;

  }

}
