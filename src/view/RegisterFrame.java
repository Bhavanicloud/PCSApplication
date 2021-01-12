package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class RegisterFrame extends JFrame {
    JLabel lTitle,lId,lName,lGender,lUserId, lPassword,lConformpassword,lContact;
    JTextField tId,tName,tGender,tContact,tUserId;
	JPasswordField tPassword,tConformpassword;
	JCheckBox cShowPassword;
    JButton bRegister;
    JRadioButton rMale,rFemale;
    ButtonGroup bBg;
    JPanel pPanel;
    JTable tTable;
    JScrollPane sScrollpane;
	Container container;
	public RegisterFrame() {
		container = getContentPane();
		lId = new JLabel("ID");
		
		lName= new JLabel("Name");
		lGender= new JLabel("Gender");
		lContact= new JLabel("Contact");
		lUserId=new JLabel("Username");
		lPassword=new JLabel("Password");
		lConformpassword=new JLabel("ConformPassword");
		//passfield
		tPassword=new JPasswordField();
		tConformpassword=new JPasswordField();
		//text field block
		tId = new JTextField();
		tName = new JTextField();
		tGender = new JTextField();
		tContact = new JTextField();
		tUserId=new JTextField();
		//
		cShowPassword=new JCheckBox("Show Password");
		
		//Radio Button
		rMale = new JRadioButton("Male");
		rFemale = new JRadioButton("Female");
		//ButtonGroup
		bBg = new ButtonGroup();
		//Button
		
		bRegister = new JButton("Register");
		
		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				callDispose();
				new SuccessfullyRegistered();
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		  
		this.setTitle("REGISTRATION FORM");
		this.setVisible(true);
		this.setBounds(10,10,500,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);//fixed size frame
		
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lId.setBounds(100,50,60,30);
		lName.setBounds(100,85,60,30);
		lGender.setBounds(100, 120, 60, 30);
		lContact.setBounds(100,190,60,30);
		tId.setBounds(200, 50, 130, 30);
		tName.setBounds(200, 85, 130, 30);
		tContact.setBounds(200, 190, 130, 30);
		bRegister.setBounds(200,500,100,50);
		rFemale.setBounds(260, 120, 70, 30);
	    rMale.setBounds(205, 120, 60, 30);
	    lUserId.setBounds(100, 240, 60, 30);
		lPassword.setBounds(100,280,60,30);
		tUserId.setBounds(200,240,130,30);
		tPassword.setBounds(200,280,130,30);
		cShowPassword.setBounds(200,320,150,30);
		tConformpassword.setBounds(260,360,150,30);
		lConformpassword.setBounds(100,360,120,30);
		
		}
	
	public void addComponentsToContainer() {
		container.add(lId);
		container.add(lName);
		container.add(lGender);
		container.add(lContact);
		container.add(tId);
		container.add(tName);
		container.add(tContact);
		container.add(rMale);
		container.add(rFemale);
		container.add(rMale); 
        container.add(rFemale); 
        container.add(bRegister);
        container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(cShowPassword);
		container.add(lConformpassword);
		container.add(tConformpassword);
		
		
		
	}
	public void callDispose() {
		this.dispose();
	}

}
