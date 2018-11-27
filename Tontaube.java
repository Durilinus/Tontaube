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
public abstract class Tontaube {
    
    private static int dieAnzahlTontauben;
    protected int dieGroesse;
    protected int xPos;
    protected int yPos;
    protected boolean sichtbar;
    
    
    
    public Tontaube(){
        
    }
    
        public int gibAnzahlTontauben(){
            return dieAnzahlTontauben;       
        }
    
        public int gibGroesse(){
            return dieGroesse;
        }
    
        public void setzeSichtbar(boolean pWert){
            sichtbar = pWert;
        }
    
        public boolean gibSichtbar(){
            return sichtbar;
        }
        
        public void neueTontaube(){
            dieAnzahlTontauben++;
        }
        
        public void getroffeneTontaube(){
            dieAnzahlTontauben--;
        }
        
        public int gibX(){
            return xPos;
        }
        
        public int gibY(){
            return yPos;
        }
        
        public abstract void berechnePosition();
        
        public abstract void bewege();
            
        
    
    
    
}