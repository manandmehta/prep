package Golden;

import java.util.Random;

public class QuickSort_Golden {
//	private static void quickSort(int a[],int start, int end){
//		if(start >= end){
//			return;
//		}
//		
//		int pindex = partition(a, start, end);
//		
//		quickSort(a, start, pindex-1);
//		quickSort(a, pindex+1, end);
//	}
//
//	private static int partition(int a[], int start, int end){
//	
//		int pindex = start;
//		int pivot = a[end];
//
//		for(int i = start; i < end-1 ; i ++){
//			if(a[i] <= pivot){
//				int temp = a[i];
//				a[i] = a[pindex];
//				a[pindex] = temp;
//				pindex ++;
//			}
//		}
//		
//		// Forgot this
//		int temp = a[pindex];
//		a[pindex] = a[end];
//		a[end] = temp;
//		
//		return pindex;
//	} 
	private void quickSort(int a[]){
		if(a == null || a.length <= 1){return;}
		quickSort(a,0,a.length-1);
	}
	
	private void quickSort(int a[], int start, int end){
		if(start >= end){return;}
		int [] boundary = partition(a,start,end);
		quickSort(a,start,boundary[0]);
		quickSort(a,boundary[1],end);
	}
	
	private int[] partition(int a[], int start, int end){
		int random = new Random().nextInt(end);
		int pivot = a[random];
		int i = start, lo = start, hi = end; 
		while(i <= hi){
			if(a[i] == pivot){
				i++;
			}else if(a[i] < pivot){
				swap(a,i,lo);
				lo++;
				i++;
			}else{
				swap(a,i,hi);
				hi--;
			}
		}
		return new int[]{lo-1,i};
	}
	
	private void swap(int a[], int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort_Golden s = new QuickSort_Golden();
		int a[] = new int[]{5,6,5,9,1,7,2,4,7,0,4,5,3,5,5,6,7,6,7,6,7,6,8,11,10};
		s.quickSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
	
	
}
