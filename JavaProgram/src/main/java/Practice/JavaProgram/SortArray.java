package Practice.JavaProgram;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,9,7,2,10};
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
		
		int[] arr1 = {10,5,8,1,20};
		
		Arrays.sort(arr1);
		
		System.out.println("Asencding arrays :" + Arrays.toString(arr1));
		
		Integer[] arr2 = {23,8,1,9,20}; 
		
		Arrays.sort(arr2, Collections.reverseOrder());
		
		System.out.println("Descending arrays :" + Arrays.toString(arr2));
		
	}

}
