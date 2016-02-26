/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pewpewgame.objects;

/**
 *
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
