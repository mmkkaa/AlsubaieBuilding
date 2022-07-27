
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class Stores extends MainWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			// Connection to the mySQL database
			static DatabaseConnection connect = new DatabaseConnection(
					"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
					"Majan1957");

			static getInfo info;
			static MainWindow main; 
			static paymentHistory ps;
			
			
			static  String[] columnNames = { "Invoice ID", "Flat Number", "Tenant Name" , "Payment Method"
	                , "Amount Paid" , "Date"};

			final static String flatNo = "Store 1";
			final static String flatNo2 = "Store 2"; 
			final  static String flatNo3 = "Store 3"; 
			
			
	     
		public 	static void view(final String username) { 
			
				
			    final JPanel tenantInfo = new JPanel();
				final JPanel tenantInfo2 = new JPanel(); 
				final JPanel tenantInfo3 = new JPanel();
			 
			    
			   final  JTabbedPane tp = new JTabbedPane();
			  
			  
               
		        /** 
		         * Detects clicks when user click tab inside tabbed pane 
		         */ 
			   
			 
			   
               tp.add("Store 1",tenantInfo); 
			   tp.add("Store 2",tenantInfo2); 
			   tp.add("Store 3",tenantInfo3); 
              
			   
		        JPanel rightsP = new JPanel();
		        
		        
		        JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
				rights.setBounds(200,900,600,20);
				rights.setFont(new Font("Calibri", Font.PLAIN,10));
				
				rightsP.add(rights); 
				
				
				    

		    	
				// check if entered number is validated or not 
				
				
				Font font = new Font("Times New Roman", Font.PLAIN, 14); 
				  
				    //------------------------------------------------
				    final JFrame viewFrame = new JFrame("Stores"); 
				    viewFrame.setBounds(200, 100,1000, 700);
				    

					
					
				   
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
	                
	                
	                JLabel sdateLB = new JLabel("Rent starting date:" );
	                sdateLB.setBounds(30, 180, 200, 30);
	                tenantInfo.add(sdateLB);
	                sdateLB.setFont(font);
	                
	                JLabel sdate = new JLabel(getInfo.getTenantStartDay(flatNo)); 
	                sdate.setBounds(300, 180 , 200, 30);
	                tenantInfo.add(sdate);
	                sdate.setFont(font);
	               
	                JLabel edateLB =  new JLabel("Rent ending date:" );  
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
				    
	               
	                JLabel flatNoLB = new JLabel("Store number:"); 
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
	                
	                
	                JLabel bedroomLB = new JLabel("Store Space:"); 
	                bedroomLB.setBounds(30,360,200,30);
	                JLabel bedroomNo = new JLabel(getInfo.getspace(flatNo));
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
					   
			      
			     
	                //---------------------------------------------------------------------------------
				    
				 
			 
			        //Ask for window decorations provided by the look and feel.
			        JFrame.setDefaultLookAndFeelDecorated(true);
			       //Set the frame icon to an image loaded from a file.
			        SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/107636964.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    	         
			    			  viewFrame.setIconImage(icon.getImage());
			    			
			            }
			        });
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
			
			        
				/**if ((checkNull(flatNoo) == true) || (checkString(flatNoo) == true)){ 
					JOptionPane.showMessageDialog(null, "Login Failed , Please inter valid number");
					
				} else {  

			    	*/
			
			//---------------------------------------------------------------------
			      
				    tenantInfo2.setLayout(null);
				    tenantInfo2.setBorder(BorderFactory.createTitledBorder("Tenant Details"));
				    
				    JLabel picLabel2 = new JLabel(new ImageIcon("/images/userphoto.png"));
				    picLabel2.setBounds(600,50,300,300);
				    tenantInfo2.add(picLabel2); 
				    
				    JLabel line12 = new JLabel("_______________________________________ Personal Details _______________________________________"); 
				    line12.setBounds(10,10,1000,30);
				    tenantInfo2.add(line12);
				    
				    JLabel nameLB22 = new JLabel("Tenant Name:"); 
				    nameLB22.setBounds(30 ,60 ,200,30);
				    tenantInfo2.add(nameLB22);
				    nameLB22.setFont(font);
				    
				    JLabel name2 = new JLabel(getInfo.getTenantName(flatNo2));
	                name2.setBounds( 300, 60, 200, 30);
	                tenantInfo2.add(name2);
	                name2.setFont(font);
	                
					
				    JLabel idLB2 = new JLabel("Tenant's National ID number:"); 
				    idLB2.setBounds(30 , 90, 200, 30);
				    tenantInfo2.add(idLB2);
				    idLB2.setFont(font);
				    
				    JLabel id2 = new JLabel(getInfo.getTenantIDno(flatNo2)); 
	                id2.setBounds(300 , 90, 200, 30);
	                tenantInfo2.add(id2);
	                id2.setFont(font);
	                
	                JButton back2 = new JButton("Back");
			        back2.setBounds(550,550,90,30);
			        tenantInfo2.add(back2); 
			       
	                JLabel numLB2= new JLabel("Contact Number:" );
	                numLB2.setBounds(30, 120, 200, 30);
	                tenantInfo2.add(numLB2);
	                numLB2.setFont(font);
	                JLabel num2 = new JLabel(getInfo.getTenantPhoneNo(flatNo2)); 
	                num2.setBounds(300 , 120 , 200, 30);
	                tenantInfo2.add(num2);
	                num2.setFont(font);
	                
	                
	        		
	                JLabel emailLB2 = new JLabel("Email Address:" );
	                emailLB2.setBounds(30 , 150 , 200, 30);
	                tenantInfo2.add(emailLB2);
	                emailLB2.setFont(font);
	                JLabel email2 = new JLabel(getInfo.getTenantEmail(flatNo2));
	                email2.setBounds(300, 150 ,200, 30);
	                tenantInfo2.add(email2);
	                email2.setFont(font);
	                
	                
	                JLabel sdateLB2 = new JLabel("Rent starting date:" );
	                sdateLB2.setBounds(30, 180, 200, 30);
	                tenantInfo2.add(sdateLB2);
	                sdateLB2.setFont(font);
	                
	                JLabel sdate2 = new JLabel(getInfo.getTenantStartDay(flatNo2)); 
	                sdate2.setBounds(300, 180 , 200, 30);
	                tenantInfo2.add(sdate2);
	                sdate2.setFont(font);
	               
	                JLabel edateLB2 =  new JLabel("Rent ending date:" );  
	                edateLB2.setBounds(30, 210 , 200, 30);
	                tenantInfo2.add(edateLB2);
	                edateLB2.setFont(font); 
	                
	                JLabel edate2 = new JLabel(getInfo.getTenantEndDay(flatNo2)); 
	                edate2.setBounds(300 , 210 , 200, 30);
	                tenantInfo2.add(edate2);
	                edate2.setFont(font);
	              
	                
	                JLabel line22 = new JLabel("_______________________________________ Flat Details ___________________________________________"); 
				    line22.setBounds(10,240,1000,30);
				    tenantInfo2.add(line22);
				    
	               
	                JLabel flatNoLB2 = new JLabel("Store number:"); 
	                flatNoLB2.setBounds(30 , 270 , 200,30);
	                tenantInfo2.add(flatNoLB2);
	                
	                flatNoLB2.setFont(font);
	                
	                JLabel flatno2 = new JLabel(getInfo.getFlatNo(flatNo2)); 
	                flatno2 .setBounds(300, 270, 200,30);
	                tenantInfo2.add(flatno2);
	                
	                flatno2.setFont(font);
	                
	                JLabel floorLB2 = new JLabel("Floor:"); 
	                floorLB2.setBounds(30,300,200,30);
	                tenantInfo2.add(floorLB2); 
	                
	                floorLB2.setFont(font);
	                
	                JLabel floor2 = new JLabel(getInfo.getFloor(flatNo2));
	                floor2.setBounds(300,300,200,30);
	                tenantInfo2.add(floor2);
	                floor2.setFont(font);
	                
	                JLabel flatTypeLB2 = new JLabel("Tenancy Type:"); 
	                flatTypeLB2.setBounds(30,330,200,30);
	                tenantInfo2.add(flatTypeLB2);
	                flatTypeLB2.setFont(font);
	                
	                JLabel flatType2 = new JLabel(getInfo.getFlatType(flatNo2)); 
	                flatType2.setBounds(300,330,200,30);
	                tenantInfo2.add(flatType2);
	                flatType2.setFont(font);
	                
	                
	                JLabel bedroomLB2 = new JLabel("Store Space:"); 
	                bedroomLB2.setBounds(30,360,200,30);
	                JLabel bedroomNo2 = new JLabel(getInfo.getspace(flatNo2));
	                bedroomNo2.setBounds(300,360,200,30);
	                tenantInfo2.add(bedroomNo2);
	                tenantInfo2.add(bedroomLB2); 
	                bedroomNo2.setFont(font);
	                bedroomLB2.setFont(font);
	                
	             
	                JLabel line32 = new JLabel("________________________________________ Payment Details ________________________________________"); 
				    line32.setBounds(10,390,1000,30);
				    tenantInfo2.add(line32);
	       
					
			        JLabel pPlanLB2 = new JLabel("Payment Plan:"); 
			        pPlanLB2.setBounds(30,420,200,30);
			        JLabel pPlan2 = new JLabel(getInfo.getPaymentPlan(flatNo2)); 
			        pPlan2.setBounds(300,420,200,30);
			        tenantInfo2.add(pPlanLB2);
			        tenantInfo2.add(pPlan2);
			        pPlanLB2.setFont(font);
			        pPlan2.setFont(font);
			        
			        
			        JLabel pMethodLB2 = new JLabel("Payment Method:"); 
			        pMethodLB2.setBounds(30,450,200,30);
			        JLabel pMethod2 = new JLabel(getInfo.getPaymentMethod(flatNo2)); 
			        pMethod2.setBounds(300,450,200,30);
			        tenantInfo2.add(pMethod2);
			        tenantInfo2.add(pMethodLB2); 
			        pMethodLB2.setFont(font);
			        pMethod2.setFont(font);
			        
			        
			        JLabel pAdvLB2 = new JLabel("Advanced Paid Amount:");
			        pAdvLB2.setBounds(30,480,200,30);
			        JLabel pAdv2 = new JLabel(getInfo.getPaymnetAdv(flatNo2) + " OMR");
			        pAdv2.setBounds(300,480,200,30);
			        tenantInfo2.add(pAdvLB2);
			        tenantInfo2.add(pAdv2);
			        pAdvLB2.setFont(font);
			        pAdv2.setFont(font);
			        
			        
			        JLabel pHistory2 = new JLabel("Payment History");
			        pHistory2.setBounds(30,550,200,30);
			        JButton showHistory2 = new JButton("View Payment History"); 
			        showHistory2.setBounds(300,550,200,30);
			        tenantInfo2.add(pHistory2); 
			        tenantInfo2.add(showHistory2);
			        
			        pHistory2.setFont(font);
			      

					   SwingUtilities.invokeLater(new Runnable(){
				            public void run() {
				            	URL url2 = MainWindow.class.getResource("/images/buildingBack.png");
				    	        ImageIcon icon2= new ImageIcon(url2);
				    			JLabel background2= new JLabel(icon2); 
				    			background2.setBounds(200, 100,1000, 700);
								
				    			tenantInfo2.add(background2); 
				    			
				            }
				        });
					   
			      
			      
					
	                //---------------------------------------------------------------------------------
				    
				 
				 // set flow layout for the frame  
				    Container con  = viewFrame.getContentPane();
				    
				    
		      		 
				  //  JScrollPane scroll = new JScrollPane(tenantInfo); 
			      //  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
			      //  scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
			       
			       
		     
		  		    con.add(tp, BorderLayout.CENTER);
		  		    con.add(rightsP, BorderLayout.SOUTH); 
		  		    
		  		    
		  		    con.setBackground(Color.GRAY);
			      
			        
			        //Ask for window decorations provided by the look and feel.
			        JFrame.setDefaultLookAndFeelDecorated(true);
			       //Set the frame icon to an image loaded from a file.
			        
			        viewFrame.setVisible(true);
			   //     viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			        back2.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							
							MainWindow.Options(username);
							viewFrame.dispose();
							
						}
			     		
			     	});
			        
			        
			        showHistory2.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							
							paymentHistory.view("Store 2", username);
							
						}
			     		
			     	});
			        
			        
			        
			        //------------------------------------------------------------------------
			        
			        
			    	
					 
					   
					    tenantInfo3.setLayout(null);
					    tenantInfo3.setBorder(BorderFactory.createTitledBorder("Tenant Details"));
					    
					    JLabel picLabel3 = new JLabel(new ImageIcon("/images/userphoto.png"));
					    picLabel3.setBounds(600,50,300,300);
					    tenantInfo3.add(picLabel3); 
					    
					    JLabel line13 = new JLabel("_______________________________________ Personal Details _______________________________________"); 
					    line13.setBounds(10,10,1000,30);
					    tenantInfo3.add(line13);
					    
					    JLabel nameLB23 = new JLabel("Tenant Name:"); 
					    nameLB23.setBounds(30 ,60 ,200,30);
					    tenantInfo3.add(nameLB23);
					    nameLB23.setFont(font);
					    
					    JLabel name3 = new JLabel(getInfo.getTenantName(flatNo3));
		                name3.setBounds( 300, 60, 200, 30);
		                tenantInfo3.add(name3);
		                name3.setFont(font);
		                
						
					    JLabel idLB3 = new JLabel("Tenant's National ID number:"); 
					    idLB3.setBounds(30 , 90, 200, 30);
					    tenantInfo3.add(idLB3);
					    idLB3.setFont(font);
					    
					    JLabel id3 = new JLabel(getInfo.getTenantIDno(flatNo3)); 
		                id3.setBounds(300 , 90, 200, 30);
		                tenantInfo3.add(id3);
		                id3.setFont(font);
		                
		                JButton back3 = new JButton("Back");
				        back3.setBounds(550,550,90,30);
				        tenantInfo3.add(back3); 
				       
		                JLabel numLB3= new JLabel("Contact Number:" );
		                numLB3.setBounds(30, 120, 200, 30);
		                tenantInfo3.add(numLB3);
		                numLB3.setFont(font);
		                JLabel num3= new JLabel(getInfo.getTenantPhoneNo(flatNo3)); 
		                num3.setBounds(300 , 120 , 200, 30);
		                tenantInfo3.add(num3);
		                num3.setFont(font);
		                
		                
		        		
		                JLabel emailLB3 = new JLabel("Email Address:" );
		                emailLB3.setBounds(30 , 150 , 200, 30);
		                tenantInfo3.add(emailLB3);
		                emailLB3.setFont(font);
		                JLabel email3 = new JLabel(getInfo.getTenantEmail(flatNo3));
		                email3.setBounds(300, 150 ,200, 30);
		                tenantInfo3.add(email3);
		                email3.setFont(font);
		                
		                
		                JLabel sdateLB3 = new JLabel("Rent starting date:" );
		                sdateLB3.setBounds(30, 180, 200, 30);
		                tenantInfo3.add(sdateLB3);
		                sdateLB3.setFont(font);
		                
		                JLabel sdate3 = new JLabel(getInfo.getTenantStartDay(flatNo3)); 
		                sdate3.setBounds(300, 180 , 200, 30);
		                tenantInfo3.add(sdate3);
		                sdate3.setFont(font);
		               
		                JLabel edateLB3 =  new JLabel("Rent ending date:" );  
		                edateLB3.setBounds(30, 210 , 200, 30);
		                tenantInfo3.add(edateLB3);
		                edateLB3.setFont(font); 
		                
		                JLabel edate3 = new JLabel(getInfo.getTenantEndDay(flatNo3)); 
		                edate3.setBounds(300 , 210 , 200, 30);
		                tenantInfo3.add(edate3);
		                edate3.setFont(font);
		              
		                
		                JLabel line23 = new JLabel("_______________________________________ Flat Details ___________________________________________"); 
					    line23.setBounds(10,240,1000,30);
					    tenantInfo3.add(line23);
					    
		               
		                JLabel flatNoLB3 = new JLabel("Store number:"); 
		                flatNoLB3.setBounds(30 , 270 , 200,30);
		                tenantInfo3.add(flatNoLB3);
		                
		                flatNoLB3.setFont(font);
		                
		                JLabel flatno3 = new JLabel(getInfo.getFlatNo(flatNo3)); 
		                flatno3 .setBounds(300, 270, 200,30);
		                tenantInfo3.add(flatno3);
		                
		                flatno3.setFont(font);
		                
		                JLabel floorLB3 = new JLabel("Floor:"); 
		                floorLB3.setBounds(30,300,200,30);
		                tenantInfo3.add(floorLB3); 
		                
		                floorLB3.setFont(font);
		                
		                JLabel floor3 = new JLabel(getInfo.getFloor(flatNo3));
		                floor3.setBounds(300,300,200,30);
		                tenantInfo3.add(floor3);
		                floor3.setFont(font);
		                
		                JLabel flatTypeLB3 = new JLabel("Tenancy Type:"); 
		                flatTypeLB3.setBounds(30,330,200,30);
		                tenantInfo3.add(flatTypeLB3);
		                flatTypeLB3.setFont(font);
		                
		                JLabel flatType3 = new JLabel(getInfo.getFlatType(flatNo3)); 
		                flatType3.setBounds(300,330,200,30);
		                tenantInfo3.add(flatType3);
		                flatType3.setFont(font);
		                
		                
		                JLabel bedroomLB3 = new JLabel("Store Space:"); 
		                bedroomLB3.setBounds(30,360,200,30);
		                JLabel bedroomNo3 = new JLabel(getInfo.getspace(flatNo3));
		                bedroomNo3.setBounds(300,360,200,30);
		                tenantInfo3.add(bedroomNo3);
		                tenantInfo3.add(bedroomLB3); 
		                bedroomNo3.setFont(font);
		                bedroomLB3.setFont(font);
		                
		             
		                JLabel line33 = new JLabel("________________________________________ Payment Details ________________________________________"); 
					    line33.setBounds(10,390,1000,30);
					    tenantInfo3.add(line33);
		       
						
				        JLabel pPlanLB3 = new JLabel("Payment Plan:"); 
				        pPlanLB3.setBounds(30,420,200,30);
				        JLabel pPlan3 = new JLabel(getInfo.getPaymentPlan(flatNo3)); 
				        pPlan3.setBounds(300,420,200,30);
				        tenantInfo3.add(pPlanLB3);
				        tenantInfo3.add(pPlan3);
				        pPlanLB3.setFont(font);
				        pPlan3.setFont(font);
				        
				        
				        JLabel pMethodLB3 = new JLabel("Payment Method:"); 
				        pMethodLB3.setBounds(30,450,200,30);
				        JLabel pMethod3 = new JLabel(getInfo.getPaymentMethod(flatNo3)); 
				        pMethod3.setBounds(300,450,200,30);
				        tenantInfo3.add(pMethod3);
				        tenantInfo3.add(pMethodLB3); 
				        pMethodLB3.setFont(font);
				        pMethod3.setFont(font);
				        
				        
				        JLabel pAdvLB3 = new JLabel("Advanced Paid Amount:");
				        pAdvLB3.setBounds(30,480,200,30);
				        JLabel pAdv3 = new JLabel(getInfo.getPaymnetAdv(flatNo3) + " OMR");
				        pAdv3.setBounds(300,480,200,30);
				        tenantInfo3.add(pAdvLB3);
				        tenantInfo3.add(pAdv3);
				        pAdvLB3.setFont(font);
				        pAdv3.setFont(font);
				        
				        
				        JLabel pHistory3 = new JLabel("Payment History");
				        pHistory3.setBounds(30,550,200,30);
				        JButton showHistory3 = new JButton("View Payment History"); 
				        showHistory3.setBounds(300,550,200,30);
				        tenantInfo3.add(pHistory3); 
				        tenantInfo3.add(showHistory3);
				        
				        pHistory3.setFont(font);
				      

						   SwingUtilities.invokeLater(new Runnable(){
					            public void run() {
					            	URL url3 = MainWindow.class.getResource("/images/buildingBack.png");
					    	        ImageIcon icon3 = new ImageIcon(url3);
					    			JLabel background3 = new JLabel(icon3); 
					    			background3.setBounds(200, 100,1000, 700);
									
					    			tenantInfo3.add(background3); 
					    			
					            }
					        });
						   
				      
				      
						
		                //---------------------------------------------------------------------------------
					    
					 
				 
				        //Ask for window decorations provided by the look and feel.
				        JFrame.setDefaultLookAndFeelDecorated(true);
				       //Set the frame icon to an image loaded from a file.
				        
				        viewFrame.setVisible(true);
				   //     viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        
				        back3.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								MainWindow.Options(username);
								viewFrame.dispose();
								
							}
				     		
				     	});
				        
				        
				        showHistory3.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								paymentHistory.view("Store 3", username);
								
							}
				     		
				     	});
				
				 
			
			        

			       
				
				
			}
		
		
		
		
	     
		
			
}
