package test;

public class heapsort {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,0};
        heapsort(arr);
        dd_arr(arr);
    }

    public static void heapsort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);//o(logN)
            swap(arr,0,--heapSize); //O(1)
        }
    }

     //某个数在index位置，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index *2 +1; //左孩子的下标
        while(left <heapSize){ //下方还有孩子的时候
            //两个孩子中，谁的值最大，把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left+1 :left;
            //父与较大的孩子，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index *2+1;
        }
    }

    //某个数现在处于index位置，往上移动
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void dd_arr(int[] arr){
        int len = arr.length;
        for(int i=0;i<len;i++){
            System.out.println(arr[i]);
        }
    }
}
