
package insuranceproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class InsurancePage extends JFrame{
    private Container c;
    private JLabel title, jl1, jl2, jl3, jl4, jl5,seperators;
    private JTextArea plan1, plan2, plan3, plan4, plan5;
    
   public InsurancePage(){
       setTitle("");
       setBounds(450, 10, 500, 690); 
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = getContentPane(); 
       c.setLayout(null); 
       setResizable(false);
       
       
        title = new JLabel("Available plans"); 
        title.setFont(new Font("Arial", Font.BOLD, 25)); 
        title.setSize(500, 20); 
        title.setLocation(160, 20); 
        c.add(title);  
       
        seperators = new JLabel("-------------------------------------------------------------------------------------------- "); 
        seperators.setFont(new Font("Arial", Font.BOLD, 12)); 
        seperators.setSize(500, 20); 
        seperators.setLocation(55, 40); 
        c.add(seperators); 
        
        
        
        jl1 = new JLabel("Plan  1 - Obligatory insurance. "); 
        jl1.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl1.setSize(500, 20);
        jl1.setLocation(20, 60); 
        c.add(jl1);  
        
        plan1 = new JTextArea();
        plan1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        plan1.setText (""
                + "Risks covered : Accident caused by another driver.\n"
                + "Premium : 3% - 5% \n"
                + "Coverage : 60%   \n"
                        );    
        plan1.setHighlighter(null);
        plan1.setBackground(new Color(238, 238, 238, 255));
        plan1.setSize(400,60);
        plan1.setEditable(false);
        plan1.setLocation(75, 90);
        c.add(plan1);
       
        jl2 = new JLabel("Plan  2 - All-risk insurance. "); 
        jl2.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl2.setSize(500, 20);
        jl2.setLocation(20, 155); 
        c.add(jl2);  
        
        
        plan2 = new JTextArea();
        plan2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        plan2.setText (""
                + "Risks covered : Any risk.\n"
                + "Premium : 8 - 13%  \n"
                + "Coverage :  100%  + car replacement\n"
                        );    
        plan2.setHighlighter(null);
        plan2.setBackground(new Color(238, 238, 238, 255));
        plan2.setSize(400,60);
        plan2.setEditable(false);
        plan2.setLocation(75, 185);
        c.add(plan2);
    
                         
        jl3 = new JLabel("Plan 3 - Vehicle damage insurance. "); 
        jl3.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl3.setSize(500, 20);
        jl3.setLocation(20, 250); 
        c.add(jl3);  
        
        
        plan3 = new JTextArea();
        plan3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        plan3.setText (""
                + "Risks covered : Only vehicule damage\n"
                + "Premium : 4 - 6% \n"
                + "Coverage :  75%  \n"
                        );    
        plan3.setHighlighter(null);
        plan3.setBackground(new Color(238, 238, 238, 255));
        plan3.setSize(400,60);
        plan3.setEditable(false);
        plan3.setLocation(75, 280);
        c.add(plan3);  
        
    
        jl4 = new JLabel("Plan 4 - The personal insurance of the driver. "); 
        jl4.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl4.setSize(500, 20);
        jl4.setLocation(20, 345); 
        c.add(jl4);  
        
        
        plan4 = new JTextArea();
        plan4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        plan4.setText (""
                + "Risks covered : Only medical bills of the driver \n"
                + "Premium :  5%  \n"
                + "Coverage :  80%  \n"
                        );    
        plan4.setHighlighter(null);
        plan4.setBackground(new Color(238, 238, 238, 255));
        plan4.setSize(400,60);
        plan4.setEditable(false);
        plan4.setLocation(75, 375);
        c.add(plan4);
      
        
        jl5 = new JLabel("Plan 5 - Assistance. "); 
        jl5.setFont(new Font("Arial", Font.BOLD, 16)); 
        jl5.setSize(500, 20);
        jl5.setLocation(20, 440); 
        c.add(jl5);  
        
        
        plan5 = new JTextArea();
        plan5.setFont(new Font("Arial", Font.PLAIN, 16)); 
        plan5.setText (""
                + "Risks covered : Car tow, flat tire, car replacement  \n"
                + "Premium :  3%  \n"
                + "Coverage :  100%  \n"
                        );    
        plan5.setHighlighter(null);
        plan5.setBackground(new Color(238, 238, 238, 255));
        plan5.setSize(400,60);
        plan5.setEditable(false);
        plan5.setLocation(75, 470);
        c.add(plan5);  
     
    setVisible(true); 
       
       
       
       
       
   } 
    
    
    
}
