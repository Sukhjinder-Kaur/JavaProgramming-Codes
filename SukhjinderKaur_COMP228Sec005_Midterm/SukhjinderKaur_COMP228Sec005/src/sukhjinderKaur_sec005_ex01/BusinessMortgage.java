package sukhjinderKaur_sec005_ex01;

import java.util.Date;

public class BusinessMortgage extends Mortgage {
	
	//instance variables
	public double businessInsurance;
	
	//getter and setter
	public void setBusinessInsurance(double businessInsurance) {
		if (businessInsurance > 0) {
		this.businessInsurance = businessInsurance;
	}
	}

	public double getBusinessInsurance() {
		return businessInsurance;
	}
	
	//constructor
	public BusinessMortgage(int mortgageNumber, String customerName, Date dateOfbirth, Address customerAddress,
			double mortgageAmount, double rateOfInterest, int time ,double businessInsurance) {
		super(mortgageNumber, customerName, dateOfbirth, customerAddress, mortgageAmount, rateOfInterest, time);
		if (businessInsurance > 0) {
			this.businessInsurance = businessInsurance;
		}
	}

	@Override
	public double CalculateMonthlyMortgageInstallment(double mortgageAmount) {
		return ((mortgageAmount * (rateOfInterest / 100) * time) / 12) + businessInsurance;
	}

	@Override
	public String toString() {
		return "%n"+"Mortgage Number:" + mortgageNumber +"%n"
				+ "Customer Name:" + customerName +"%n"+ "Date Of Birth:"+ dateOfbirth +"%n"+ 
				"Customer Address:" + customerAddress +"%n"+ "Mortgage Amount:" + mortgageAmount+
				"%n"+ "Rate Of Interest:" +rateOfInterest +"%n"+ "Time:" + time + " years"+ "%n"+ 
				"Business Insurance:" +businessInsurance + "%n"+ "Monthly Installment:" + 
				CalculateMonthlyMortgageInstallment(mortgageAmount)+"%n";
	}


}
