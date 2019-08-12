import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
class DeleteFrame extends JFrame{
Container c;
JLabel lb1Eid;

JTextField txtEid,txtEname;

JButton btnDelete,btnBack;


DeleteFrame(){
	
	c=getContentPane();
	c.setLayout(new FlowLayout());
	lb1Eid = new JLabel("EID");
	txtEid = new JTextField(15);
	
	
	btnDelete = new JButton("Delete");
	btnBack = new JButton("BAck");
	
	c.add(lb1Eid);
	c.add(txtEid);
	
	
	c.add(btnDelete);
	c.add(btnBack);
	
	
	ActionListener a2 = (ae)->{		
		String eidInStr = txtEid.getText();			
		String regex = "\\d+";
		
		Boolean b=eidInStr.matches(regex);
		
			
		if(b==true){
		
		
		int eid = Integer.parseInt(txtEid.getText());
	
		
		new DbHandler().deleteEmployee(eid);
			txtEid.setText("");
			txtEid.requestFocus();
		}
		
		else{
			System.out.println("Invalid Inputt");
			JOptionPane.showMessageDialog(c,"Invalid Inputt ");
			txtEid.setText("");
			txtEid.requestFocus();
			
		}
		
		
	};
	btnDelete.addActionListener(a2);
	
	
	ActionListener a1 = (ae)->{
		MainFrame a = new MainFrame();
		dispose();
		
		
		
	};
	btnBack.addActionListener(a1);
	
	setTitle("Edit Student");
	setSize(800,500);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
	
	
}
	
	
	
}