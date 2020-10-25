package excercise1;


import java.util.Random;
import java.lang.ArithmeticException;
import javax.swing.JOptionPane;

public class QuestionBank {
	// fields
	private int  correctAnswers;
	private int incorrectAnswers;
	private int score;
	private int noOfQuestions=5;
	
	//constructor
	public QuestionBank(int correctAnswers,int incorrectAnswers,int score,int noOfQuestions) 
	{
		// initializing 
		this.correctAnswers = correctAnswers;
		this.incorrectAnswers = incorrectAnswers;
		this.score = score;
		this.noOfQuestions=5;
	}
	// Method for displaying questions bank	
	public String[] simulateQuestion(int questionNumber) {
		String[] q1 ={ String.format("1. Which of these packages contain all the collection classes?%n"
				+"A. java.lang%nB. java.util%nC. java.net%nD. java.awt"),"B"}; //B
		String[] q2 ={ String.format("2. Which of these classes is not part of Java’s collection framework?%n"
				+ "A. Maps%nB. Array%nC. Stack%nD. Queue"),"D"};//D
		String[] q3 ={ String.format("3. What is Collection in Java?%n"
				+"A. A group of objects%nB. A group of classes%nC. A group of interfaces%nD. None of the mentioned"),"A"};//A
	    String[] q4 ={ String.format("4. Which of these methods deletes all the elements from invoking collection?%n"
				+"A. clear()%nB. reset()%nC. delete()%nD. refresh()"),"A"};//A
	    String[] q5 ={ String.format("5. Which of these interface handle sequences?%n"
				+"A. Set%nB. List%nC. Comparator%nD. Collection"),"B"};//B
	    
	    String[][] question = { q1, q2, q3, q4, q5 };

		return question[questionNumber];
	}
	// method for checking if answers are correct or not
	public boolean checkAnswer (String question, String submittedAnswer) {
		boolean ansIsCorrect = false;
			if (question.equals(submittedAnswer.toUpperCase())) {
				ansIsCorrect = true;
				correctAnswers++;
			} else {
				incorrectAnswers++;
			}
		return ansIsCorrect;
}
	
	// method for generate message dialogbox
	
	public void generateMessage(boolean ansIsCorrect) {
		// creating random object
		Random random = new Random();
		
		if (ansIsCorrect) {
			switch (random.nextInt(4)) {
			case 0:
				JOptionPane.showMessageDialog(null, "Excellent!");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Good!");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Keep up the good work!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Nice work!");
				break;
			}
		} else {
			switch (random.nextInt(4)) {
			case 0:
				JOptionPane.showMessageDialog(null, "No. Please try again");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Wrong. Try once more");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Don't give up!");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "No. Keep trying..");
				break;
			}
		}
	}
		
	// Methods for looping for questions 
	public void inputAnswer() {
		for (int counter = 0; counter < 5; counter++) {
			String[] question = simulateQuestion(counter);
			String answer = JOptionPane.showInputDialog(question[0]);
			boolean ansIsCorrect = checkAnswer(question[1],answer);
			generateMessage(ansIsCorrect);
		}
	 	// calculating score and displaying result
		score = correctAnswers / 5 * 100 ;
		String result = String.format(" You have answered %d correct and %d incorrect answers.Your percentage is %d.",correctAnswers,incorrectAnswers,score);
		JOptionPane.showMessageDialog(null, result,"Test Score",JOptionPane.INFORMATION_MESSAGE);
	}
}