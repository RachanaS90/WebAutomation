package Practice.JavaProgram;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {10, 20, 30, 40};
		
		for(int i = arr.length - 1;i >= 0;i--)
		{
			System.out.print(arr[i] + " ");
		}
		
		int[] duparr = {10, 20, 10, 30, 40};
		
		for(int i = 0; i< duparr.length; i++)
		{
			for(int j= i+1;j<duparr.length;j++)
			{
			if(duparr[i]==duparr[j])
			{
				System.out.println("Duplicate Number is "+ duparr[i]);
			}
			}
		}
	}
	
	


}
