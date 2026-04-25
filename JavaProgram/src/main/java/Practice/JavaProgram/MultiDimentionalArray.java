package Practice.JavaProgram;

public class MultiDimentionalArray {
	
	public static void main(String args[])
	{
		int a[][] = {{2,4,5},{3,4,7}};

		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}

