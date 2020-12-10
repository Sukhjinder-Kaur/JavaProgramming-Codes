package sukhjinderkaur_sec005_ex01;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

	@FXML
	private Label cityLabel;

	@FXML
	private TextField cityTextField;

	@FXML
	private Button displayButton;

	@FXML
	private TextArea resultTextArea;

	@FXML
	void displayButtonClick(ActionEvent event) {

		String textSelectedCity = String.valueOf(cityTextField.getText());

		try {
			System.out.println("> Start Program ...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("> Driver Loaded successfully.");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD",
					"COMP122M20_003_P_72", "password");

			System.out.println("> Database connected successfully.");
			System.out.println(">==================================\n");

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students WHERE city = '" + textSelectedCity + "'");
			
			resultTextArea.clear();

			while (rs.next()) {
				int stuid = rs.getInt("studentID");
				String firstN = rs.getString("firstName");
				String lastN = rs.getString("lastName");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String province = rs.getString("province");
				String postalCode = rs.getString("postalCode");

				String displayResult = stuid+"\t"+"\t"+firstN +"\t"+"\t"+lastN +"\t"+"\t"+address+"\t"+"\t"+city+"\t"+"\t"+province+"\t"+"\t"+postalCode+"\n";
				resultTextArea.appendText(displayResult);
			}

			rs.close();
			st.close();
			connection.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void initialize() {

		try {
			System.out.println("> Start Program ...");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("> Driver Loaded successfully.");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD",
					"COMP122M20_003_P_72", "password");

			System.out.println("> Database connected successfully.");
			System.out.println(">==================================\n");

			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students");

			while (rs.next()) {
				int stuid = rs.getInt("studentID");
				String firstN = rs.getString("firstName");
				String lastN = rs.getString("lastName");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String province = rs.getString("province");
				String postalCode = rs.getString("postalCode");
				
				String displayResult = stuid+"\t"+"\t"+firstN +"\t"+"\t"+lastN +"\t"+"\t"+address+"\t"+"\t"+city+"\t"+"\t"+province+"\t"+"\t"+postalCode+"\n";
				resultTextArea.appendText(displayResult);
			}

			rs.close();
			st.close();
			connection.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
