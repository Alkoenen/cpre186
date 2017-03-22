package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SwitchingScenes extends Application{
	
	public Stage window;
	public Scene scene1, scene2;
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primarystage) throws Exception {
		window = primarystage;
		//Button1
		Button B = new Button("Tanner");
		B.setOnAction(e -> window.setScene(scene2));
		
		//Layout 1
		Group root = new Group();
		Scene scene1 = new Scene(root);
		window.setScene(scene1);
		Canvas canvas = new Canvas( 1024, 500 );
		root.getChildren().add( canvas );
		root.getChildren().add( B );
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		
		Image TitleScreen = new Image("file:TitleScreen.png");
		gc.drawImage(TitleScreen, 0, 0);
		
		//Button2
		Button B2 = new Button("I dont like tanner");
		B2.setOnAction(e -> primarystage.setScene(scene1));
		
		//Layout 2
		Group root2 = new Group();
		Scene scene2 = new Scene(root2);
		window.setScene(scene2);
		Canvas canvas2 = new Canvas( 1024, 500 );
		root2.getChildren().add( canvas2 );
		root2.getChildren().add( B2 );
		GraphicsContext gc2 = canvas2.getGraphicsContext2D();
		Image space = new Image( "file:Courtyard.png" );
		gc2.drawImage(space, 0, 0);
		
		//end stuff
		
		window.setScene(scene1);
		window.setTitle("Why Tanner?");
		window.show();
	}



}