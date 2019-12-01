import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TermsConditions extends JFrame{

	
	JPanel myPanel = new JPanel();
	JLabel Label1= new JLabel("			 									Welcome to INSAT Wireless Control System!");
	JLabel Label2= new JLabel(" These terms and conditions outline the rules and regulations for the use of IWCS's App.");
	JLabel Label3= new JLabel(" By using this application we assume you accept these terms and conditions.");
	JLabel Label4= new JLabel(" Do not continue to use IWCS if you do not agree to take all of the terms.");
	JLabel Label5= new JLabel(" License");
	JLabel Label6= new JLabel(" Unless otherwise stated, ICWS own the intellectual property rights for this App");
	JLabel Label7= new JLabel(" You must not:");
	JLabel Label8= new JLabel(" * 	Sell, rent or sub-license this App");
	JLabel Label9= new JLabel(" * 	Reproduce, duplicate or copy material from this App");
	JLabel Label10= new JLabel(" * 	This Agreement shall begin on the date of your purchase of this product.");
	JLabel Label11= new JLabel();
	JLabel Label12= new JLabel();
	
	JButton myButton= new JButton("Accept Terms and Continue ..");
	JLabel footer= new JLabel("Made with love, RT3 2019/2020, KBL,MR,LA,YC ",SwingConstants.CENTER);

	
	TermsConditions(){
		
	super("INSAT Wireless Control System");
	TermsConditions Pointer = this;
	this.setSize(600, 600);
	
	//Styling Labels
	Label1.setFont(new Font("Courier New",Font.BOLD,15));
	Label1.setForeground(Color.blue);
	Label5.setFont(new Font("Courier New",Font.BOLD,15));
	Label7.setFont(new Font("Courier New",Font.BOLD,15));
	Label7.setForeground(Color.red);
	myPanel.setLayout(new GridLayout(14,1));
	
	//Adding All Pannels to the App
	myPanel.add(Label1);
	myPanel.add(Label2);
	myPanel.add(Label3);
	myPanel.add(Label4);
	myPanel.add(Label5);
	myPanel.add(Label6);
	myPanel.add(Label7);
	myPanel.add(Label8);
	myPanel.add(Label9);
	myPanel.add(Label10);
	myPanel.add(Label11);
	myPanel.add(Label12);
	myPanel.add(myButton);
	myPanel.add(footer);
	
	//Styling the footer
	footer.setBackground(Color.lightGray);
	footer.setOpaque(true);
	footer.setFont(new Font("Courier New",Font.ITALIC,15));
	
	
	
	myButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			ContainerClass app= new ContainerClass();
			Pointer.dispose();
		}
	});
	this.setContentPane(myPanel);
	this.setVisible(true);
	
	   
	//Centering my frame in the center of the monitor
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	
	}

}
