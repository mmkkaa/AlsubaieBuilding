import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class AllPaid extends MainWindow{

	
	   /**
	    * This class will view all the payment did in a specific given date range 
	    * It will show all flats with names and date for all the flats that have paid in that range 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static  JFrame frame; 
	static  String[] columnNames = {"Flat Number" , "Tenant Name" , "Date"};
    static  JTable table;
	   
	   static public void viewall(String s)  {

		    frame = new JFrame("Payment History"); 
		    frame.setSize(new Dimension(1080, 740));
		    frame.setBounds(200,50,1070,740);
		    frame.setLayout(null);
		    
		    JPanel panel1 = new JPanel();
		    panel1.setLayout(null);
		    panel1.setBorder(BorderFactory.createTitledBorder("Tenant Payment Details"));
		    panel1.setBounds(10, 10, 1000, 620);
		    
		    frame.setBackground(Color.gray);
		  //TableModel tm = new TableModel();
		  final DefaultTableModel model = new DefaultTableModel();
		  model.setColumnIdentifiers(columnNames);
		  //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
		  //table = new JTable(model);
		  table = new JTable();
		  table.setEnabled(true);
		  table.setModel(model); 
		  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		  table.setFillsViewportHeight(true);
		  table.setBounds(10,10,980,500); 
		  JScrollPane scroll = new JScrollPane(table);
		  scroll.setHorizontalScrollBarPolicy(
		  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		  scroll.setVerticalScrollBarPolicy(
		  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		  
		  scroll.setBounds(20,20,980,600);
		  
		  JButton back = new JButton("Back");
		  back.setBounds(230,650 , 150, 30);
		  
		  
		  String flatNO = ""; 
		  String name= "";
		  String Date="";
		  
		  System.out.println("Connection starts.."); 
		  try {
		   
			  
			    ResultSet rs;
				
				Connection connection;
				
			
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");  
		  String sql = " select * from `paymentHistory` where `flatNo` = ?";
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, s); 
	      
	      rs = ps.executeQuery();
	     
		  
		  while(rs.next())  {
			  
		 
		  flatNO = rs.getString("flatNo");
		  name = rs.getString("name");
		  Date = rs.getString("paymentID"); 
		  
		 
		  model.addRow(new Object[]{flatNO, name, Date});
		   
		  }
		  
		  
		  }
		  
		  
		catch(Exception ex)
		{

			  System.out.println("Connection falied.."); 
		JOptionPane.showMessageDialog(null,ex.getMessage(),"No Payments founded",
		JOptionPane.ERROR_MESSAGE);
		}
		  
		  
		  
		  //back clicked
			back.addActionListener(new ActionListener() {
				//close frame, open user menu
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					
				}
			});
			
			
			panel1.add(scroll);
			frame.add(back);
			
			  
			    Container con  = frame.getContentPane();
			    con.add(panel1);
				 //Ask for window decorations provided by the look and feel.
			     JFrame.setDefaultLookAndFeelDecorated(true);
			    //Set the frame icon to an image loaded from a file.
			     
			        SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/107636964.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    	         
			    			  frame.setIconImage(icon.getImage());
			    			
			            }
			        });
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
	   }
}
