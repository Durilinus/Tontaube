/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendykjanniktontauben;

import java.awt.Graphics;

/**
 *
 * @author Jannik.Mendyk
 */
public class Fadenkreuz {
    
    private Oberflaeche Of;
    
    private static int rFK = 10;
    private int x;
    private int y;   
    
    public Fadenkreuz(Oberflaeche O){
        Of = O;
       
    }
   
    
    public int gibRadius(){
        return rFK;
    }
    
    public void setX(){
        x = Of.gibXFK();
    }
    
    public void setY(){
        y = Of.gibYFK();
    }
    
    public int gibXFK(){
        return x;
    }
    
    public int gibYFK(){
        return y;
    }
    
    public void zeichnen(Graphics g){
        g.drawRoundRect(x, y, rFK*2, rFK*2, rFK*2, rFK*2);
        g.drawLine(x+rFK, y-5, x+rFK, (y+(rFK*2))+5);
        g.drawLine(x-5, y+rFK, (x+(rFK*2))+5, y+rFK);
        
    }
    
}