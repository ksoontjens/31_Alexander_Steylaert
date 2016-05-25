/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;
import java.awt.*;
import org.havi.ui.*;

/**
 *
 * @author student
 */
public class InterfaceDrawer extends HComponent {
    Image img1, img2, img3, img4;
    
    
    public InterfaceDrawer()
    {
        this.setBounds(0,0,720,56);
        img1 = this.getToolkit().getImage("project/batman.png");
        img2 = this.getToolkit().getImage("project/alien.png");
        img3 = this.getToolkit().getImage("project/johnney bravo.png");
        img4 = this.getToolkit().getImage("project/samson.png");
        
        //images: C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        
        MediaTracker mt = new MediaTracker(this);
        
        mt.addImage(img1, 0);
        mt.addImage(img2, 1);
        mt.addImage(img3, 2);
        mt.addImage(img4, 3);
        
        
        //this.repaint();
        
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            
        }
        
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(img1, 10, 160, null);
        g.drawImage(img2, 190, 160, null);
        g.drawImage(img3, 370, 160, null);
        g.drawImage(img4, 550, 160, null);
    }
    
    
    
}
