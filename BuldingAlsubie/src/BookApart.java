import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class BookApart extends MainWindow{
	
	/**
	 * 
	 * this class is to allow user to book apartment from the dashboard
	 * it will forward user to next step which is tenant registeration's window
	 * 
	 */
	private static final long serialVersionUID = 1L;
			// Connection to the mySQL database
			static DatabaseConnection connect = new DatabaseConnection(
					"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
					"Majan1957");
			
			static setInfo s;
			static MainWindow m; 
			static JTextField n; 
			@SuppressWarnings("rawtypes")
			static JComboBox floor; 
			static String Tfloor;
			static JLabel error = new JLabel(" "); 
			
			
			 
			 
			@SuppressWarnings({ "unchecked", "rawtypes" })
			static public void Viewregister(String s, String j, final String username) {
				
				final JLabel lable = new JLabel(""); 
				final JLabel lable2 = new JLabel(""); 
				final JLabel label3 = new JLabel("");
                
				
				Font font = new Font("Times New Roman", Font.PLAIN, 14); 
				
				    //------------------------------------------------
				    final JFrame viewFrame = new JFrame("Tenant Registration"); 
				    viewFrame.setBounds(200, 100,1000, 700);
				    viewFrame.setIconImage(new ImageIcon("/images/107636964.png").getImage());
			        
				    
				    
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
				    
				    final JTextField name = new JTextField ();
	                name.setBounds( 300, 60, 200, 30);
	                tenantInfo.add(name);
	                
					
				    JLabel idLB = new JLabel("Tenant's National ID number:"); 
				    idLB.setBounds(30 , 90, 200, 30);
				    tenantInfo.add(idLB);
				    idLB.setFont(font);
				    
				    final JTextField  id = new JTextField (); 
	                id.setBounds(300 , 90, 200, 30);
	                tenantInfo.add(id);
	                id.setFont(font);
	                
                     id.addKeyListener(new KeyAdapter() {
	      	        	
	  	        	    public void keyPressed(KeyEvent k) {
	  	        	    	
	  	        	    	
	  	        	    	// Error for any delete and . 
	  	        	    	
	  	        	    	if (k.getKeyChar() >= '0' &&
	  	        	    			k.getKeyChar() <= '9' || k.getKeyChar() == '.' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
	  	        	    		
	  	        	    		
	  	        	    		id.setEditable(true); 
	  	        	    		lable.setText("");
	  	        	    	} else { 
	  	        	    		
	  	        	    		id.setEditable(false);
	  	        	    		lable.setText(" * Enter only digits 0-9");
	  	        	    	}
	  	        	    	
	  	        	    }
	  	        	
	  	        });
	                
					
	                JLabel numLB= new JLabel("Contact Number:" );
	                numLB.setBounds(30, 120, 200, 30);
	                tenantInfo.add(numLB);
	                numLB.setFont(font);
	                final  JTextField num = new JTextField (); 
	                num.setBounds(300 , 120 , 200, 30);
	                tenantInfo.add(num);
	                
	                
	                num.addKeyListener(new KeyAdapter() {
	      	        	
	  	        	    public void keyPressed(KeyEvent k) {
	  	        	    	
	  	        	    	
	  	        	    	// Error for any delete and . 
	  	        	    	
	  	        	    	if (k.getKeyChar() >= '0' &&
	  	        	    			k.getKeyChar() <= '9' || k.getKeyChar() == '.' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
	  	        	    		
	  	        	    		
	  	        	    		num.setEditable(true); 
	  	        	    		lable2.setText("");
	  	        	    	} else { 
	  	        	    		
	  	        	    		num.setEditable(false);
	  	        	    		lable2.setText(" * Enter only digits 0-9");
	  	        	    	}
	  	        	    	
	  	        	    }
	  	        	
	  	        });
	                
	                
	                lable.setBounds(520,90,200,30);
	                lable.setForeground(Color.RED);
	      	        tenantInfo.add(lable); 
	      	        
	      	        
	      	        lable2.setBounds(520,120,400,30);
	                lable2.setForeground(Color.RED);
	      	        tenantInfo.add(lable2); 
	      	        
	                JLabel emailLB = new JLabel("Email Address:" );
	                emailLB.setBounds(30 , 150 , 200, 30);
	                tenantInfo.add(emailLB);
	                emailLB.setFont(font);
	               final  JTextField email = new JTextField();
	                email.setBounds(300, 150 ,200, 30);
	                tenantInfo.add(email);
	                
	                
	                JLabel sdateLB = new JLabel("Tenancy starting date:" );
	                sdateLB.setBounds(30, 180, 200, 30);
	                tenantInfo.add(sdateLB);
	                sdateLB.setFont(font);
	              
	                
	                JLabel dateGuide1 = new JLabel("DD-MM-YYYY"); 
	                JLabel dateGuide2 = new JLabel("DD-MM-YYYY"); 
	                
	                tenantInfo.add(dateGuide1); 
	                tenantInfo.add(dateGuide2);
	                
	                dateGuide1.setBounds(550 , 180 , 200 , 30); 
	                dateGuide2.setBounds(550 , 210 , 200 , 30); 
	                
	               final  JTextField sdate = new JTextField(); 
	                sdate.setToolTipText("DD-MM-YYYY");
	                sdate.setBounds(300, 180 , 200, 30);
	                tenantInfo.add(sdate);
	                
	                JLabel edateLB =  new JLabel("Tenancy ending date:" );  
	                edateLB.setBounds(30, 210 , 200, 30);
	                tenantInfo.add(edateLB);
	                edateLB.setFont(font); 
	                
	               final  JTextField edate = new JTextField(); 
	                edate.setToolTipText("DD-MM-YYYY");
	                edate.setBounds(300 , 210 , 200, 30);
	                tenantInfo.add(edate);
	               
	                
	                JLabel line2 = new JLabel("_______________________________________ Flat Details ___________________________________________"); 
				    line2.setBounds(10,240,1000,30);
				    tenantInfo.add(line2);
				    
				    JLabel flatTypeLB = new JLabel("Tenancy Type:"); 
	                
	                flatTypeLB.setBounds(30 , 270 , 200,30);
	                tenantInfo.add(flatTypeLB);
	                flatTypeLB.setFont(font);
	                
	                
				    String[] types = {"--SELECT--" , "Gallery" , "Store" , "Office" , "Apartment" , "Penthouse" }; 
	                @SuppressWarnings({ })
					final   JComboBox flatType = new  JComboBox(types); 
	               
	                flatType .setBounds(300, 270, 200,30);
	                tenantInfo.add(flatType);
	                
	                flatType.setSelectedIndex(4);
	                flatType.setEnabled(false);
	                
	                JLabel flatNoLB = new JLabel("Flat number:"); 
	                flatNoLB.setBounds(30,330,200,30);
	                tenantInfo.add(flatNoLB);
	                
	                
	                flatNoLB.setFont(font);
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
				    
	             
	                @SuppressWarnings({ })
					final JComboBox  flatno = new JComboBox(flatnum); 
	             
	                flatno.setSelectedItem(s); 
	                flatno.setEnabled(false);
	                
	                flatno.setBounds(300,330,200,30);
	                tenantInfo.add(flatno);
	               
	               // String flatNO = flatno.getText().trim();
	               // int flatNo = Integer.parseInt(flatNO);
	                
	                
					String[] floornum = {"--SELECT--","-1" , "0", "1","2" , "3" , "4", "5",
							"6" , "7" , "8" , "9"};
					
	                JLabel floorLB = new JLabel("Floor:"); 
	                floorLB.setBounds(30,300,200,30);
	                tenantInfo.add(floorLB); 
	                floorLB.setFont(font);
	               
	                
	                floor = new JComboBox(floornum);
	                floor.setBounds(300,300,200,30);
	                
	                floor.setSelectedItem(j);
	                floor.setEnabled(false); 
	                tenantInfo.add(floor);
	               // floor.setEnabled(false);
	                
	               
	               
	              
	                String[] roomNum = { "--SELECT--","2 Bedrooms" , "3 Bedrooms" } ; 
	                
	                JLabel bedroomLB = new JLabel("Bedrooom's Number:"); 
	                bedroomLB.setBounds(30,360,200,30);
	                
	                
	              final   JComboBox bedroomNo = new JComboBox(roomNum);
	              //  bedroomNo.setEnabled(false);
	                bedroomNo.setBounds(300,360,200,30);
	                tenantInfo.add(bedroomNo);
	                tenantInfo.add(bedroomLB); 
	                bedroomLB.setFont(font);
	               
	                
	               // floor.setText(getInfo.getFloor(flatNo));
	                
                	//flatType.setText(getInfo.getFlatType(flatNo));
	                
                	//bedroomNo.setText(getInfo.getBedroomsNo(flatNo));
	                
	                
	                
	                JLabel line3 = new JLabel("________________________________________ Payment Details ________________________________________"); 
				    line3.setBounds(10,390,1000,30);
				    tenantInfo.add(line3);
	       
					String[] plans = { " 12 Months Terms " , "Full-Year Tenancy Fees" }; 
			        JLabel pPlanLB = new JLabel("Payment Plan:"); 
			        pPlanLB.setBounds(30,420,200,30);
			      final   JComboBox pPlan = new JComboBox(plans); 
			        //pPlan.setSelectedItem("--SELECT--"); 
			        pPlan.setBounds(300,420,200,30);
			        tenantInfo.add(pPlanLB);
			        tenantInfo.add(pPlan);
			        pPlanLB.setFont(font);
			        
			      
			        String[] methods = { "Checks" , "Bank Transfare" }; 
			        JLabel pMethodLB = new JLabel("Payment Method:"); 
			        pMethodLB.setBounds(30,450,200,30);
			      final   JComboBox pMethod = new JComboBox(methods); 
			       // pMethod.setSelectedItem("--SELECT--"); 
			        pMethod.setBounds(300,450,200,30);
			        tenantInfo.add(pMethod);
			        tenantInfo.add(pMethodLB); 
			        pMethodLB.setFont(font);
			  
			       
			        JLabel pAdvLB = new JLabel("Advanced Paid Amount:");
			        pAdvLB.setBounds(30,480,200,30);
			        final    JTextField pAdv = new JTextField ();
			       
			        pAdv.setBounds(300,480,200,30);
			        tenantInfo.add(pAdvLB);
			        tenantInfo.add(pAdv);
			        pAdvLB.setFont(font);
			        
                 
			        
			        pAdv.addKeyListener(new KeyAdapter() {
	      	        	
	  	        	    public void keyPressed(KeyEvent k) {
	  	        	    	
	  	        	    	
	  	        	    	// Error for any delete and . 
	  	        	    	
	  	        	    	if (k.getKeyChar() >= '0' &&
	  	        	    			k.getKeyChar() <= '9' || k.getKeyChar() == '.' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
	  	        	    		
	  	        	    		
	  	        	    		pAdv.setEditable(true); 
	  	        	    		label3.setText("");
	  	        	    	} else { 
	  	        	    		
	  	        	    		pAdv.setEditable(false);
	  	        	    		label3.setText(" *  Enter only digits (1.000 - 250.000)");
	  	        	    	}
	  	        	    	
	  	        	    }
	  	        	
	  	        });
	                
	                
	                label3.setBounds(520,470,300,30);
	                label3.setForeground(Color.RED);
	      	        tenantInfo.add(label3); 
	      	        
	      	        
			        
			        final JButton confirm = new JButton("Confirm");
			        confirm.setBounds(400,510,90,30);
			        tenantInfo.add(confirm); 
			        
			        JButton back = new JButton("Back");
			        back.setBounds(500,510,90,30);
			        tenantInfo.add(back); 
			       

	                   error.setForeground(Color.RED);
     	    	       error.setBounds(520,120,200,30);
     	    	       tenantInfo.add(error); 
     	    	       
     	    	       
			        JPanel rightsP = new JPanel();
			        
			        
			       
			        JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
					rights.setBounds(200,900,600,20);
					rights.setFont(new Font("Calibri", Font.PLAIN,10));
					
					rightsP.add(rights); 
					

					   SwingUtilities.invokeLater(new Runnable(){
				            public void run() {
				            	URL url = MainWindow.class.getResource("/images/buildingBack.png");
				    	        ImageIcon icon = new ImageIcon(url);
				    			JLabel background = new JLabel(icon); 
				    			
								background.setBounds(0,0,1000,900);
								
				    			tenantInfo.add(background); 
				    			
				            }
				        });
					//-------------------------extract texts from fields -------------------------
					
					   
					   flatType.addItemListener(new ItemListener() {
						    public void itemStateChanged(ItemEvent e) {
						        
						    	 if ( (flatType.getSelectedItem().toString()== "Gallery" ) ||
						    		  (flatType.getSelectedItem().toString() == "Store" ) ||
						    		  (flatType.getSelectedItem().toString() =="Office" ) )   
						    	 {
						    		   bedroomNo.setEnabled(false);
						    		 
						    	

						    	 }  else if (flatType.getSelectedItem().toString() == "Apartment") {
						                	 
						                	bedroomNo.setSelectedIndex(1);
						                	bedroomNo.setEnabled(false);
						                	
						                }
						                
						    		   
						    	 else { 
						    		 
						    		 bedroomNo.setEnabled(true);
						    		 bedroomNo.setSelectedIndex(2);
						    		 
						    	 }
						    	 
						    	
						    	 
						    }
						});
						
					   

				        
		                num.getDocument().addDocumentListener(new DocumentListener() {

		                	
		                	
							@Override
							public void insertUpdate(DocumentEvent e) {
								
								if ( num.getText().length() > 8  || num.getText().length() < 8) { 
									   
			  	        	    	 
			  	        	    	   error.setText(" * Please insert 8 digits only"); 
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} else {
									 error.setText(" "); 
									 confirm.setEnabled(true);
								}
								
							}

							@Override
							public void removeUpdate(DocumentEvent e) {
								
								if ( num.getText().length() > 8 || num.getText().length() < 8) { 
									   
									 error.setText(" * Please insert 8 digits only"); 
									 
			  	        	    	  
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} else {
									error.setText(" "); 
									  confirm.setEnabled(true);
								}
							}

							@Override
							public void changedUpdate(DocumentEvent e) {
							
								if ( num.getText().length() > 8 || num.getText().length() < 8 ) { 
									  
									 error.setText("* Please insert 8 digits only"); 
									
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} 
								
								else { 
									error.setText(" "); 
									 confirm.setEnabled(true);
									
								}
							}
		                	
		                	
		                	
		                	
		                	
		                });
		                
		                

				        
		                id.getDocument().addDocumentListener(new DocumentListener() {

		                	
							@Override
							public void insertUpdate(DocumentEvent e) {
								
								if ( id.getText().length() > 8  || id.getText().length() < 7) { 
									   
			  	        	    	 
									 error .setText("* Please insert 8 digits only"); 
									 error.setBounds(520,90,200,30);
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} else {
									error.setText(" "); 
									 confirm.setEnabled(true);
								}
								
							}

							@Override
							public void removeUpdate(DocumentEvent e) {
								
								if ( id.getText().length() > 8 || id.getText().length() < 7) { 
									   
			  	        	 
									error .setText("* Please insert 8 digits only"); 
									error.setBounds(520,90,200,30);
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} else {
									error.setText(" "); 
									  
									  confirm.setEnabled(true);
								}
							}

							@Override
							public void changedUpdate(DocumentEvent e) {
							
							if ( id.getText().length() > 8 || id.getText().length() < 7 ) { 
									  

								error .setText(" * Please insert 8 digits only"); 
								  error.setBounds(520,90,200,30);
			  	        	    	   confirm.setEnabled(false);
			  	        	    	   
			  	        	       
								} 
								
								else { 
									error.setText(" "); 
									 confirm.setEnabled(true);
									
								}
							}
		                	
		                	
		                	
		                	
		                	
		                });
		                
		                
					
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
			        
			        
			       // viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			       /**
				       confirm.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								setInfo.setTenantName(Tname, Temail, Tnum, Tid, Tsdate, Tedate, flatNos);
								setInfo.setFlatDetails(flatNos, Tfloor, TflatType, TbedroomNo);
								setInfo.setPaymentDetails(flatNos, TpPlan, TpMehtod, TpAdv);
							}
				     		
				     	});*/
				   
				       
				       back.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
								
								MainWindow.Options(username);
								viewFrame.dispose();
								
							}
				     		
				     	});
				       
				       
				       confirm.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {
							
							
								final String Tname = name.getText();
							    final String Temail = email.getText();
								final String Tid = id.getText(); 
								final String Tnum = num.getText(); 
								final String Tsdate = sdate.getText(); 
								final String Tedate = edate.getText(); 
								
								final String TflatNo = flatno.getSelectedItem().toString();
								             Tfloor = floor.getSelectedItem().toString();
								final String TflatType = flatType.getSelectedItem().toString(); 
								final String TbedroomNo = bedroomNo.getSelectedItem().toString();
								final String TpPlan = pPlan.getSelectedItem().toString();
								final String TpMehtod = pMethod.getSelectedItem().toString();
								final String TpAdv = pAdv.getText(); 
								
								
								if(Statistics.isTaken(TflatNo) == 0) {
									
								
									if ( Tname.isEmpty()|| Temail.isEmpty() ||Tid.isBlank() || 
											Tnum.isEmpty()|| Tsdate.isEmpty() || Tedate.isEmpty() || TpAdv.isEmpty()) { 
										
										JOptionPane.showMessageDialog(null,"Please fill in all required detailes ");
									
									
									} else {
								
					            	    setInfo.setTenantName(Tname, Temail, Tnum, Tid, Tsdate,Tedate, TflatNo);
										setInfo.setFlatDetails(TflatNo, Tfloor, TflatType, TbedroomNo);
										setInfo.setPaymentDetails(TflatNo, TpPlan, TpMehtod, TpAdv);
										setInfo.setTaken(TflatNo);
										
										JOptionPane.showMessageDialog(null,"Registeration is Completed");
										viewFrame.dispose();
										MainWindow.Options(username);
										
									}
										
								}
								
								
								 else { 
										
									    JOptionPane.showMessageDialog(null,"This flat is already booked, please choose another flat ");
									}
								
									
				              }
				           
				        });
				       
			    
			}
			
		
}


