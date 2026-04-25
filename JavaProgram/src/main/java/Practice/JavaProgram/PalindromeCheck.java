package Practice.JavaProgram;

public class PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Radar";
		
		String reversedStr = new StringBuilder(str).reverse().toString();
		System.out.println(reversedStr);
		
		if(str.equals(reversedStr))
		{
			System.out.println(str + " is palindrome. ");
		}
		else {
			System.out.println(str + " is not a palindrome. ");
		}

	}

}
