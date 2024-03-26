package ds.searching;

public class BookAllocation {

	public static void main(String[] args) {
		int arr[] = { 12, 34, 67, 90 }; // Number of pages in books

	  int m = 2; // No. of students
	
	  System.out.println("Minimum number of pages = "
	                     + findPages(arr, arr.length, m));

	}
	
	static int findPages(int[] a, int n, int m) {
		int min=0, max=0;				//min and max no. of pages that can be allotted to a student
		for(int i=0; i<n; i++) {
			if(a[i]>min)				//min= max pages in any book if each student is given 1 book
				min = a[i];
			max+= a[i];					//max= sum of all pages if all will be allotted to 1 student
		}
		
		int mid, result=0;
		while(min<=max) {
			mid = min+(max-min)/2;
			
			if(ifPossibleToAllot(a, mid, m)) {			//if possible to allot books with max pages=mid
				result = mid;					//store this mid as this is the possible min we have so far
				
				max = mid-1;					//try to minimize
			}else {
				min = mid+1;					//if not possible, then increase the max pages i.e. go to right half
			}
		}
		return result;
	}
	
	static boolean ifPossibleToAllot(int[] books, int maxPages, int students) {
		int curr_sum=0;
		int reqStudents=1;
		for(int i=0; i<books.length; i++) {
			curr_sum+=books[i];					//get the total pages to be allotted
			if(curr_sum>maxPages) {				//if total pages>maxPages
				reqStudents++;					//then we need to allot this book i to next student so reqStudents++
			
				curr_sum = books[i];			//since this book is allotted to new student, start calculating total pages that can be allotted to this new student
			}
		}
		
		return reqStudents<=students;			//if reqStudents>students, that means allocation is not possible and we need to increase max pages
	}

}
