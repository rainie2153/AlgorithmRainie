package basic1;

import java.util.Arrays;


//1.Assumption 2.Approach and how u intend to solve the problem
//3.code comments if applicable
//4.big O run time complexity and justify ur ans
//5.identify any additional data structure u used and justify why u used them
//6.provide best ans
public class class1 {
	public static void main(String[] args) {
		class1 a = new class1();
		int[] array =  {9,8,3,5,6,-1};
		System.out.println(Arrays.toString(array));
		array = a.selectionSort(array);

		System.out.println(Arrays.toString(array));
	}
		
	
		
		//print array
//		int a[] = new int[10];
//		a[0] = 1;
//		a[9] = 100;
//		for (int i=0; i<a.length; i++) {
//			System.out.println(a[i]);
//		}
		//=============
		//ascending order｛8，4， －3， －1｝
	public int[] selectionSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		for (int i=0; i<array.length -1; i++) {
			for (int j=i+1; j<array.length; j++) {
				int min = i;
				if (array[j]<array[min]) {
					min = j;
				}
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
				
			}
		}
		return array;
	
	}
	
//	public void swap (int[] array, int left, int right) {
//		int temp = array[left];
//		array[left] = array[right];
//		array[right] = temp;
//	}
	
	
	
	
	
}