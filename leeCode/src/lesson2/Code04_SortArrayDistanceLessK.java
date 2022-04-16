package lesson2;

import java.util.PriorityQueue;

public class Code04_SortArrayDistanceLessK {
//堆排序扩展
	//已知一个几乎有序的数组，几乎有序是指，如果把数组排好序的话，每个元素移动
	//的距离可以不超过k， 并且k相对于数组来说比较小， 请选择一个合适的排序算法
	//对这个数组进行排序

	public void sortedArrDistanceLessK(int[] arr, int k) {
		//优先级队列本质上是个小根堆
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int index = 0;
		for (; index < Math.min(arr.length, k); index++) {
			heap.add(arr[index]);
		}
		int i = 0;
		//第二次循环arr.length-k的长度
		for (; index < arr.length; i++, index++) {
			heap.add(arr[index]);//这样将全部元素入小根堆
			arr[i] = heap.poll(); //返回返回第一个元素，并在堆中将其删除
		}
		while (!heap.isEmpty()) {
			arr[i++] = heap.poll();
		}
	}
}
