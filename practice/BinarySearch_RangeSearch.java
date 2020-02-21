package Golden;

public class BinarySearch_RangeSearch{
	public static int binSearch(int a[], int start, int end, int val){
		if(start > end){
			return -1;
		}
		
		int mid = (start + end)/2;
		
		if(a[mid] == val){
			return mid;
		}
		
		if(a[mid] > val){
			return binSearch(a,start,mid-1,val);
		}else{
			return binSearch(a,mid+1,end,val);
		}
	}
	
	public static int rangeBinary(int a[], int start, int end, int val, int lastSeen, boolean leftRange){
		if(start > end){
			return lastSeen;
		}
	
		int mid = (start+end)/2;
		
		if(a[mid] == val){
			lastSeen = mid;
		}
		
		if(a[mid] > val || (leftRange && a[mid] == val)){
			return rangeBinary(a,start,mid-1,val,lastSeen, leftRange);
		}else{
			return rangeBinary(a,mid+1,end,val,lastSeen, leftRange);
		}
	}
	
	public static void main(String[] args) {
		 int a[] = new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
		 //System.out.println(binSearch(a,0,a.length-1,-5));
		 
		 int b[] = new int[]{1};
		 System.out.println(rangeBinary(b,0,b.length-1,1 /*val*/,-1,false));
	}

}