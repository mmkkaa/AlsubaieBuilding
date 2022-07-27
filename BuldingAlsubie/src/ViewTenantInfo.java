import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class ViewTenantInfo extends MainWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		// Connection to the mySQL database
		static DatabaseConnection connect = new DatabaseConnection(
				"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
				"Majan1957");
		
		
		//get value of text fields
		//String username = usernameTxt.getText().trim(); 
		//String password1 =String.valueOf(passwordTxt.getPassword());
	
		
	    
		static getInfo info;
		static JLabel flatNoLB = new JLabel("Please Select a Flat Number:");
		static JTextField flatNoTF = new JTextField (); 
		static String flatNo = flatNoTF.getText(); 
		static JButton Enter = new JButton("Enter");
		static int flatNos;
		static MainWindow main; 
		static  String[] columnNames = { "Invoice ID", "Flat Number", "Tenant Name" , "Payment Method"
                , "Amount Paid" , "Date"};


		
	     
		public static void enterNo(final String username) { 
			
			
			    final JFrame infoFrame = new JFrame("Tenant Information Viewer"); 
			    infoFrame.setSize(new Dimension(600, 300));
			    infoFrame.setBounds(400, 200, 600, 300);
			    infoFrame.setIconImage(new ImageIcon("/images/107636964.png").getImage());
		        
			    
			    JPanel flatNoEnter = new JPanel();
			    JButton backButton = new JButton("Back");
			    
			    flatNoEnter.setBorder(BorderFactory.createTitledBorder("Select the flat number:"));
			    flatNoEnter.setBounds(200, 100, 100, 100);
			    
			    JLabel panelInfo = new JLabel("To search for Tenant's information please select flat number below.");
			    
			    
			    String[] flatnum = { "--SELECT--", 
			    		             "31" , "32"  , "33" , "34" ,
			    		             "41" , "42" , "43" , "44" ,
			    		             "51" , "52" , "53" , "54"
			    		           , "61" , "62" , "63" , "64" , 
			    		             "71" , "72" , "73" , "74",
			    		             "81" , "82" , "83" , "84",
			    		             "91" , "92"}; 
			    
             
                @SuppressWarnings({ "rawtypes", "unchecked" })
				final JComboBox  flatno = new JComboBox(flatnum); 
               
			    
			    panelInfo.setBounds(50, 50, 500, 30);
			    flatNoLB.setBounds(50, 100, 200, 30);
			    flatno.setBounds(50, 150, 200, 30);
			    Enter.setBounds(300, 200, 70, 30);
			    backButton.setBounds(390, 200, 70, 30);
			    
			    
			    flatNoEnter.setLayout(null);
			    flatNoEnter.add(flatNoLB); 
			    flatNoEnter.add(flatno);
			    flatNoEnter.add(Enter); 
			    flatNoEnter.add(panelInfo);
			    flatNoEnter.add(backButton);
			    
			    Container con  = infoFrame.getContentPane();
			    con.add(flatNoEnter);
			    
		        //Ask for window decorations provided by the look and feel.
		        JFrame.setDefaultLookAndFeelDecorated(true);
		       //Set the frame icon to an image loaded from a file.
		        
		        infoFrame.setVisible(true);
		        infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		        
		       
		       

			      Enter.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							
							// check if entered number is validated or not 
							
							final String flatNo = flatno.getSelectedItem().toString();
							
							if (        flatNo.equals("31") ||flatNo.equals("32") || flatNo.equals("33")  || flatNo.equals("34") || 
						        		flatNo.equals("41") ||flatNo.equals("42") || flatNo.equals("43")  || flatNo.equals("44") || 
						        		flatNo.equals("51") ||flatNo.equals("52") || flatNo.equals("53")  || flatNo.equals("54") || 
						        		flatNo.equals("61") ||flatNo.equals("62") || flatNo.equals("63")  || flatNo.equals("64") || 
						        		flatNo.equals("71") ||flatNo.equals("72") || flatNo.equals("73")  || flatNo.equals("74") || 
						        		flatNo.equals("81") ||flatNo.equals("82") || flatNo.equals("83") || flatNo.equals("84")  || 
						        		flatNo.equals("91") ||flatNo.equals("92") )
								
								
							{ 
								

								Font font = new Font("Times New Roman", Font.PLAIN, 14); 
								  
								    //------------------------------------------------
								    final JFrame viewFrame = new JFrame("Tenant Information Viewer"); 
								    viewFrame.setBounds(200, 100,1000, 700);
								    
								    
								    
								    final JPanel tenantInfo = new JPanel();
								    tenantInfo.setLayout(null);
								    tenantInfo.setBorder(BorderFactory.createTitledBorder("Tenant Details"));
								    
								    JLabel picLabel = new JLabel(new ImageIcon("/images/userphoto.png"));
								    picLabel.setBounds(600,50,300,300);
								    tenantInfo.add(picLabel); 
								    
								    JLabel line1 = new JLabel("_______________________________________ Personal Details _______________________________________"); 
								    line1.setBounds(10,10,1000,30);
								    tenantInfo.add(line1);
								    
								    JLabel nameLB2 = new JLabel("Tenant Name:"); 
								    nameLB2.setBounds(30 ,60 ,200,30);
								    tenantInfo.add(nameLB2);
								    nameLB2.setFont(font);
								    
								    JLabel name = new JLabel(getInfo.getTenantName(flatNo));
					                name.setBounds( 300, 60, 200, 30);
					                tenantInfo.add(name);
					                name.setFont(font);
					                
									
								    JLabel idLB = new JLabel("Tenant's National ID number:"); 
								    idLB.setBounds(30 , 90, 200, 30);
								    tenantInfo.add(idLB);
								    idLB.setFont(font);
								    
								    JLabel id = new JLabel(getInfo.getTenantIDno(flatNo)); 
					                id.setBounds(300 , 90, 200, 30);
					                tenantInfo.add(id);
					                id.setFont(font);
					                
					                JButton back = new JButton("Back");
							        back.setBounds(550,550,90,30);
							        tenantInfo.add(back); 
							       
					                JLabel numLB= new JLabel("Contact Number:" );
					                numLB.setBounds(30, 120, 200, 30);
					                tenantInfo.add(numLB);
					                numLB.setFont(font);
					                JLabel num = new JLabel(getInfo.getTenantPhoneNo(flatNo)); 
					                num.setBounds(300 , 120 , 200, 30);
					                tenantInfo.add(num);
					                num.setFont(font);
					                
					                
					        		
					                JLabel emailLB = new JLabel("Email Address:" );
					                emailLB.setBounds(30 , 150 , 200, 30);
					                tenantInfo.add(emailLB);
					                emailLB.setFont(font);
					                JLabel email = new JLabel(getInfo.getTenantEmail(flatNo));
					                email.setBounds(300, 150 ,200, 30);
					                tenantInfo.add(email);
					                email.setFont(font);
					                
					                
					                JLabel sdateLB = new JLabel("Tenancy starting date:" );
					                sdateLB.setBounds(30, 180, 200, 30);
					                tenantInfo.add(sdateLB);
					                sdateLB.setFont(font);
					                
					                JLabel sdate = new JLabel(getInfo.getTenantStartDay(flatNo)); 
					                sdate.setBounds(300, 180 , 200, 30);
					                tenantInfo.add(sdate);
					                sdate.setFont(font);
					               
					                JLabel edateLB =  new JLabel("Tenancy ending date:" );  
					                edateLB.setBounds(30, 210 , 200, 30);
					                tenantInfo.add(edateLB);
					                edateLB.setFont(font); 
					                
					                JLabel edate = new JLabel(getInfo.getTenantEndDay(flatNo)); 
					                edate.setBounds(300 , 210 , 200, 30);
					                tenantInfo.add(edate);
					                edate.setFont(font);
					              
					                
					                JLabel line2 = new JLabel("_______________________________________ Flat Details ___________________________________________"); 
								    line2.setBounds(10,240,1000,30);
								    tenantInfo.add(line2);
								    
					               
					                JLabel flatNoLB = new JLabel("Apartment number:"); 
					                flatNoLB.setBounds(30 , 270 , 200,30);
					                tenantInfo.add(flatNoLB);
					                
					                flatNoLB.setFont(font);
					                
					                JLabel flatno = new JLabel(getInfo.getFlatNo(flatNo)); 
					                flatno .setBounds(300, 270, 200,30);
					                tenantInfo.add(flatno);
					                
					                flatno.setFont(font);
					                
					                JLabel floorLB = new JLabel("Floor:"); 
					                floorLB.setBounds(30,300,200,30);
					                tenantInfo.add(floorLB); 
					                
					                floorLB.setFont(font);
					                
					                JLabel floor = new JLabel(getInfo.getFloor(flatNo));
					                floor.setBounds(300,300,200,30);
					                tenantInfo.add(floor);
					                floor.setFont(font);
					                
					                JLabel flatTypeLB = new JLabel("Tenancy Type:"); 
					                flatTypeLB.setBounds(30,330,200,30);
					                tenantInfo.add(flatTypeLB);
					                flatTypeLB.setFont(font);
					                
					                JLabel flatType = new JLabel(getInfo.getFlatType(flatNo)); 
					                flatType.setBounds(300,330,200,30);
					                tenantInfo.add(flatType);
					                flatType.setFont(font);
					                
					                
					                JLabel bedroomLB = new JLabel("Bedrooom's Number:"); 
					                bedroomLB.setBounds(30,360,200,30);
					                JLabel bedroomNo = new JLabel(getInfo.getBedroomsNo(flatNo));
					                bedroomNo.setBounds(300,360,200,30);
					                tenantInfo.add(bedroomNo);
					                tenantInfo.add(bedroomLB); 
					                bedroomNo.setFont(font);
					                bedroomLB.setFont(font);
					                
					                JLabel line3 = new JLabel("________________________________________ Payment Details ________________________________________"); 
								    line3.setBounds(10,390,1000,30);
								    tenantInfo.add(line3);
					       
									
							        JLabel pPlanLB = new JLabel("Payment Plan:"); 
							        pPlanLB.setBounds(30,420,200,30);
							        JLabel pPlan = new JLabel(getInfo.getPaymentPlan(flatNo)); 
							        pPlan.setBounds(300,420,200,30);
							        tenantInfo.add(pPlanLB);
							        tenantInfo.add(pPlan);
							        pPlanLB.setFont(font);
							        pPlan.setFont(font);
							        
							        
							        JLabel pMethodLB = new JLabel("Payment Method:"); 
							        pMethodLB.setBounds(30,450,200,30);
							        JLabel pMethod = new JLabel(getInfo.getPaymentMethod(flatNo)); 
							        pMethod.setBounds(300,450,200,30);
							        tenantInfo.add(pMethod);
							        tenantInfo.add(pMethodLB); 
							        pMethodLB.setFont(font);
							        pMethod.setFont(font);
							        
							        
							        JLabel pAdvLB = new JLabel("Advanced Paid Amount:");
							        pAdvLB.setBounds(30,480,200,30);
							        JLabel pAdv = new JLabel(getInfo.getPaymnetAdv(flatNo) + " OMR");
							        pAdv.setBounds(300,480,200,30);
							        tenantInfo.add(pAdvLB);
							        tenantInfo.add(pAdv);
							        pAdvLB.setFont(font);
							        pAdv.setFont(font);
							        
							        
							        JLabel pHistory = new JLabel("Payment History");
							        pHistory.setBounds(30,550,200,30);
							        JButton showHistory = new JButton("View Payment History"); 
							        showHistory.setBounds(300,550,200,30);
							        tenantInfo.add(pHistory); 
							        tenantInfo.add(showHistory);
							        
							        pHistory.setFont(font);
							      

									   SwingUtilities.invokeLater(new Runnable(){
								            public void run() {
								            	URL url = MainWindow.class.getResource("/images/buildingBack.png");
								    	        ImageIcon icon = new ImageIcon(url);
								    			JLabel background = new JLabel(icon); 
								    			background.setBounds(200, 100,1000, 700);
												
								    			tenantInfo.add(background); 
								    			
								            }
								        });
									   
							      
							        JPanel rightsP = new JPanel();
							        
							        
							        JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
									rights.setBounds(200,900,600,20);
									rights.setFont(new Font("Calibri", Font.PLAIN,10));
									
									rightsP.add(rights); 
									
									
					                //---------------------------------------------------------------------------------
								    
								 
								 // set flow layout for the frame  
								    Container con  = viewFrame.getContentPane();
								    
								    
						      		 
								  //  JScrollPane scroll = new JScrollPane(tenantInfo); 
							      //  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
							      //  scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
							       
							       
						     
						  		    con.add(tenantInfo, BorderLayout.CENTER);
						  		    con.add(rightsP, BorderLayout.SOUTH); 
						  		    
						  		    
						  		    con.setBackground(Color.GRAY);
							      
							        
							        //Ask for window decorations provided by the look and feel.
							        JFrame.setDefaultLookAndFeelDecorated(true);
							       //Set the frame icon to an image loaded from a file.
							        
							        viewFrame.setVisible(true);
							   //     viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							        
							        back.addActionListener(new ActionListener() {

										public void actionPerformed(ActionEvent e) {
											
											MainWindow.Options(username);
											viewFrame.dispose();
											
										}
							     		
							     	});
							        
							        
							        showHistory.addActionListener(new ActionListener() {

										public void actionPerformed(ActionEvent e) {
											
											paymentHistory.view(flatNo, username);
											
										}
							     		
							     	});
							
							
						        	
						    } else { 
						        	
						    	JOptionPane.showMessageDialog(null,"Please select a flat"); 
								   
							
						   }	
						
						}
			     	});
			      
			      

			     backButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							MainWindow.Options(username); 
							infoFrame.dispose(); 
 
						}
			     		
			     	});
			     
			     	
		}
	   

		
}