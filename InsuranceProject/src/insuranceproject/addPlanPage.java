
package insuranceproject;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.util.*;

public class addPlanPage extends JFrame implements ActionListener{
    private Container c;
    private JLabel jl1;
    private JCheckBox cb1, cb2, cb3, cb4, cb5;
    private JButton button, plandetails;
    
  public addPlanPage(){
      setTitle("");
       setBounds(990, 90, 300, 300); 
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = getContentPane(); 
       c.setLayout(null); 
       setResizable(false);
      
        //jl1 = new JLabel("Please select the plans " + "\n" + " you would like to add to your policy"); 
       jl1 = new JLabel("<html> Please select the plans you  <br> would like to add to the policy</html>"); 
        jl1.setFont(new Font("Arial", Font.BOLD, 15)); 
        jl1.setSize(500, 40); 
        jl1.setLocation(10, 10); 
        c.add(jl1); 
       
        cb1 = new JCheckBox("Plan 1");
        cb1.setFont(new Font("Arial", Font.BOLD, 13)); 
        cb1.setSize(300,30);
        cb1.setLocation(10,60);
        cb1.setSelected(true);
        cb1.setEnabled(false);
        cb1.addActionListener(this);
        c.add(cb1);
        
        cb2 = new JCheckBox("Plan 2");
        cb2.setSize(300,30);
        cb2.setLocation(10,80);
        cb2.addActionListener(this);
        c.add(cb2);
        
        cb3 = new JCheckBox("Plan 3");
        cb3.setSize(300,30);
        cb3.setLocation(10,100); 
        cb3.addActionListener(this);
        c.add(cb3);
        
        cb4 = new JCheckBox("Plan 4");
        cb4.setSize(300,30);
        cb4.setLocation(10,120);
        cb4.addActionListener(this);
        c.add(cb4);
        
        cb5 = new JCheckBox("Plan 5");
        cb5.setSize(300,30);   
        cb5.setLocation(10,140);
        cb5.addActionListener(this);
        c.add(cb5);      
        
        plandetails = new JButton("Plan details"); 
        plandetails.addActionListener(this);
        plandetails.setSize(100,30);
        plandetails.setLocation(100, 170);
        c.add(plandetails);
        
        button = new JButton("Add"); 
        button.addActionListener(this);
        button.setSize(100,30);
        button.setLocation(100, 200);
        c.add(button);  
        
        
        setVisible(true);
       
      
  }
    
    public void actionPerformed (ActionEvent evt){
     String s = evt.getActionCommand();
     
     if(s.equals("Plan details")) new InsurancePage();
      
             if(s.equals("Add")) 
      { 
        String nbplan = ""; 
        if(cb1.isSelected()){ nbplan+= "1-"; }
        if(cb2.isSelected()){ nbplan+= "2-"; }
        if(cb3.isSelected()){ nbplan+= "3-"; }
        if(cb4.isSelected()){ nbplan+= "4-"; }
        if(cb5.isSelected()){ nbplan+= "5-"; } 
          
        try{
              
          FileWriter fw= new FileWriter("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");       
    
           fw.write(nbplan);
           
           fw.close();
          
          }catch(Exception e){System.out.println(e);}    
          
        setVisible(false);
          
      }
      
          }
  
  
  
  
  
}
