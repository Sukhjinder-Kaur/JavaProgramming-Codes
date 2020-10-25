package excercise1;

public abstract class Insurance {
		// fields
		protected String  typeOfInsurance ;
		protected double  monthlyCost;

		//constructor
		public Insurance(String typeOfInsurance) {
			this.typeOfInsurance = typeOfInsurance;
		}

		// getter and setter
		public String getTypeOfInsurance() {
			return typeOfInsurance;
		}

		public double getMonthlyCost() {
			return monthlyCost;
		}
		
		// abstract methods
		public abstract void setInsuranceCost(double cost);
		public abstract void displayInfo();
}