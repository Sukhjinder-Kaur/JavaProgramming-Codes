package excercise1;

public class Health extends Insurance {

	//constructor using the abstract class
	public Health(double cost) {
		super("health");
		setInsuranceCost(cost);
	}
	
	// implementing the insurance cost from super class
	@Override
	public void setInsuranceCost(double cost) {
		this.monthlyCost = cost;
	}
	
	//displaying information
	@Override
	public void displayInfo() {
		System.out.println(
			String.format("%s: %s%n%s: $%.2f%n",
				"Insurance Type",getTypeOfInsurance(),"MonthlyCost",getMonthlyCost()));
	}
}