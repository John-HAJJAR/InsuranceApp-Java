
package insuranceproject;

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.util.*;

public class PolicyPage extends JFrame implements ActionListener {
    private Container c;
    private JLabel jl, firstn, secondn, pnumber, nat;
    private JLabel seperator1, seperator2, seperator3, seperator4;    
    private JTextField tfirstn, tsecondn, tpnumber;
    private JLabel regnumb, model, type, year, color, price, stateov, currdate;
    private JTextField tregnumb, tmodel, ttype, tyear, tcolor, tprice, tcurrdate;
    private JButton button1, button2;
    private JComboBox nationalite, jcstateov;
    private Date ddate = new Date(); 
    private Checkbox checkbox1;
    private JCheckBox checkbox2;
    private String [] nationalities = {" ", "UNITED KINGDOM - GB ", "ARGENTINA - AR", "AUSTRALIA -AU", "BELGIUM - BE","BRAZIL - BR", "CANADA - CA", "CHINA - CN", "COLOMBIA- CO","FRANCE - FR", "GERMANY - DE", "INDIA - IN", "JAPAN - JP", "SPAIN - ES", "EGYPT - EG", "LEBANON - LB","UNITED ARAB EMIRATES - AE "};
    private String [] tabstateov = {" ","Excellent", "Very Good", "Fair", "Poor", "Very Poor"};  
    
    
    public PolicyPage() {
       setTitle("");
       setBounds(450, 10, 500, 690); 
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = getContentPane(); 
       c.setLayout(null); 
       setResizable(false);
       
        jl = new JLabel("Create a Policy");
        jl.setFont(new Font("Academy Bold", Font.ITALIC + Font.BOLD, 22));
        jl.setSize(400, 30); 
        jl.setLocation(170, 20); 
        c.add(jl); 
        
        seperator1 = new JLabel("---------------------------- Personal Information ---------------------------- "); 
        seperator1.setFont(new Font("Arial", Font.BOLD, 12)); 
        seperator1.setSize(500, 20); 
        seperator1.setLocation(50, 60); 
        c.add(seperator1); 
        
        firstn = new JLabel("First name"); 
        firstn.setFont(new Font("Arial", Font.BOLD, 16)); 
        firstn.setSize(500, 20); 
        firstn.setLocation(50, 80); 
        c.add(firstn); 
  
        tfirstn = new JTextField(); 
        tfirstn.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tfirstn.setSize(200, 20); 
        tfirstn.setLocation(170, 80); 
        c.add(tfirstn); 
        
        secondn = new JLabel("Second name"); 
        secondn.setFont(new Font("Arial", Font.BOLD, 16)); 
        secondn.setSize(500, 20); 
        secondn.setLocation(50, 110); 
        c.add(secondn); 
  
        tsecondn = new JTextField(); 
        tsecondn.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tsecondn.setSize(200, 20); 
        tsecondn.setLocation(170, 110); 
        c.add(tsecondn); 
        
        pnumber = new JLabel("Phone number"); 
        pnumber.setFont(new Font("Arial", Font.BOLD, 16)); 
        pnumber.setSize(500, 20); 
        pnumber.setLocation(50, 140); 
        c.add(pnumber); 
  
        tpnumber = new JTextField(); 
        tpnumber.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tpnumber.setSize(200, 20); 
        tpnumber.setLocation(170, 140); 
        c.add(tpnumber); 
      
        nat = new JLabel("Nationalite"); 
        nat.setFont(new Font("Arial", Font.BOLD, 16)); 
        nat.setSize(500, 20); 
        nat.setLocation(50, 170); 
        c.add(nat); 
  
        nationalite = new JComboBox(nationalities); 
        nationalite.setSelectedIndex(0);
        nationalite.setFont(new Font("Arial", Font.PLAIN, 16)); 
        nationalite.setSize(200, 20); 
        nationalite.setLocation(170, 170); 
        c.add(nationalite);
        
        //Start Vehicule Section
        seperator2 = new JLabel("---------------------------- Vehicule Information ---------------------------- "); 
        seperator2.setFont(new Font("Arial", Font.BOLD, 12)); 
        seperator2.setSize(500, 20); 
        seperator2.setLocation(50, 200); 
        c.add(seperator2); 
        
        
        //regnumb = new JLabel("Registration \n number"); 
        regnumb = new JLabel("<html>Registration <br> &nbsp;&nbsp;&nbsp;  number</html>"); 
        regnumb.setFont(new Font("Arial", Font.BOLD, 16)); 
        regnumb.setSize(500, 40); 
        regnumb.setLocation(50, 230); 
        c.add(regnumb); 
  
        tregnumb = new JTextField(); 
        tregnumb.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tregnumb.setSize(200, 25); 
        tregnumb.setLocation(170, 235); 
        c.add(tregnumb); 
        
        model = new JLabel(" Model"); 
        model.setFont(new Font("Arial", Font.BOLD, 16)); 
        model.setSize(500, 40); 
        model.setLocation(70, 260); 
        c.add(model); 
  
        tmodel = new JTextField(); 
        tmodel.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tmodel.setSize(200, 20); 
        tmodel.setLocation(170, 270); 
        c.add(tmodel); 
        
        
        type = new JLabel("Type"); 
        type.setFont(new Font("Arial", Font.BOLD, 16)); 
        type.setSize(500, 40); 
        type.setLocation(75, 290); 
        c.add(type); 
  
        ttype = new JTextField(); 
        ttype.setFont(new Font("Arial", Font.PLAIN, 16)); 
        ttype.setSize(200, 20); 
        ttype.setLocation(170, 300); 
        c.add(ttype); 
        
        year = new JLabel("Year"); 
        year.setFont(new Font("Arial", Font.BOLD, 16)); 
        year.setSize(500, 40); 
        year.setLocation(75, 320); 
        c.add(year); 
  
        tyear = new JTextField(); 
        tyear.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tyear.setSize(100, 20); 
        tyear.setLocation(170, 330); 
        c.add(tyear); 

        
        color = new JLabel("Color"); 
        color.setFont(new Font("Arial", Font.BOLD, 16)); 
        color.setSize(500, 40); 
        color.setLocation(75, 350); 
        c.add(color); 
  
        tcolor = new JTextField(); 
        tcolor.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tcolor.setSize(200, 20); 
        tcolor.setLocation(170, 360); 
        c.add(tcolor); 
        
        
        price = new JLabel("Value"); 
        price.setFont(new Font("Arial", Font.BOLD, 16)); 
        price.setSize(500, 40); 
        price.setLocation(75, 380); 
        c.add(price); 
  
        tprice = new JTextField(); 
        tprice.setFont(new Font("Arial", Font.PLAIN, 16)); 
        tprice.setSize(200, 20); 
        tprice.setLocation(170, 390); 
        c.add(tprice); 
        
        
        stateov = new JLabel("Condition"); 
        stateov.setFont(new Font("Arial", Font.BOLD, 16)); 
        stateov.setSize(500, 40); 
        stateov.setLocation(75, 410); 
        c.add(stateov); 
           
        jcstateov = new JComboBox(tabstateov); 
        jcstateov.setSelectedIndex(0);
        jcstateov.setFont(new Font("Arial", Font.PLAIN, 16)); 
        jcstateov.setSize(200, 20); 
        jcstateov.setLocation(170, 420); 
        c.add(jcstateov); 

    //End Vehicule Section
        
    //Start of insurance section
        seperator3 = new JLabel("---------------------------- Plan / policy section ---------------------------- "); 
        seperator3.setFont(new Font("Arial", Font.BOLD, 12)); 
        seperator3.setSize(500, 20); 
        seperator3.setLocation(50, 450); 
        c.add(seperator3); 
        
        
        currdate = new JLabel("Current date : "); 
        currdate.setFont(new Font("Arial", Font.BOLD, 15)); 
        currdate.setSize(500, 40); 
        currdate.setLocation(150, 465); 
        c.add(currdate); 
        
        tcurrdate = new JTextField(); 
        tcurrdate.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tcurrdate.setSize(85, 19); 
        tcurrdate.setLocation(255, 475);
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(ddate);
        tcurrdate.setText(stringDate);  
        tcurrdate.setEditable(false);
        c.add(tcurrdate); 
   
        button1 = new JButton("Add plan"); 
        button1.addActionListener(this);
        button1.setSize(100,30);
        button1.setLocation(175, 500); 
        c.add(button1);
        
    //end of insurance section
        
        seperator4 = new JLabel("------------------------------ Contract finished ------------------------------ "); 
        seperator4.setFont(new Font("Arial", Font.BOLD, 12)); 
        seperator4.setSize(500, 20); 
        seperator4.setLocation(50, 540); 
        c.add(seperator4);     
        
    //finish check
        checkbox2 = new JCheckBox("I have double checked all the information.");
        checkbox2.setSize(300,30);
        checkbox2.setLocation(110,560);
        checkbox2.addActionListener(this);
        c.add(checkbox2);
        
        
        button2 = new JButton("Create"); 
        button2.addActionListener(this);
        button2.setSize(100,30);
        button2.setLocation(175, 590);
        button2.setEnabled(false);
        c.add(button2);            
         
    //end finish check 
       setVisible(true); 
   }
   
  


