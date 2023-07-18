
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JPasswordField pin, rpin;
    JButton change, back; 
    String pinno;

    PinChange(String pinno) {
        
        this.pinno = pinno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel rpintext = new JLabel("Re-Enter New PIN: ");
        rpintext.setForeground(Color.WHITE);
        rpintext.setFont(new Font("System", Font.BOLD, 16));
        rpintext.setBounds(165, 360, 180, 25);
        image.add(rpintext);
        
        rpin = new JPasswordField();
        rpin.setFont(new Font("Raleway", Font.BOLD, 25));
        rpin.setBounds(330, 360, 180, 25);
        image.add(rpin);
        
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
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
        if(ae.getSource() == change) {
            try {
            String npin = pin.getText();
            String repin = rpin.getText();
            
                if(!npin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                
                if(repin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                
                Conn cn = new Conn();
                String q1 = "Update bank set pin = '"+repin+"' where pin = '"+pinno+"'";
                String q2 = "Update login set pinno = '"+repin+"' where pinno = '"+pinno+"'";
                String q3 = "Update signupthree set pinno = '"+repin+"' where pinno = '"+pinno+"'";
                
                cn.s.executeUpdate(q1); 
                cn.s.executeUpdate(q2); 
                cn.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(repin).setVisible(true);
                
            } catch(Exception e) {
                System.out.println(e);
            } 
        } else {
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
