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
 * This class is used to handle player input.
 *
 * @author max
 */
public class InputHandler {

    GameController gameC;
    ArrayList<String> input = new ArrayList<String>();

    public InputHandler(GameController g) {
        this.gameC = g;
    }

    /**
     * The scene methods give KeyEvents that we register here. To get smooth
     * movement, we add the input keycode to a string array, and remove it when
     * the key is released.
     *
     * @param scene The game scene.
     */
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

    /**
     * This method deals with what happens if specific keys are pressed. The
     * arrow keys change the direction and move the player forward. Spacebar is
     * used to fire. If held down, it fires once, waits a second and then
     * rapidfire. Rarely useful feature. ESC to exit and R to restart.
     *
     * @param player The player object.
     */
    public void handleInputs(Player player) {
        if (player.getHp() > 0) {
            handleAliveInputs(player);
        }
        handleAlwaysInputs(player);
    }

    private void handleAliveInputs(Player player) {
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
    }

    private void handleAlwaysInputs(Player player) {
        if (input.contains("R")) {
            gameC.reset();
        }
        if (input.contains("ESCAPE")) {
            System.exit(0);
        }
    }

}
