package com.sumeeth.googleinterview.puzzle;

public class TwoIntegerSum {

    public static void main(String[] args) {
//        ListNode L1 = new ListNode();
//        L1.val=2;
//        ListNode L12 = new ListNode();
//        L12.val=4;
//        ListNode L13 = new ListNode();
//        L13.val=3;
//        L1.next=L12;
//        L12.next=L13;
//
//
//        ListNode L2 = new ListNode();
//        L2.val=5;
//        ListNode L22 = new ListNode();
//        L22.val=6;
//        ListNode L23 = new ListNode();
//        L23.val=4;
//        L2.next=L22;
//        L22.next=L23;

//        printList(addTwoNumbers(L1, L2));
//        printList(getLinkedList( new int[]{9,9,9,9,9,9,9}));
        printList(addTwoNumbers( arrayToLinkedList( new int[]{9, 9, 9,9}) , arrayToLinkedList( new int[]{9,9,9,9,9,9,9})));
    }

    private static ListNode arrayToLinkedList(int [] arr){
        ListNode L2 = new ListNode();
        ListNode Head = L2;
        ListNode prev = null;
        if(arr.length == 1){
            L2.val=arr[0];
            return L2;
        }else {
            for (int i : arr) {
                L2.val = i;
                ListNode tmp = new ListNode();
                L2.next = tmp;
                prev = L2;
                L2 = tmp;
            }
            L2 = prev;
            L2.next = null;
        } return Head;
    }

    public static void printList(ListNode L){
        System.out.println();
        while (L !=null){
            System.out.print(L.val+", ");
            L = L.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int index = 0;
        int sum = 0;
        int carryForward = 0;
        ListNode res = new ListNode();
        ListNode head = res;
        ListNode previous = null;

        while (l1 != null || l2 != null) {

            if (l1 == null && l2 != null) {
                sum = l2.val + carryForward;
                carryForward=0;
            } else if (l2 == null && l1 != null) {
                sum = l1.val + carryForward;
                carryForward=0;
            } else {
                sum = l1.val + l2.val + carryForward;
                carryForward=0;
            }

            if (sum >= 10) {
                carryForward = sum / 10;
                sum = sum - 10;
            }
            res.val = sum;
            ListNode tmp = new ListNode();
            res.next = tmp;
            previous = res;
            res = res.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;


        }
        if(carryForward>0){
            res.val=carryForward;
        }else {
            res = previous;
            res.next = null;
        }
        return head;

    }
}
