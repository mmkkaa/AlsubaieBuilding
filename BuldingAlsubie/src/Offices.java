import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Offices extends MainWindow{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			// Connection to the mySQL database
			static DatabaseConnection connect = new DatabaseConnection(
					"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
					"Majan1957");
			
			
		
		     
		public 	static void view(final String username) { 
				
				final JFrame frame = new JFrame("Offices");
				
			    frame.setBounds(400, 200, 700, 600);
			    
			    frame.setIconImage(new ImageIcon("/src/images/107636964.png").getImage());
			    
			    
			    
		        final JPanel panel = new JPanel()
		        {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					protected void paintComponent(Graphics g)
		            {
		                g.setColor( getBackground() );
		                g.fillRect(0, 0, getWidth(), getHeight());
		                super.paintComponent(g);
		            }
		        };
		        
		        
		        
		        panel.setLayout(null);
		        panel.setOpaque(false);
		        panel.setBackground( new Color(0, 0, 0, 50) );
		        
		        SwingUtilities.invokeLater(new Runnable(){
		            public void run() {
		            	
		            	Border border = new LineBorder(Color.DARK_GRAY, 1);
		            	
		            	URL url = MainWindow.class.getResource("/images/office.png");
		    	        ImageIcon icon = new ImageIcon(url);
		    	        
		    	        URL url2 = MainWindow.class.getResource("/images/optionsBack.png");
		    	        ImageIcon icon2 = new ImageIcon(url2);
		    	        
		    	        JLabel back = new JLabel(icon2); 
		    	        back.setBounds(0, 0, 700, 600);
	                    
		    	   
		    	        
		    	        final JButton office1 = new JButton("Office 11"); 
				        office1.setBounds(20,100,300,180);
				        office1.setIcon(icon);
				        office1.setFont(new Font("Times New Roman", Font.BOLD,19));
				        office1.setBorderPainted(true);
				       
				        office1.setOpaque(false);
				        office1.setContentAreaFilled(true);
				        office1.setBackground(new Color(255,255,250,20));
				        office1.setForeground(new Color(0,0,0,200));
				        office1.setBorder(border);
				        
				        office1.addMouseListener(new MouseAdapter() {
				            public void mouseEntered(MouseEvent evt) {
				            	office1.setBackground(Color.LIGHT_GRAY);
				            	office1.setForeground(Color.BLUE);
				            }

				            public void mouseExited(MouseEvent evt) {
				            	office1.setForeground(new Color(0,0,0,200));
				            }
				        });
				        
				        
				       final  JButton office2 = new JButton("Office 21"); 
				        office2.setBounds(20,300,300,180);
				        office2.setIcon(icon);
				        office2.setFont(new Font("Times New Roman", Font.BOLD,19));
				        office2.setBorderPainted(true);
				        office2.setOpaque(false);
				        office2.setContentAreaFilled(true);
				        office2.setBackground(new Color(255,255,250,10));
				        office2.setForeground(new Color(0,0,0,200));
				        office2.setBorder(border);
				        
				        office2.addMouseListener(new MouseAdapter() {
				            public void mouseEntered(MouseEvent evt) {
				            	office2.setBackground(Color.LIGHT_GRAY);
				            	office2.setForeground(Color.BLUE);
				            }

				            public void mouseExited(MouseEvent evt) {
				            	office2.setForeground(new Color(0,0,0,200));
				            }
				        });
				        
				        
				        final  JButton office3 = new JButton("Office 12"); 
				        office3.setBounds(330,100,300,180);
				        office3.setIcon(icon);
				        office3.setFont(new Font("Times New Roman", Font.BOLD,19));
				        office3.setBorderPainted(true);
				        office3.setOpaque(false);
				        office3.setContentAreaFilled(true);
				        office3.setBackground(new Color(255,255,250,10));
				        office3.setForeground(new Color(0,0,0,200));
				        office3.setBorder(border);
				        
				        office3.addMouseListener(new MouseAdapter() {
				            public void mouseEntered(MouseEvent evt) {
				            	office3.setBackground(Color.LIGHT_GRAY);
				            	office3.setForeground(Color.BLUE);
				            }

				            public void mouseExited(MouseEvent evt) {
				            	office3.setForeground(new Color(0,0,0,200));
				            }
				        });
				        
				        
				        
				        final  JButton office4 = new JButton("Office 22"); 
				        office4.setBounds(330,300,300,180);
				        office4.setIcon(icon);
				        office4.setFont(new Font("Times New Roman", Font.BOLD,19));
				        office4.setBorderPainted(true);
				        office4.setOpaque(false);
				        office4.setContentAreaFilled(true);
				        office4.setBackground(new Color(255,255,250,10));
				        office4.setForeground(new Color(0,0,0,200));
				        office4.setBorder(border);
				        
				        office4.addMouseListener(new MouseAdapter() {
				            public void mouseEntered(MouseEvent evt) {
				            	office4.setBackground(Color.LIGHT_GRAY);
				            	office4.setForeground(Color.BLUE);
				            }

				            public void mouseExited(MouseEvent evt) {
				            	office4.setForeground(new Color(0,0,0,200));
				            }
				        });
				        
				        
				  
				        //--------------actions ----------------- 
				        
				        office1.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								enterNo(office1.getText(), username); 
								frame.dispose();
							
							}
				     		
				     	});
				        
				        
				        office2.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								enterNo(office2.getText(), username); 
								frame.dispose();
							
							}
				     		
				     	});
				        
				        
				        office3.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								enterNo(office3.getText(), username); 
								frame.dispose();
							
							}
				     		
				     	});
				        
				        
				        office4.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								enterNo(office4.getText(), username); 
								frame.dispose();
							
							}
				     		
				     	});
				        
				        
				        
				      //  panel.add(see1);
				      //  panel.add(see2);
				        panel.add(office1);
				        panel.add(office2); 
				        panel.add(office3);
				        panel.add(office4); 
				        
				    	
				     //   panel.add(back);
				        
				        
				        
				        
		             
		            }
		        });
		       
		        
		        JButton back = new JButton("Back"); 
		        back.setBounds(250,500,150,40);
		        panel.add(back); 
		       
		        
		        back.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						
						
						frame.dispose();
						
							MainWindow.Options(username);
					}
		     		
		     	});
		        
		        
		        SwingUtilities.invokeLater(new Runnable(){
		            public void run() {
		            	
		            	URL url = MainWindow.class.getResource("/images/szYvJB.png");
		    	        ImageIcon icon = new ImageIcon(url);
		    			JLabel background = new JLabel(icon); 
		    			background.setBounds(0, -10, 700, 600);
		                    
		    			panel.add(background);
		    			
		    			
		            }
		        });
		        
		        
		        JPanel rightsP = new JPanel();
		        
		        
		        JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
				rights.setBounds(200,900,600,20);
				rights.setFont(new Font("Calibri", Font.PLAIN,10));
				
				rightsP.add(rights); 
				
				
				    Container con  = frame.getContentPane();
				
				    con.add(panel,BorderLayout.CENTER);
				    con.add(rightsP, BorderLayout.SOUTH);
				    
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
			    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
				
			}
		
		
		

	    
		static getInfo info;
		
		
		static MainWindow main; 
		static  String[] columnNames = { "Invoice ID", "Flat Number", "Tenant Name" , "Payment Method"
                , "Amount Paid" , "Date"};


		
	     
		public static void enterNo(final String flatNo, final String username) { 
			
			
			 

			    	
							// check if entered number is validated or not 
							
							
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
							    
				               
				                JLabel flatNoLB = new JLabel("Office number:"); 
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
				                
				                JLabel flatTypeLB = new JLabel("Tenancy Type: "); 
				                flatTypeLB.setBounds(30,330,200,30);
				                tenantInfo.add(flatTypeLB);
				                flatTypeLB.setFont(font);
				                
				                JLabel flatType = new JLabel(getInfo.getFlatType(flatNo)); 
				                flatType.setBounds(300,330,200,30);
				                tenantInfo.add(flatType);
				                flatType.setFont(font);
				                
				                
				             
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
										
										view(username);
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
						
						

			   
		}  
			
}
