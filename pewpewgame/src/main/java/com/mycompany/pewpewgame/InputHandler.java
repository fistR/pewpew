/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author max
 */
public class InputHandler {
    
    ArrayList<String> input = new ArrayList<String>();
    
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
    
    public void handleInputs(Scene scene){
        
    }
    
}
