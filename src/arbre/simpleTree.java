/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbre;

import java.awt.Graphics;

/**
 *
 * @author jordy
 */
public class simpleTree extends Tree{
    

    public simpleTree(Graphics g,int x, int y,double angle,int nbBranche,double len) {
        super(g, x, y, angle, nbBranche, len, 1);

        this.render(g);
        
    }
    
    public void generateTree(){
        
    }
    
    public void render(Graphics g){
        if (nbBranche != 0) {
            int x2 = x + (int)(Math.cos(Math.toRadians(angle))* longeur *10);
            int y2 = y + (int)(Math.sin(Math.toRadians(angle)) * longeur *10);
            
            g.drawLine(x, y, x2, y2);
            simpleTree b = new simpleTree(g,x2, y2, angle - 20,nbBranche-1, longeur -1);
            simpleTree br = new simpleTree(g,x2, y2, angle + 20,nbBranche-1, longeur -1);
        }
    }
    
    
    
}
