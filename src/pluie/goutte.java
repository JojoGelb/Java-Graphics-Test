/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluie;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author jordy
 */
public class goutte {
    private float x;
    private float y;
    private float z;
    private float ySpeed;
    private ecran e;
    private float taille;

    public goutte(ecran e) {
        this.e = e;
        x = randomInt(0, e.getFenetre().getWidth()+1);
        y = randomInt(-500, -50);
        z = randomInt(0, 20);
        this.taille = map(z,0,20,10,20);
        ySpeed = map(z,0,20,1,20);
    }
    
    
    
    public void update(){
        y = y+ ySpeed;
        float gravity = map(z,0,20,0,(float)0.2);
        ySpeed =  ySpeed + gravity;
        if(y> e.getFenetre().getHeight()){
            y = randomInt(-200, -100);
            ySpeed = map(z,0,20,1,20);
        }
    }
    
    public void show(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.BLUE);
        float epaisseur = map(z,0,20,1,3);
        g2.setStroke(new BasicStroke(epaisseur));
        g2.drawLine((int)x,(int) y,(int) x, (int)y + (int)taille);
        
    }
    
    public int randomInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }
    
    public float map(float value,float start1, float stop1, float start2, float stop2) {
        float outgoing = start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
        return outgoing;
    }
}
