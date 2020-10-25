package excercise1;

import java.util.Scanner;

public class InsuranceDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		Insurance [] insurance = new Insurance[2];
		
		for(int i = 0; i < insurance.length; i++) {
			System.out.print("Please select the type of insurance you want: Health / Life? ");
			String type= input.next();
			System.out.print("Please enter the monthly cost:");
			double cost = input.nextDouble();
			System.out.println(String.format("%n%s%n","Your output is below:"));
	 
			if (type.equalsIgnoreCase("health")){
				
				Health healthInsurance = new Health(cost);
				insurance[i] = healthInsurance;
				healthInsurance.displayInfo();	
				
			}else if (type.equalsIgnoreCase("life")) {
				
				Life lifeInsurance = new Life(cost);
				insurance[i] = lifeInsurance;
				lifeInsurance.displayInfo();
				
			}else {
				System.out.println("Please enter a valid input!");
			}
		}
		
		for(int i=0;i<insurance.length;i++) {
			System.out.println(String.format("%n%s%n","Displaying new cost set to Insurances"));
			if (insurance[i].getTypeOfInsurance() == "health") {
				insurance[i].setInsuranceCost(200);
			}
			if (insurance[i].getTypeOfInsurance() == "life") {
				insurance[i].setInsuranceCost(300);
			}
			System.out.println(
				String.format("%s %s $%.2f",insurance[i].getTypeOfInsurance().toUpperCase(),
					"insurance cost set to",insurance[i].getMonthlyCost()));
		}
	}
}