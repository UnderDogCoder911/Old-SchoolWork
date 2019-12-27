public class House {
	//3 private instance variables for age, type and cost for the house
	private int age;
	private String type;
	private double cost;
	
	//4 Constructors, one with no arguments, one with 1 argument, 1 with 2 args and 1 with 3 args
	public House()
	{
		age = 1950;
		type = "attached";
		cost = 100000;			
	}
	public House(double cost)
	{
		this.cost = cost;
		age = 1950;
		type = "attached";
	}
	public House(int age, double cost)
	{
		this.age = age;
		this.cost = cost;
		type = "attached";
	}
	public House(int age, double cost, String type)
	{
		this.age = age;
		this.cost = cost;
		this.type = type;
	}
	//3 Accessor methods to return age, type and cost
	public  int getAge()
	{
		return age;
	}
	public  double getCost(){
	    return cost;
	}
	public String getType(){
	    return type;
	}
	
	//5 mutator methods, 3 for setting 3 values independently, one to set all 3 and one to set age and cost of the house
	public void setAge(int newAge){
	   age = newAge; 
	}
	
	public void setType(String newType){
	    type = newType;
	}
	public void setCost(double newCost){
	    cost = newCost;
	}
	public void setAllThreeVariables(int newAge, double newCost, String newType){
	    age = newAge;
	    cost = newCost;
	    type = newType;
	}
	public void setAgeandCost(int newAge, double newCost){
	    age = newAge;
	    cost = newCost;
	}
	//A public method that returns the cost of a house based on type and age
	public double estimatePrice(int age, String type){
	 
		for (int y=1; y<=100; y++){ 
			//for the first 5 years 1% of 100000 is added to 100000
			if (type.equalsIgnoreCase("attached") && age<=5 && y<5) {
				cost += 1000;
				}
			//after 5 years 2% of 105000 is added to 105000.
			else if (type.equalsIgnoreCase("attached") && age>5 && y>5) {
				cost += 2100;
				
			}
			//for the first 5 years 2% of 150000 is added to 150000
			if (type.equalsIgnoreCase("Semi-detached") && age<=5 && y<=5) {
				cost += 3000;
				
		}
			//after 5 years 3% of 165000 is added to 165000.
			else if (type.equalsIgnoreCase("Semi-detached") && age>5 && y>5) {
				cost += 4950;
				
			}
			//for the first 5 years 2% of 200000 is added to 200000
			if (type.equalsIgnoreCase("detached") && age<=5 && y<=2) {
				cost += 4000;
			
				}
			//after 5 years 2% of 220000 is added to 220000.
			else if (type.equalsIgnoreCase("detached") &&  age>5 && y>5){
				cost += 4400;
				
			}
		}
		return cost;
		
	}
	//a to string method to return type, age and cost of a house
	public String toString() {
		return ("This House is type "+type+". Its age is "+age+" and costs $"+cost);
	}
	//a equals method to test for equality of 2 objects
	public boolean equals(House anotherHouse) {
		if (anotherHouse.type == type && anotherHouse.age == age)
			return true;
		else
			return false;
	}
	//isLessThan and isGreaterThan methods to compare price
	public boolean isLessThan(House anotherHouse) {
		if(cost < anotherHouse.cost)
			return true;
		else 
			return false;
	}
	public boolean isGreaterThan(House anotherHouse) {
		if (cost> anotherHouse.cost)
			return true;
		else
			return false;
			
	}
}


