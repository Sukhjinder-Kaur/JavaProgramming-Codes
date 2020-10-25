package excercise2;

public class PartTimeGameTester extends GameTester {
	
	//field
	protected double salaryPerHour;
	protected double noOfHours;

	//constructor
	public PartTimeGameTester(String gameTesterName, boolean fullTimeStatus,double salaryPerHour,double noOfHours) {
		super(gameTesterName, fullTimeStatus);
		if (salaryPerHour < 0.0) // validate salary per hr
	         throw new IllegalArgumentException(
	            "Hourly wage must be >= 0.0");

	      if ((noOfHours < 0.0) || (noOfHours > 168.0)) // validate hours
	         throw new IllegalArgumentException(
	            "Hours worked must be >= 0.0 and <= 168.0");

		this.salaryPerHour = salaryPerHour;
		this.noOfHours=noOfHours;
		this.fullTimeStatus=false;
	}

	//setter
	public void setSalaryPerHour(double salaryPerHour) {
		if (salaryPerHour < 0.0) // validate wage
	         throw new IllegalArgumentException(
	            "Hourly wage must be >= 0.0");
		this.salaryPerHour = salaryPerHour;
	}
	
	public void setNoOfHours(double noOfHours) {
		if ((noOfHours < 0.0) || (noOfHours > 168.0)) // validate hours
	         throw new IllegalArgumentException(
	            "Hours worked must be >= 0.0 and <= 168.0");
		this.noOfHours = noOfHours;
	}
	//getter
	public double getSalaryPerHour() {
		return salaryPerHour;
	}
	
	public double getNoOfHours() {
		return noOfHours;
	}
	
	//Implementing the abstract method here to return earnings
	@Override
	public double earnings() 
	{
		if (getNoOfHours()<=40)// no overtime
		{
		return getSalaryPerHour() * getNoOfHours() ;	
	} else {
		return 40 * getSalaryPerHour() + (getNoOfHours() - 40) * getSalaryPerHour() * 1.5;
	}
}
	// method
		@Override
		public String toString()                                    
		   { return String.format("%s: %s%n%s: %s%n%s: %s%n",
						"Student Name",getGameTesterName(),"Full Time Tester",isfullTimeStatus(),
						"Salary after per hour calculation and overtime worked(if any)",earnings());
			
		}


}
