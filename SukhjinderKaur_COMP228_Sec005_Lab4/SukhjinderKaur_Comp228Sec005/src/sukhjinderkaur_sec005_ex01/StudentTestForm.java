package sukhjinderkaur_sec005_ex01;

import javax.swing.JFrame;

public class StudentTestForm {
    public static void main(String[] args) {
    	StudentInformation studentForm = new StudentInformation();
        studentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentForm.setSize(700, 400);
        studentForm.setVisible(true);

    }
}