/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

/**
 *
 * @author saranshkalra
 */

//declaring the account class
class Account {
        //variable to store the name of the account holder
	private String strName;
        //variable to store the id of the account holder
	private int intId;
        //variable to store the account type of the account holder
	private char charAccountType;
        //variable to store the balance of the account holder
	private double doubleBalance;
	
        //default constructor
	public Account() {
		this.strName = "";
		this.intId = 0;
		this.charAccountType = 'c';
		this.doubleBalance = 0;
	}
        
        //parametrized constructor
	public Account(String strName, int id, char accountType, double balance) {
		this.strName = strName;
		this.intId = id;
		this.charAccountType = accountType;
		this.doubleBalance = balance;
	}
        
        //accessor for name of the account holder
	public String getStrName() {
		return strName;
	}
        
        //mutator for name of the account holder
	public void setStrName(String strName) {
		this.strName = strName;
	}
        
        //accessor for id of the account holder
	public int getId() {
		return intId;
	}
        
        //mutator for id of the account holder
	public void setId(int id) {
		this.intId = id;
	}
        
        //accessor for account type of the account holder
	public char getAccountType() {
		return charAccountType;
	}

        //mutator for account type of the account holder
	public void setAccountType(char accountType) {
		this.charAccountType = accountType;
	}

        //accessor for balance of the account holder
	public double getBalance() {
		return doubleBalance;
	}
        
        //mutator for balance of the account holder
	public void setBalance(double balance) {
		this.doubleBalance = balance;
	}
        
	//function for withdrawing an amount from the balance
	public void withdraw(double amount)  {
		this.doubleBalance -= amount; 
	}
	
	//function for depositing an amount from the balance
	public void deposit(double amount) {
		this.doubleBalance += amount; 
	}
	
        //function to display the balance in the account holders account
	public void displayBalance( ) {
		JOptionPane.showMessageDialog(null, "Balance: " + getBalance());
	}
	
        //function to display all the information of the account
	public void displayAll() {             
                JOptionPane.showMessageDialog(null, "Name: " + getStrName() 
                                                 +"\nId: " + getId()
                                                 +"\nAccount Type: " + getAccountType() 
                                                 +"\nBalance: " + getBalance() + "\n");
                    
        }
}

class SavingsAccount extends Account{
	private double doubleRate;
	
        //parametrized constructor
	public SavingsAccount(double rate, String strName, int id, char accountType, 
                              double balance) {
                //call to parameterized constructor of parent class
		super(strName,id,accountType,balance);
		this.doubleRate = rate;
	}
        
        //parametrized constructor with default for super class
	public SavingsAccount(double rate) {
                //call to default constructor of parent class
		super();
		this.doubleRate = rate;
	}
	
        //default constructor
	public SavingsAccount() {
                //call to default constructor of parent class
		super();
		this.doubleRate = 0;
	}
        
        //function to add interst on the balance in the account  balance
	public void addInterest() {
		setBalance((100 + doubleRate) * getBalance());
	}
	
        //function to deduct the loan from the account balance
	public void deductLoan(double loan) {
		setBalance(getBalance()-loan);
	}
        
        //function to delete an account by account holder id 
        public static int deleteAnAccountById(SavingsAccount Acc[], int id, int size) {
            //variable to store if the record with that name found or not
            int found = 0;
            //loop to find the person whose id is entered to be deleted
            for (int i = 0; i < size; i++) {
                //if the id matches
                if(Acc[i].getId() == id) {
                    //copy the rest of the array as copying the next account info 
                    //into the current one till size-1
                    while(i < size-1) {
                        Acc[i] = Acc[i+1];
                        i++;
                    }
                    //since one account got deleted decrease the size by one
                    size--;
                    //setting found = 1 if found
                    found = 1;
                    //then break out of the loop since the account was found
                    break;
                }
            }
            
            //if found is still zero means not found, display error message
            if(found == 0) {
                JOptionPane.showMessageDialog(null, "Record with this Id doesn't exist");
            }
            
            //return to size to update it
            return size;
        }
        
