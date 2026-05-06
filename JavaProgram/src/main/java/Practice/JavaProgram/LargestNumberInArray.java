package Practice.JavaProgram;

import java.util.Arrays;

public class LargestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {100,20,8,200,80};
		
		int max = arr[0];
		
		for(int num : arr)
		{
			if(max < num)
			{
				max = num;
			}
			
		}
		System.out.println("Maximum number is " + max);
		
		
		int maxnumber = Arrays.stream(arr).max().getAsInt();
		System.out.println(maxnumber + " is largest number");
	}

}
