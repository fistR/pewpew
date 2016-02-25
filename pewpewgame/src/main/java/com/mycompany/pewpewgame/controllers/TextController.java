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
 *
 * @author max
 */
public class TextController {
    
    public void updateTexts(int score, int hp, GraphicsContext gc){
        Font font = Font.font(16);
        gc.setFont(font);
        gc.setLineWidth(3);
        gc.fillText("SCORE: " + score, 8, 16);
        gc.fillText("HEALTH: " + hp, 8, 32);
        
        if(hp<1){
            gc.setFill(Color.RED);
            font= Font.font(36);
            gc.setFont(font);
            gc.fillText("YOU ARE DEAD", 120,230);
            font = Font.font(16);
            gc.setFont(font);
            gc.fillText("Press R to reset", 180, 280);
        }
    }
}
