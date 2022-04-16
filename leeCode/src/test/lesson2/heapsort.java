package test.lesson2;

import java.util.Arrays;

public class heapsort {
    public static void main(String[] args){
        int[] arr = {5,4,73,2,3,1};
        heapSort(arr);
        dd(arr);

//        System.out.println(res);
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }


    //插入节点创建大根堆
    public static void heapInsert(int[] arr, int index){
        //如果当前节点大于父节点，就往上调
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //调整堆序列
    public static void heapify(int[] arr,int index,int size){
        int left = index*2+1; //左孩子下标
        while(left<size){
            //与右兄弟节点比较
            int largest = left+1<size && arr[left+1]>arr[left]?left+1:left;
            //与父节点比较，返回大的
            largest  = arr[largest] > arr[index] ? largest:index;
            if(largest==index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;
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