        //function to delete by account by account holder name
        public static int deleteAnAccountByName(SavingsAccount Acc[], String strName, int size) {
            //variable to store if the record with that name found or not
            int found = 0;
            //loop to find the person whose name is entered to be deleted
            for (int i = 0; i < size; i++) {
                //if the name matches
                if(Acc[i].getStrName().equals(strName)) {
                    //copy the rest of the array as copying the next account info 
                    //into the current one till size-1
                    while(i < size-1) {
                        Acc[i] = Acc[i+1];
                        i++;
                    }
                    //since one account got deleted decrease the size by one
                    size--;
                    //setting found = 1 if found
                    found = 1;
                    //then break out of the loop since the account was found
                    break;
                }
            }
            
            //if found is still zero means not found, display error message
            if(found == 0) {
                JOptionPane.showMessageDialog(null, "Record with this name doesn't exist");
            }
            
            //return to size to update it
            return size;
        }
        
        //function for sorting by name (bubble sort)
        public static void SortByName(SavingsAccount Acc[]) {
            String tempStrName;
            int tempId;
            char tempAccountType;
            double tempBalance;
            for (int j = 0; j<Acc.length-1; j++)
            {
               for (int i = 0; i<Acc.length-1; i++)
               {
                   if(Acc[i].getStrName().compareTo(Acc[j].getStrName())>0)
                   {
                       tempStrName = Acc[i].getStrName();
                       tempId = Acc[i].getId();
                       tempAccountType = Acc[i].getAccountType();
                       tempBalance = Acc[i].getBalance();
                       Acc[i].setStrName(Acc[j].getStrName());
                       Acc[i].setId(Acc[j].getId());
                       Acc[i].setAccountType(Acc[j].getAccountType());
                       Acc[i].setBalance(Acc[j].getBalance());
                       Acc[j].setAccountType(tempAccountType);
                       Acc[j].setStrName(tempStrName);
                       Acc[j].setBalance(tempBalance);
                       Acc[j].setId(tempId);
                    }
                }

            }
        }
        
        //over riding parent function to display all the information of all accounts 
        //in the whole array
        public static String displayAll(SavingsAccount Acc[], int size) {
            String str = "";
            for(int i = 0; i < size; i++) {
                str += "Name: " + Acc[i].getStrName() 
                    +"\nId: " + Acc[i].getId()
                    +"\nAccount Type: " + Acc[i].getAccountType() 
                    +"\nBalance: " + Acc[i].getBalance() + "\n\n";
                    
                    
            } 
            return str;
        }
}

class SampleDialog1 extends JDialog implements ActionListener{
    
    //bolean variables to store which radio button is currently selected
    boolean bmRb1= false;
    boolean bmRb2=false;
    boolean bmRb3=false;
    
    //global variable size to keep track of how many accounts are left
    int size = 50; 
    
    //declaration for an array of 50 objects of SavingsAccount class
    SavingsAccount[] arr = new SavingsAccount[50];
    
