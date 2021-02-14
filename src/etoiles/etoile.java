package etoiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author jordy
 */
public class etoile {
    private float x;
    private float y;
    private float z;
    
    private int temp = 0;
    
    private float pz;
    
    private int width,heigth;

    public etoile(ecran e) {

        width = (e.getFenetre().getWidth()+1);
        heigth = (e.getFenetre().getHeight()+1);
        this.x = randomInt(-width, width);
        this.y = randomInt(-heigth, heigth);
        this.z = randomInt(0, width*2);
        pz = z;
    }
    
    public void update(){
       z = z-10;
       if(z<1){
           z = width*2;
           this.x = randomInt(-width, width);
        this.y = randomInt(-heigth, heigth);
       }
       pz = z;
    }
    
    public void show(Graphics g){
        g.setColor(Color.WHITE);
        
        float sx = map(x/z,0,1,0,width);
        float sy = map(y/z,0,1,0,heigth);
        
        float r = map(z,0,width,16,0);
        
        g.fillOval((int)sx,(int) sy, (int)r, (int)r);
        
        float px = map(x/pz,0,1,0,width);
        float py = map(y/pz,0,1,0,heigth);

        g.drawLine((int)px,(int) py,(int)sx,(int) sy);

    }
    
    public float map(float value,float start1, float stop1, float start2, float stop2) {
        float outgoing = start2 + (stop2 - start2) * ((value - start1) / (stop1 - start1));
        return outgoing;
    }
    
        //Genere un int au hazard
    public int randomInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

    
    
}
