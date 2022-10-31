package application;

import java.io.File;

import application.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		Vacation test = new Vacation("Tester");
		
		test.setSafetyImportance(.55);
		test.calculateRankings();
		test.saveVacation();
		
		Vacation test2 = new Vacation(new File("./Data/SavedVaccations/Tester.csv"));
		
		System.out.println(test2);
		
		launch(args);
	}
}
