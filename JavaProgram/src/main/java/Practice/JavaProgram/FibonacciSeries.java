package Practice.JavaProgram;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a= 0;
		int b= 1;
		
		for(int i=1;i<=10;i++)
		{
			System.out.print(a + " ");
			int sum = a + b;
			a= b;
			b = sum;
		}

	}

}
