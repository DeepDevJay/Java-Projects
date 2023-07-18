package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,education,occupation;
    String formno;
    
    SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
        JLabel religionlab = new JLabel("Religion: ");
        religionlab.setFont(new Font("Raleway", Font.BOLD, 20));
        religionlab.setBounds(100,140,100,30);
        add(religionlab);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion); 
        
        JLabel categorylab = new JLabel("Category: ");
        categorylab.setFont(new Font("Raleway", Font.BOLD, 20));
        categorylab.setBounds(100,190,200,30);
        add(categorylab);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel incomelab = new JLabel("Income: ");
        incomelab.setFont(new Font("Raleway", Font.BOLD, 20));
        incomelab.setBounds(100,240,200,30);
        add(incomelab);
        
        String incomecategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
  
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationvalues[] = {"Non-Graduation","Graduate","Post-Graduation","PHD","Other"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupationlab = new JLabel("Occupation: ");
        occupationlab.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationlab.setBounds(100,390,200,30);
        add(occupationlab);
        
        String occupationvalues[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panlab = new JLabel("Pan No: ");
        panlab.setFont(new Font("Raleway", Font.BOLD, 20));
        panlab.setBounds(100,440,200,30);
        add(panlab);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        JLabel aadharlab = new JLabel("Aadhar No: ");
        aadharlab.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharlab.setBounds(100,490,200,30);
        add(aadharlab);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100,540,200,30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup eaccountgroup = new ButtonGroup();
        eaccountgroup.add(eyes);
        eaccountgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) { 
        String sreligion = (String)religion.getSelectedItem(); 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        String gender = null;
        if(syes.isSelected()) {
            gender = "Yes";
        } else if(sno.isSelected()) {
            gender = "No";
        }
        
        String existingaccount = null;
        if(eyes.isSelected()) {
            existingaccount = "Yes";
        } else if(eno.isSelected()) {
            existingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();

        try {
                Conn c = new Conn();
                String query = "Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"',"
                        + "'"+seducation+"','"+soccupation+"','"+seniorcitizen+"','"+existingaccount+"','"+span+"','"+saadhar+"')";
                c.s.executeUpdate(query);
                
                // Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                    
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
          
    }
}
