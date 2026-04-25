package Practice.JavaProgram;

public class LargestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10,20,5,45,90};
		
		int max = arr[0];
		
		for(int num : arr)
		{
			if(num > max)
			{
				max =num;
			}
		}
		System.out.println("Max number is "+ max);
	}

}
