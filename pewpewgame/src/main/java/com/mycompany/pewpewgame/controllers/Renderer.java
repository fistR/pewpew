/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import com.mycompany.pewpewgame.objects.Bullet;
import com.mycompany.pewpewgame.objects.GameObject;
import com.mycompany.pewpewgame.objects.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The Renderer class handles the Graphical
 * representation of the gamestate.
 * @author max
 */
public class Renderer {
    
    private GraphicsContext gc;
    private GameController gameC;
    /**
     * The renderer needs the GraphicsContext
     * for controlling what is displayed and
     * the GameController to get the state of 
     * the game logic.
     * @param gc the GraphicsContext.
     * @param gameC the GameControler.
     */   
    public Renderer(GraphicsContext gc, GameController gameC) {
        this.gc = gc;
        this.gameC = gameC;
    }
    /**
     * Draws all the existing GameObjects
     * on their position and direction in 
     * the current game state.
     * @param plr
     * @param player 
     */
    public void renderAll(ImageView plr, Player player) {
        renderPlayer(plr, player);
        renderBullets();
        renderEnemies();
        renderTexts();
    }
    /**
     * Refreshes and clears the canvas.
     * This means clearing the last picture and
     * redrawing only the background.
     */
    public void refreshCanvas() {
        gc.setFill(Color.DARKSLATEBLUE);
        gc.fillRect(0, 0, 512, 512);
        gc.setFill(Color.WHITE);
    }
    
    private void renderPlayer(ImageView plr, Player player) {
        if (player.getHp() <= 0) {
            plr.setImage(null);
        } else {
            plr.setImage(player.getImg());
            plr.setRotate(player.getOrientation().getRotationInDegrees());
            plr.setX(player.getPosX());
            plr.setY(player.getPosY() - 16);
        }
    }
    
    private void renderBullets() {
        for (Bullet b : gameC.getBullets()) {
            gc.fillText(".", b.getPosX(), b.getPosY());
        }
    }
    
    private void renderEnemies() {
        for (GameObject e : gameC.getEnemyC().getEnemies()) {
            Font font = Font.font(16);
            gc.setFont(font);
            gc.setFill(Color.IVORY);
            gc.fillText("☹", e.getPosX(), e.getPosY());
            gc.setFill(Color.WHITE);
        }
        
    }
    
    private void renderTexts() {
        Font font = Font.font(16);
        gc.setFont(font);
        gc.setLineWidth(3);
        gc.fillText(gameC.getTextController().getScoreText(), 8, 16);
        gc.fillText(gameC.getTextController().getHealthText(), 8, 32);
        
        if (gameC.getPlayer().getHp() < 1) {
            gc.setFill(Color.RED);
            font = Font.font(36);
            gc.setFont(font);
            gc.fillText(gameC.getTextController().getLoseText(), 120, 230);
            font = Font.font(16);
            gc.setFont(font);
            gc.fillText(gameC.getTextController().getRestartText(), 180, 280);
        }
    }    
}
