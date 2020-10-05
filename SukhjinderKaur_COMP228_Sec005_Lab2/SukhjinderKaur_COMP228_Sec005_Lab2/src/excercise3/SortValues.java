package excercise3;

import java.util.Random;

public class SortValues {
	
	 static public int[] SortNumbers() {
		int [] numberArray= new int[6];
		Random randArray=new Random();
		
		System.out.printf("General Numbers: ");
		
		for (int i=0;i<numberArray.length;i++) {
			numberArray[i]=randArray.nextInt(30);
			System.out.printf("%d ",numberArray[i]);
		}
		
		System.out.printf("%n");
		int [] sortedArray= numberArray;
		int higherNumber = 0;
		for(int i=0; i < sortedArray.length; i++) {
        	for(int j=1; j < (sortedArray.length-i); j++) {
        		if(sortedArray[j-1] < sortedArray[j]) {
        			higherNumber = sortedArray[j-1];
        			sortedArray[j-1] = sortedArray[j];
        			sortedArray[j] = higherNumber;
        		}
        	}
        }
		System.out.printf("Numbers in decending order: ");
		for (int i=0; i< sortedArray.length; i++) {
			System.out.printf("%d ", sortedArray[i]); 
		}
		System.out.printf("%n");
		return sortedArray;
	 }
}