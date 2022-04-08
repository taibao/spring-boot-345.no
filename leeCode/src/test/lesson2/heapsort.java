package test.lesson2;

import java.util.Arrays;

public class heapsort {
    public static void main(String[] args){
        int[] arr = {1,3,4,2,5};
//        System.out.println(res);
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
