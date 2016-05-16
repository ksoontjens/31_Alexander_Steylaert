package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener{

    private XletContext actueleXletContext;
    private HScene scene;
    private HScene confirmation;
    private boolean debug=true;
    
    Color geel = new Color(255,255,51,200);
    
    
    HTextButton option1;
    HTextButton option2;
    HTextButton option3;
    HTextButton option4;
    HTextButton blanco;
    HStaticText title;
    HStaticText confirmationtxt;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
      if(debug) System.out.println("Xlet Initialize");
      this.actueleXletContext = context;
      
      //template aanmaken
     HSceneTemplate sceneTemplate = new HSceneTemplate();
     
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
             new HScreenDimension(1.0f, 2.0f), HSceneTemplate.REQUIRED);
     /*
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, 
             new HScreenDimension(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      */
     
     scene=HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
                                        // ( X, Y, W, H )
        //title
        title=new HStaticText("Choose your next president", 0, 30, 720, 50);
        title.setBackground(Color.LIGHT_GRAY);
        title.setBackgroundMode(HVisible.NO_BACKGROUND_FILL);
        
        //buttons + images
        option1=new HTextButton("Batman",10,400,160,40);
        
        option2=new HTextButton("A. Lien",180,400,160,40);
        
        option3=new HTextButton("J. Bravo",360,400,160,40);
        
        option4=new HTextButton("S. Verhulst",540,400,160,40);
        
        blanco=new HTextButton("Blanco", 300, 500, 120, 50);
        
        //set properties for buttons
        HTextButton[] button = {option1,option2,option3,option4,blanco};
        for (int i = 0; i < button.length; i++) {
         button[i].setBackground(geel);
         button[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
         button[i].setBordersEnabled(false);
         button[i].setForeground(Color.BLACK);
      }
        
        option1.setFocusTraversal(option1, blanco, option4, option2);
        option2.setFocusTraversal(option2, blanco, option1, option3);
        option3.setFocusTraversal(option3, blanco, option2, option4);
        option4.setFocusTraversal(option4, blanco, option3, option1);
        blanco.setFocusTraversal(option1, null, null, null);
        
        option1.setActionCommand("1");
        option1.addHActionListener(this);
        option2.setActionCommand("2");
        option2.addHActionListener(this);
        option3.setActionCommand("3");
        option3.addHActionListener(this);
        option4.setActionCommand("4");
        option4.addHActionListener(this);
        blanco.setActionCommand("blanco");
        blanco.addHActionListener(this);
        
        scene.add(title);   scene.add(option1);
        scene.add(option2); scene.add(option3);
        scene.add(option4); scene.add(blanco);
        
        scene.validate();
        //comfirmation.validate();
        
        
        scene.setVisible(true);
        
        option1.requestFocus();

        
        
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    

    public void actionPerformed(ActionEvent arg0) {
        
        System.out.println(arg0.getActionCommand());
        
        scene.remove(option1); scene.remove(option2);
        scene.remove(option3); scene.remove(option4);
        scene.remove(title);
        
        
        
        /*confirmationtxt=new HStaticText("You chose:", 0, 30, 720, 50);
        confirmationtxt.setBackground(Color.LIGHT_GRAY);
        confirmationtxt.setBackgroundMode(HVisible.NO_BACKGROUND_FILL);
            //blanco.setTextContent("Verify", 1);
            scene.add(confirmationtxt);*/
            
            
            scene.repaint();
            //blanco.requestFocus();
        
         
        }
      
}
