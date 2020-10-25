package excercise3;

import java.util.Scanner;

public class ProcessMortgage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mortgage [] mortgage = new Mortgage[3];
		
		Scanner input = new Scanner(System.in);
	
		
		for (int i = 0; i < mortgage.length; i++) {
			
			System.out.print("Enter the current interest rate:");
			double rate = input.nextDouble();
			
			System.out.print("Enter the type of mortgage: Personal/Business?");
			String type = input.next();
			System.out.print("\n");
			
			if (type.equalsIgnoreCase("personal")){
				
				PersonalMortgage personalMortgage = new PersonalMortgage(1234,"Shallini",270000.00,2.03,5);
				mortgage[i] = personalMortgage;
				personalMortgage.getMortgageInfo();	
				
			}else if (type.equalsIgnoreCase("business")) {
				
				BusinessMortgage businessMortgage = new BusinessMortgage(4567,"Abhi",300000.00,2.25,3);
				mortgage[i] = businessMortgage;
				businessMortgage.getMortgageInfo();	
				
			}else {
				System.out.println("Please enter a valid input!");
				break;
			}
				}
		System.out.println("Details of all mortgages is below:");
		System.out.print("\n");
        for(int i=0;i<mortgage.length;i++)
        {
        	mortgage[i].getMortgageInfo();
               System.out.println();
        }

		}
	}
