package excercise2;

import java.util.Random;

public class Lotto {
	//field
private int [] randLottoArray;
 
//constructor
public Lotto(int [] randLottoNumber) {
		this.randLottoArray = randLottoNumber;
	} 
//getter

public int[] getRandLottoArray() {
	return randLottoArray;
}
// Method to Generate Lottery Number
 public Lotto() {
	 
	 randLottoArray= new int [3];
	 Random randomNumber = new Random();
	 
	 for (int i = 1; i < randLottoArray.length; i++) {
		 randLottoArray[i]=randomNumber.nextInt(9)+1;
 }
	 }

}