package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date; 

public class FastCash extends JFrame implements ActionListener {

    JButton rh, rfh, rt, rtt, rft, rtt1, back;
    String pinno;
    
    FastCash(String pinno) {
        this.pinno = pinno;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        rh = new JButton("Rs 100");
        rh.setBounds(170, 415, 150, 30);
        rh.addActionListener(this);
        image.add(rh);
        
        rfh = new JButton("Rs 500");
        rfh.setBounds(355, 415, 150, 30);
        rfh.addActionListener(this);
        image.add(rfh);

        rt = new JButton("Rs 1000");
        rt.setBounds(170, 450, 150, 30);
        rt.addActionListener(this);
        image.add(rt);
                
        rtt = new JButton("Rs 2000");
        rtt.setBounds(355, 450, 150, 30);
        rtt.addActionListener(this);
        image.add(rtt);
        
        rft = new JButton("Rs 5000");
        rft.setBounds(170, 485, 150, 30);
        rft.addActionListener(this);
        image.add(rft);
        
        rtt1 = new JButton("Rs 10000");
        rtt1.setBounds(355, 485, 150, 30);
        rtt1.addActionListener(this);
        image.add(rtt1);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        
        setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn con = new Conn();
            try {
                String q1 = "select * from bank where pin = '"+pinno+"'";
                ResultSet rs = con.s.executeQuery(q1);
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && balance <Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                } else {
                    
                    Date date = new Date();
                    String q = "insert into bank values('"+pinno+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                    con.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                    
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
       new FastCash("");
    }
}
