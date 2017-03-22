package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Straightcopy extends Application{
	
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
		VBox layout1 = new VBox(20);
		layout1.getChildren().add( B );
		scene1 = new Scene(layout1, 200,200);
		
		
		Image TitleScreen = new Image("file:TitleScreen.png");
		
		
		//Button2
		Button B2 = new Button("I dont like tanner");
		B2.setOnAction(e -> window.setScene(scene1));
		
		//Layout 2
		VBox layout2 = new VBox(20);
		layout2.getChildren().add( B2 );
		scene2 = new Scene(layout2,400,400);
		//Group root = new Group();
		//Canvas canvas = new Canvas( 1024, 768 );
		//root.getChildren().add( canvas );
		//root.getChildren().add( B2 );
		//GraphicsContext gc = canvas.getGraphicsContext2D();
		//Image space = new Image( "file:Courtyard.png" );
		//gc.drawImage(space, 0, 0);
		//Scene scene2 = new Scene( root );
		
		//end stuff
		
		window.setScene(scene1);
		window.setTitle("Why Tanner?");
		window.show();
	}



}