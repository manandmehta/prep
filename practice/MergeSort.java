package Golden;

public class MergeSort {
	private void mergeSort(int a[]){
		if(a == null || a.length <= 1){return;}
		int aux[] = new int[a.length];
		mergeSort(a,aux,0,a.length-1);
	}
	private void mergeSort(int a[], int aux[], int start, int end){
		if(start >= end){return;}
		int mid = (start + end)/2;
		mergeSort(a,aux,start,mid);
		mergeSort(a,aux,mid+1,end);
		merge(a,aux,start,mid,end);
	}

	private void merge(int[] a, int[] aux, int start, int mid, int end) {
		for(int i = start; i <= end; i++){aux[i] = a[i];}
		
		int i_s = start, index = start, i_e = mid+1;
		while(i_s <= mid || i_e <= end){
			if(i_s > mid){a[index++] = aux[i_e++];}
			else if(i_e > end){a[index++] = aux[i_s++];}
			else{
				if(aux[i_s] <= a[i_e]){
					a[index++] = aux[i_s++];
				}else{
					a[index++] = aux[i_e++];
				}
			}
		}
	}
	public static void main(String[] args) {
		MergeSort s = new MergeSort();
		int a[] = new int[]{5,6,5,9,1,7,2,4,7,0,4,5,3,5,5,6,7,6,7,6,7,6,8,11,10};
		s.mergeSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
