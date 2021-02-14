/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pluie;

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
    private goutte[] gou = new goutte[500];

    public ecran() {
        fenetre = new JFrame();
        fenetre.setSize(640,360);
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-fenetre.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-fenetre.getSize().height)/2);
        fenetre.setTitle("pluie");
        
        fenetre.setContentPane(this);
        
        this.setBackground(new Color(230,230,250));
        
        for(int i = 0; i<gou.length; i++){
            gou[i] = new goutte(this);
        }
        
        fenetre.setVisible(true);
        double time = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis()> time + 15){
                repaint();
                time = System.currentTimeMillis();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i<gou.length; i++){
            gou[i].update();
            gou[i].show(g);
        }
    }
    
    

    public JFrame getFenetre() {
        return fenetre;
    }
    
    
    
}
