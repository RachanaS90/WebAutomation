package Practice.JavaProgram;

import java.util.ArrayList;

public class CollectionNew {
	
	public static void main(String args[])
	{
		
		int a[] = {4,5,5,5,4,6,6,9,4};
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			int count = 0;
			if(!list.contains(a[i]))
			{
				list.add(a[i]);
				count++;
				
				for(int j= i+1;j<a.length;j++)
				{
					if(a[i]==a[j])
					{
						count++;
					}
				}
				
				System.out.println(a[i] +" has count " + count);
				
				
				if(count == 1)
				{
					System.out.println(a[i] + "is unique number. ");
				}
			}
		}
	}

}
