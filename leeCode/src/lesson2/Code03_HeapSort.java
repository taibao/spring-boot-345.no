package lesson2;

import java.util.Arrays;

public class Code03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//构建大根堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		//从小到大排序序列化，将每个节点放到正确的位置
		int size = arr.length;
		swap(arr, 0, --size); //直接将最大值，排在最后面
		while (size > 0) {
			heapify(arr, 0, size);//每序列化一次就得到一个大根
			swap(arr, 0, --size);
		}
	}

	//插入堆
	public static void heapInsert(int[] arr, int index) {
		//如果当前节点大于父节点，就往上调
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) /2);
			index = (index - 1)/2 ;
		}
	}

	//堆化
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;
		//left是从小到大的过程， 从根到叶子的过程
		while (left < size) {
			//判断是否有右兄弟， 有的话返回两个最大的
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//与父节点比较， 返回大的
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index); //交换成大根堆
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
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

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
