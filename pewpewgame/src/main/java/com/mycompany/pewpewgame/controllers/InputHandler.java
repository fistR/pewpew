/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.controllers.GameController;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import com.mycompany.pewpewgame.objects.Player;

/**
 *
 * @author max
 */
public class InputHandler {
    
    GameController gameC;
    ArrayList<String> input = new ArrayList<String>();
    
    public InputHandler(GameController g){
        this.gameC = g;
    }
    
    public void registerInputs(Scene scene){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
 
                    
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });
 
        scene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });
    }
    
    public void handleInputs(Player player){
        
        if(input.contains("LEFT")){
            player.setPosX(player.getPosX() - 1);
            player.orientation.current = "LEFT";
        }
        if(input.contains("RIGHT")){
            player.setPosX(player.getPosX() + 1);
            player.orientation.current = "RIGHT";
        }
        if(input.contains("UP")){
            player.setPosY(player.getPosY() - 1);
            player.orientation.current = "UP";
        }
        if(input.contains("DOWN")){
            player.setPosY(player.getPosY() + 1);
            player.orientation.current = "DOWN";
        }
        if(input.contains("SPACE")){
            gameC.spawnBullet(player.getPosX(), player.getPosY(), player.orientation);
            input.remove("SPACE");
        }
    }
    
}
