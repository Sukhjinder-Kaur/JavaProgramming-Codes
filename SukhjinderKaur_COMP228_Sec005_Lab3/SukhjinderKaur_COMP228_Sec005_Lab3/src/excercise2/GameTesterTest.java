package excercise2;

import java.util.Scanner;

public class GameTesterTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameTester [] gameTester = new GameTester[2];
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < gameTester.length; i++) {
		
			System.out.print("Please enter your name: ");
			String name= input.next();
			
			System.out.print("Are you a full time tester: True/False? ");
			boolean type= input.nextBoolean();
		
			if (type == true) {
				FullTimeGameTester fullTimeGameTester = new FullTimeGameTester(name, type, 3000);
				gameTester[i]  = fullTimeGameTester;
				System.out.println(fullTimeGameTester.toString());	
			}else if (type == false) {
				System.out.print("How many hours do you work per week? ");
				double hours= input.nextDouble();
				
				PartTimeGameTester partTimeGameTester = new PartTimeGameTester(name,type,20,hours);
				gameTester[i] = partTimeGameTester;
				System.out.println(partTimeGameTester.toString());
			}else {
				System.out.print("Please enter a valid input!");
				break;
			}
		}
		
		System.out.println("Details of testers are displayed below:");
        for(int i=0;i<gameTester.length;i++)
        {
        	System.out.println(gameTester[i].toString());
        }
	}	
}