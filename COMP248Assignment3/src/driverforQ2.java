
public class driverforQ2 {

	public static void main(String[] args) {
		//4 house objects using 4 different constructors + greetings
		System.out.print("Welcome to our Class test!");
		House H1 = new House();
		House H2 = new House(100000.0);
		House H3 = new House(4, 100000.0);
		House H4 = new House(2, 200000.0, "detached");
		
		System.out.println("\nHouse H1: "+H1.toString());
		System.out.println("House H2: "+H2.toString());
		System.out.println("House H3: "+H3.toString());
		System.out.println("House H4: "+H4.toString());
		
		//testing out accessor methods
		System.out.println("\nAccessor Method: The housetype for house H4 is "+H4.getType()+","
				+ " its age is "+H4.getAge()+", and it costs $"+H4.getCost());
		
		//Calculating estimated price of houses given type and age 1 attached and 1 detached
		System.out.println("\nThe estimated price of house H3 is "+H3.estimatePrice(4, "attached"));
		System.out.println("The estimated price of house H4 is "+H4.estimatePrice(2, "detached"));

		//Testing out 5 mutators modifying the attributes of different house objects
		H3.setAge(5);
		System.out.println("\nMutator Method: The new age for house H3 is "+H3.getAge());
		
		H3.setType("semi-detached");
		System.out.println("Mutator Method: The new housetype for house H3 is "+H3.getType());
		
		H3.setCost(240000.0);
		System.out.println("Mutator Method: The new cost for house H3 is "+H3.getCost());
		
		H3.setAgeandCost(6, 245000.0);
		System.out.println("Mutator Method: The new house H3 age is "+H3.getAge()+" and its new cost is "+H3.getCost());
	
		H3.setAllThreeVariables(14, 260000.0, "semi-detached");
		System.out.println("Mutator Method: The new housetype for house H3 is "+H3.getType()+", "
				+ "and its new age is "+H3.getAge()+" \nand its cost is "+H3.getCost());
		
		//Testing out toString, equals, isLessThan and isGreaterthan for different house objects
		
		System.out.print("\n"+H3.toString());
		
		
		System.out.println("\n\nHouses H1 and H2 are equal is "+H1.equals(H2));
		System.out.println("Houses H1 and H4 are equal is "+H1.equals(H4));
		
		
		System.out.println("\nHouse H4 is less than H3 is "+H4.isLessThan(H3));
		
		System.out.println("\nHouse H1 is greater than H3 is "+H1.isGreaterThan(H3));
	
		System.out.print("\nEVERYTHING WORKS! Thanks for running this program and goodbye!");
	}
	

}
