package test.lesson3;

import java.util.Arrays;

//桶排序算法： 基数排序

public class radixsort {
    public static void main(String[] args){
        int[] arr = {5,4,6,2,3,1,1001};

        radixSort(arr,0,arr.length-1,maxbits(arr));
        dd(arr);

//        System.out.println(res);
    }

    //求数组中最大数的位数
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(arr[i],max);
        }
        int bit = 0;
        while(max>0){
            max /= 10;
            bit++;
        }
        return bit;
    }


//基数排序
public static void radixSort(int[] arr, int l,int r,int digit){
    final int radix=10;
    int[] bucket = new int[r-l+1];
    for(int d=1;d<=digit;d++){
        int[] count = new int[radix];
        //统计词频
        for (int i=l;i<=r;i++){
            int j = getDigit(arr[i],d);
            count[j]++;
        }
        //将词频转为前缀和
        for(int i=1;i<radix;i++){
            count[i] = count[i]+count[i-1];
        }
        //从右往左把数据倒到桶里
        for (int i=r;i>=l;i--){
            int j = getDigit(arr[i],d);
            bucket[--count[j]] = arr[i];
        }

        //把bucket里面的数据倒回arr
        for (int i=l, j=0;i<=r;i++,j++){
            arr[i] = bucket[j];
        }
    }

}





//求d位上的值
    public static int getDigit(int x, int d){
        return (x/(int)Math.pow(10,d-1))%10;
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
