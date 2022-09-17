
package insuranceproject;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.util.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ActionPage implements ActionListener, Observer{
    private Container c;
    private JMenuBar jmbar;
    private JMenu jm1,jm2;
    private JButton b1, b2, b3;
    private JLabel jl, jl0, jl1, jl2, jl3, jl4;
    private String premiumcheck;
    private PremiumOBS premOBS;
    
    public ActionPage (String name, String numb, String reg, PremiumOBS obs) throws IOException {        
       JFrame jf = new JFrame("");
       jf.setBounds(450, 10, 500, 300); 
       jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = jf.getContentPane(); 
       c.setLayout(null); 
       jf.setResizable(false);
       jf.setVisible(true);
       jmbar = new JMenuBar();
      
           premOBS = obs;
       
           jl = new JLabel("Client with these credentials found : ");
           jl.setFont(new Font("Arial", Font.BOLD, 16)); 
           jl.setSize(400, 30); jl.setLocation(20, 20); c.add(jl);
           
           jl0 = new JLabel("Full name : " + name); 
           jl0.setFont(new Font("Arial", Font.PLAIN, 16)); 
           jl0.setSize(400, 30); jl0.setLocation(30, 50); c.add(jl0); 
   
       
            jl1 = new JLabel("Phone number : " + numb);
            jl1.setFont(new Font("Arial", Font.PLAIN, 16));
            jl1.setSize(400, 30); jl1.setLocation(30, 75); c.add(jl1); 
       
            jl2 = new JLabel("Registration number : " + reg); 
            jl2.setFont(new Font("Arial", Font.PLAIN, 16));
            jl2.setSize(400, 30); jl2.setLocation(30, 100); c.add(jl2); 
       
            String [] tab = (new Facture().dbreader(numb, reg));
            String planslist = (new Facture().getPlans(tab));
            
            jl3 = new JLabel("List of plans taken : " + planslist); 
            jl3.setFont(new Font("Arial", Font.PLAIN, 16));
            jl3.setSize(400,30); jl3.setLocation(30, 125); c.add(jl3);

            //Add a JLabel that says if client has paid their premium or not yet.
            // + OBSERVER WHEN PAID.
            if(tab[tab.length-1].equals("np"))
                { premiumcheck = "Premium : Not paid."; }
            else { premiumcheck="Premium : Paid.";}
       
            
            jl4 = new JLabel(premiumcheck); 
            jl4.setFont(new Font("Arial", Font.PLAIN, 16));
            jl4.setSize(400,30); jl4.setLocation(30, 150); c.add(jl4);

       
        JButton b1 = new JButton("Pay"); b1.addActionListener(this);
        JButton b2 = new JButton("Claim"); b2.addActionListener(this);
        JButton b3 = new JButton("Delete"); b3.addActionListener(this);
        b1.setContentAreaFilled(false); b1.setBorderPainted(false); b1.setFocusable(false);
        b2.setContentAreaFilled(false); b2.setBorderPainted(false); b2.setFocusable(false);
        b3.setContentAreaFilled(false); b3.setBorderPainted(false); b3.setFocusable(false);
        b1.setPreferredSize(new Dimension(200, 20));
        b2.setPreferredSize(new Dimension(200, 20));
        b3.setPreferredSize(new Dimension(200, 20));
        
       jmbar.add(b1); jmbar.add(b2); jmbar.add(b3); jf.setJMenuBar(jmbar); 
}

    private JFrame jf;
 public void newPay(String pnumber, String reg, PremiumOBS obs) throws IOException{
       jf = new JFrame("");
       jf.setBounds(575, 350, 250, 175); 
       jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       jf.setLayout(null);
       jf.setResizable(false);
       
       Facture f = new Facture();
       String [] tab = null;
       tab = f.dbreader(pnumber, reg); 
       int length = tab.length;
       if(!tab[length-1].equals("np"))
          {
              JFrame f1 = new JFrame("Attention !");
              JOptionPane.showMessageDialog(f1, "Client already paid their premium.");   
        }
       else 
       {
           jf.setVisible(true);
           JLabel prem = new JLabel("Premium : " + tab[length-2] + "$"); 
           prem.setFont(new Font("Arial", Font.BOLD, 18));
           prem.setSize(150,20); prem.setLocation(45, 20); jf.add(prem); 
           JButton b = new JButton("Pay now"); b.setSize(100,20); b.setLocation(65, 80); jf.add(b);
       
           b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Facture f = new Facture();
                f.ClientPaid(pnumber, reg); 
                premOBS.setMessage("Premium : Paid."); //observer
                jf.dispose();}});
        }  
       premOBS.addObserver(this); // observer
    }    
 
    
   public void update(Observable o, Object arg) {
        jl4.setText(premOBS.getMessage());
    }    
    
    
 public void actionPerformed (ActionEvent evt){
 String s = evt.getActionCommand();
 if (s.equals("Pay")) 
    {
        String n = jl1.getText().substring(15);
        String r = jl2.getText().substring(22);
     try { newPay(n, r, premOBS); } 
     catch (IOException ex) { System.out.println(ex); }
     
    }
 
 if (s.equals("Claim")) 
        {
           Facture f = new Facture();
           String n = jl1.getText().substring(15);
           String r = jl2.getText().substring(22);         
     try {
         f.newClaim(n, r);
     } catch (IOException ex) {
         System.out.println(ex);
     }
        }
 if (s.equals("Delete")) 
    {
           Facture f = new Facture();
           String n = jl1.getText().substring(15);
           String r = jl2.getText().substring(22);
           int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this policy ? ", 
                "Confirmation to delete", JOptionPane.YES_NO_OPTION);
           if (confirmation == 0)
           {f.DeletePolicy(n,r);}
    }

 }


} 