    JRadioButton MRB1 = new JRadioButton();
    JRadioButton MRB2 = new JRadioButton();
    JRadioButton MRB3 = new JRadioButton();
    JTextField MTF11 = new JTextField(10);
    JTextField MTF21 = new JTextField(10);
    JButton btnSubmit = new JButton("Submit");
    JLabel jLabel1 = new JLabel ("Enter Id: ");
    JLabel jLabel2 = new JLabel ("Enter Name: ");
    JLabel jLabel3 = new JLabel ("SortByName ");
    
    
    SampleDialog1(JFrame f, String str) {
        
        super(f,str);
        setLayout(new FlowLayout());
        setSize(800,400);
        add(MRB1);
        add(jLabel1);
        add(MTF11);
        add(MRB2);
        add(jLabel2);
        add(MTF21);
        add(MRB3);
        add(jLabel3);
        add(btnSubmit);
        ButtonGroup group = new ButtonGroup();
        group.add(MRB1);
        group.add(MRB2);
        group.add(MRB3);
        //disabling both the text fields
        MTF11.setEnabled(false);
        MTF21.setEnabled(false);
        
        //initialises the array elements of SavingsAccount class using 
        //parameterized constructor
        arr[0] = new SavingsAccount(2.6,"ab", 1, 's', 5000.00);
        arr[1] = new SavingsAccount(1.2,"ac", 11, 'c', 1000.00); 
        arr[2] = new SavingsAccount(3.4,"hg", 33, 's', 6000.00);
        arr[3] = new SavingsAccount(3.1,"res", 24, 'c', 2200.00);
        arr[4] = new SavingsAccount(2.4,"sk", 80, 'c', 2000.00);
        arr[5] = new SavingsAccount(2.7,"jg", 2, 's', 4300.00);
        arr[6] = new SavingsAccount(2.9,"dfg", 43, 's', 7000.00);
        arr[7] = new SavingsAccount(3.2,"asd", 20, 'c', 9000.00);
        arr[8] = new SavingsAccount(4.2,"tyr", 34, 's', 5400.00);
        arr[9] = new SavingsAccount(2.6,"yuy", 35, 'c', 6800.00);
        arr[10] = new SavingsAccount(2.0,"pik", 42, 'c', 2700.00);
        arr[11] = new SavingsAccount(2.4,"lkj", 39, 's', 5900.00);
        arr[12] = new SavingsAccount(3.8,"ndr", 53, 'c', 9800.00);
        arr[13] = new SavingsAccount(7.5,"lkk", 65, 's', 4800.00);
        arr[14] = new SavingsAccount(4.7,"hgg", 62, 'c', 8800.00);
        arr[15] = new SavingsAccount(2.2,"kjl", 54, 'c', 22200.00);
        arr[16] = new SavingsAccount(2.4,"str", 22, 's', 10000.00);
        arr[17] = new SavingsAccount(2.8,"bvc", 16, 'c', 2000.00);
        arr[18] = new SavingsAccount(6.4,"bmn", 76, 's', 9100.00);
        arr[19] = new SavingsAccount(2.4,"awse", 5, 'c', 12000.00);
        arr[20] = new SavingsAccount(4.4,"lkji", 55, 'c', 7600.00);
        arr[21] = new SavingsAccount(2.4,"yuit", 190, 's', 2340.00);
        arr[22] = new SavingsAccount(8.4,"vcfd", 9, 'c', 9870.00);
        arr[23] = new SavingsAccount(7.4,"trde", 67, 'c', 4360.00);
        arr[24] = new SavingsAccount(6.4,"nvbg", 4, 's', 2570.00);
        arr[25] = new SavingsAccount(5.4,"amh", 3, 'c', 3300.00);
        arr[26] = new SavingsAccount(3.9,"pan", 44, 'c', 8765.00);
        arr[27] = new SavingsAccount(2.4,"bvcf", 36, 'c', 9356.00);
        arr[28] = new SavingsAccount(7.4,"sijy", 74, 's', 66000.00);
        arr[29] = new SavingsAccount(9.4,"mnrd", 14, 'c', 2000.00);
        arr[30] = new SavingsAccount(11.4,"jav", 87, 'c', 99700.00);
        arr[31] = new SavingsAccount(2.0,"manh", 75, 'c', 12000.00);
        arr[32] = new SavingsAccount(2.1,"gdfr", 66, 's', 14500.00);
        arr[33] = new SavingsAccount(2.5,"vbgf", 144, 'c', 28700.00);
        arr[34] = new SavingsAccount(2.4,"dsjl", 47, 'c', 92000.00);
        arr[35] = new SavingsAccount(3.0,"srgy", 82, 'c', 87600.00);
        arr[36] = new SavingsAccount(2.1,"hgbn", 121, 's', 90100.00);
        arr[37] = new SavingsAccount(2.5,"bvhn", 10, 'c', 2900.00);
        arr[38] = new SavingsAccount(2.9,"zxsd", 13, 's', 26000.00);
        arr[39] = new SavingsAccount(4.4,"cvbn", 12, 'c', 29500.00);
        arr[40] = new SavingsAccount(6.4,"fcds", 29, 'c', 53700.00);
        arr[41] = new SavingsAccount(2.3,"rety", 123, 'c', 84210.00);
        arr[42] = new SavingsAccount(1.4,"vkjhy", 187, 's', 90800.00);
        arr[43] = new SavingsAccount(2.4,"cvert", 145, 'c', 88900.00);
        arr[44] = new SavingsAccount(2.9,"laxd", 8, 'c', 74640.00);
        arr[45] = new SavingsAccount(2.4,"bbcc", 10, 's', 87770.00);
        arr[46] = new SavingsAccount(3.4,"pklo", 6, 's', 99900.00);
        arr[47] = new SavingsAccount(7.4,"kkkg", 124, 'c', 54500.00);
        arr[48] = new SavingsAccount(2.4,"jhfhf", 7, 'c', 75890.00);
        arr[49] = new SavingsAccount(2.4,"mbnnn", 90, 's', 27650.00);
        
        
        btnSubmit.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                //variable for storing the new size returned after deleting an account
                int size1 = 0;
                //if radio button one is selected and submit button is clicked
                if(bmRb1){
                    //store the id entered in the text box in a string
                    String strId = MTF11.getText();
                    //convert the string to integer as the id is an integer
                    int intId = Integer.parseInt(strId);
                    //call delete an account by id function and store the return value in size1 
                    size1 = SavingsAccount.deleteAnAccountById(arr, intId, size);
                }

                //if radio button two is selected and submit button is clicked
                else if(bmRb2){
                    //store the name entered in the text box in a string
                    String strName = MTF21.getText();
                    //call delete an account by name function and store the return value in size1 
                    size1 = SavingsAccount.deleteAnAccountByName(arr, strName, size); 
                }

                //if radio button three is selected and submit button is clicked
                else if(bmRb3){
                    //sort the array arr by name by calling sort by name function of savingsAccount class
                    SavingsAccount.SortByName(arr);             
                }

                //Create a text area and display all the accounts in the array only if size1 has changed 
                //and is not the same as size because if that is the case the account didnt get 
                //deleted as it was not found
                if(size1!=size) {
                    // create a JTextArea with 35 and 40 as dimensions
                    JTextArea textArea = new JTextArea(35, 40);
                    //Set its text as display all function call of savingsaccount class
                    textArea.setText(SavingsAccount.displayAll(arr,size));
                    //set the text area to be uneditable
                    textArea.setEditable(false);

                    // wrap a scrollpane around it
                    JScrollPane scrollPane = new JScrollPane(textArea);

                    // display them in a message dialog
                    JOptionPane.showMessageDialog(null, scrollPane);
                }
            
            }});
        
        MRB1.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                //Text box 1 enabled for entering id 
                MTF11.setEnabled(true);
                MTF21.setEnabled(false);
                //boolean radio button 1 made true when radio button 1 selected
                bmRb1= true;
                bmRb2=false;
                bmRb3=false;
            }});
        
        MRB2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                MTF11.setEnabled(false);
                //Text box 2 enabled for entering id 
                MTF21.setEnabled(true);
                bmRb1= false;
                //boolean radio button 2 made true when radio button 1 selected
                bmRb2=true;
                bmRb3=false;
            }});
        
        MRB3.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                //Both text boxes disabled as none are needed
                MTF11.setEnabled(false);
                MTF21.setEnabled(false);
                bmRb1= false;
                bmRb2=false;
                //boolean radio button 3 made true when radio button 1 selected
                bmRb3=true;
            }});
    
    }
    
    public void actionPerformed (ActionEvent event) {
        
        
        
    }                     
    
}

class SampleDialog2 extends JDialog implements ActionListener{
   

    JButton btn = new JButton("Exit");
    
    
    SampleDialog2(JFrame f, String str) {
        super(f,str);
        setLayout(new FlowLayout());
        setSize(400,400);
        add(btn);
        btn.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent event) {
        System.exit(0);
    }
    
}


public class ProjectSim extends javax.swing.JFrame {

    /**
     * Creates new form ProjectSim
     */
    public ProjectSim() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        option2 = new javax.swing.JMenuItem();
        option1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        option2.setText("Perform Action");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });
        jMenu1.add(option2);

        option1.setText("Exit");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });
        jMenu1.add(option1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed
        // TODO add your handling code here:
        ProjectSim objf = new ProjectSim();
        SampleDialog2 objSD2 = new SampleDialog2 (objf,"Exit Menu");
        objSD2.setVisible(true);
    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed
        // TODO add your handling code here:
        ProjectSim objf = new ProjectSim();
        SampleDialog1 objSD = new SampleDialog1 (objf,"Perform Action Menu");
        objSD.setVisible(true);
    }//GEN-LAST:event_option2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectSim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectSim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem option1;
    private javax.swing.JMenuItem option2;
    // End of variables declaration//GEN-END:variables
}
