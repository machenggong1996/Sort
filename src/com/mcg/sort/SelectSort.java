package com.mcg.sort;

/**
 * 
 * @author lenovo 第一趟，从n 个记录中找出关键码最小的记录与第一个记录交换； 第二趟，从第二个记录开始的n-1
 *         个记录中再选出关键码最小的记录与第二个记录交换； 以此类推….. 第i 趟，则从第i 个记录开始的n-i+1
 *         个记录中选出关键码最小的记录与第i 个记录交换， 直到整个序列按关键码有序。
 */
public class SelectSort {
	public static void getSelectSort(int[] a) {
		if (a == null || a.length == 0) {// 判断数组是否为空
			System.out.println("该数组为空！");
			return;
		}
		int n = a.length;
		int temp;
		for (int i = 0; i < n - 1; i++) {// 每一趟都从i到n-1里找到一个最小的值，与i所在的值交换
			int min = i;// 记录最小的值的索引
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			if (min != i) {// 如果相等，就无需交换
				temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}

		}

	}

	public static void main(String[] args) {
		int[] a = { 3, 5, 1, 2, 6, 4, 7, 11, 23, 44, 3, 34, 8, 23, 6, 9 };
		getSelectSort(a);
		System.out.print("简单选择排序：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
