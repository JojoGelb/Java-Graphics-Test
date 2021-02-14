/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbre;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

/**
 *
 * @author jordy
 */
public class RandomTree extends Tree {
    
    private int r;
    
    public RandomTree(Graphics g,int x, int y, double angle,int nbBranche,double len,int thick) {
        
        super(g, x, y, angle,nbBranche, len, thick);
        
        r= randomInt(1, 5);
        
        
        this.render(g);
           
    }
    
    @Override
    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if (nbBranche != 0) {
            int x2 = x + (int)(Math.cos(Math.toRadians(angle))* longeur *10);
            int y2 = y + (int)(Math.sin(Math.toRadians(angle)) * longeur *10);
            BasicStroke st = new BasicStroke(thick);
            
            
            g2.setStroke(st);
            
            
            g2.drawLine(x, y, x2, y2);
            
            switch(r){
                case 1 :
                    RandomTree b = new RandomTree(g,x2, y2, angle,nbBranche-1, longeur -1,thick-1);
                    break;
                case 2:
                    RandomTree c = new RandomTree(g,x2, y2, angle- randomInt(10,60),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree bra = new RandomTree(g,x2, y2, angle + randomInt(10,60),nbBranche-1, longeur -1,(int)(thick*0.67));
                    break;
                case 3 :
                    RandomTree ba = new RandomTree(g,x2, y2, angle -randomInt(20,60),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree brza = new RandomTree(g,x2, y2, angle + randomInt(20,60),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree br = new RandomTree(g,x2, y2, angle,nbBranche-1, longeur -1,(int)(thick*0.67));
                    break;
                case 4:
                    RandomTree t = new RandomTree(g,x2, y2, angle -randomInt(40,70),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree tt = new RandomTree(g,x2, y2, angle + randomInt(40,70),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree ttt = new RandomTree(g,x2, y2, angle-randomInt(10,35),nbBranche-1, longeur -1,(int)(thick*0.67));
                    RandomTree tttt = new RandomTree(g,x2, y2, angle+randomInt(10,35),nbBranche-1, longeur -1,(int)(thick*0.67));
                
            }
            
        }
    }
    
    
}
