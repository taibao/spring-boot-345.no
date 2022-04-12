package test.lesson4;

import java.util.*;

public class hashAndTree {


    //非基础类型， 按引用传递
    public static class Node{
        public int value;
        public Node next;
        public Node(int val){
            value = val;
        }
    }



    public static void main(String[] args){
        Node nodeA = null;
        Node nodeB = null;
        Node nodeC = null;

        //只有key时用hashSet
//        HashSet<Integer> hashSet1 = new HashSet<>();
//        hashSet1.add(3);
//        System.out.println(hashSet1.contains(3));
//        hashSet1.remove(3);
//        System.out.println(hashSet1.contains(3));

        //保存key=>value结构
//        HashMap<Integer,String> mapTest = new HashMap<>();
//        mapTest.put(1,"zuo");
//        System.out.println(mapTest.get(1));
//        mapTest.put(1,"cheng");
//        System.out.println(mapTest.get(1));
//        mapTest.put(2,"2");

        //增删改查时间都是常数级别的
//        System.out.println(mapTest.containsKey(1));
//        System.out.println(mapTest.get(4));

        //展示有序表常用操作，有序表key按顺序组织，key一定要能排序
        //有序表的增删改查都是O(logN)级别的
//        TreeMap<Integer,String> treeMap1 = new TreeMap<>();
//        treeMap1.put(7,"我是7");
//        treeMap1.put(5,"我是5");
//        treeMap1.put(4,"我是4");
//        treeMap1.put(3,"我是3");
//        treeMap1.put(9,"我是9");
//        treeMap1.put(2,"我是2");
//        treeMap1.put(1,"我是1");
//        System.out.println(treeMap1.containsKey(5));
//        System.out.println(treeMap1.get(5));
//        System.out.println(treeMap1.firstKey()+",我最小");
//        System.out.println(treeMap1.lastKey()+",我最大");
//        System.out.println(treeMap1.floorKey(8)+",在表中所有<=8的数，我离8最近");
//        System.out.println(treeMap1.ceilingKey(8)+",在表中所有>=8的数中，我离8最近");
//        System.out.println(treeMap1.floorKey(7)+",在表中所有<=7的数中，我离7最近");
//        System.out.println(treeMap1.ceilingKey(7)+",在表中所有>=7的数中，我离7最近");
//        treeMap1.remove(5);
//        System.out.println(treeMap1.get(5)+",删了就没有了");
//        System.out.println("=============================");

//使用有序表必须提供比较器
        TreeSet<Node> treeSet = new TreeSet(new NodeComparator()); //红黑树
        nodeA = new Node(5);
        nodeB = new Node(3);
        nodeC = new Node(7);
        try{
            treeSet.add(nodeA);
            treeSet.add(nodeB);
            treeSet.add(nodeC);
            System.out.println("添加节点");
        }catch(Exception e){
            System.out.println("抛出异常"+e.getMessage());
        }
        System.out.println("=============================");

    }



public static class NodeComparator implements Comparator<Node>{
     //重载已有方法
       @Override
    public int compare(Node o1, Node o2){
           return o1.value-o2.value;
       }
}

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
