package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.davic.resources.ResourceProxy;
import org.havi.ui.*;
import org.havi.ui.event.HActionListener;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;

public class HelloTVXlet implements Xlet, HActionListener,
                                    ResourceClient, HBackgroundImageListener {
    private HScene scene;
    private HScreen screen;
    private HBackgroundDevice bgDev;
    private HStillImageBackgroundConfiguration bgConfig;
    private HBackgroundImage bgImg;
    InterfaceDrawer imager;
    HTextLayoutManager textManager;
    private XletContext actueleXletContext;
    static boolean debug=true;
    String vote;
    
    //custom colors
    static Color purple =       new Color(100,113,194);
    static Color infoColor =    new Color(29,108,142,200);
    static Color green =        new Color(89,201,134);
    static Color blue =         new Color(86,154,184,255);
    
    //graphic elements
    HTextButton option1, option2, option3, option4;
    HTextButton blanco, confirm, goback, help;
    HStaticText title, confirmTitle, helptxt;

    public void initXlet(XletContext context) throws XletStateChangeException {
        
      if(debug) System.out.println("Xlet Initialize");
      this.actueleXletContext = context;
      
      scene = HSceneFactory.getInstance().getDefaultHScene();
      screen = HScreen.getDefaultHScreen();
      bgDev = screen.getDefaultHBackgroundDevice();
      bgDev.reserveDevice(this);
      HBackgroundConfigTemplate bgConfigTemplate = new HBackgroundConfigTemplate();
      bgConfigTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
                                     HBackgroundConfigTemplate.REQUIRED);
      try {
          bgConfig = (HStillImageBackgroundConfiguration) bgDev.getBestConfiguration(bgConfigTemplate);
          bgDev.setBackgroundConfiguration(bgConfig);
      } catch (Exception ex) {
          if(HelloTVXlet.debug){
            System.out.println("Error: background ("+ex.toString()+")");
          
      }}
      
      imager = null;
      imager = new InterfaceDrawer("hoi");
      
      
      //template aanmaken
     /*HSceneTemplate sceneTemplate = new HSceneTemplate();
     
     sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
             new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);*/
     
                                     // ( X, Y, W, H )
        //title
        title=new HStaticText("Choose your next president", 0, 30, 720, 50);
        title.setBackground(Color.LIGHT_GRAY);
        title.setBackgroundMode(HVisible.NO_BACKGROUND_FILL);
        
       // img1 = this.getToolkit().getImage("alien.jpg");
        
        //buttons + images
        option1=new HTextButton("Batman",        10, 360, 160, 40);
        
        option2=new HTextButton("A. Lien",      190, 360, 160, 40);
        
        option3=new HTextButton("J. Bravo",     370, 360, 160, 40);
        
        option4=new HTextButton("S. Verhulst",  550, 360, 160, 40);
        
        blanco=new HTextButton("blanco",        300, 500, 120, 50);
        
        confirm=new HTextButton("confirm",      180, 500, 120, 50);
        
        goback=new HTextButton("cancel",        300, 500, 120, 50);
        
        help=new HTextButton("?",               10,   10,  30, 30);
        
        //set properties for buttons
        HTextButton[] button = {option1,option2,option3,option4,blanco,confirm,goback,help};
        for (int i = 0; i < button.length; i++) {
         button[i].setBackground(purple);
         button[i].setBackgroundMode(HVisible.BACKGROUND_FILL);
         button[i].setBordersEnabled(false);
         button[i].setForeground(Color.BLACK);
         button[i].setActionCommand(button[i].getTextContent(HState.DISABLED_STATE));
         button[i].addHActionListener(this);
      }
        confirm.setBackground(green);
        help.setBackground(infoColor);
        help.setForeground(Color.WHITE);
        
        //Focustraversals
        option1.setFocusTraversal(help, blanco, option4, option2);
        option2.setFocusTraversal(help, blanco, option1, option3);
        option3.setFocusTraversal(help, blanco, option2, option4);
        option4.setFocusTraversal(help, blanco, option3, option1);
        help.setFocusTraversal(blanco, option1, option1, option4);
        
        blanco.setFocusTraversal(option1, help, null, null);
        confirm.setFocusTraversal(null, null, null, goback);
        goback.setFocusTraversal(null, null, confirm, null);
        
        
        
    }
    
    public void showNominees(){
        scene.add(title);   scene.add(option1);
        scene.add(option2); scene.add(option3);
        scene.add(option4); scene.add(blanco);
        scene.add(help);
        
        
        scene.add(imager);
        option1.requestFocus();
        
    }

    public void startXlet() {
        showNominees();
        
        bgImg = new HBackgroundImage("project/background.m2v");
        bgImg.load(this);
        
        
        scene.validate();
        scene.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent arg0) {
        
        if(arg0.getActionCommand() == confirm.getTextContent(HState.DISABLED_STATE))
        {
            //Vote comfirmed
            System.out.println("Succes: User voted for: "+vote);
            scene.removeAll();
            confirmTitle.setTextContent("Thank you for voting!", HState.NORMAL_STATE);
            scene.add(confirmTitle);
            scene.validate();
            scene.repaint();
            
            //whiteHouse.sendVote(vote);
        }
        else if (arg0.getActionCommand() == "cancel"){
            //Start over
            System.out.println("Succes: User changed mind for: "+vote);
            
            scene.removeAll();
            showNominees();
            scene.repaint();
        }
        else if (arg0.getActionCommand() == help.getTextContent(HState.DISABLED_STATE)){
            
            scene.removeAll();

            System.out.println("Succes: User doesn't understand application");
            
            confirmTitle=new HStaticText("Information" , 0, 30, 720, 50);
            helptxt=new HStaticText(
                    "1. selecteer favoriete kandidaat en druk op ENTER\n" +
                    "2. Druk op ENTER ter confirmatie\n" +
                    "3. Wanneer u het dankwoord te zien krijgt, is uw stem opgeslagen\n" +
                    "\n" +
                    "Contacteer ons bij problemen op: info@votingapplicatieprojectje.be"
                    , 10, 50, 705, 500);
            
            goback.setTextContent("Go back", HState.DISABLED_STATE);
            scene.add(confirmTitle);
            scene.add(helptxt);
            scene.add(goback);

            scene.validate();
            scene.repaint();

            goback.requestFocus();
        }
        else {
            //Voting comfirmation
            if(arg0.getActionCommand() != blanco.getTextContent(HState.DISABLED_STATE)){
                vote="for "+arg0.getActionCommand();
            }
            else {vote = arg0.getActionCommand();}
            
            confirmTitle=new HStaticText("You are voting "+vote+", are you sure?" , 0, 30, 720, 50);
            confirmTitle.setBackground(Color.LIGHT_GRAY);
            confirmTitle.setBackgroundMode(HVisible.NO_BACKGROUND_FILL);
            goback.setTextContent("Cancel", HState.DISABLED_STATE);

            scene.removeAll();

            System.out.println("Succes: User is voting for "+arg0.getActionCommand()+"...");

            scene.add(confirmTitle);
            scene.add(confirm); scene.add(goback);

            scene.validate();
            scene.repaint();

            confirm.requestFocus();
        }
         
        }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        if(HelloTVXlet.debug){
            System.out.println("Succes: backgroundimage loaded...");
        }
        try {
            bgConfig.displayImage(bgImg);
        } catch (Exception ex) {
            if(HelloTVXlet.debug){
            System.out.println("Error: backgroundimage "+ex.toString()+")");
        }
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        if(HelloTVXlet.debug){
            System.out.println("Error: backgroundimage not loaded");
        }
    }
      
}
