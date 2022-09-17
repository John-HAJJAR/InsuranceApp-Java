package insuranceproject;


import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.text.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Facture{
    
    public Facture(){
    }
    
    public String [] dbreader (String pnumber, String reg) throws IOException {
       FileReader fr; 
        try { 
            
            fr = new FileReader("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
            String[] words= null;
            BufferedReader br = new BufferedReader(fr);
            String s; 
            while((s=br.readLine())!=null)  
            {
             words=s.split("%20");
              if(words[2].equals(pnumber) && words[4].equals(reg))
              {
                  br.close(); fr.close(); return words;   
              } else {continue; }
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException ex) {System.out.println(ex);}
        return null;
    }

    private JLabel infos, dateoa, condition, plans, damages, amountpaid;
    private JTextField tdamages, tamountpaid, tplanused, tdateoa;
       
    
    public void newClaim(String pnumber, String reg) throws IOException{
       JFrame jf = new JFrame("");
       jf.setBounds(450, 350, 500, 250); 
       jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       jf.setLayout(null); 
       jf.setResizable(false);
       jf.setVisible(true);
       
       String [] plantab;
       JButton jb;
       String [] gg = null;
       gg = dbreader(pnumber,reg);
       
       String planslist = getPlans(gg);
       plantab = planslist.split("-");
       
       infos = new JLabel("Please fill the claim's information below "); 
       infos.setFont(new Font("Arial", Font.PLAIN, 13));
       infos.setSize(300,20); infos.setLocation(20, 20); jf.add(infos);
       
       dateoa = new JLabel("Date of accident "); 
       dateoa.setSize(200,20); dateoa.setLocation(20, 50); jf.add(dateoa); 
       dateoa.setFont(new Font("Arial", Font.BOLD, 14));
       
       tdateoa = new JTextField(); tdateoa.setSize(200, 20); tdateoa.setLocation(145, 50); jf.add(tdateoa); 
      
       damages = new JLabel("List of damages ");
       damages.setFont(new Font("Arial", Font.BOLD, 14));
       damages.setSize(200,20); damages.setLocation(20, 75); jf.add(damages);
              
       tdamages = new JTextField(); tdamages.setSize(200, 20); tdamages.setLocation(145, 75); jf.add(tdamages); 
      
       amountpaid = new JLabel("Amount paid "); 
       amountpaid.setFont(new Font("Arial", Font.BOLD, 14));
       amountpaid.setSize(200,20); amountpaid.setLocation(20, 100); jf.add(amountpaid); 
       
       tamountpaid = new JTextField(); tamountpaid.setSize(200, 20); tamountpaid.setLocation(145, 100); jf.add(tamountpaid); 
       
       plans = new JLabel("Please input the invoked plan for this claim");
       plans.setFont(new Font("Arial", Font.BOLD, 14));
       plans.setSize(500,20); plans.setLocation(20, 125); jf.add(plans);
       
       tplanused = new JTextField(); tplanused.setSize(50, 20); tplanused.setLocation(335, 125); jf.add(tplanused); 
       
       jb= new JButton("Create the claim");  jb.setSize(150,20); jb.setLocation(150, 175); jf.add(jb);
  
       jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
       
            String planinvoke = tplanused.getText();
          
            int subs = 0;
            for(int i=0; i<plantab.length; i++)
                {  
                    if(planinvoke.equals(plantab[i])) 
                        {
                            subs = 1;
                        try { 
                                FactureClaim(pnumber, reg);
                            } catch (IOException ex) {System.out.println(ex);}
                                break;
                        }
                    
                 }
                    if (subs == 0)
                    {
                        JFrame f1 = new JFrame("Attention !");
                        JOptionPane.showMessageDialog(f1, "Client did not subscribe to plan " + planinvoke + ".");   
                    }
            }
        });
    
    
    
    }
   
    
    
    public void FactureClaim (String pnumber, String reg) throws IOException{
        JFrame frame = new JFrame("");
       frame.setBounds(989, 100, 350, 400); 
       frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       frame.setLayout(null); 
       frame.setResizable(false);
       frame.setVisible(true);
       String planinuse = tplanused.getText();
       int amount = Integer.parseInt(tamountpaid.getText());
       
        //start calculate amount
       if(planinuse.equals("1"))
       {
            amount = (int) (amount * 0.6);
       }
       if(planinuse.equals("2"))
       {
            amount = (int) (amount * 1);
       }
       if(planinuse.equals("3"))
       {
            amount = (int) (amount * 0.75);
       }
       if(planinuse.equals("4") )
       {
            amount = (int) (amount * 0.8);
       }
       if(planinuse.equals("5") )
       {
            amount = (int) (amount * 1);
       }
         //end calculating amount
       
       String [] table = null;
       table = dbreader(pnumber, reg);
       
        JLabel lab1 = new JLabel(" Facture/Receipt ");
        lab1.setFont(new Font("Academy Bold", Font.ITALIC + Font.BOLD, 22));
        lab1.setSize(400, 30); 
        lab1.setLocation(80, 5); 
        frame.add(lab1);
        
        JLabel Cname = new JLabel("Client name : " + table[0] + " " + table[1]);
        Cname.setFont(new Font("Arial", Font.BOLD, 14));
        Cname.setSize(350, 30); 
        Cname.setLocation(20, 60); 
        frame.add(Cname);
        
        JLabel pnb = new JLabel("Phone number : " + pnumber);
        pnb.setFont(new Font("Arial", Font.BOLD, 14));
        pnb.setSize(350, 30); 
        pnb.setLocation(20, 85); 
        frame.add(pnb);
        
        JLabel rn = new JLabel("Registration numb : " + reg);
        rn.setFont(new Font("Arial", Font.BOLD, 14));
        rn.setSize(350, 30); 
        rn.setLocation(20, 110); 
        frame.add(rn);
        
       
        JLabel date1 = new JLabel("Date of accident : " + tdateoa.getText());
        date1.setFont(new Font("Arial", Font.BOLD, 14));
        date1.setSize(350, 30); 
        date1.setLocation(20, 135); 
        frame.add(date1);
        
        Date ddate = new Date(); 
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate= DateFor.format(ddate);
        JLabel currdate = new JLabel("Date of claim : " + stringDate);
        currdate.setFont(new Font("Arial", Font.BOLD, 14));
        currdate.setSize(350, 30); 
        currdate.setLocation(20, 160); 
        frame.add(currdate);
        
        JLabel dam = new JLabel("Damages done : " + tdamages.getText());
        dam.setFont(new Font("Arial", Font.BOLD, 14));
        dam.setSize(350, 30); 
        dam.setLocation(20, 185); 
        frame.add(dam);
        
        
        JLabel Am = new JLabel("Amount paid by the client : " + tamountpaid.getText() + "$");
        Am.setFont(new Font("Arial", Font.BOLD, 14));
        Am.setSize(350, 30); 
        Am.setLocation(20, 210); 
        frame.add(Am);
        
        
        JLabel Am2 = new JLabel("Amount paid to the client : " + amount + "$");
        Am2.setFont(new Font("Arial", Font.BOLD, 14));
        Am2.setSize(350, 30); 
        Am2.setLocation(20, 235); 
        frame.add(Am2);
        
    }
         
    
    public String getPlans(String [] tab)
    {
        int length = tab.length;
        int plannb = 1;
        String planns12345 = "";
        if(tab[length-1].equals("np"))
            {
            for (int il=0; il<length-14; il++) plannb++;
                    switch (plannb)
                    {
                        case 2 : planns12345 = tab[12]; break;
                        case 3 : planns12345 = tab[12] + "-" + tab[13]; break;
                        case 4 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14]; break;
                        case 5 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14] + "-" +  tab[15]; break;
                        case 6 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14] + "-" + tab[15] + "-" +  tab[16]; break;    
                    }
            }
        else {
            for (int il=0; il<length-13; il++) plannb++;
                    switch (plannb)
                    {
                        case 2 : planns12345 = tab[12]; break;
                        case 3 : planns12345 = tab[12] + "-" + tab[13]; break;
                        case 4 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14]; break;
                        case 5 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14] + "-" +  tab[15]; break;
                        case 6 : planns12345 = tab[12] + "-" + tab[13] + "-" + tab[14] + "-" + tab[15] + "-" +  tab[16]; break;    
                    }
            
            
        }
            
        return planns12345;            
        }
    
     public void ClientPaid (String pnumber, String regnumber){
      File oldFile = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
      File newFile = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\temp.txt");
      String line = ""; String newline = ""; 
      try {
          FileWriter fw = new FileWriter("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\temp.txtt", true);
          BufferedWriter bw = new BufferedWriter(fw);
          PrintWriter pw = new PrintWriter(bw);
          Scanner x = new Scanner(new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt"));
          x.useDelimiter("\n");
          
        while(x.hasNext())
        {    
            line = x.next();
            String[] words= null;
            words = line.split("%20");
         
         if(words[2].equals(pnumber) && words[4].equals(regnumber))
          {
            for(int i=0; i<words.length-1; i++)
            {
               newline +=   words[i] + "%20";
            }
            pw.print(newline + "\n");
          }
         else {  pw.print(line + "\n"); }
          
        }
        x.close();
        pw.flush();
        pw.close();
        
        oldFile.delete();
       
       File temp2 = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
       newFile.renameTo(temp2);
       
        
        }catch(Exception e){System.out.println(e);}
    }
     
   
  public void DeletePolicy (String pnumber, String regn) {
      File oldFile1 = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
      File newFile1 = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\temp.txt");
      String line = "";
      try {
          FileWriter fw1 = new FileWriter("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\temp.txt", true);
          BufferedWriter bw1 = new BufferedWriter(fw1);
          PrintWriter pw1 = new PrintWriter(bw1);
          Scanner x = new Scanner(new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt"));
          x.useDelimiter("\n");
          
        while(x.hasNext())
        {    
            line = x.next();
            String[] words= null;
            words = line.split("%20");
         
         if(words[2].equals(pnumber) && words[4].equals(regn))
          {
              continue;
          }
         else { pw1.print(line + "\n"); }
          
        }
        
 
        x.close();
        pw1.flush();
        pw1.close();
        
        oldFile1.delete();
       
       File temp2 = new File("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
       newFile1.renameTo(temp2);
       
        
        }catch(Exception e){System.out.println(e);}
  }
 
    public int CheckForCreatePolicy (String pnumber, String reg) throws IOException {
       FileReader fr; 
        try { 
            
            fr = new FileReader("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt");
            String[] words= null;
            BufferedReader br = new BufferedReader(fr);
            String s; 
            while((s=br.readLine())!=null)   
            {
             words=s.split("%20"); 
             if(words[2].equals(pnumber) && words[4].equals(reg))
                { br.close(); fr.close(); return -3; }
              if(words[2].equals(pnumber))
                { br.close(); fr.close(); return -2;} 
              if(words[4].equals(reg))
                { br.close(); fr.close(); return -1;} 
             
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException ex) {System.out.println(ex);}
        return 0;
    }
   
    
    
}
