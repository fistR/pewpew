package com.mycompany.pewpewgame;
import com.mycompany.pewpewgame.objects.Player;
import com.mycompany.pewpewgame.controllers.InputHandler;
import com.mycompany.pewpewgame.controllers.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;


/**
 *
 * @author max
 */
public class Peli extends Application{
    
    public static void main(String[] args){
        launch(args);
    }
    
    public void start(Stage stage){
        
        stage.setTitle("PewPew");
        Canvas canv = new Canvas(512,512);
        Group root = new Group();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        root.getChildren().add(canv);
        GraphicsContext gc = canv.getGraphicsContext2D();
        
        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        final long timeStart = System.currentTimeMillis();
        Player player = new Player(10);
        GameController gameC = new GameController(player, gc);
        InputHandler input = new InputHandler(gameC);
        input.registerInputs(scene);  
        ImageView plr = new ImageView();
        plr.setImage(player.getImg());
        plr.setFitWidth(16);
        plr.setFitHeight(16);
        root.getChildren().add(plr);
        
        KeyFrame kf = new KeyFrame(
        Duration.seconds(0.017),
        new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                double t = (System.currentTimeMillis() - timeStart)/1000.0;
                
                //handle the gameloop
            input.handleInputs(player);
                // Clear the canvas
            gc.setFill( Color.DARKSLATEBLUE);
            gc.fillRect(0,0, 512,512);
            gc.setFill( Color.WHITE);
            gameC.updatePlayer(plr);
            gameC.updateBullets();
            gameC.updateEnemies();
            gameC.getCc().handleCollisions();
            gameC.getTextController().updateTexts(gameC.getScore(),gameC.getPlayer().getHp(),gc);
            }
        });
        gameLoop.getKeyFrames().add(kf);
        gameLoop.play();
        
        stage.show();
    }
    
}
