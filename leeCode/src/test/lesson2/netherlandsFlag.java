package test.lesson2;

import java.util.Arrays;

//荷兰国旗问题
//第一题
//给定一个数组arr，和一个数num， 请把小于等于num的数放在数组的左边，大于num的
//数放在数组的右边。要求额外空间复杂度0（1）， 时间复杂度O（N）
//第二题
//小于num的数放数组左边，等于放中间，大于放右边。要求额外空间复杂度o(1), 时间复杂度O(N)


public class netherlandsFlag {
    public static void main(String[] args){
        int[] arr = {5,4,8,2,3,1,5};
        netherlandsFlag(arr,5);
        dd(arr);

//        System.out.println(res);
    }

public static void netherlandsFlag(int[] arr,int num){
        partition(arr,0,arr.length-1,num);
}

public static int[] partition(int[] arr,int l,int r,int num){
        int less = l-1;
        int more = r+1;
        while(l<more){
            if(arr[l]<num){
                swap(arr,++less,l++);
            }else if(arr[l]>num){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        return new int[]{less+1,more-1};
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
