package sukhjinderKaur_sec005_ex01;

import java.util.Date;

public abstract class Mortgage {
	// instance variables
	public final int mortgageNumber;
	public String customerName;
	public Date dateOfbirth;
	public Address customerAddress;
	public double mortgageAmount;
	public double rateOfInterest;
	public int time;

	// setters
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public void setCustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setMortgageAmount(double mortgageAmount) {
		if (mortgageAmount > 0) {
			this.mortgageAmount = mortgageAmount;
		}
	}

	public void setRateOfInterest(double rateOfInterest) {
		if (rateOfInterest > 0 && rateOfInterest <= 5) {
			this.rateOfInterest = rateOfInterest;
		}
	}

	public void setTime(int time) {
		this.time = time;
	}

	// getter
	public int getMortgageNumber() {
		return mortgageNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Date getDateOfbirth() {
		return dateOfbirth;
	}

	public Address getCustomerAddress() {
		return customerAddress;
	}

	public double getMortgageAmount() {
		return mortgageAmount;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public int getTime() {
		return time;
	}

	// constructor
	public Mortgage(int mortgageNumber, String customerName, Date dateOfbirth, Address customerAddress,
			double mortgageAmount, double rateOfInterest, int time) {
		super();
		this.mortgageNumber = mortgageNumber;
		this.customerName = customerName;
		this.dateOfbirth = dateOfbirth;
		this.customerAddress = customerAddress;
		this.time = time;

		if (mortgageAmount > 0) {
			this.mortgageAmount = mortgageAmount;
		}
		if (rateOfInterest > 0 && rateOfInterest <= 5) {
			this.rateOfInterest = rateOfInterest;
		}
	}

	// overloaded constructor
	public Mortgage(int mortgageNumber, String customerName, Date dateOfbirth, Address customerAddress) {
		super();
		this.mortgageNumber = mortgageNumber;
		this.customerName = customerName;
		this.dateOfbirth = dateOfbirth;
		this.customerAddress = customerAddress;
	}

	// abstract method and To string method
	public abstract double CalculateMonthlyMortgageInstallment(double mortgageAmount);

	@Override
	public String toString() {
		return "Mortgage [Mortgage Number:" + mortgageNumber + ", Customer Name:" + customerName + ", Date Of Birth:"
				+ dateOfbirth + ", Customer Address:" + customerAddress + ", Mortgage Amount:" + mortgageAmount
				+ ", Rate Of Interest:" + rateOfInterest + ", Time:" + time + "]";
	}
}
