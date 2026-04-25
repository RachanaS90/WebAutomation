package Practice.JavaProgram;

public class CountOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[] str = {'a','b','b','a','c','d','a','a','e','a'};
		
		int count = 0;
		
		for(char ch : str)
		{
			if(ch=='a')
			{
			count++;
			}
		
		}
		System.out.println("Count of a letter in given array is " + count);
		
		
	}

}
