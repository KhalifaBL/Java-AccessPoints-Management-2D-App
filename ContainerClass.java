import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

//Importing JAVA swing elements 
import javax.swing.*;


public class ContainerClass extends JFrame implements MouseListener {
	
	/************ Declaration ***************/

	
	JMenuBar myMenuBar= new JMenuBar();
	JMenu myMenu1= new JMenu("Power settings");

	JMenu myMenu2= new JMenu("Show");



	JMenuItem i1= new JMenuItem("List of Access Points");
	JMenuItem i2= new JMenuItem("List of PCs");

	
	JPanel myPanel=new JPanel();
	JPanel selectionMenu = new JPanel();
	
	private ButtonGroup bg = new ButtonGroup();
	private JCheckBox jcb1 = new JCheckBox("Access Point");
	private JCheckBox jcb2 = new JCheckBox("PC");
	private JCheckBox jcb3 = new JCheckBox("Obstacle");
	

	private int N_PA = 0, N_PC = 0;

	static ArrayList<PC> PCs = new ArrayList<PC>();
	static ArrayList<AccessPoint> APs = new ArrayList<AccessPoint>();

	
	//Footer for the App
	JLabel footer= new JLabel("Made with love, RT3 2019/2020, KBL,MR,LA,YC ",SwingConstants.CENTER);
			
	
	/************ Constructor ***************/

			
	ContainerClass(){
		super("INSAT Wireless Control System");
		this.setSize(600, 600);
		this.addMouseListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//Setting the Layout of the ContainerClass as FlowLayout
		this.setLayout(new FlowLayout());
		

		//Setting the Layout of the myPanel as BorderLayout
		myPanel.setLayout(new BorderLayout());
		
		//Styling the footer
		footer.setBackground(Color.lightGray);
		footer.setOpaque(true);
		footer.setFont(new Font("Courier New",Font.ITALIC,15));
		
		
		
		//Adding elements to the main myPanel
		myPanel.add(myMenuBar,BorderLayout.NORTH);
		myPanel.add(footer,BorderLayout.SOUTH);
		
		//Action on myMenu1
		myMenu1.addMenuListener(new SampleMenuListener());

		//Action on myMenu2Items
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccessPointsList APlist= new AccessPointsList();
			}
		});
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PCsList PClist= new PCsList();
			}
		});
		
		 
		 
		//Adding menu options to the Main Menu
		myMenu2.add(i1);
		myMenu2.add(i2);

		myMenuBar.add(myMenu1);	
		myMenuBar.add(myMenu2);
		
		//Styling the selection buttons 
		jcb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jcb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jcb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jcb1.setForeground(Color.BLACK);
		jcb2.setForeground(Color.BLACK);
		jcb3.setForeground(Color.BLACK);
		
		//Adding my 3 selection buttons to the same button group 
		bg.add(jcb1);
		bg.add(jcb2);
		bg.add(jcb3);
		
		
		//Adding my 3 selection buttons to the JPanel selectionMenu 
		
		selectionMenu.add(jcb1);
		selectionMenu.add(jcb2);
		selectionMenu.add(jcb3);
		
		//Making the selectionMenu visible on myPanel
		myPanel.add(selectionMenu, BorderLayout.EAST);
		
		//Styling the cursor of
		myMenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		myPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
		
		//Setting myPanel as the ContentPane for ContainerClass JFrame
		this.setContentPane(myPanel);
		this.setVisible(true);
		
		//Centering my frame in the center of the monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension ContainerClassSize=this.getSize();
		this.setLocation(dim.width/2-ContainerClassSize.width/2, dim.height/2-ContainerClassSize.height/2);
	}
	
	
	/************ Decision Making ***************/
	
	// Calculation a distance between 2 points
	double distance(double x1, double y1, double x, double y) {
		return Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
	}
	
	// Calculating the Signal Attenuation
	double Signal_Attenuation(double xc, double yc, double r, double x, double y) {
		// if Signal_Attenuation=1 then the signal is at its maximum 
		// if Signal_Attenuation=0 then signal is completely faded
		double f = 1.0 - distance(xc, yc, x, y) / ((double) r);
		if (f < 0) {
			return (0);
		}
		return (f);
	}
	
	/************ PCs Handling ***************/

	public void DisconnectAllPCs(Graphics2D ga) {
		for (int j = 0; j < PCs.size(); j++) {

			PCs.get(j).DisconnectPC(ga);
		}
	}
	
	public void ReconnectAllPCs(Graphics2D ga) {
		for (int i = 0; i < (PCs.size()); i++) {
			System.out.println("num de pc :" + 0 + "  coor x : " + PCs.get(0).getX());
			System.out.println("i=  " + i);
			System.out.println("x    =" + PCs.get(i).getX());
			ConnectNewPC(ga, PCs.get(i), i);

		}
	}
	public int ConnectNewPC(Graphics2D ga, PC pc, int Nbre) {
		int dmin;
		int d = 500;
		int xp = pc.getX();
		int yp = pc.getY();
		Point Pc = new Point(xp, yp);
		int num = 0;
		dmin = PowerEntry.Rc;

		// Pour chercher le plus proche PA
		for (int i = 0; i < APs.size(); i++) {
			d = (int) distance(xp, yp, APs.get(i).getX(), APs.get(i).getY());

			if (d < dmin) {
				dmin = d;
				num = i + 1;
			}
			System.out.println("dmin       " + dmin);

		}

		if (d < PowerEntry.Rc) {
			System.out.println("nombre=" + Nbre);
			PCs.get(Nbre).setnumPA(num);
			return num;

		} else {
			System.out.println("Nbre=" + Nbre);
			PCs.get(Nbre).setnumPA(num);
			return 0;
		}
	}


	
	
	/************ Graphics Handling ***************/
	
	void DrawingAccessPoints(Graphics2D ga, int xc, int yc, int r ) {

		
		for (int i = 0; i < 2 * r; i += 1) {
			for (int j = 0; j < 2 * r; j += 1) {
				int x = (xc - r) + i;
				int y = (yc - r) + j;
				double f = Signal_Attenuation(xc, yc, r, x, y);

				DrawingPixel(ga, f, x, y);
			}
		}
	}

	public void DrawingPixel(Graphics2D ga, double f, int x, int y) {

		if ((f != 0)) {
			int R = (int) (255 - f * 255);
			Color C = new Color(R, 255-R, 0, 220);
			Shape pixel = new Rectangle2D.Double(x, y, 1, 1);
			ga.setPaint(C);
			ga.fill(pixel);

		}
	}
	
	/************ Mouse Events Handling ***************/

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		Graphics g;
		Graphics2D ga;
		g = this.getGraphics();
		ga = (Graphics2D) g;
		int x;
		int y;
		if (e.getButton() == MouseEvent.BUTTON1) {

			x = e.getX();
			y = e.getY();
		if (jcb1.isSelected()) {
			
			//Drawing AccessPoint if user has entered the power of the AccessPoint
			if(PowerEntry.Rc==0) {
				
			}else {
				APs.add(N_PA, new AccessPoint(x, y, PowerEntry.Rc));
				DrawingAccessPoints(ga, x, y, PowerEntry.Rc);
				N_PA++;

				if (!PCs.isEmpty()) {
					DisconnectAllPCs(ga);
					ReconnectAllPCs(ga);
				}
			}
		
		}
		// Draw PC
		else if (jcb2.isSelected()) {
			PC pc = new PC(x, y, 0);
			PCs.add(N_PC, pc);

			pc.DrawPC(ga, x, y);
			if (!APs.isEmpty()) {
				ConnectNewPC(ga, pc, N_PC);
			}
			System.out.print("==>" + PCs.get(N_PC).getnumPA());

			N_PC++;
		}
	
	}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
