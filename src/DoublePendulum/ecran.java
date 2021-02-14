/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublePendulum;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jordy
 */
public class ecran extends JPanel{

    private JFrame fenetre;
    private pendule p;
    
    
    public ecran() {
        fenetre = new JFrame();
        fenetre.setSize(1200,900);
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-fenetre.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-fenetre.getSize().height)/2);
        fenetre.setTitle("Pendule démon");
        
        fenetre.setContentPane(this);
        this.setBackground(Color.BLACK);
        
        
        
        fenetre.setVisible(true);
        p = new pendule(200, 200, 10, 10);
        double time = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis()> time + 20){
                repaint();
                p.update();
                time = System.currentTimeMillis();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        g.translate(500, 200);
        
        p.render(g);
        
    }
    
    

    public JFrame getFenetre() {
        return fenetre;
    }
   
    
    
    
}
