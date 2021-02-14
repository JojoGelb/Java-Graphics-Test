/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbre;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

/**
 *
 * @author jordy
 */
public class ThickerTree extends Tree{


    public ThickerTree(Graphics g,int x, int y, double angle,int nbBranche,double len,int thick) {
        super(g, x, y, angle, nbBranche, len, thick);
        System.out.println(longeur);
        
        this.render(g);
        
        
        
    }
    
    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        if (nbBranche != 0) {
            int x2 = x + (int)(Math.cos(Math.toRadians(angle))* longeur *10);
            int y2 = y + (int)(Math.sin(Math.toRadians(angle)) * longeur *10);
            BasicStroke st = new BasicStroke(thick);
            
            g2.setStroke(st);
            
            
            g2.drawLine(x, y, x2, y2);
            ThickerTree b = new ThickerTree(g,x2, y2, angle - 20,nbBranche-1, longeur -1,(int)(thick*0.67));
            //ThickerTree bra = new ThickerTree(g,x2, y2, angle , length -1,(int)(thick*0.67));
            ThickerTree br = new ThickerTree(g,x2, y2, angle + 20,nbBranche-1, longeur -1,(int)(thick*0.67));
        }
    }
    
    
    
}
