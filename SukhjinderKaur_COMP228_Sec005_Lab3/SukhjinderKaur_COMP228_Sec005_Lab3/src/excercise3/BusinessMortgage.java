package excercise3;

public class BusinessMortgage extends Mortgage {

	
	// constructor setting the interest rate to 1% over the current prime rate.
	public BusinessMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate,
			int term) {
		super(mortgageNumber, customerName, amountOfMortgage, interestRate, term);	
		this.setInterestRate(interestRate+1);
	}
	
}
