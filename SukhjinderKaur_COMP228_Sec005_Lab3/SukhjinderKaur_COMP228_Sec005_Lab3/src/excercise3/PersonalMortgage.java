package excercise3;

public class PersonalMortgage extends Mortgage{

	// constructor setting the interest rate to 2% over the current prime rate.
	public PersonalMortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate,
			int term) {
		super(mortgageNumber, customerName, amountOfMortgage, interestRate, term);
		this.setInterestRate(interestRate+2);
	}

	
}
