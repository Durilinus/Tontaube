/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mendykjanniktontauben;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Random;

/**
 *
 * @author Jannik.Mendyk
 */
public class Steuerung {
    Tontaube[] dieTontaube = new Tontaube[10];
    Tontaube1 Tontaube1 = new Tontaube1();
    private Oberflaeche o;
    private int zustand;
    private int anzahlTreffer;
    public Random zufall = new Random();
    private int aP = 0;
    
    public Steuerung(Oberflaeche Of){
        o = Of;
        Timer3.start();
    }
    
    private final Timer Timer = new Timer(10000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {

                verarbeiteTick();                
        }     
    });
    
    private final Timer Timer2 = new Timer(300, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            tick();     

        }     
    });
    
    
    private final Timer Timer3 = new Timer(1, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            o.aktualisiereOberflaeche();

        }     
    });

    
    public void starteSpiel(){
        Timer.start();
        Timer2.start();
    }
    
    public void tick(){      
        o.aktualisiereOberflaeche();         
        for(int i=0; i < Tontaube1.gibAnzahlTontauben(); i++){
            dieTontaube[i].bewege();
        }   
        System.out.println("anzahl: "+Tontaube1.gibAnzahlTontauben());
    }

    
    public void verarbeiteTick(){ 
        System.out.println("10erTick");
      while(Tontaube1.gibAnzahlTontauben()< 10){
                
            switch(zufall.nextInt(3)){           
        
                case 0: dieTontaube[Tontaube1.gibAnzahlTontauben()] = new Tontaube1();
                        dieTontaube[Tontaube1.gibAnzahlTontauben()].setzeSichtbar(true);
                    break;
                case 1: dieTontaube[Tontaube1.gibAnzahlTontauben()] = new Tontaube2();
                        dieTontaube[Tontaube1.gibAnzahlTontauben()].setzeSichtbar(true);
                    break;
                case 2: dieTontaube[Tontaube1.gibAnzahlTontauben()] = new Tontaube3();
                        dieTontaube[Tontaube1.gibAnzahlTontauben()].setzeSichtbar(true);
                    break;
            }
            for(int naechsteTt = 0; naechsteTt <= Tontaube1.gibAnzahlTontauben(); naechsteTt++){
            dieTontaube[naechsteTt].berechnePosition();
            }
            Tontaube1.neueTontaube();
            break;
        
      }
      o.aktualisiereOberflaeche();
    }
    
    public void zeichneAlleTt(Graphics g){      
        for(int T = 0; T < Tontaube1.gibAnzahlTontauben(); T++){
            if(dieTontaube[T].gibSichtbar() == true){
               int xPosTt = dieTontaube[T].gibX();
               int yPosTt = dieTontaube[T].gibY();
               int groesse = dieTontaube[T].gibGroesse();
               g.drawRect(xPosTt, yPosTt+150, 15, 15);           
            }   
        }    
    }    
    
    public void feuer(int fx,int fy){
            for(int z = 0; z < Tontaube1.gibAnzahlTontauben();z++){
                if(fx == dieTontaube[z].xPos && fy == dieTontaube[z].yPos){
                    dieTontaube[z].setzeSichtbar(false);
                    anzahlTreffer++;
                    Tontaube1.getroffeneTontaube();
                    System.out.println("getroffen");
                }
            }
            System.out.println(fx+"-"+fy);
    }
    
    public boolean pruefeObGetroffen(){
        return true;
    }
    
    
    
}
