package hellotvxlet;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;

/**
 *
 * @author Alexander Steyaert & Sven Aerts
 */

public class HelloTVXlet implements Xlet {
    VoteMachine instance;
    XletContext context;
    static boolean alreadyVoted=false;
    
    public void initXlet(XletContext context) throws XletStateChangeException {
      this.context = context;
      instance = new VoteMachine();
      
      instance.initXlet(context);
      instance.startXlet();
    }
    
    public void startXlet() {
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void pauseXlet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
    
   