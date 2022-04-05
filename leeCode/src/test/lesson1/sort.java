package test.lesson1;

import java.util.Arrays;

public class sort {
    public static void main(String[] args){
       int[] arr = generateRandomArray(5,10);
//       dd(arr);
    //   int sum = digui(4,3); //递归求阶乘
     //   System.out.println(sum);

//        selectionSort(arr);
//        dd(arr);

//        comparator(arr);
//        bubbleSort(arr);
//        insertSort(arr);
        arr = new int[]{1,2,3,4,5};
        int offset = bsfind(arr,5);
        System.out.println(offset);
//        dd(arr);
    }

    //二分查找
    public static int bsfind(int[] arr, int x){
        if(arr==null || arr.length==0){
            return -1;
        }
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int mid = ((r+l)>>1);
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] > x){
                r = mid -1;
            }else{
                l = mid +1 ;
            }
        }
        if(arr[l]==x){
            return l;
        }
        return -1;
    }



    //插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }


    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    //选择排序
 public static void selectionSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        int len = arr.length;
        for(int i=0;i<len-1;i++ ){
            for(int j=i+1;j<len;j++){
                if(arr[i]>arr[j]){
                    swap(arr,i,j);
                }
            }
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
