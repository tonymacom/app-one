package com.tony.unit;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2020/4/3
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class Test {


    public ListNode mergeKLists(ListNode[] lists) {







        return null;
    }


    public ListNode mergeTwoLists(ListNode node1,ListNode node2, int length) {

        while (node1.next != null) {




            node1 = node1.next;
        }

        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;


        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;


        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;


        ListNode node = mergeKLists(new ListNode[]{node1, node4, node7});

        while (node.next != null) {
            System.out.print(node.val+"->");
            node = node.next;
        }

    }

}

