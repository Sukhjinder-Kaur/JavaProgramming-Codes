package sukhjinderKaur_sec005_ex01;

import java.util.Date;

public class HomeMortgage extends Mortgage {

	// instance variables

	public int propertyTax;
	public int infrastructureTax;

	// getter and setter
	public void setPropertyTax(int propertyTax) {
		if (propertyTax > 0) {
			this.propertyTax = propertyTax;
		}
	}

	public void setInfrastructureTax(int infrastructureTax) {
		if (infrastructureTax > 0) {
			this.infrastructureTax = infrastructureTax;
		}
	}

	public int getPropertyTax() {
		return propertyTax;
	}

	public int getInfrastructureTax() {
		return infrastructureTax;
	}

	// constructor
	public HomeMortgage(int mortgageNumber, String customerName, Date dateOfbirth, Address customerAddress,
			double mortgageAmount, double rateOfInterest, int time, int propertyTax, int infrastructureTax) {
		super(mortgageNumber, customerName, dateOfbirth, customerAddress, mortgageAmount, rateOfInterest, time);

		if (propertyTax > 0) {
			this.propertyTax = propertyTax;
		}
		if (infrastructureTax > 0) {
			this.infrastructureTax = infrastructureTax;
		}

	}

	@Override
	public double CalculateMonthlyMortgageInstallment(double mortgageAmount) {
		return ((mortgageAmount * (rateOfInterest / 100) * time) / 12) + (propertyTax / 12) + infrastructureTax;

	}

	@Override
	public String toString() {
		return "%n" + "Mortgage Number:" + mortgageNumber + "%n" + "Customer Name:" + customerName + "%n"
				+ "Date Of Birth:" + dateOfbirth + "%n" + "Customer Address:" + customerAddress + "%n"
				+ "Mortgage Amount:" + mortgageAmount + "%n" + "Rate Of Interest:" + rateOfInterest + "%n" + "Time:"
				+ time + " years" + "%n" + "Property Tax:" + propertyTax + "%n" + "Infrastructure Tax:"
				+ infrastructureTax + "%n" + "Monthly Installment:"
				+ CalculateMonthlyMortgageInstallment(mortgageAmount) + "%n";
	}

}
