//package com.java;
//
///******************************************************************************
//*	Program Author: Dr. Yongming Tang for CSCI 6810 Java and the Internet	  *
//*	Date: February, 2014													  *
//*******************************************************************************/
//
//import java.awt.*;     //including Java packages used by this program
//import java.awt.event.*;
//import javax.swing.*;
//
//class TransferPanel extends JPanel implements ActionListener
//{
//    private JButton TransferButton;
//    private JTextField AmountField, FromField, ToField;
//    private JComboBox transferFrom, transferTo;
//    private String Amount, From, To, UName;
//
//    public TransferPanel(String UName)
//    {
//    	TransferControl1 OC = new TransferControl1(UName);
//        TransferButton = new JButton("Transfer"); //initializing two button references
//
//        transferFrom = new JComboBox(OC.accList);
//		transferTo = new JComboBox(OC.accList);
//
//        AmountField = new JTextField(15);
//        AmountField.setText("0.0");
//
//        //JLabel TypeLabel = new JLabel("Choose Account Type: ");
//        JLabel FromLabel = new JLabel("FROM Account:");
//        JLabel ToLabel = new JLabel("TO Account");
//        JLabel AmountLabel = new JLabel("Enter amount to transfer");
//
//        JPanel FromPanel = new JPanel();
//        JPanel ToPanel = new JPanel();
//        JPanel AmountPanel = new JPanel();
//
//
//        FromPanel.add(FromLabel); // list all accounts
//        FromPanel.add(transferFrom);
//        ToPanel.add(ToLabel);
//        ToPanel.add(transferTo);
//        AmountPanel.add(AmountLabel);
//        AmountPanel.add(AmountField);
//
//        add(FromPanel);
//        add(ToPanel);
//        add(AmountPanel);
//
//        add(TransferButton);  //add the two buttons on to this panel
//        TransferButton.addActionListener(this); //event listener registration
//    }
//
//    public void actionPerformed(ActionEvent evt)  //event handling
//    {
//        //Object source = evt.getSource(); //get who generates this event
//        String arg = evt.getActionCommand();
//        if (arg.equals("Transfer")) { //determine which button is clicked
//        	
//            Amount = AmountField.getText();
//            From = (String)transferFrom.getSelectedItem();
//            To = (String)transferTo.getSelectedItem();
//            if (From.equals("") || To.equals(""))
//                JOptionPane.showMessageDialog(null, "Please Choose an Account!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//            else if (From == To )
//                     JOptionPane.showMessageDialog(null, "Same Account can't be used for transfer, use different accounts", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//                 else {
//					 TransferControl1 OBAcct_Ctrl = new TransferControl1(UName);
//				 }
//
//            //Acct = new Account(UName, PsWord, PsWord1, Name);
//            //if (Acct.signUp())
//                //JOptionPane.showMessageDialog(null, "Account has been open!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//            //else
//                //JOptionPane.showMessageDialog(null, "Account creation failed due to an invalid email address or unmatched passwords or the email address exists.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
//		}
//    }
///*
//    public String getUsername() {
//		return UName;
//	};
//
//	public String getPassword() {
//	    return PsWord;
//	}
//
//	public String getPassword1() {
//	    return PsWord1;
//	}*/
//}
//
//public class TransferBO1 extends JFrame
//{
//    private TransferPanel OBA_Panel;
//
//    public TransferBO1(String UName)
//    {
//        setTitle("Transfer");
//        setSize(350, 260);
//
//         //get screen size and set the location of the frame
//         Toolkit tk = Toolkit.getDefaultToolkit();
//         Dimension d = tk.getScreenSize();
//         int screenHeight = d.height;
//         int screenWidth = d.width;
//         setLocation( screenWidth / 3, screenHeight / 4);
//
//         addWindowListener (new WindowAdapter()  //handle window event
//            {
//		       public void windowClosing (WindowEvent e)
//			                  { System.exit(0);
//               }
//            });
//
//         Container contentPane = getContentPane(); //add a panel to a frame
//         OBA_Panel = new TransferPanel(UName);
//         contentPane.add(OBA_Panel);
//         show();
//    }
//
//    /*public static void main(String [] args)
//    { JFrame frame = new SignUpBO(); //initialize a JFrame object
//      frame.show(); //display the frame
//    }*/
//}
//
