import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
class EditFrame extends JFrame{
Container c;
JLabel lb1Name,lb1Eid,lb1Marks;

JTextField txtEid,txtEname,txtMarks;

JButton btnEdit,btnBack;


EditFrame(){
	
	c=getContentPane();
	c.setLayout(new FlowLayout());
	lb1Eid = new JLabel("EID");
	txtEid = new JTextField(15);
	
	lb1Name = new JLabel("Sname");
	txtEname = new JTextField(15);
	
	
		
	lb1Marks = new JLabel("Marks");
	txtMarks = new JTextField(15);
	
	
	
	btnEdit = new JButton("Edit");
	btnBack = new JButton("BAck");
	
	c.add(lb1Eid);
	c.add(txtEid);
	c.add(lb1Name);
	c.add(txtEname);
	
	c.add(lb1Marks);
	c.add(txtMarks);
	
	c.add(btnEdit);
	c.add(btnBack);
	
	
	ActionListener a2 = (ae)->{
		
		
		String eidInStr = txtEid.getText();			
		String ename = txtEname.getText();	
		String eidMarks = txtMarks.getText();	
		
		String regex = "\\d+";
		
		Boolean b=eidInStr.matches(regex);
		
		Boolean b2=ename.matches(regex);
		
		Boolean b3=eidMarks.matches(regex);
		
		
		int eMarks2=0;
		if(b==true){
			eMarks2 = Integer.parseInt(txtMarks.getText());
		}
		
			
		
			
		if(b==true & b2==false & b3==true & ename.length()>=2 & eMarks2>=0 & eMarks2<=100){
		
		
		
		
		
		int eid = Integer.parseInt(txtEid.getText());
	
		int marks = Integer.parseInt(txtMarks.getText());
		
		new DbHandler().editStudent(eid,ename,marks);
		
		
		
		txtEid.setText("");
		txtEname.setText("");
		txtMarks.setText("");
			txtEid.requestFocus();
			
			
			
			}
		
		else{
			
			
			
			
						try{
		 URL url = this.getClass().getClassLoader().getResource("sorry.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
	  clip.open(audioIn);
	  
	  
	
			clip.start();
			
			
			}
			catch(UnsupportedAudioFileException be){ be.printStackTrace();}

 catch (IOException e) {   e.printStackTrace(); } 
 catch (LineUnavailableException e) { e.printStackTrace();}
			
			
			
			
			
			
			
			
			JOptionPane.showMessageDialog(c,"Put valid Entries");
			txtEid.setText("");
			
			txtEname.setText("");
			txtMarks.setText("");
			txtEid.requestFocus();
			
		}
		
		
		
		
	};
	btnEdit.addActionListener(a2);



	
	
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