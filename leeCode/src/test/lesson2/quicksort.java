package test.lesson2;

import java.util.Arrays;

public class quicksort {
    public static void main(String[] args){
        int[] arr = {5,4,73,2,3,1,56};
        quickSort(arr);
        dd(arr);

//        System.out.println(res);
    }


    public static void quickSort(int[] arr){
        if(arr==null|| arr.length<2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    //快速排序递归，一次确定一位
    public static void quickSort(int[] arr,int l,int r){
        if(l<r){
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);
            //分区
            int[] pos = partition(arr,l,r);
            quickSort(arr,l,pos[0]-1);
            quickSort(arr,pos[1]+1,r);
        }
    }

    public static int[] partition(int[] arr,int l,int r){
        //划定左右分区
        int less = l-1;
        int more = r; //r位置元素要作为枢轴不能动它

        while(l<more){
            if(arr[l]<arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l]>arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //最后将枢轴与大于区左边界交换,使得枢轴到了正确的位置
        swap(arr,more,r);//more要退回一步，但下一步就要减一干脆不动
        return new int[]{less+1,more};
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
