package test.lesson4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ReverseList {

    //单链表
    public static class Node{
        public int value;
        public Node next;
        public Node(int val){
            value = val;
        }
    }

    //双链表
    public static class DoubleNode{
        public int value;
        public DoubleNode pre;
        public DoubleNode next;
        public DoubleNode(int val){
            this.value=val;
        }
    }


    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printDan(head1);

        //创建双链表实例, 创建的时候要同时把前去后继都给关联上
        //定义第一个双链表节点， 没有前驱只有后继
        DoubleNode head2 = new DoubleNode(1);
        //定义第二个双链表节点
        head2.next = new DoubleNode(2);
        head2.next.pre = head2;
        //定义第三个
        head2.next.next = new DoubleNode(3);
        head2.next.next.pre = head2.next;
        //定义第四个节点
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.pre = head2.next.next;

        printDouble(head2.next);


//        head1 = reverseList(head1);
    }

    //打印单链表,只要一个表头
    public static void printDan(Node head){
        if(head==null){
            System.out.println("这是一个空链表");
        }
        System.out.println("开始打印链表");
        while(head!=null){
            System.out.println(head.value);
            head =  head.next;
        }
    }

    //打印双链表
    public static void printDouble(DoubleNode head){
        System.out.println("打印双链表");
        DoubleNode end = null;
        while(head != null){
            System.out.println(head.value+" ");
            end = head;
            head = head.next;
        }
        while(end!=null){
            System.out.println(end.value+" ");
            end = end.pre;
        }
    }

    public static void printLinkedList(Node head){
        System.out.println("Link List");
        while(head!=null){
            System.out.println(head.value+" ");
            head=head.next;
        }
        System.out.println();
    }



public static class NodeComparator implements Comparator<Node>{
     //重载已有方法
       @Override
    public int compare(Node o1, Node o2){
           return o1.value-o2.value;
       }
}

public static void comparator(int[] arr){
        Arrays.sort(arr);
}


 public static void swap(int[] arr, int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
 }


    //数组生成器
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int)((maxSize))];
        for(int i=0;i<arr.length;i++){
//            arr[i] = (int)((maxValue + 1)*Math.random()) - (int) (maxValue * Math.random());
            arr[i] = (int)((maxValue + 1)*Math.random());
        }
        return arr;
    }

  public static int[] copyArr(int[] arr){
       if(arr == null){
           return null;
       }
       int[] res = new int[arr.length];
       for(int i=0;i<arr.length;i++){
           res[i] = arr[i];
       }
       return res;
  }

  public static boolean isEqual(int[] arr1,int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if(arr1.length != arr2.length){
            return false;
        }
        for (int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
  }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void dd(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //最简单递归求阶乘，可知递归要素1.结果 2.下一级条件，不可缺少
    public static int digui(int sum,int i){
        return i>1?digui(sum*i,i-1):sum; //条件要递减最后要返回
    }




}
