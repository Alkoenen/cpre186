package application;


	import java.util.ArrayList;

	import javafx.animation.AnimationTimer;
	import javafx.application.Application;
	import javafx.event.EventHandler;
	import javafx.scene.Group;
	import javafx.scene.Scene;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import javafx.scene.image.Image;
	import javafx.scene.input.KeyEvent;
	import javafx.stage.Stage;

	public class GameDev extends Application {

		public static void main(String[] args){
			launch(args);
		}
		
		@Override
		public void start(Stage theStage){
			theStage.setTitle("Timeline Example");
			
			Group root = new Group();
			Scene theScene = new Scene( root );
			theStage.setScene( theScene );
			
			Canvas canvas = new Canvas( 1024, 768 );
			Canvas canvas2 = new Canvas( 1024, 768 );
			root.getChildren().add( canvas );
			root.getChildren().add( canvas2 );
			
			GraphicsContext gc2 = canvas.getGraphicsContext2D();
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			
			Image earth = new Image( "https://raw.githubusercontent.com/tutsplus/Introduction-to-JavaFX-for-Game-Development/master/earth.png" );
			Image sun = new Image("file:sun.png");
			Image space = new Image( "file:Courtyard.png" );
			Image TitleScreen = new Image("file:TitleScreen.png");
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

			Boolean[] KeyLast = new Boolean [4];
			String[] Keys = {"W","A","S","D"};
			
			int[] position = {0,0};
			
			
			new AnimationTimer(){
				public void handle(long currentNanoTime){
					double t = (currentNanoTime - startNanoTime)/1000000000.0;
					
					
					gc.clearRect(0, 0, 1024, 768);
					gc.drawImage( space, 0, 0);
					if(input.contains(Keys[0])){
						if(KeyLast[0]){
							position[0] = position[1] + 1;
						}
						else{
							KeyLast[0] = true;
							
						}
						
					}
					if(input.contains(Keys[1])){
						if(KeyLast[1]){
							//if(CanMove){
							position[1] = position[0] - 1;
							//}
						}
						else{
							KeyLast[1] = true;
							
						}
						
					}
					else{
						KeyLast[0] = false;
					}
					gc.drawImage( sun, position[0], 0);
					//clear the canvas
					//Background image clears canvas
					
					
				}
			}.start();
			
			
			theStage.show();
		}
	}


