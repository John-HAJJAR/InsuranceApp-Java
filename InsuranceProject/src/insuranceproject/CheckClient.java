
package insuranceproject;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.util.*;

public class CheckClient extends JFrame implements ActionListener{
    private Container c;
    private JButton bt1;
    private JLabel jl, jl1, jl2, jl3, jl4;
    private JTextField tf2, tf3, tf4;
   public CheckClient(){
       setTitle("");
       setBounds(450, 10, 500, 300); 
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = getContentPane(); 
       c.setLayout(null); 
       setResizable(false);
       setVisible(true);
       
        jl = new JLabel("Client information");
        jl.setFont(new Font("Academy Bold", Font.ITALIC + Font.BOLD, 22));
        jl.setSize(400, 30); 
        jl.setLocation(140, 20); 
        c.add(jl);    
       
      
       
        jl1 = new JLabel("Please fill the textboxes with the client's information."); 
        jl1.setFont(new Font("Arial", Font.PLAIN, 13)); 
        jl1.setSize(500, 20); 
        jl1.setLocation(50, 80); 
        c.add(jl1); 
       
        jl2 = new JLabel("Phone number"); 
        jl2.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl2.setSize(500, 20); 
        jl2.setLocation(50, 110); 
        c.add(jl2); 
  
        tf2 = new JTextField(); 
        tf2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tf2.setSize(180, 20); 
        tf2.setLocation(230, 110); 
        c.add(tf2);
        
        jl3 = new JLabel("Regstration number"); 
        jl3.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl3.setSize(500, 20); 
        jl3.setLocation(50, 140); 
        c.add(jl3); 
  
        tf3 = new JTextField(); 
        tf3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tf3.setSize(180, 20); 
        tf3.setLocation(230, 140); 
        c.add(tf3); 
 
        bt1 = new JButton("Check"); 
        bt1.addActionListener(this);
        bt1.setSize(100,30);
        bt1.setLocation(180, 190); 
        c.add(bt1);
         
      } 
     public void actionPerformed (ActionEvent evt){
     String s = evt.getActionCommand();
      if (s.equals("Check")) 
      {
          String spnumber = tf2.getText();
          String sregnumber = tf3.getText(); 
          String fnameclient = checkclient(spnumber,sregnumber);
          
        if (fnameclient != null)
        {
              try {
                  PremiumOBS obs = new PremiumOBS();
                  new ActionPage(fnameclient, spnumber, sregnumber, obs);
              } catch (IOException ex) {
                  System.out.println(ex);
              }
        }  

      } 
     }

public String checkclient(String phonenumber, String regnumber){
        FileReader fr; 
        try {
            fr = new FileReader("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
            String[] words= null;
            BufferedReader br = new BufferedReader(fr);
            String s; 
            while((s=br.readLine())!=null) 
            {
             words=s.split("%20"); 
              if(words[2].equals(phonenumber) && words[4].equals(regnumber))
              {
                   br.close(); fr.close(); return words[0] + " " + words[1];
              } else {continue; }
            }
            br.close();
            fr.close();
        }catch(Exception e){System.out.print(e);}
       
        //if not returned then client not found
        Frame f1 = new JFrame("Error !");
        JOptionPane.showMessageDialog(f1, "Client not found, please check if the information is written correctly.");
        return null;
    }



}
