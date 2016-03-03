/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.controllers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * For controlling the UI text in the game.
 * @author max
 */
public class TextController {
    
    private String scoreText;
    private String healthText;
    private String loseText;
    private String restartText;
    private GameController gameC;
    /**
     * Needs the GameController for information.
     * @param gameC the GameController.
     */
    public TextController(GameController gameC) {
        this.gameC = gameC;
        this.scoreText = "SCORE: " + gameC.getScore();
        this.loseText = "YOU ARE DEAD";
        this.healthText = "HEALTH: " + gameC.getPlayer().getHp();
        this.restartText =  "Press R to reset";
    }
    /**
     * Updates the strings of the score and health texts.
     * The Renderer handles rendering the text from the Strings
     * in this class.
     */
    public void updateTexts() {
        this.scoreText = "SCORE: " + gameC.getScore();
        this.healthText = "HEALTH: " + gameC.getPlayer().getHp();
    }

    public String getScoreText() {
        return scoreText;
    }

    public void setScoreText(String scoreText) {
        this.scoreText = scoreText;
    }

    public String getHealthText() {
        return healthText;
    }

    public void setHealthText(String healthText) {
        this.healthText = healthText;
    }

    public String getLoseText() {
        return loseText;
    }

    public void setLoseText(String loseText) {
        this.loseText = loseText;
    }

    public String getRestartText() {
        return restartText;
    }

    public void setRestartText(String restartText) {
        this.restartText = restartText;
    }

    public GameController getGameC() {
        return gameC;
    }

    public void setGameC(GameController gameC) {
        this.gameC = gameC;
    }
    
    
}
