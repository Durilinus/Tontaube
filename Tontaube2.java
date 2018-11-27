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
public class Tontaube2 extends Tontaube{
    
    double PI = Math.PI;

    //int xstart = 0;   
    //int ystart = 150;
    
    public Tontaube2(){

    }

    @Override
    public void berechnePosition() {
        
    }

    @Override
    public void bewege() {
        PI+= Math.PI/2;
        xPos++;
        yPos = (int) (Math.sin(xPos)*15);
        System.out.println(xPos);
        System.out.println(yPos);
        
    }
    
}

