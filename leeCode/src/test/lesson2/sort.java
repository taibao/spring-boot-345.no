package test.lesson2;

import java.util.Arrays;

public class sort {
    public static void main(String[] args){
        int[] arr = {3,2,6,5,1,8,12,34,15};
        mergeSort(arr);
        dd(arr);
    }

    //归并排序
    public static void mergeSort(int[] arr){
        if(arr==null || arr.length==1){
            return;
        }
        mergeSort(arr,0, arr.length-1);
    }

    //递归排序
    public static void mergeSort(int[] arr, int l,int r){
        if(l==r){
            return;
        }
        int mid = l+((r-l)>>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r); //归并操作把小的一边放左边，大的一边放右边
    }

    public static void merge(int arr[], int l,int mid, int r){
        int[] help = new int[r-l+1]; //辅助数组正好放下左右排序数组
        //定义两个指针指向左右数组
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;

        //合并到辅助数组中
        while(p1<=mid && p2<=r){
            help[i++] = (arr[p1]<arr[p2])?arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[i++] = arr[p1++];
        }
        while(p2<=r){
            help[i++] = arr[p2++];
        }

        for(int j=0;j<help.length;j++){
            arr[l+j] = help[j];
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
