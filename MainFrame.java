import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;



class MainFrame extends JFrame{

Container c;
JButton btnAdd,btnView,btnEdit,btnDelete,btnExit;


MainFrame(){
	
	c=getContentPane();
	c.setLayout(new FlowLayout());
	btnAdd = new JButton("Add");
	btnView = new JButton("View");
	
	btnEdit= new JButton("Edit");
	
	btnDelete= new JButton("Delete");
	btnExit= new JButton("Exit");
	c.add(btnAdd);
	c.add(btnView);
	c.add(btnEdit);
	c.add(btnDelete);
	c.add(btnExit);
	
	
	ActionListener a1 = (ae)->{
		
		AddFrame a = new AddFrame();
		dispose();
				
	};
	btnAdd.addActionListener(a1);
	
	
	ActionListener a2 = (ae)->{
		ViewFrame a = new ViewFrame();
		dispose();	
		
	};
	btnView.addActionListener(a2);
	
	
	
	
ActionListener a3 = (ae)->{
	
	EditFrame a = new EditFrame();
	dispose();
	
	
};
btnEdit.addActionListener(a3);



ActionListener a4 = (ae)->{
	
	DeleteFrame a = new DeleteFrame();
	dispose();
	
	
};
btnDelete.addActionListener(a4);
	
	

ActionListener a5 = (ae)->{
	
	System.exit(0);
	
	
	
};
btnExit.addActionListener(a5);
	
	
	
	
	
	
	
	
	setTitle("Student Management");
	setSize(800,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
	
}

public static void main(String args[]){

MainFrame f = new MainFrame();
}


}

class DbHandler{
	
	
	
	public void addStudent(int eid,String ename, int eMarks){
		
		Connection con = null;
		try{
			
			
			System.out.println("Loading Driverr");
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	System.out.println("Driverr Loaded");
	
	
	System.out.println("Trying to connectt");
	
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
	System.out.println("Connectedd");
	
	
	
		
	String sql = "insert into student values (?, ?, ?)";
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setInt(1,eid);
	pst.setString(2,ename);
	pst.setInt(3,eMarks);
	int result = pst.executeUpdate();
	
	
	
	
	
	
	 URL url2 = this.getClass().getClassLoader().getResource("yes.wav");
         AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);
         // Get a sound clip resource.
         Clip clip2 = AudioSystem.getClip();
	  clip2.open(audioIn2);
		
		
		
			clip2.start();
	
	
	
	
	
	
	
	System.out.println(result+"  Records Insertedd");
	JOptionPane.showMessageDialog(new JDialog(),result+" recordss insertedd");
		
		pst.close();
			
		}
		
		catch(SQLException e){
		System.out.println("Issuees "+e);
		JOptionPane.showMessageDialog(new JDialog()," issue"+e);
		
	
}
catch(UnsupportedAudioFileException be){ be.printStackTrace();}

 catch (IOException e) {   e.printStackTrace(); } 
 catch (LineUnavailableException e) { e.printStackTrace();}
			
finally{

try{
		System.out.println("Trying to close the connection");
		if(con!=null){
			con.close();
		}
		System.out.println("Connection Closedd");
			
}

catch(SQLException e){
		System.out.println("Closing  Issuees "+e);
}	
}	
	}
	
	
	
	
public String viewStudent(){

Connection con = null;
StringBuffer sb = new StringBuffer();


try{
	System.out.println("Loading Driverr");
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	System.out.println("Driverr Loaded");
	
	
	System.out.println("Trying to connectt");	
	
	
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
	System.out.println("Connectedd");
	
	
	
	
	Statement stmt = con.createStatement();
	String sql = "select * from student";
	ResultSet rs = stmt.executeQuery(sql);
	sb.append("Rno. \t Name \t Marks\n");
	while(rs.next()){
		
		int eid=rs.getInt(1);
		String ename = rs.getString(2);
		int marks=rs.getInt(3);
		System.out.println("eid = "+eid+" ename "+ename+" Marksssss "+marks+"\n");
		sb.append(eid+"\t ");
		sb.append(ename+"\t");
		sb.append(marks+"\n ");
		System.out.println();
		
	}
	rs.close();
	stmt.close();
}
catch(SQLException e){
		System.out.println("Issuees "+e);
		JOptionPane.showMessageDialog(new JDialog()," issue"+e);
		
	
}
	finally{

try{
		System.out.println("Trying to close the connection");
		if(con!=null){
			con.close();
		}
		System.out.println("Connection Closedd");
			
}

catch(SQLException e){
		System.out.println("Closing  Issuees "+e);
	
}
}
return sb.toString();
	
	
}	









	
	
