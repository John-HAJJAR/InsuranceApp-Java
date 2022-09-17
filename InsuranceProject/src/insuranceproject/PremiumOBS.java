//OBSERVER
package insuranceproject;

 import java.util.*;

 public class PremiumOBS extends Observable{
    private String message;
    
  public String getMessage(){return message;}
  
  public void setMessage(String message)
    {
       this.message = message;
          setChanged();
          notifyObservers();
    }
    
}
