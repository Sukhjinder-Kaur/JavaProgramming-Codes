package excercise2;

public abstract class GameTester {

	// fields
			protected String  gameTesterName ;
			protected boolean  fullTimeStatus;
			
	//constructor
			public GameTester(String gameTesterName, boolean fullTimeStatus) {
				this.gameTesterName = gameTesterName;
				this.fullTimeStatus = fullTimeStatus;
			}
	//getter
			public String getGameTesterName() {
				return gameTesterName;
			}
			
			public boolean isfullTimeStatus() {
				return fullTimeStatus;
			}
	// abstract method
			public abstract double earnings();
			
}