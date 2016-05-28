package hellotvxlet;
import java.awt.*;
import org.havi.ui.*;

/**
 *
 * @author Alexander Steyaert & Sven Aerts
 */

public class InterfaceDrawer extends HComponent {
    private Image img1, img2, img3, img4;
    private MediaTracker mt;
    Color back = VoteMachine.blue;
    
    public InterfaceDrawer()
    {   
        img1 = this.getToolkit().getImage("project/batman.png");
        img2 = this.getToolkit().getImage("project/alien.png");
        img3 = this.getToolkit().getImage("project/johnney bravo.png");
        img4 = this.getToolkit().getImage("project/samson.png");
        
        //images: C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        
        mt = new MediaTracker(this);
        mt.addImage(img1, 0);
        mt.addImage(img2, 1);
        mt.addImage(img3, 2);
        mt.addImage(img4, 3);
        
        try {
        mt.waitForAll();
        if(VoteMachine.debug){
            System.out.println("Succes: MT");
        }
        } catch (Exception ex) {
        if(VoteMachine.debug){
            System.out.println("Error: mediatracker ("+ex.toString()+")");
        }
        }
        
        this.setBounds(0,0,720,576);
    }
    
    public void paint(Graphics g)
    {
        g.setColor(back);
        
        g.fillRoundRect (5, 200, 170, 205, 5, 5);
        g.drawImage(img1, 10,  200, null);
        
        g.fillRoundRect (185, 200, 170, 205, 5, 5);
        g.drawImage(img2, 190, 200, null);
        
        g.fillRoundRect (365, 200, 170, 205, 5, 5);
        g.drawImage(img3, 370, 200, null);
        
        g.fillRoundRect (545, 200, 170, 205, 5, 5);
        g.drawImage(img4, 550, 200, null);
        
        if(VoteMachine.debug){
            System.out.println("Succes: paint");
        }
    }
    
    
    
}
