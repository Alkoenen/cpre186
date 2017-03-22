package application;


import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameDevStart extends Application {
	
	Stage window;
	
	Scene scene1, scene2;
	private static int Movement = 1;
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage theStage){
		
		theStage.setTitle("Timeline Example");
		
		Group root = new Group();
		Scene theScene = new Scene( root );
		theStage.setScene( theScene );
		
		
		//GameLayout
		
		Canvas canvas = new Canvas( 1024, 768 );
		Canvas canvas2 = new Canvas( 1024, 768 );
		root.getChildren().add( canvas );
		root.getChildren().add( canvas2 );
		
		GraphicsContext gc2 = canvas.getGraphicsContext2D();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		
		//Image earth = new Image( "https://raw.githubusercontent.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/master/earth.png" );
		//Image sun = new Image("file:sun.png");
		Image space = new Image( "file:Courtyard.png" );
		Image TitleScreen = new Image("file:TitleScreen.png");
		Image hero = new Image("file:hero.png", 50, 64, true, false);
		final long startNanoTime = System.nanoTime();
		
		
		
		ArrayList<String> input = new ArrayList<String>();

		theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();

				// only add once... prevent duplicates
				if (!input.contains(code))
					input.add(code);
			}
		});

		theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				String code = e.getCode().toString();
				input.remove(code);
			}
		});

		boolean[] KeyLast = {false,false,false,false};
		String[] Keys = {"W","A","S","D"};
		
		int[] position = {24,24};
		
		
		new AnimationTimer(){
			public void handle(long currentNanoTime){
				double t = (currentNanoTime - startNanoTime)/1000000000.0;
				
				
				gc.clearRect(0, 0, 1024, 768);
				gc.drawImage( space, 0, 0);
				
				//going up
				if(input.contains(Keys[0])){
					if(KeyLast[0] && (position[1] != 24)){
						position[1] = position[1] - Movement;
					}
					else{
						KeyLast[0] = true;
						
					}
					
				}
				else{
					KeyLast[0] = false;
				}
				//going left
				if(input.contains(Keys[1])){
					if((KeyLast[1] && (position[0] != 24))){
						
						position[0] = position[0] - Movement;
					
					}
					else{
						KeyLast[1] = true;
						
					}
					
				}
				else{
					KeyLast[1] = false;
				}
				// going down
				if(input.contains(Keys[2])){
					if(KeyLast[2] && (position[1] != 680)){
						position[1] = position[1] + Movement;
					}
					else{
						KeyLast[2] = true;
						
					}
					
				}
				else{
					KeyLast[2] = false;
				}
				//going right
				if(input.contains(Keys[3])){
					if(KeyLast[3] && (position[0] != 949)){
						
						position[0] = position[0] + Movement;
					
					}
					else{
						KeyLast[3] = true;
						
					}
					
				}
				else{
					KeyLast[3] = false;
				}

				gc.drawImage( hero, position[0], position[1]);
				//clear the canvas
				//Background image clears canvas
				
				
			}
		}.start();
		
		
		theStage.show();
	}
	
	
	
}

