package Practice.JavaProgram;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "india";
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for(char c : str.toCharArray())
		{
			map.put(c,map.getOrDefault(c,0)+1);
		}
		
		for( Entry<Character, Integer> entry : map.entrySet())
		{
			if(entry.getValue()==1)
			{
				System.out.println("First non-repeatative value is " + entry.getKey());
				break;
			}
		}
	}
}
