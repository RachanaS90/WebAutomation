package Practice.JavaProgram;

public class Pyramid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 1;
		for(int i=4;i>=1;i--)
		{
			for(int j=4;j>=i;j--)
			{
				System.out.print(k+" ");
				k++;
			}
			System.out.println(" ");
		}
	}

}
