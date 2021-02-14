/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbre;

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
    private simpleTree b;
    private ThickerTree T;
    private RandomTree Rt;
    
    
    public ecran() {
        fenetre = new JFrame();
        fenetre.setSize(1200,900);
        fenetre.setResizable(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-fenetre.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-fenetre.getSize().height)/2);
        fenetre.setTitle("Arbre");
        
        fenetre.setContentPane(this);
        this.setBackground(Color.BLACK);
        
        
        
        fenetre.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        g.translate(600, 800);
        b = new simpleTree(g,0, -200, -90,10, 5);
        T = new ThickerTree(g,-400,0,-90,10,6,20);
        Rt = new RandomTree(g, 400, 0, -90, 9, 7, 20);
        

        
        
        
    }
    
    

    public JFrame getFenetre() {
        return fenetre;
    }
   
    
    
    
}