	public void editStudent(int eid,String ename,int marks){

Connection con=null;
int eidd=eid;
String enamee=ename;

try{
	
	
	
	
	
	
	System.out.println("Loading Driverr");
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	System.out.println("Driverr Loaded");
	
	
	System.out.println("Trying to connectt");
	
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
	System.out.println("Connectedd");
	
	 
	
	Statement s1 = con.createStatement();
	String s2 = "update student set ENAME='"+enamee+"',MARKS='"+marks+"' where SID='"+eidd+"'";
	int r1=s1.executeUpdate(s2);
	
	
		
	
	 URL url2 = this.getClass().getClassLoader().getResource("yes.wav");
         AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);
         // Get a sound clip resource.
         Clip clip2 = AudioSystem.getClip();
	  clip2.open(audioIn2);
		
		
		
			clip2.start();
	
	
	
	
	
		System.out.println(r1+"  Records Insertedd");
		JOptionPane.showMessageDialog(new JDialog(),r1+" recordss updatedd");
		
		
		s1.close();
}
catch(SQLException e){
		System.out.println("Issuees "+e);
		JOptionPane.showMessageDialog(new JDialog()," issue"+e);
		
	
}



catch(UnsupportedAudioFileException be){ be.printStackTrace();}

 catch (IOException e) {   e.printStackTrace(); } 
 catch (LineUnavailableException e) { e.printStackTrace();}


finally{

try{
		System.out.println("Trying to close the connection");
		if(con!=null){
			con.close();
		}
		System.out.println("Connection Closedd");
			
}

catch(SQLException e){
		System.out.println("Closing  Issuees "+e);
	
		
	
}
	
}


}	
	









	
	public void deleteEmployee(int eid){

Connection con=null;
int eidd=eid;
try{
	System.out.println("Loading Driverr");
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	System.out.println("Driverr Loaded");
	
	
	System.out.println("Trying to connectt");
	
	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
	System.out.println("Connectedd");
	
	 
	
	Statement s1 = con.createStatement();
	String s2 = "delete from student where SID='"+eidd+"'";
	int r1=s1.executeUpdate(s2);
	
	
	if(r1>=1){
	
	
	
	 URL url2 = this.getClass().getClassLoader().getResource("yes.wav");
         AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);
         // Get a sound clip resource.
         Clip clip2 = AudioSystem.getClip();
	  clip2.open(audioIn2);
		
		
		
			clip2.start();
	
	
		System.out.println(r1+"  Records Deleted");
		JOptionPane.showMessageDialog(new JDialog(),r1+" recordss Deleted");
	}
	else{
		 URL url2 = this.getClass().getClassLoader().getResource("sorry.wav");
         AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);
         // Get a sound clip resource.
         Clip clip2 = AudioSystem.getClip();
	  clip2.open(audioIn2);
		
		
		
			clip2.start();
	
	
		System.out.println(r1+"  Records Deleted");
		JOptionPane.showMessageDialog(new JDialog(),r1+" recordss Deleted");
		
	}
		
		s1.close();
}
catch(SQLException e){
		System.out.println("Issuees "+e);
		JOptionPane.showMessageDialog(new JDialog()," issue"+e);
		
	
}



catch(UnsupportedAudioFileException be){ be.printStackTrace();}

 catch (IOException e) {   e.printStackTrace(); } 
 catch (LineUnavailableException e) { e.printStackTrace();}




finally{

try{
		System.out.println("Trying to close the connection");
		if(con!=null){
			con.close();
		}
		System.out.println("Connection Closedd");
			
}

catch(SQLException e){
		System.out.println("Closing  Issuees "+e);
	
		
	
}
	
}


}	

















}

