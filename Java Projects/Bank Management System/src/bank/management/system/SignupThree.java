package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancle; 
    String formno;

    SignupThree(String formno) {
        
        this.formno = formno;
        
        setLayout(null);    
        
        JLabel acdetails = new JLabel("Page 3: Account Details");
        acdetails.setFont(new Font("Raleway", Font.BOLD, 22));
        acdetails.setBounds(280, 40, 400, 40);
        add(acdetails);
        
        JLabel actype = new JLabel("Account Type: ");
        actype.setFont(new Font("Raleway", Font.BOLD, 22));
        actype.setBounds(100, 140, 200, 30);
        add(actype);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 250, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel cardno = new JLabel("Card Number: ");
        cardno.setFont(new Font("Raleway", Font.BOLD, 22));
        cardno.setBounds(100, 300, 200, 30);
        add(cardno);
        
        JLabel cnumber = new JLabel("xxxx-xxxx-xxxx-2002");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        cnumber.setBounds(330, 300, 300, 30);
        add(cnumber);
        
        JLabel cndetail = new JLabel("Your 16 Digit Card Number");
        cndetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cndetail.setBounds(100, 330, 300, 20);
        add(cndetail);
        
        JLabel pinno = new JLabel("PIN Number: ");
        pinno.setFont(new Font("Raleway", Font.BOLD, 22));
        pinno.setBounds(100, 370, 200, 30);
        add(pinno);
        
        JLabel pnumber = new JLabel("xxxx");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);
        
        JLabel pdetail = new JLabel("Your 4 Digit Password");
        pdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetail.setBounds(100, 400, 300, 20);
        add(pdetail);
        
        JLabel services = new JLabel("Services Required: ");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 400, 30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway", Font.BOLD, 14));
        cancle.setBounds(420, 720, 100, 30);
        cancle.addActionListener(this);
        add(cancle);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(r1.isSelected()) {
                accountType = "Saving Account";
            } else if(r2.isSelected()) {
                accountType = "Fixed Deposite Account";
            } else if(r3.isSelected()) {
                accountType = "Fixed Deposite Account";
            } else if(r4.isSelected()) {
                accountType = "Recurring Deposite Account";
            }    
            
            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()) {
                facility = facility + "ATM Card";
            } else if(c2.isSelected()) {
                facility = facility + "Internet Banking";
            } else if(c3.isSelected()) {
                facility = facility + "Mobile Banking";
            } else if(c4.isSelected()) {
                facility = facility + "Email & SMS Alerts";
            } else if(c5.isSelected()) {
                facility = facility + "Cheque Book";
            } else if(c6.isSelected()) {
                facility = facility + "E-Statement";
            }
            
            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String q1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardno+"', '"+pinno+"', '"+facility+"')";
                    String q2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pinno+"')";
                    
                    conn.s.executeUpdate(q1);
                    conn.s.executeUpdate(q2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number" + cardno + "\n Pin: " + pinno);
                
                    setVisible(false);
                    new Deposit(pinno).setVisible(false);
                }
            } catch(Exception e) {
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancle) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
