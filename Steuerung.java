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
    }
    
    private final Timer Timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            tick();
            aP++;

            if(aP == 10){
                verarbeiteTick();
                aP = 0;
            }
                       
        }     
    });
    

    
    public void starteSpiel(){
        Timer.start();
    }
    
    public void tick(){
        System.out.println("tick");
       o.aktualisiereOberflaeche(); 
    }
    
    public void verarbeiteTick(){ 
        System.out.println("10erTick");
      while(Tontaube1.gibAnzahlTontauben()<10){
          
        for(int naechsteTt = 0; naechsteTt < 10; naechsteTt++){
            
            switch(zufall.nextInt(3)){           
        
                case 0: dieTontaube[naechsteTt] = new Tontaube1();
                        dieTontaube[naechsteTt].setzeSichtbar(true);
                    break;
                case 1: dieTontaube[naechsteTt] = new Tontaube2();
                        dieTontaube[naechsteTt].setzeSichtbar(true);
                    break;
                case 2: dieTontaube[naechsteTt] = new Tontaube3();
                        dieTontaube[naechsteTt].setzeSichtbar(true);
                    break;
            }
            dieTontaube[naechsteTt].berechnePosition();
            Tontaube1.neueTontaube();
            break;
        }
        break;
      }
      o.aktualisiereOberflaeche();
        System.out.println(dieTontaube[0].xPos);
    }
    
    public void zeichneAlleTt(Graphics g){      
        System.out.println("zeichnet");
        for(int T = 0; T <10; T++){
            System.out.println(dieTontaube[T].gibSichtbar());
            if(dieTontaube[T].gibSichtbar() == true){
               int xPos = dieTontaube[T].gibX();
               int yPos = dieTontaube[T].gibY();
               int groesse = dieTontaube[T].gibGroesse();
               g.drawRect(xPos, yPos, groesse, groesse);
               System.out.println(dieTontaube[T].gibX());
            }   
            break;
        }    
    }    
    
    public void feuer(int fx,int fy){
            for(int z = 0; z < Tontaube1.gibAnzahlTontauben();z++){
                if(fx == dieTontaube[z].xPos && fy == dieTontaube[z].yPos){
                    dieTontaube[z].setzeSichtbar(false);
                    anzahlTreffer++;
                    Tontaube1.getroffeneTontaube();
                }
            }
    }
    
    public boolean pruefeObGetroffen(){
        return true;
    }
    
    
    
}
