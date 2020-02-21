package Golden;

public class HeapSort {
	int heap[]; 
	int size; 
	int maxSize;
	
	public HeapSort(int n){
		heap = new int[n + 1];
		this.size = 0;
		this.maxSize = n + 1;
	}
	
	public void heapSort(int a[]){
		//buildHeap(a);
		buildHeapFast(a);
		
		int size = this.size;
		for(int i= 0 ; i < size ; i++){
			a[i] = extractMin();
		}
	}
	
	private void buildHeapFast(int a[]){
		for(int n : a){
			heap[++size] = n; 
		}
		
		/*
		 * Must go in reverse to build heap
		 * */
		for(int i = size/2 ; i >= 1 ; i--){
			heapifyDown(i);
		}
	}
	
	private int extractMin(){
		// Remove element from root 
		int min = heap[1];
		
		// Move element from last position to root 
		heap[1] = heap[size];
		
		// Reduce size of heap
		size--;
		
		// Heapify down 
		heapifyDown(1);
		
		return min;
	}
	
	private void heapifyDown(int index){
		while( (leftChild(index) != -1 && heap[index] > heap[leftChild(index)]) ||(  rightChild(index) != -1 && (heap[index] > heap[rightChild(index)]))){
			int swap = -1;
			if( (2 * index + 1) <= size  && heap[2 * index + 1] < heap[2*index]){
				// If right child exist or if it is smaller
				swap = 2 * index + 1;
			}else{
				swap = 2 * index;
			}
			
			int temp = heap[swap];
			heap[swap] = heap[index];
			heap[index] = temp;
			
			index = swap;
		}
	}
	
	private int leftChild(int index){
		if(index * 2 > size){
			return -1;
		}
		
		return index * 2;
	}
	private int rightChild(int index){
		if(index* 2 + 1 > size){
			return -1;
		}
		
		return index* 2 + 1;
	}
	
	public static void main(String[] args) {
		 int a[] = {3,4,1,6,5,2};
		//int a[] = {6,5,4,3,2,1,0};
		//int a[] = {-5,-4,-3,3,3,2,4,-1,0,6,5,4,3,2,1,0};
		new HeapSort(a.length).heapSort(a);
		
		for (int i : a) {
			System.out.println(i);
		}
	}
}
