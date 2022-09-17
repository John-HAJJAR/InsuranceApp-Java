package insuranceproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InsuranceProject extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton b1,b2,b3,b4;
   public InsuranceProject(){
    setTitle("Insurance Company");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    b1 = new JButton("Customers"); b1.addActionListener(this);
    b2 = new JButton("Create Policy"); b2.addActionListener(this);
    b3 = new JButton("Insurance Plans"); b3.addActionListener(this);
    b4 = new JButton("Action"); b4.addActionListener(this);
     panel = new JPanel();
     add(panel);
     panel.setLayout(null);
      panel.add(b1); b1.setSize(150,50); b1.setLocation(100, 50); 
      panel.add(b2); b2.setSize(150,50); b2.setLocation(100, 120); 
      panel.add(b3); b3.setSize(150,50); b3.setLocation(100, 190); 
      panel.add(b4); b4.setSize(150,50); b4.setLocation(100, 260);
       setBounds(10, 90, 350, 400);
       setVisible(true); setResizable(false);
   }
   
     public void actionPerformed (ActionEvent evt){
     String s = evt.getActionCommand();
      if (s.equals("Customers")) new CustomerPage(); 
      if (s.equals("Create Policy")) new PolicyPage();
      if (s.equals("Insurance Plans")) new InsurancePage();
      if (s.equals("Action")) new CheckClient();
      
 
    }
 
   
    public static void main(String[] args) {
        new InsuranceProject();
        
    }
    
}
