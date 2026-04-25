package Practice.JavaProgram;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {

	public static void main(String args[]) {
	
 Date d = new Date();
 System.out.println(d.toString());
 SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
 System.out.println(sdf.format(d));
 
 System.out.println(DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD);
 
 
 
 
 
	
	}

	
}
