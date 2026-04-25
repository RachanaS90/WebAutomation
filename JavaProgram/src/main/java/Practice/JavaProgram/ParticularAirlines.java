package Practice.JavaProgram;

public class ParticularAirlines implements AirtrafficGuidelines  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParticularAirlines pa = new ParticularAirlines();

		pa.bodycolor();
		pa.genericRule();
		pa.heightRule();
	}

	public void genericRule() {
		System.out.println("Generic rules are addded");
		
	}

	public void bodycolor() {
		System.out.println("Airline will have white and red colors");
		
	}

	public void heightRule() {
		System.out.println("Height rules are addded");
		
	}
	
	

}
