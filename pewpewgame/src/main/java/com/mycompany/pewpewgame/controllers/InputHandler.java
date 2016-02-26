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
    
    public InputHandler(GameController g) {
        this.gameC = g;
    }
    
    public void registerInputs(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    if (!input.contains(code)) {
                        input.add(code);
                    }                        
                }
            }); 
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent e) {
                    String code = e.getCode().toString();
                    input.remove(code);
                }
            });
    }
    
    public void handleInputs(Player player) {
        if (player.getHp() <= 0) {
            if (input.contains("R")) {
                gameC.reset();
            }   
            if (input.contains("ESCAPE")) {
                System.exit(0);
            }
            return;
        }        
        if (input.contains("LEFT")) {
            player.getOrientation().current = "LEFT";
            player.move(player.getOrientation());
        }
        if (input.contains("RIGHT")) {
            player.getOrientation().current = "RIGHT";
            player.move(player.getOrientation());
        }
        if (input.contains("UP")) {
            player.getOrientation().current = "UP";
            player.move(player.getOrientation());
        }
        if (input.contains("DOWN")) {
            player.getOrientation().current = "DOWN";
            player.move(player.getOrientation());
        }
        if (input.contains("SPACE")) {
            gameC.spawnBullet(player.getPosX() + 6, player.getPosY() - 6, player.getOrientation());
            input.remove("SPACE");
        }
        if (input.contains("R")) {
            gameC.reset();
        }
        if (input.contains("ESCAPE")) {
            System.exit(0);
        }
    }
    
}
