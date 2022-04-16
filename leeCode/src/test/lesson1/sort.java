package test.lesson1;

import java.util.Arrays;

public class sort {
    public static void main(String[] args){
//       int[] arr = generateRandomArray(5,10);
//       dd(arr);
    //   int sum = digui(4,3); //递归求阶乘
     //   System.out.println(sum);

//        selectionSort(arr);
//        dd(arr);

//        comparator(arr);
//        bubbleSort(arr);
//        insertSort(arr);
//        arr = new int[]{1,2,3,4,5};
//        int offset = bsfind(arr,5);
//        int offset = nearestIndex(arr,90);
//        System.out.println(offset);
//        dd(arr);

        //使用异或互换值
//        int a = 5;
//        int b = 7;
//        a = a^b;
//        b = a^b;
//        a = a^b;
//
//        System.out.println(a);
//        System.out.println(b);

        //输出奇数次出现的数
//        int[] arr1 = {3,3,2,3,1,1,1,3,1,1,1};
//        printOddTimesNum1(arr1);

//        int e0 = 38;
//        System.out.println(e0 & (~e0 +1));

//        int e1 = 12;
//        int e2 = 6;
//        System.out.println(e1&e2);

//        int[] arr1 = {3,3,2,3,1,1,1,3,4,1,1,1};
//        printOddTimesNum2(arr1);

//        int[] arr = {1,2,13,5,6};
//        int max = process(arr,0,arr.length-1);
//        System.out.println(max);

        //求局部最小值
        int[] arr = { 6, 5, 3, 4, 6, 7, 8 };
        int index = getLessIndex(arr);
        System.out.println(index+"，值为"+arr[index]);
    }

    //获取局部最小值
    public static int getLessIndex(int[] arr){
        int len = arr.length;
        if(arr == null || len==0)
        {
            return -1;
        }
        if(len==1 || arr[0]<arr[1]){
            return 0;
        }
        if( arr[len-1]<arr[len-2]){
            return len-1;
        }
        int l = 1;
        int r = len-2;
        int mid = 0;
        while(l<r){
            mid = (l+r)/2;
            if(arr[mid]>arr[mid-1]){
                r = mid -1;
            }else if(arr[mid]>arr[mid+1]){
                l = mid +1;
            }else{
                return mid;
            }
        }
        return l;
    }

    //获取最大值递归版
    public static int process(int[] arr,int L,int R){
        if(L==R){
            return arr[L];
        }
        int mid = L+((R-L)>>1);
        int left =  process(arr,L,mid);
        int right = process(arr,mid+1,R);
        return Math.max(left,right);
    }


    //寻找一个数组中出现奇数次数的数 （有两个数a，b出现奇数次）
    public static void printOddTimesNum2(int[] arr){
        int e0 =0 , eOhasOne=0;
        //求a&b, a,b进制位里至少有一位是1，一位是0
        for(int curNum : arr){
            e0 ^= curNum; //e0=a^b
        }
        //取e0最右边非0的值
        int rightOne = e0 & (~e0+1); //找到a^b中最右的非0数
        for(int cur:arr){
            //只与该位也为1的数异或, 从而得到该位为1的奇数值
            if((cur&rightOne)!=0){
                eOhasOne ^= cur;
            }
        }
        System.out.println("两个奇数值分别为："+eOhasOne + "和"+ (e0^eOhasOne));
    }


    //统计奇数次 只有一个数出现奇数次
    public static void printOddTimesNum1(int[] arr){
        int e0 = 0;
        for(int cur : arr){
            e0 ^= cur; //偶数次出现的数，因为成双出现而抵消
        }
        System.out.println(e0);
    }

    //查找最左位置
    public static int nearestIndex(int[] arr, int value){
        int L =0;
        int R=arr.length-1;
        int index=-1;
        while(L<=R){
            int mid = (L+R)/2;
            if(arr[mid] >= value){
                index=mid;
                R = mid -1;
            }else{
                L=mid+1;
            }
        }
        return index;
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
