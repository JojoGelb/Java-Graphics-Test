/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbre;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jordy
 */
public abstract class Tree {
    protected int x,y;
    protected double angle,longeur;
    protected int thick;
    protected int nbBranche;
    
    protected ArrayList<Branche> arbre = new ArrayList<>();

    public Tree(Graphics g,int x, int y, double angle,int nbBranche, double longeur, int thick ) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.longeur = longeur;
        this.thick = thick;
        this.nbBranche = nbBranche;
        
        if(thick == 0){
            this.thick = 1;
        }
        if(longeur <= 0){
            this.longeur =1;
        }
        
    }
    
    public abstract void render(Graphics g);
    
    public int randomInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
       return nb;
    }
    
    
}
