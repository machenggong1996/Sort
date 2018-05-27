package com.mcg.sort;

import java.util.Arrays;

/*
 * 希尔排序也成为“缩小增量排序”，其基本原理是，现将待排序的数组元素分成多个子序列，使得每个子序列的元素个数相对较少，然后对各个子序列分别进行直接插入排序，
 * 待整个待排序列“基本有序”后，最后在对所有元素进行一次直接插入排序。因此，我们要采用跳跃分割的策略：将相距某个“增量”的记录组成一个子序列，这样才能保证在
 * 子序列内分别进行直接插入排序后得到的结果是基本有序而不是局部有序。希尔排序是对直接插入排序算法的优化和升级。 所谓的基本有序，就是小的关键字基本在前面，大
 * 的基本在后面，不大不小的基本在中间，例如｛2,1,3,6,4,7,5,8,9,｝就可以称为基本有序了。但像｛1,5,9,3,7,8,2,4,6｝这样，9在第三位，2在倒数第
 * 三位就谈不上基本有序。
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 2, 7, 9, 8, 3, 6 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr1 = { 1, 4, 2, 7, 9, 8, 3, 6 };
		sort1(arr1);
		System.out.println(Arrays.toString(arr1));
		swap(arr, 0, 2);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * 19 * 希尔排序 针对有序序列在插入时采用交换法 20 * @param arr 21
	 */

	public static void sort(int[] arr) {
		// 增量gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在组进行直接插入排序操作
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				while (j - gap >= 0 && arr[j] < arr[j - gap]) {
					// 插入排序采用交换法
					swap(arr, j, j - gap);
					j -= gap;
					System.out.println(j);
				}
			}
		}
	}

	/**
	 * 希尔排序 针对有序序列在插入时采用移动法。 39 * @param arr 40
	 */

	public static void sort1(int[] arr) {
		// 增量gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在组进行直接插入排序操作
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						// 移动法
						arr[j] = arr[j - gap];
						j -= gap;
					}
					arr[j] = temp;
				}
			}
		}
	}

	/**
	 * 60 * 交换数组元素 * @param arr * @param a * @param b
	 */

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}
}
