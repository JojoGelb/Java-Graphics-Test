/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublePendulum;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 *
 * @author jordy
 */
public class pendule {
    private float r1,r2,m1,m2,a1,a2,x1,y1,x2,y2;

    public pendule(float r1, float r2, float m1, float m2) {
        this.r1 = r1;
        this.r2 = r2;
        this.m1 = m1;
        this.m2 = m2;
        this.a1 = (float) (PI/4);
        this.a2 = (float) (PI/8);
        update();
        
    }
    
    public void update(){
        x1 = r1*(float)sin(a1);
        y1 = r1*(float)cos(a1);
        
        x2 = x1+ r2*(float)sin(a2);
        y2 = y1+ r2*(float)cos(a2);

        a1+=0.1;
        a2-=0.1;
    }
    
    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
            
        g2.setStroke(new BasicStroke(2));
        
        g2.drawLine(0, 0, (int)x1, (int)y1);
        g2.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        g2.setStroke(new BasicStroke(15));
        g2.drawOval((int)x1-(int)m1/2, (int)y1,(int) m1, (int)m1);
        g2.fillOval((int)x1-(int)m1/2, (int)y1,(int) m1, (int)m1);
        
        g2.drawOval((int)x2-(int)m2/2, (int)y2,(int) m2, (int)m2);
        g2.fillOval((int)x2-(int)m2/2, (int)y2,(int) m2, (int)m2);
    }
}
