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
   
    double sin = Math.sin(xPos)/4;
    int sini = (int) sin;
    
    @Override
    public void berechnePosition() {
        
    }
    
    public void bewege(){
        xPos = xPos + sini;
        yPos = yPos + sini*6;
        
    }
    
    
}
