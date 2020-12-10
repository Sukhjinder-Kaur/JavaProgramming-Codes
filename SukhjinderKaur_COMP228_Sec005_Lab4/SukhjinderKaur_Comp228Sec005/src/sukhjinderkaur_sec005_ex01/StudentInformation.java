package sukhjinderkaur_sec005_ex01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class StudentInformation extends JFrame {

	private JList<String> courseList;
	private JComboBox<String> courseComboBox;
	private List<String> courseChoice = new ArrayList<>();
	String[] arrayOfCourses;
	private JTextArea infoDisplayTextArea;
	private final ButtonGroup buttonGroup = new ButtonGroup();

// creating constructor

	public StudentInformation() {
		super("Student Information Form");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jpanelLeft=new JPanel();
		JPanel jpanelCenter=new JPanel();
		JPanel jpanelRight=new JPanel();
		JPanel jpanelTop=new JPanel();
		JPanel jpanelMiddleCourse=new JPanel();
		JPanel jpanelBottom=new JPanel();

		// creating labels

		jpanelLeft.setLayout(new GridLayout(7, 1, 5, 5));

		JLabel nameLabel=new JLabel("Name: ");
		jpanelLeft.add(nameLabel);

		JLabel addressLabel = new JLabel("Address: ");
		jpanelLeft.add(addressLabel);

		JLabel provinceLabel = new JLabel("Province: ");
		jpanelLeft.add(provinceLabel);

		JLabel cityLabel = new JLabel("City: ");
		jpanelLeft.add(cityLabel);

		JLabel postalLabel = new JLabel("Postal Code: ");
		jpanelLeft.add(postalLabel);

		JLabel numberLabel = new JLabel("Phone Number: ");
		jpanelLeft.add(numberLabel);

		JLabel emailLabel = new JLabel("Email: ");
		jpanelLeft.add(emailLabel);

		// creating text fields for entering the details

		jpanelCenter.setLayout(new GridLayout(7, 1, 5, 5));

		JTextField nameTextField = new JTextField(10);
		jpanelCenter.add(nameTextField);

		JTextField addressTextField = new JTextField(10);
		jpanelCenter.add(addressTextField);

		JTextField provinceTextField = new JTextField(10);
		jpanelCenter.add(provinceTextField);

		JTextField cityTextField = new JTextField(10);
		jpanelCenter.add(cityTextField);

		JTextField postalTextField = new JTextField(10);
		jpanelCenter.add(postalTextField);

		JTextField numberTextField = new JTextField(10);
		jpanelCenter.add(numberTextField);

		JTextField emailTextField = new JTextField(10);
		jpanelCenter.add(emailTextField);

		// creating the JList
		courseList = new JList<String>();
		courseList.setVisibleRowCount(9);

		// create combo box
		courseComboBox = new JComboBox<String>();
		courseComboBox.setMaximumRowCount(5);
		courseComboBox.setPreferredSize(new Dimension(250, 60));
		courseComboBox.setSize(new Dimension(100, 150));

		courseComboBox.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(courseComboBox.getSelectedItem() != null) 
		{   
			String courseSelected = courseComboBox.getSelectedItem().toString();
		    if (!courseChoice.contains(courseSelected)) {
			courseChoice.add(courseSelected);
			arrayOfCourses = new String[courseChoice.size()];
			for (int i = 0; i < arrayOfCourses.length; i++) {
				arrayOfCourses[i] = courseChoice.get(i);
				courseList.removeAll();
				courseList.setListData(arrayOfCourses);
			}
		}
	} else {
		courseChoice.clear();
	}
}		
		});

		new JScrollPane(infoDisplayTextArea);

		// creating radio button
		JRadioButton computerRadiobutton = new JRadioButton("Computer Science", false);
		computerRadiobutton.setHorizontalAlignment(SwingConstants.LEFT);
		JRadioButton businessRadiobutton = new JRadioButton("Business", false);
		jpanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jpanelTop.add(computerRadiobutton);
		jpanelTop.add(businessRadiobutton);
		jpanelMiddleCourse.setLayout(new FlowLayout());

		// grouping radio buttons
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(computerRadiobutton);
		radioGroup.add(businessRadiobutton);

		// Register buttons for events
		RadioButtonHandler handler = new RadioButtonHandler();
		computerRadiobutton.addActionListener(handler);
		businessRadiobutton.addActionListener(handler);

		// creating checkBoxes
		JCheckBox studentCouncilCheckBox = new JCheckBox("Student Council");
		JCheckBox volunteerCheckBox = new JCheckBox("Volunteer work");
		getContentPane().add(jpanelBottom, BorderLayout.SOUTH);

		// combo box for courses
		jpanelMiddleCourse.add(courseComboBox);
		jpanelMiddleCourse.add(courseList);

		// creating Text Area
		FlowLayout fl_jpanelBottom = new FlowLayout();
		fl_jpanelBottom.setVgap(6);
		fl_jpanelBottom.setHgap(6);
		jpanelBottom.setLayout(fl_jpanelBottom);
		JTextArea infoDisplayTextArea = new JTextArea(5, 40);
		infoDisplayTextArea.setEditable(false);
		jpanelBottom.add(infoDisplayTextArea);

		JButton resetButton = new JButton("Reset");
		jpanelBottom.add(resetButton);

		// Creating button to display information
		JButton displaybutton = new JButton("Display");
		jpanelBottom.add(displaybutton);
		buttonGroup.add(displaybutton);
		displaybutton.setVerticalAlignment(SwingConstants.TOP);
		displaybutton.setHorizontalAlignment(SwingConstants.LEFT);

		displaybutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String courses = "";
				String program = "";
				String otherActivities = "";

				if (studentCouncilCheckBox.isSelected() && volunteerCheckBox.isSelected()) {
					otherActivities = studentCouncilCheckBox.getText() + "and" + volunteerCheckBox.getText();

				} else if (volunteerCheckBox.isSelected() && !studentCouncilCheckBox.isSelected()) {
					otherActivities = volunteerCheckBox.getText();

				} else if (studentCouncilCheckBox.isSelected() && !volunteerCheckBox.isSelected()) {
					otherActivities = studentCouncilCheckBox.getText();

				} else if (!studentCouncilCheckBox.isSelected() && !studentCouncilCheckBox.isSelected()) {
					otherActivities = "No extra activities joined";
				}

				// radio button check condition

				if (computerRadiobutton.isSelected()) {
					program = computerRadiobutton.getText();
				}

				else if (businessRadiobutton.isSelected()) {
					program = businessRadiobutton.getText();
				}

				for (int i = 0; i < arrayOfCourses.length; i++) {
					courses += arrayOfCourses[i] + ", ";
				}

				infoDisplayTextArea.setText(String.format("%s, %s, %s, %s, %s, %s, %s%n %n%s: %s %n%s: %s %n%s: %s",
						nameTextField.getText(), addressTextField.getText(), provinceTextField.getText(),
						cityTextField.getText(), postalTextField.getText(), numberTextField.getText(),
						emailTextField.getText(), "Name of Program ", program, "Courses", courses, "Other Activities",
						otherActivities));
			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				radioGroup.clearSelection();
				studentCouncilCheckBox.setSelected(false);
				volunteerCheckBox.setSelected(false);
				courseChoice.clear();
				courseComboBox.removeAllItems();
				courseList.setSelectedIndex(0);
				infoDisplayTextArea.setText(null);
			}
		});

		// Add panels to window
		getContentPane().add(jpanelLeft, BorderLayout.WEST);
		getContentPane().add(jpanelCenter, BorderLayout.CENTER);
		getContentPane().add(jpanelRight, BorderLayout.EAST);
		
		GroupLayout gl_jpanelRight = new GroupLayout(jpanelRight);
		gl_jpanelRight.setHorizontalGroup(
			gl_jpanelRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpanelRight.createSequentialGroup()
					.addComponent(jpanelTop, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_jpanelRight.createSequentialGroup()
					.addGap(44)
					.addComponent(volunteerCheckBox, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(studentCouncilCheckBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(43))
				.addGroup(gl_jpanelRight.createSequentialGroup()
					.addGap(21)
					.addComponent(jpanelMiddleCourse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_jpanelRight.setVerticalGroup(
			gl_jpanelRight.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpanelRight.createSequentialGroup()
					.addComponent(jpanelTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpanelRight.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentCouncilCheckBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(volunteerCheckBox, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jpanelMiddleCourse, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
					.addContainerGap())
		);
		jpanelRight.setLayout(gl_jpanelRight);

	}

	// radio button event handler
	public class RadioButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton radioButton = (JRadioButton) e.getSource();

			if (radioButton.getText() == "Computer Science") {
				courseChoice.clear();
				courseList.setSelectedIndex(0);
				courseComboBox.removeAllItems();
				courseComboBox.addItem("");
				courseComboBox.addItem("Java");
				courseComboBox.addItem("Web Development");
				courseComboBox.addItem("Python");
				courseComboBox.addItem("C#");
				courseComboBox.addItem("Database");
			} else if (radioButton.getText() == "Business") {
				courseChoice.clear();
				courseList.setSelectedIndex(0);
				courseComboBox.removeAllItems();
				courseComboBox.removeAllItems();
				courseComboBox.addItem("");
				courseComboBox.addItem("Economics");
				courseComboBox.addItem("Finance");
				courseComboBox.addItem("Accounting");
				courseComboBox.addItem("Business Management");
				courseComboBox.addItem("Human Resources Management");

			} else {
				courseChoice.clear();
				courseList.setSelectedIndex(0);
				courseComboBox.removeAllItems();
				courseComboBox = null;
			}
		}
	}
}
