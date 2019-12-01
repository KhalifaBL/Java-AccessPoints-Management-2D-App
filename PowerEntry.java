import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PowerEntry extends JFrame {
    private JLabel jLabel1 ;
    private JTextField jText1=new JTextField() ;
    private JPanel jPanel1;
    private JButton jButton1;
    static int newPuissance;
    
	static int Rc=0;
    public PowerEntry(){
        initComponents() ;
        this.setSize(300,70);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        
    	//Centering my frame in the center of the monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
//@suppressWarning("uncheked")

    PowerEntry pointer=this;

    //@SuppressWarnings("unchecked")
//<editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(){
        jLabel1 = new JLabel() ;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE) ;
        this.setTitle("Choix de la puissance des points d'acces") ;
        jLabel1.setFont(new java.awt.Font("Tahoma" , 1, 12 )) ;
        jLabel1.setForeground(Color.black) ;
        jLabel1.setText("Entrez la puissance de votre point d'acces:" ) ;
        jPanel1= new JPanel();
        jButton1= new JButton("Valider"); 
        jPanel1.setLayout(new GridLayout(1,2));
        jPanel1.add(jText1);
        jPanel1.add(jButton1);
        this.add(jPanel1,BorderLayout.CENTER);
        this.add(jLabel1,BorderLayout.NORTH);
        jButton1.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent event){
        		int i = Integer.parseInt(jText1.getText());
        		
        		newPuissance=i;
        		Rc=(int)(1.66*newPuissance+83);
        		pointer.dispose();
        	System.out.println(Rc);
        		
        	 }
        });
        
        this.pack();
    }


}
