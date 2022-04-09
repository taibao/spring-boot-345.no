package test.lesson2;

import java.util.Arrays;
import java.util.PriorityQueue;

//堆排序扩展
//已知一个几乎有序的数组，几乎有序是指，如果把数组排好序的化，每个元素移动
//的距离可以不超过k， 并且k相对于数组来说比较小， 请选择一个合适的排序算法
//对这个数组进行排序


public class sortArrayDistanceLessk {
    public static void main(String[] args){
        int[] arr = {5,4,73,2,3,1};
        sortArrayDistanceLessk(arr, 4);
        dd(arr);

//        System.out.println(res);
    }

    public static void sortArrayDistanceLessk(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index=0;
        for(;index<Math.min(k,arr.length);index++){
            heap.add(arr[index]);
        }
        int i=0;
        for(;index<arr.length;index++){
            heap.add(index);
            arr[i++] = heap.poll();
        }

        while(i<arr.length){
            arr[i++] = heap.poll();
        }
    }



//数组排序
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
