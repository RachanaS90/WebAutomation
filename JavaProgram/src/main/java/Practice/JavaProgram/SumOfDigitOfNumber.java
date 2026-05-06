package Practice.JavaProgram;

public class SumOfDigitOfNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          
		int number = 6758;
		
		int sum = 0;
		
		while(number > 0)
		{
			int digit = number % 10 ;
			sum = sum+ digit;
			number = number /10;

		}
         System.out.println(sum);	
         
         
         String number1 ="12345";
         
         int addition = 0;
         
         for(char c : number1.toCharArray())
         {
        	 addition = addition + Character.getNumericValue(c);
         }
	    System.out.println(addition);	
	}

}
