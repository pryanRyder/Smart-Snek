package CompareData;

public class CompareIntArray {

	//Tests to see if two 1D int arrays are the same.
	public static boolean compareIntArray(int[] arr1, int[] arr2) {
		
		if(arr1.length != arr2.length) {
			
			return false;
		}
		
		int i=0;
		for(i=0; i < arr1.length; i++) {
			
			if(arr1[i] != arr2[i]) {
				
				return false;
			}
		}
		
		return true;
	}
	
}
