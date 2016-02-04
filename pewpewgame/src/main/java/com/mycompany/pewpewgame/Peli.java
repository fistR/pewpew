package com.mycompany.pewpewgame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;
import com.mycompany.pewpewgame.InputHandler;


/**
 *
 * @author max
 */
public class Peli extends Application{
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void start(Stage stage){
        InputHandler input = new InputHandler();
        stage.setTitle("PewPew");
        
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        Canvas canv = new Canvas(512,512);
        root.getChildren().add(canv);
        GraphicsContext gc = canv.getGraphicsContext2D();
        input.registerInputs(scene);
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        final long timeStart = System.currentTimeMillis();
        KeyFrame kf = new KeyFrame(
        Duration.seconds(0.017),
        new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                double t = (System.currentTimeMillis() - timeStart)/1000.0;
                
                //handle the gameloop
                input.handleInputs(scene);
                //clear canvas
                gc.clearRect(0,0,512,512);
                
            }
        });
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
        
        stage.show();
    }
    
}
