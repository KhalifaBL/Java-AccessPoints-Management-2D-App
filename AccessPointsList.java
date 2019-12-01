import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class AccessPointsList extends  JFrame{
    private  JLabel jLabel1;
    private  JScrollPane jScrollPane1;
    private  JTable jTable1;
    
    public AccessPointsList(){
    
    	this.setVisible(true);
        initComponents() ; 
    	//Centering my frame in the center of the monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
    }
    //@SuppressWarnings("unchecked")
    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents(){
        jLabel1 = new JLabel() ;
        jScrollPane1 = new JScrollPane() ;
        jTable1 = new  JTable() ;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE) ;
        this.setTitle("La liste des points d'acces") ;

        jLabel1.setFont(new java.awt.Font("Tahoma" , 1, 24 )) ;
        jLabel1.setForeground(Color.black) ;
        jTable1.setModel( new javax.swing.table.DefaultTableModel(
                new Object [][] {  } ,
                new String [] {
                        "Numero du point d'acces ","Position x","Position y", "Rayon" } )) ;

        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel() ;
        String titled[] = {
                "Numero du point d'acces" , "Position x", "Position y", "Rayon" } ;
        String [] data = new String[4] ;

        int x ;

        for(int j=0; j<ContainerClass.APs.size() ; j++)
        {
            x= j+1 ;
            data[0]=x+"" ;
            data[1]=ContainerClass.APs.get(j).getX() + ""  ;
            data[2]=ContainerClass.APs.get(j).getY() + "" ;
            data[3]=ContainerClass.APs.get(j).getRc() +"" ;
            tableModel.addRow(data ) ;
        }
        
        jTable1.setModel(tableModel) ;
        jScrollPane1.setViewportView(jTable1) ;

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane()) ;
        getContentPane().setLayout(layout) ;
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)))
        ;
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addGap(139, 139, 139))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE )));
        this.pack();
    }


}
