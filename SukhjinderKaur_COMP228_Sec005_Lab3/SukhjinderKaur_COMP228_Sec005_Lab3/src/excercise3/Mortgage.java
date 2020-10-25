package excercise3;

public abstract class Mortgage implements MortgageConstants {
	
	//fields
	private int mortgageNumber;
	private String customerName;
	private double amountOfMortgage;
	private double interestRate;
	private int term;
	
	//constructor
	public Mortgage(int mortgageNumber, String customerName, double amountOfMortgage, double interestRate, int term) {
		this.mortgageNumber = mortgageNumber;
		this.customerName = customerName;
		this.setInterestRate(interestRate);
		
		if (amountOfMortgage >maxMortgageAmt) {
			this.amountOfMortgage = maxMortgageAmt;
		}else {
			this.amountOfMortgage = amountOfMortgage;	
		}
		if(term !=mediumTerm && term!= longTerm) {
			this.term=shortTerm;		
		}else {
		this.term = term;
		}
	}
	//getter and setters for interest rate
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void getMortgageInfo() {
		
		double amountOwed = amountOfMortgage + (amountOfMortgage*getInterestRate()*term)/100;
		
		System.out.println(String.format("%s: %d%n%s: %s%n%s: $%.2f%n%s: $%.2f%n%s: %d%n%s %d %s: $%.2f%n",
				"Mortgage",mortgageNumber,"CustomerName",customerName,"Mortgage Amount",
				amountOfMortgage,"Interest Rate",getInterestRate(),"Term", term,"Amount owed after",term,"years",amountOwed));
		}

		}