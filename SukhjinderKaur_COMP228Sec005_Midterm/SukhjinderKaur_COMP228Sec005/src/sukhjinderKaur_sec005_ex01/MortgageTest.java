package sukhjinderKaur_sec005_ex01;

import java.util.Date;

public class MortgageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating date and address objects first
		Date birth1 = new Date(1988 - 10 - 13);
		Date birth2 = new Date(1995 - 8 - 26);
		Date birth3 = new Date(1990 - 6 - 11);
		Date birth4 = new Date(1992 - 5 - 16);

		Address address1 = new Address(129, "George Street", "Toronto", "Ontario", "M1G 5T6");
		Address address2 = new Address(1111, "King Street", "Calgary", "Alberta", "T2X 9K2");
		Address address3 = new Address(2704, "Boulevard", "New Westminister", "British Columbia", "B7C 4J0");
		Address address4 = new Address(4511, "West", "Waterloo", "Ontario", "M1N 2U3");

		// creating objects for mortgages
		HomeMortgage homeMortgage1 = new HomeMortgage(3427, "Abhi", birth1, address1, 170000, 3, 10, 3000, 150);
		HomeMortgage homeMortgage2 = new HomeMortgage(2789, "Smith", birth3, address3, 700000, 2, 25, 4500, 150);

		BusinessMortgage businessMortgage1 = new BusinessMortgage(5890, "John", birth2, address2, 300000, 5, 15, 250);
		BusinessMortgage businessMortgage2 = new BusinessMortgage(9450, "Frank", birth4, address4, 400000, 1.9, 21,250);

		System.out.println("Home Mortgages processed individually:\n");

		System.out.printf(homeMortgage1.toString());
		System.out.printf(homeMortgage2.toString());

		System.out.println("\n\nBusiness Mortgages processed individually:\n");
		System.out.printf(businessMortgage1.toString());
		System.out.printf(businessMortgage2.toString());

		System.out.printf("\n\nHome Mortgages processed polymorphically:\n");

		Mortgage[] mortgage = new Mortgage[4];

		mortgage[0] = homeMortgage1;
		mortgage[1] = homeMortgage2;
		mortgage[2] = businessMortgage1;
		mortgage[3] = businessMortgage2;

		for (Mortgage mortgagelist : mortgage) {
			System.out.printf(mortgagelist.toString());
		}

	}
}
