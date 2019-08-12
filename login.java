import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

class login extends JFrame{
Container c;
JLabel lb1Name,lb1Eid;

JTextField txtEname;
JPasswordField txtEid;
JButton btnSave,btnBack;


login(){
	
	
	c=getContentPane();
	c.setLayout(new FlowLayout());
	lb1Eid = new JLabel("Password");
	txtEid = new JPasswordField(15);
	
	lb1Name = new JLabel("UserName");
	txtEname = new JTextField(15);
	
	
		
	btnSave = new JButton("Login");
	btnBack = new JButton("Exit");
	
	
	c.add(lb1Name);
	c.add(txtEname);
	c.add(lb1Eid);
	c.add(txtEid);
	c.add(btnSave);
	c.add(btnBack);
	
	
		
	ActionListener a1 = (ae)->{
		
			
		String eidInStr = txtEid.getText();			
		String ename = txtEname.getText();	
		
		
		if(eidInStr.equals("123")&&ename.equals("abc")){
			
		MainFrame a = new MainFrame();
		dispose();
		}
		else{
			JOptionPane.showMessageDialog(c,"Invalid username and password");
						
			txtEid.setText("");		
			txtEname.setText("");
			txtEid.requestFocus();						
						
		}
		
		
		
	};
	btnSave.addActionListener(a1);
	
	
	
		

ActionListener a5 = (ae)->{
	
	System.exit(0);
	
	
	
};
btnBack.addActionListener(a5);
	
	
	
	
	
	setTitle("Login");
	setSize(250,300);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
}public static void main(String args[]){
	login l1 = new login();
	
	
}

}
	
	
	
	
	