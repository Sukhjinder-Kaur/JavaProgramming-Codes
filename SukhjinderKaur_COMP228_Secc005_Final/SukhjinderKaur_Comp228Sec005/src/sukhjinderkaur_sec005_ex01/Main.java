package sukhjinderkaur_sec005_ex01;

import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("StudentInfoForm.fxml"));
			Scene scene = new Scene(root,600,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Student Information Form");
			primaryStage.show();
			
	}

	catch(Exception e)
	{
		e.printStackTrace();
	}
}

	public static void main(String[] args) {
		launch(args);
	}

}
