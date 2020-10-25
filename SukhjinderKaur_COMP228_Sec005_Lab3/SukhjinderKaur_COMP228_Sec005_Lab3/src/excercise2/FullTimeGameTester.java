package excercise2;

public class FullTimeGameTester extends GameTester {

	//field
	protected double baseSalary;

	//constructor
	public FullTimeGameTester(String gameTesterName, boolean fullTimeStatus,double baseSalary) {
		super(gameTesterName, fullTimeStatus);
		 if (baseSalary < 0.0) // validate baseSalary                  
	         throw new IllegalArgumentException("Base salary must be >= 0.0");
		 	this.baseSalary = baseSalary;
		 	this.fullTimeStatus=true;
	}

	//setters
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) // validate baseSalary                  
	         throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = baseSalary;
	}

	//getters
	public double getBaseSalary() {
		return baseSalary;
	}
	//Implementing the abstract method here to return earnings
	@Override
	public double earnings() {
		return getBaseSalary();	
	}

	// method
	@Override
	public String toString()                                    
	   { return String.format("%s: %s%n%s: %s%n%s: %s%n",
					"Student Name",getGameTesterName(),"Full Time Tester",isfullTimeStatus(),"Base Salary",earnings());
		
	}

}