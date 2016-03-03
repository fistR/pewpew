/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

/**
 * The Orientation class exists to
 * provide easy calculations for which direction
 * GameObjects move.
 * @author max
 */
public class Orientation {
    
    public String current;
    
    public Orientation(String str) {        
        this.current = str;        
    }
    
    public void setOrientation(String orientation) {
        this.current = orientation;
    }
    
    public String getOrientation() {
        return this.current;
    }
    /**
     * Converting the direction to degrees 
     * applicable to the JavaFX instance.
     * @return 
     */
    public int getRotationInDegrees() {
        if (this.current.equals("LEFT")) {
            return 90;
        } else if (this.current.equals("RIGHT")) {
            return 270;
        } else if (this.current.equals("DOWN")) {
            return 0;
        } else if (this.current.equals("UP")) {
            return 180;
        }
        return 0;
    }
}
