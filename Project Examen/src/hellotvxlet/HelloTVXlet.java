package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener{

    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    String vote;
    
    Color geel = new Color(255,255,51,200);
    
    HTextButton option1, option2, option3, option4;
    HTextButton blanco, confirm, goback;
    HStaticText title, confirmTitle;
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
      if(debug) System.out.println("Xlet Initialize");
      this.actueleXletContext = context;
      
      //template aanmaken
     HSceneTemplate sceneTemplate = new HSceneTemplate();
     
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
             new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
     
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
        
        option2=new HTextButton("A. Lien",190,400,160,40);
        
        option3=new HTextButton("J. Bravo",370,400,160,40);
        
        option4=new HTextButton("S. Verhulst",550,400,160,40);
        
        blanco=new HTextButton("Blanco", 300, 500, 120, 50);
        
        confirm=new HTextButton("Confirm", 180, 500, 120, 50);
        
        goback=new HTextButton("Cancel", 300, 500, 120, 50);
        
        //set properties for buttons
        HTextButton[] button = {option1,option2,option3,option4,blanco,confirm,goback};
        for (int i = 0; i < button.length; i++) {
         button[i].setBackground(geel);
         button[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
         button[i].setBordersEnabled(false);
         button[i].setForeground(Color.BLACK);
         button[i].setActionCommand(button[i].getTextContent(HState.DISABLED_STATE));
         button[i].addHActionListener(this);
      }
        confirm.setBackground(Color.GREEN);
        goback.setBackground(Color.RED);
        
        //Focustraversals
        option1.setFocusTraversal(null, blanco, option4, option2);
        option2.setFocusTraversal(null, blanco, option1, option3);
        option3.setFocusTraversal(null, blanco, option2, option4);
        option4.setFocusTraversal(null, blanco, option3, option1);
        blanco.setFocusTraversal(option1, null, null, null);
        confirm.setFocusTraversal(null, null, null, goback);
        goback.setFocusTraversal(null, null, confirm, null);
        
        scene.add(title);   scene.add(option1);
        scene.add(option2); scene.add(option3);
        scene.add(option4); scene.add(blanco);
        
        scene.validate();
        scene.setVisible(true);
        
        option1.requestFocus();
        
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    

    public void actionPerformed(ActionEvent arg0) {
        
        System.out.println(arg0.getActionCommand());
        
        if(arg0.getActionCommand() == confirm.getTextContent(HState.DISABLED_STATE))
        {
            System.out.println("Voted for: "+vote);
            scene.removeAll();
            confirmTitle.setTextContent("Thank you for voting!", HState.NORMAL_STATE);
            scene.add(confirmTitle);
            scene.validate();
            scene.repaint();
            
            //whiteHouse.sendVote(vote);
        }
        else if (arg0.getActionCommand() == goback.getTextContent(HState.DISABLED_STATE)){
            scene.removeAll();
            scene.repaint();
            startXlet();
        }
        else {
            vote=arg0.getActionCommand();
            
            confirmTitle=new HStaticText("You chose "+arg0.getActionCommand()+", are you sure?" , 0, 30, 720, 50);
            confirmTitle.setBackground(Color.LIGHT_GRAY);
            confirmTitle.setBackgroundMode(HVisible.NO_BACKGROUND_FILL);


            scene.removeAll();

            System.out.println("hoi");

            scene.add(confirmTitle);
            scene.add(confirm); scene.add(goback);

            scene.validate();
            scene.repaint();

            confirm.requestFocus();
        }
         
        }
      
}