     public void actionPerformed (ActionEvent evt){
     String s = evt.getActionCommand();
      if (s.equals("Add plan")) new addPlanPage();
          
      if (s.equals("Create")) {   
          try{
  
            //addd exceptions here !!!
            if (tfirstn.getText().isEmpty() || tsecondn.getText().isEmpty()) 
                        throw new Exception ("You should fill in the First and Second name.");
          
             String phonenb = tpnumber.getText();
            if (phonenb.length() >8 || phonenb.length() < 8) 
                 throw new Exception ("Phone numebr must be 8 digits.");    
          
             for (int i = 0; i < phonenb.length() ; i++) 
              if (!Character.isDigit(phonenb.charAt(i)))
                  throw new Exception ("Phone number must only contain numbers.");
          
          
            if (nationalite.getSelectedIndex() == 0) 
                        throw new Exception ("You must select a nationality.");
         
             if (tregnumb.getText().isEmpty()) throw new Exception ("Please fill the registration number.");
          
            if (tmodel.getText().isEmpty() || ttype.getText().isEmpty() || tcolor.getText().isEmpty() )
                throw new Exception ("Please fill all the information in the vehicule's section.");
          
            if (tyear.getText().length() != 4) 
            {
              for (int i = 1; i < 4 ; i++) 
               { 
                    if (!Character.isDigit(tyear.getText().charAt(i)))
                  throw new Exception ("A year is composed of only numbers.");
               }
             throw new Exception ("A year must contains 4 numbers.");    
             }
          
           if (jcstateov.getSelectedIndex() == 0 || jcstateov.getSelectedIndex() == -1) 
                        throw new Exception ("Please pick a state for the vehicule.");
         
           String price123 = tprice.getText();
           for (int i = 1; i < price123.length() ; i++) 
               { 
                   if (!Character.isDigit(price123.charAt(i)))
                  throw new Exception ("Please only fill the price field with numbers.");
               }
           
           Facture ftest = new Facture ();
           int testclient = 0;
           testclient = ftest.CheckForCreatePolicy (tpnumber.getText(), tregnumb.getText());
           
           if(testclient == -3) 
               throw new Exception ("Client with the same phone number and same registration number already exists.");
           if(testclient == -2) 
               throw new Exception ("Client with the same phone number already exists.");
           if(testclient == -1) 
               throw new Exception ("Client with the same registration number already exists.");
           
           
           //end exceptions
         
            FileReader fr0 = new FileReader("C:\\Users\\user\\InsuranceProject\\src\\insuranceproject\\plans.txt"); 
            String[] wordsplan= null;
            BufferedReader br0 = new BufferedReader(fr0);
            String s0;
            s0=br0.readLine();
            wordsplan=s0.split("-");
            double pricecar = Integer.parseInt(tprice.getText().substring(0, tprice.getText().length() - 1));
            int premium = 0;
            for (int j=0;j<wordsplan.length; j++)
                {
                    if (wordsplan[j].equals("1"))
                            {
                            if (pricecar <= 7000) 
                                    {
                                      premium += pricecar * 0.03;
                                    }
                            else if (pricecar >7000 && pricecar <=12000)
                                    {
                                        premium += pricecar * 0.04 ;
                                    }
                            else {premium += pricecar * 0.05;}
                            }
                    if (wordsplan[j].equals("2"))
                            {
                            if (pricecar <= 7000)
                                {
                                    premium += pricecar * 0.08;
                                }
                             else if (pricecar >7000 && pricecar <=12000)
                                    {
                                        premium += pricecar * 0.1 ;
                                    }
                            else {premium += pricecar * 0.13;}
                            }
                    if (wordsplan[j].equals("3"))
                            {
                            if (pricecar <= 7000)
                                {
                                    premium += pricecar * 0.04;
                                }
                             else if (pricecar >7000 && pricecar <=12000)
                                    {
                                        premium += pricecar * 0.05 ;
                                    }
                            else {premium += pricecar * 0.06;}
                            }
                    
                    if (wordsplan[j].equals("4"))
                            {
                             premium += pricecar * 0.05;
                            }
                    if (wordsplan[j].equals("5"))
                            {
                             premium += pricecar * 0.03;
                            }
                  }
 
            String planss= "%20";
            for (int i=0;i<wordsplan.length;i++)
                   { planss += wordsplan[i]+ "%20";}
              
          FileWriter fw= new FileWriter("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt", true);
        
          String dataa123 = tfirstn.getText() + "%20" + tsecondn.getText() + "%20" + tpnumber.getText() + "%20" +
                  nationalite.getSelectedItem() + "%20" + tregnumb.getText() + "%20" + tmodel.getText() + "%20" + ttype.getText() +
                  "%20" + tyear.getText() + "%20" + tcolor.getText() + "%20" + tprice.getText() + "%20" + jcstateov.getSelectedItem() +
                  "%20" + tcurrdate.getText();
           
          fw.write(dataa123);
          fw.write(planss);
          fw.write(premium + "%20np" +"\n");
           
          fw.close();
          
          JFrame f1 = new JFrame("Attention !");
          JOptionPane.showMessageDialog(f1, "Successfully Saved");       
          }catch(Exception e)
            {
              JFrame fw = new JFrame("Warning !");
              JOptionPane.showMessageDialog(fw, e.getMessage());   
            }
             
     }   
      
      if (s.equals("I have double checked all the information.")) 
        {
          if (button2.isEnabled()) button2.setEnabled(false);     
          else button2.setEnabled(true);
        }    
     }
}
