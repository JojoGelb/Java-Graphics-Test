package etoiles;

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
    private etoile[] etoiles = new etoile[400];
    public ecran() {
        fenetre = new JFrame();
        fenetre.setSize(800,800);
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-fenetre.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-fenetre.getSize().height)/2);
        fenetre.setTitle("étoiles");
        
        fenetre.setContentPane(this);
        this.setBackground(Color.BLACK);
        
        for(int i =0; i<etoiles.length; i++){
            etoiles[i] = new etoile(this);
        }
        
        fenetre.setVisible(true);
        double time = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis()> time + 10){
                repaint();
                time = System.currentTimeMillis();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(this.fenetre.getWidth()/2, this.fenetre.getHeight()/2);
        
        for(int i =0; i<etoiles.length; i++){
            etoiles[i].update();
            etoiles[i].show(g);
        }
    }
    
    

    public JFrame getFenetre() {
        return fenetre;
    }
    
    
    
}
