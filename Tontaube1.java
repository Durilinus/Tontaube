/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendykjanniktontauben;

/**
 *
 * @author Jannik.Mendyk
 */
public class Tontaube1 extends Tontaube{
   
    int groesse = 30;
    double PI = Math.PI;
    
    //int xstart = 0;   
    //int ystart = 150;
    
    public Tontaube1(){
        
    }
    
    @Override
    public void berechnePosition() {
        
    }
    
    public void bewege(){
        PI+= Math.PI/2;
        xPos++;
        yPos = (int) (Math.sin(xPos)*15);
        System.out.println(xPos);
        System.out.println(yPos);
    }
    
    
}