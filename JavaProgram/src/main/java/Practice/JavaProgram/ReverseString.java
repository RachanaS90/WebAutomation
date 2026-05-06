package Practice.JavaProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Java Interview Practice";
		
		String[] words = input.split(" ");
		
		//System.out.println(words[1]);
		
		StringBuilder output = new StringBuilder();
		
		for(String word : words)
		{
			output.append(new StringBuilder(word).reverse()).append(" ");
		}
		
		//System.out.println(output.toString().trim());
		
		
		String text = "Rachana";
		String result = new StringBuilder(text).reverse().toString();
	//	System.out.println(result);
		
		
		String name = "Rachana Sinha";
		String result1 = new StringBuffer(name).reverse().toString();
	//	System.out.println(result1);
		
		
		String name1 = "Rachana Sinha";
		char[] chars = name1.toCharArray();
		String reversed = "";
		for(int i = chars.length-1 ;i>=0; i--)
		{
			reversed = reversed+chars[i];
		}
		System.out.println("Original String: " + name1);
        System.out.println("Reversed String: " + reversed);
        
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : reversed.toCharArray())
        {
        	freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        
        
        System.out.println("Duplicate letter :");
        for(Entry<Character, Integer> entry : freqMap.entrySet())
        {
        	if(entry.getValue() >1 )
        	{
        		System.out.println(entry.getKey()+ " ");
        	}
        }
		
		
		
		
	}

}
