package test;

import java.util.PriorityQueue;

public class dui {
    public static void main(String[] args){
        //自带堆排序
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);
        heap.add(3);

        dd_dui(heap);
    }


    private static void dd_dui(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
