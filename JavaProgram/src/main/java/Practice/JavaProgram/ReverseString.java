package Practice.JavaProgram;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "Java Interview Practice";
		
		String[] words = input.split(" ");
		
		System.out.println(words[1]);
		
		StringBuilder output = new StringBuilder();
		
		for(String word : words)
		{
			output.append(new StringBuilder(word).reverse()).append(" ");
		}
		
		System.out.println(output.toString().trim());
		
		
		String text = "Rachana";
		String result = new StringBuilder(text).reverse().toString();
		System.out.println(result);
		
		
		
		
		
	}

}
