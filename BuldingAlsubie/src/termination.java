
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;


public class termination extends MainWindow {

	
	private static final long serialVersionUID = 1L;
	static Font font = new Font("Times New Roman", Font.BOLD, 18); 
	static Font fontTitle = new Font("Times New Roman", Font.BOLD, 30); 
	
	

	public static void start(final String username) { 
		 
	
		JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
		rights.setFont(new Font("Calibri", Font.PLAIN,10));
		rights.setForeground(Color.BLACK);
		JPanel rightsPanel = new JPanel();
		rightsPanel.add(rights);
		
		

		final JFrame frame = new JFrame(); 
		frame.setTitle("Building Statistics");
	//	frame.setLayout(null)
		
		final JPanel Tenantspanel = new JPanel(); 
		
	    Tenantspanel.setLayout(null);
		
	    JLabel title = new JLabel("Tenant Termination"); 
		title.setBounds(130,40,300,100);
		title.setFont(fontTitle);
		
		
	            	URL url = MainWindow.class.getResource("/images/teminateNotSelected.png");
	    	        ImageIcon icon = new ImageIcon(url);
	    			JLabel background = new JLabel(icon); 
	    			background.setBounds(20,40,100,100);
	    			
	    		

		 JLabel label3 =new JLabel("To terminate a tenancy's contract, please enter the flat's number:"); 
		 
		 label3.setBounds(20,140,800,30);
		 label3.setFont(font);
		
		 
		 
		    final JPanel containerPanel = new JPanel(); 
	        containerPanel.setBounds(0,0,1400,1000);
	        containerPanel.setLayout(null);
	    	containerPanel.setLayout(new OverlayLayout(containerPanel));
  
	    	
	    	Tenantspanel.setOpaque( false );
	    	Tenantspanel.setBounds(20,200,1000,470);
	    	Tenantspanel.setBackground( new Color(0, 0, 0, 200) );
	    	Tenantspanel .setBorder(BorderFactory.createTitledBorder(" "));
	    	
		
	    	 String[] flatnum = { "--SELECT--", "Gallery A" , "Gallery B" , "Gallery C" , "Gallery D" ,
		             "Store 1" , "Store 2", "Store 3" ,
		             "Office 11" , "Office 12" , "Office 21" , "Office 22",
		             "31" , "32"  , "33" , "34" ,
		             "41" , "42" , "43" , "44" ,
		             "51" , "52" , "53" , "54"
		           , "61" , "62" , "63" , "64" , 
		             "71" , "72" , "73" , "74",
		             "81" , "82" , "83" , "84",
		             "91" , "92"}; 


          @SuppressWarnings({"unchecked", "rawtypes" })
         final JComboBox  flatno = new JComboBox(flatnum); 

         flatno.setBounds(100,173,200,30);
         
         
         JLabel flatNoLabel = new JLabel("Flat Number:"); 
         flatNoLabel.setBounds(20,170,150,30);
         

         URL urlq = MainWindow.class.getResource("/images/searchIcon.png");
	        ImageIcon iconq = new ImageIcon(urlq);
			JButton search = new JButton(iconq); 
			search.setBounds(310, 173, 50 ,30);
         
			
		JButton back = new JButton("Back"); 
		back.setBounds(100, 690, 100, 40);

        
        back.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					MainWindow.Options(username); 
					frame.dispose(); 
				    

				}
	     		
	     	});
        
   

		 SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	            	
	            	URL url = MainWindow.class.getResource("/images/buildingBack.png");
	    	        ImageIcon icon = new ImageIcon(url);
	    			JLabel background = new JLabel(icon); 
	    			background.setBounds(0, 0, 1400, 900);
	                    
	    			containerPanel.add(background);
	    			
	    			
	            }
	        });
		
		    
           frame.setBounds(150, 100,1200,850);

			final Container con = frame.getContentPane();
		    
			
			con.add(flatNoLabel);
			con.add(flatno);  
			con.add(title);
			con.add(background);
			con.add(search);
			con.add(rightsPanel, BorderLayout.SOUTH);
			con.add(Tenantspanel);
			con.add(back); 
			con.add(label3);
			con.add(containerPanel);
			
			

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
