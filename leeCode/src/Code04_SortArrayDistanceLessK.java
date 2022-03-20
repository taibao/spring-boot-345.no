import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {

    public void sortedArrDistanceLessK(int[] arr,int k){
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //优先级队列, 其实就是小根堆
        int index=0;
        for(;index<Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i=0;
        for(;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }


    public static void main(String[] args){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(8);
        heap.add(4);
        heap.add(4);
        heap.add(9);
        heap.add(10);

        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }


}

