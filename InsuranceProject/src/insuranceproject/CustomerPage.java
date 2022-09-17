
package insuranceproject;

import java.util.*;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

public class CustomerPage extends JFrame{
    private Container c; 
    private JLabel title, searchjl; 
     private JScrollPane scrolltable;
      private JTable table1;
      private JButton jbutt;
      private JTextField jtf;
      private TableRowSorter<TableModel> searcht;
   public CustomerPage(){
       setTitle("");
       setBounds(410, 10, 500, 690); 
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
       c = getContentPane(); 
       c.setLayout(null); 
       setResizable(false);
      
        title = new JLabel("Customers list "); 
        title.setFont(new Font("Academy Bold", Font.ITALIC + Font.BOLD, 22));
        title.setSize(400, 30); 
        title.setLocation(170, 20); 
        c.add(title); 


        searchjl = new JLabel("Search for a customer by name, phone number or registration number :"); 
        searchjl.setFont(new Font("Arial", Font.PLAIN, 14)); 
        searchjl.setSize(500, 20); 
        searchjl.setLocation(20, 580); 
        c.add(searchjl);  
       
        
        jtf = new JTextField(); 
        jtf.setFont(new Font("Arial", Font.PLAIN, 16)); 
        jtf.setSize(100, 20); 
        jtf.setLocation(190, 600);
        c.add(jtf);
        
      
       DefaultTableModel model = new DefaultTableModel();
          table1 = new JTable(model);
          
        searcht = new TableRowSorter<>(table1.getModel());
 
        table1.setDefaultEditor(Object.class, null);
      
         table1.setRowSorter(searcht);
        model.addColumn("Name");;
        model.addColumn("Phone number");
        model.addColumn("Registration number");
        try{
            FileReader fr = new FileReader("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt"); 
            String[] words= null;
            BufferedReader br = new BufferedReader(fr);
            String s; 
            
            while((s=br.readLine())!=null)
      {
             words=s.split("%20");
         
              model.insertRow(0, new Object[] {words[0]+ " " +words[1],words[2],words[4]});
        }      
              table1.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent mouseEvent) {
                    JTable table =(JTable) mouseEvent.getSource();
                    Point point = mouseEvent.getPoint();
                    int row = table.rowAtPoint(point);
                   // System.out.println("test1");
                    if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                   // System.out.println("test2");
                    int i = table.getSelectedRow(); 
                    String regnum = "" + table.getValueAt(i, 2);
                    String pnumber = "" + table.getValueAt(i, 1);
                    
                    JFrame f1 = new JFrame("Customer details");
                    f1.setVisible(true);
                    f1.setLayout(null); 
                    f1.setBounds(990, 90, 300, 300); 
                    f1.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
                    JLabel jltitle, jlreg, jlpnumb, jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9, jl10, jlplan, jlpremium;
                   
                    try{ 
            FileReader fr2 = new FileReader("C:\\Users\\John\\Desktop\\PROJECS\\InsuranceProject\\src\\insuranceproject\\list.txt"); 
            String[] words2= null;
            BufferedReader br = new BufferedReader(fr2);
            String s; 
            while((s=br.readLine())!=null)   
            {
             words2=s.split("%20");
             if (words2[2].equals(pnumber) && words2[4].equals(regnum)) 
                { 
                    String fname = " " + words2[1].toUpperCase() + " " + words2[0];
                    String nationality = words2[3];
                    String model = words2[5];
                    String type = words2[6];
                    String year = words2[7];
                    String color = words2[8];
                    String value = words2[9];
                    String condition = words2[10];
                    String startcontract = words2[11];
                    int plannb = 1;
                    int length = words2.length;
                    String prem = "";
                      if(words2[length-1].equals("np")) prem = words2[length-2];
                      else prem = "Already paid " + words2[length-1] + " ";
                    String planns12345 = "";
                        
                    Facture f= new Facture();
                    planns12345 = f.getPlans(words2);
                    
                        jl1 = new JLabel("Full name : " + fname); 
                        jl1.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl1.setSize(500, 40); 
                        jl1.setLocation(30, 5); 
                        f1.add(jl1); 
                    
                        jlpnumb = new JLabel("Phone number : " + pnumber); 
                        jlpnumb.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jlpnumb.setSize(500, 40); 
                        jlpnumb.setLocation(30, 20); 
                        f1.add(jlpnumb); 
                        
                        jl2 = new JLabel("Nationality : " + nationality); 
                        jl2.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl2.setSize(500, 40); 
                        jl2.setLocation(30, 35); 
                        f1.add(jl2); 
                        
                        jlreg = new JLabel("Registration number : " + regnum); 
                        jlreg.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jlreg.setSize(500, 40); 
                        jlreg.setLocation(30, 50); 
                        f1.add(jlreg); 
                        
                        jl3 = new JLabel("Vehicule model : " + model); 
                        jl3.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl3.setSize(500, 40); 
                        jl3.setLocation(30, 65); 
                        f1.add(jl3);                         

                        jl4 = new JLabel("Vehicule type : " + type); 
                        jl4.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl4.setSize(500, 40); 
                        jl4.setLocation(30, 80); 
                        f1.add(jl4);                                
                        
                        jl5 = new JLabel("Year : " + year); 
                        jl5.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl5.setSize(500, 40); 
                        jl5.setLocation(30, 95); 
                        f1.add(jl5);                           
                        
                        jl6 = new JLabel("Vehicule color : " + color); 
                        jl6.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl6.setSize(500, 40); 
                        jl6.setLocation(30, 110); 
                        f1.add(jl6);                       
                    
                        jl7 = new JLabel("Vehicule value : " + value); 
                        jl7.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl7.setSize(500, 40); 
                        jl7.setLocation(30, 125); 
                        f1.add(jl7);   
                        
                        jl8 = new JLabel("Vehicule condition :  " + condition); 
                        jl8.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl8.setSize(500, 40); 
                        jl8.setLocation(30, 140); 
                        f1.add(jl8);
                                      
                        jlplan = new JLabel("Plans taken : " + planns12345); 
                        jlplan.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jlplan.setSize(500, 40); 
                        jlplan.setLocation(30, 155); 
                        f1.add(jlplan);
                        
                        jlpremium = new JLabel("Premium : " + prem + "$"); 
                        jlpremium.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jlpremium.setSize(500, 40); 
                        jlpremium.setLocation(30, 170); 
                        f1.add(jlpremium);
                        
                        
                        jl9 = new JLabel("Start of contract date :  " + startcontract); 
                        jl9.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl9.setSize(500, 40); 
                        jl9.setLocation(30, 185); 
                        f1.add(jl9);                        

                    
                      //add exactly 1 year to the initial date of the contract
                       SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
                       Date date1= dmy.parse(startcontract);  
                       Calendar cal = Calendar.getInstance();
                       cal.setTime(date1);
                       cal.add(Calendar.YEAR, 1);
                       Date currentDatePlusOne = cal.getTime();
                       String date3 = dmy.format(currentDatePlusOne);
                        
                    
                        
                        jl10 = new JLabel("End of contract date :  " + date3); 
                        jl10.setFont(new Font("Arial", Font.BOLD, 12)); 
                        jl10.setSize(500, 40); 
                        jl10.setLocation(30, 200); 
                        f1.add(jl10);
                        
                                                              
                        
                    
                } 
              
            }      
                        
            br.close();
            fr2.close(); //added
                    }catch(Exception e){System.out.println(e);}
             
                    
                    }
                }
              } );
            
        br.close(); // added
        fr.close(); // added
        }catch(Exception e){System.out.println(e);}
        
        scrolltable = new JScrollPane (table1);
        scrolltable.setLocation(10, 100);
        scrolltable.setSize(470, 470);
        add(scrolltable);
         scrolltable.setVisible(true);

        setVisible(true); 

        jtf.getDocument().addDocumentListener(new DocumentListener(){
                       
            public void insertUpdate(DocumentEvent e) {
                String text = jtf.getText();

                if (text.trim().length() == 0) {
                    searcht.setRowFilter(null);
                } else {
                    searcht.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

           
            public void removeUpdate(DocumentEvent e) {
                String text = jtf.getText();

                if (text.trim().length() == 0) {
                    searcht.setRowFilter(null);
                } else {
                    searcht.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

         
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });


            
        }

    }



