package dad.starwars.app;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StarWarsApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		StarWarsController control = new StarWarsController();
		
		Scene scene = new Scene(control.getView(), 1150, 680);
		scene.getStylesheets().add(getClass().getResource("swapiStyle.css").toExternalForm());
		scene.getStylesheets().add("https://fonts.googleapis.com/css?family=Russo+One");
		
		primaryStage.setTitle("StarWars :: People");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("file:icon.png"));
		primaryStage.centerOnScreen();
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
