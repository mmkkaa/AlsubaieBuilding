import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 

public class UpdateTenant extends MainWindow{
	
	/**
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
			static JLabel flatNoLB = new JLabel("Please Enter Flat Number:");
			static JTextField flatNoTF = new JTextField(); 
			static JButton Enter = new JButton("Enter");
			
			
			
			static JLabel lable = new JLabel(""); 
			static JLabel lable2 = new JLabel(""); 
			static JLabel label3 = new JLabel("");
			

		     
			public static void enterNo(final String username) { 
			
				    final JFrame infoFrame = new JFrame("Update Tenant Information"); 
				    infoFrame.setSize(new Dimension(600, 300));
				    infoFrame.setBounds(400, 200, 600, 300);
				    infoFrame.setIconImage(new ImageIcon("/images/107636964.png").getImage());
			        
				    JPanel flatNoEnter = new JPanel();
				    JButton backButton = new JButton("Back");
				    
				    flatNoEnter.setBorder(BorderFactory.createTitledBorder("Select the flat number:"));
				    flatNoEnter.setBounds(200, 100, 100, 100);
				    
				    JLabel panelInfo = new JLabel("To search for Tenant's information please select flat number below.");
				    
				    
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
				    
	             
	                @SuppressWarnings({ "unchecked", "rawtypes" })
					final JComboBox  flatno = new JComboBox(flatnum); 
	               
				    
				    panelInfo.setBounds(50, 50, 500, 30);
				    flatNoLB.setBounds(50, 100, 200, 30);
				    flatno.setBounds(50, 150, 200, 30);
				    Enter.setBounds(300, 200, 70, 30);
				    backButton.setBounds(390, 200, 70, 30);
				    
				    
				    flatNoLB.setBounds(50, 180, 200, 30);
				    flatNoTF.setBounds(50, 210, 200, 30);
				    Enter.setBounds(300, 210, 70, 30);
				    backButton.setBounds(390, 210, 70, 30);
				    
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
			    
			        
			        backButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							MainWindow.Options(username); 
							infoFrame.dispose(); 
 
						}
			     		
			     	});
			        
			        
			        Enter.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							final String flatNo = flatno.getSelectedItem().toString();
							if (    flatNo.equals("31") ||flatNo.equals("32") || flatNo.equals("33")  || flatNo.equals("34") || 
					        		flatNo.equals("41") ||flatNo.equals("42") || flatNo.equals("43")  || flatNo.equals("44") || 
					        		flatNo.equals("51") ||flatNo.equals("52") || flatNo.equals("53")  || flatNo.equals("54") || 
					        		flatNo.equals("61") ||flatNo.equals("62") || flatNo.equals("63")  || flatNo.equals("64") || 
					        		flatNo.equals("71") ||flatNo.equals("72") || flatNo.equals("73")  || flatNo.equals("74") || 
					        		flatNo.equals("81") ||flatNo.equals("82") || flatNo.equals("83") || flatNo.equals("84")  || 
					        		flatNo.equals("91") ||flatNo.equals("92") ||
					        		flatNo.equals("Gallery A") || flatNo.equals("Gallery B") || flatNo.equals("Gallery C") || flatNo.equals("Gallery C") ||
					        		flatNo.equals("Office 11") || flatNo.equals("Office 12") || flatNo.equals("Office 21") || flatNo.equals("Office 22") || 
					        		flatNo.equals("Store 1") || flatNo.equals("Store 2") || flatNo.equals("Store 3"))
							
							
						  { 
						
							Update(flatNo, username); 
							infoFrame.dispose(); 
 
						} else { 
							
							JOptionPane.showMessageDialog(null,"Please Enter Number of Flat / Offce / Gallery / Store"); 
							 
							
						}
							
							
						} 
			     	});
			        
			}
			 
			 
			@SuppressWarnings({ "rawtypes", "unchecked" })
			static public void Update(String Number, final String username) {
				
				
				
				
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
				    
				    final JTextField name = new JTextField ();
	                name.setBounds( 300, 60, 200, 30);
	                tenantInfo.add(name);
	                name.setText(getInfo.getTenantName(Number));
					
				    JLabel idLB = new JLabel("Tenant's National ID number:"); 
				    idLB.setBounds(30 , 90, 200, 30);
				    tenantInfo.add(idLB);
				    idLB.setFont(font);
				    
				    final JTextField id = new JTextField(); 
	                id.setBounds(300 , 90, 200, 30);
	                tenantInfo.add(id);
	                id.setFont(font);
	                id.setText(getInfo.getTenantIDno(Number));
	                id.setEnabled(false);
	               
	           /**    
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
	          */      
				
	                
	                JLabel numLB= new JLabel("Contact Number:" );
	                numLB.setBounds(30, 120, 200, 30);
	                tenantInfo.add(numLB);
	                numLB.setFont(font);
	                final  JTextField num = new JTextField (); 
	                num.setBounds(300 , 120 , 200, 30);
	                tenantInfo.add(num);
	                num.setText(getInfo.getTenantPhoneNo(Number));
	            
	                
	                
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
	                email.setText(getInfo.getTenantEmail(Number));
	                
	                
	                JLabel dateGuide1 = new JLabel("DD-MM-YYYY"); 
	                JLabel dateGuide2 = new JLabel("DD-MM-YYYY"); 
	                
	                tenantInfo.add(dateGuide1); 
	                tenantInfo.add(dateGuide2);
	                
	                dateGuide1.setBounds(550 , 180 , 200 , 30); 
	                dateGuide2.setBounds(550 , 210 , 200 , 30); 
	                
	                
	                JLabel sdateLB = new JLabel("Tenancy starting date:" );
	                sdateLB.setBounds(30, 180, 200, 30);
	                tenantInfo.add(sdateLB);
	                sdateLB.setFont(font);
	              
	                
	               final  JTextField sdate = new JTextField(); 
	                sdate.setToolTipText("YYYY-MM-DD");
	                sdate.setBounds(300, 180 , 200, 30);
	                tenantInfo.add(sdate);
	                sdate.setText(getInfo.getTenantStartDay(Number));
	                
	                JLabel edateLB =  new JLabel("Tenancy ending date:" );  
	                edateLB.setBounds(30, 210 , 200, 30);
	                tenantInfo.add(edateLB);
	                edateLB.setFont(font); 
	                
	               final  JTextField edate = new JTextField(); 
	                edate.setToolTipText("YYYY-MM-DD");
	                edate.setBounds(300 , 210 , 200, 30);
	                tenantInfo.add(edate);
	                edate.setText(getInfo.getTenantEndDay(Number));
	               
	                
	                JLabel line2 = new JLabel("_______________________________________ Flat Details ___________________________________________"); 
				    line2.setBounds(10,240,1000,30);
				    tenantInfo.add(line2);
				    
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
	    
    
	                JLabel flatNoLB = new JLabel("Apartment number:"); 
	                flatNoLB.setBounds(30 , 330 , 200,30);
	                tenantInfo.add(flatNoLB);
	                
	                flatNoLB.setFont(font);
	                
	                @SuppressWarnings({ })
					final JComboBox  flatno = new JComboBox(flatnum); 
	                String getflatno = getInfo.getFlatNo(Number); 
	                flatno.setSelectedItem(getflatno); 
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
	                String getfloor = getInfo.getFloor(Number); 
	                floor.setSelectedItem(getfloor); 
	                
	              
	                tenantInfo.add(floor);
	               // floor.setEnabled(false);
	                
	               
	                JLabel flatTypeLB = new JLabel("Tenancy Type:"); 

	                flatTypeLB.setBounds(30 , 270 , 200,30);
	                tenantInfo.add(flatTypeLB);
	                
	                flatTypeLB.setFont(font);
	                

				    String[] types = {"--SELECT--" , "Gallery" , "Store" , "Office" , "Apartment" , "Penthouse" }; 
	              final   JComboBox flatType = new  JComboBox(types); 
	              flatType .setBounds(300, 270, 200,30);
	                String getflatT = getInfo.getFlatType(Number); 
	                flatType.setSelectedItem(getflatT); 
	                tenantInfo.add(flatType);
	                
	               // flatType.setEnabled(false);
	                
	                String[] roomNum = { "--SELECT--","2 Bedrooms" , "3 Bedrooms" } ; 
	                
	                JLabel bedroomLB = new JLabel("Bedrooom's Number:"); 
	                bedroomLB.setBounds(30,360,200,30);
	                
	              final   JComboBox bedroomNo = new JComboBox(roomNum);
	              //  bedroomNo.setEnabled(false);
	                bedroomNo.setBounds(300,360,200,30);
	                
	                String getBDNO = getInfo.getBedroomsNo(Number); 
	                bedroomNo.setSelectedItem(getBDNO ); 
	                
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
			      
			      String getplan = getInfo.getPaymentPlan(Number); 
			      pPlan.setSelectedItem(getplan); 
	                
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
			        String getMethod = getInfo.getPaymentMethod(Number); 
			        pMethod.setSelectedItem(getMethod); 
		               
				      
			        tenantInfo.add(pMethod);
			        tenantInfo.add(pMethodLB); 
			        pMethodLB.setFont(font);
			  
			       
			        JLabel pAdvLB = new JLabel("Advanced Paid Amount:");
			        pAdvLB.setBounds(30,480,200,30);
			     final    JTextField pAdv = new JTextField();
			       
			        pAdv.setBounds(300,480,200,30);
			        pAdv.setText(getInfo.getPaymnetAdv(Number));
			        
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
			       
			        
			        
			        
	                num.getDocument().addDocumentListener(new DocumentListener() {

	                	 JLabel error = new JLabel("Please insert 8 digits only"); 
	                	
						@Override
						public void insertUpdate(DocumentEvent e) {
							
							if ( num.getText().length() > 8  || num.getText().length() < 8) { 
								   
		  	        	    	 
								error.setBounds(520,120,200,30);
								error .setText("Please insert 8 digits only"); 
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} else {
								 error .setText(" "); 
								 confirm.setEnabled(true);
							}
							
						}

						@Override
						public void removeUpdate(DocumentEvent e) {
							
							if ( num.getText().length() > 8 || num.getText().length() < 8) { 
								   
		  	        	 

								error .setText("Please insert 8 digits only"); 
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} else {
								 error .setText(" "); 
								  confirm.setEnabled(true);
							}
						}

						@Override
						public void changedUpdate(DocumentEvent e) {
						
							if ( num.getText().length() > 8 || num.getText().length() < 8 ) { 
								  

								error .setText("Please insert 8 digits only"); 
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} 
							
							else { 
								 error .setText(" "); 
								 confirm.setEnabled(true);
								
							}
						}
	                	
	                	
	                	
	                	
	                	
	                });
	                

			        
	                id.getDocument().addDocumentListener(new DocumentListener() {

	                	final JLabel error = new JLabel("Please insert 8 digits only"); 
	        			
						@Override
						public void insertUpdate(DocumentEvent e) {
							
							if ( id.getText().length() > 8  || id.getText().length() < 7) { 
								   
		  	        	    	 

								 error .setText("* Please insert 8 digits only"); 
								 error.setBounds(520,90,200,30);
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} else {
								 error .setText(" "); 
								 confirm.setEnabled(true);
							}
							
						}

						@Override
						public void removeUpdate(DocumentEvent e) {
							
							if ( id.getText().length() > 8 || id.getText().length() < 7 ) { 
								   
		  	        	 

								 error .setText("* Please insert 8 digits only"); 
								 error.setBounds(520,90,200,30);
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} else {
								 error .setText(" "); 
								  confirm.setEnabled(true);
							}
						}

						@Override
						public void changedUpdate(DocumentEvent e) {
						
							if ( id.getText().length() > 8 || id.getText().length() < 7 ) { 
								  

								 error .setText("* Please insert 8 digits only"); 
								 error.setBounds(520,90,200,30);
		  	        	    	   confirm.setEnabled(false);
		  	        	    	   
		  	        	       
							} 
							
							else { 
								 error .setText(" "); 
								 confirm.setEnabled(true);
								
							}
						}
	                	
	                	
	                	
	                	
	                	
	                });
	                
	                
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
						        
						    	 if ( (flatType.getSelectedItem().toString()== "Shop" ) ||
						    		  (flatType.getSelectedItem().toString() == "Store" ) ||
						    		  (flatType.getSelectedItem().toString() =="Office" ) )   
						    	 {

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
			        
			        SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/107636964.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    	         
			    			  viewFrame.setIconImage(icon.getImage());
			    			
			            }
			        });
			       //Set the frame icon to an image loaded from a file.
			        
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
								
								final String previousFlat = sameFlat(Tid); // incase the customer changed his flat ,, use this val to delete history 
								
								System.out.println(" previous: " + previousFlat); 
								
								if ( Tname.isEmpty()|| Temail.isEmpty()|| 
										Tnum.isEmpty()|| Tsdate.isEmpty() || Tedate.isEmpty() || TpAdv.isEmpty() || 
										TflatNo == "--SELECT--" || Tfloor == "--SELECT--" || TflatType == "--SELECT--" || TbedroomNo == "--SELECT--" || 
										 TpPlan =="--SELECT--" || TpMehtod == "--SELECT--") { 
									
									JOptionPane.showMessageDialog(null,"Please fill in all required detailes ");
								} 
								
								
								else { 
								
								// if the changes flat is not taken ,, system will allow user to change and update all info 
								
								      if(Statistics.isTaken(TflatNo) == 0 ) {
									
								    	  
								    	  System.out.println(" previous: " + previousFlat); 
										  System.out.println(" selected: " + TflatNo); 
											 
								    	  
								    	  //2. delete them from display table
								    	  
								    	  deletpaymentHistory(previousFlat);
								    	  deletPaymentInfo(previousFlat);
								    	  deleteFlatsTable(previousFlat); 
								    	  deleteTenant(previousFlat);
								    	
								         // 3. insert new data 
								    	  
					            	    setInfo.setTenantName(Tname, Temail, Tnum, Tid, Tsdate, Tedate, TflatNo);
										setInfo.setFlatDetails(TflatNo, Tfloor, TflatType, TbedroomNo);
										setInfo.setPaymentDetails(TflatNo, TpPlan, TpMehtod, TpAdv);
										
										
										//4. set new flat taken
										setInfo.setTaken(TflatNo);
										//5. set old flat not taken
										setInfo.setNotTaken(previousFlat);
										
										JOptionPane.showMessageDialog(null,"Information is updated");
										viewFrame.dispose();
										MainWindow.Options(username);
										
									}
										
								
								
								
								//if the flat is already booked and tenant will only update personal info not changing the flat , 
								// system should send updates only of personal info and keep the flat same 
								
								
								 else if (Statistics.isTaken(TflatNo) == 1 ) {
									 
									 System.out.println(" previous: " + previousFlat); 
									 System.out.println(" selected: " + TflatNo); 
									 
									 // no need to change anything 
									   if (TflatNo.equals(previousFlat) ) {
										   
										   
										    setInfo.setTenantName(Tname, Temail, Tnum, Tid, Tsdate, Tedate, TflatNo);
											setInfo.setFlatDetails(TflatNo, Tfloor, TflatType, TbedroomNo);
											setInfo.setPaymentDetails(TflatNo, TpPlan, TpMehtod, TpAdv);
											//setInfo.setTaken(TflatNo);
											
											JOptionPane.showMessageDialog(null,"Registeration is Completed");
											viewFrame.dispose();
											MainWindow.Options(username);
									   } 
									   
									   
									   else {
											 
										      // if customer is changing to a flat which is already booked 
												 
												JOptionPane.showMessageDialog(null,"This flat is already booked, please choose another flat ");
										 
										 }
									   
									}
								      
								      
								 
								
			
							}
								
					} 
		
			});
				       
			    
	}
			
			
			
			
			
			static public String sameFlat(String ID) {
				
				String flat = ""; 
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   ResultSet rs;
					   
					 

			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("SELECT `flatNo` FROM `Tenant2` WHERE `nationalID` = ?  ");
			     		st1.setString(1, ID); 
			     		rs = st1.executeQuery(); 
			     		
			     		while (rs.next())
			           {
			     			flat= rs.getString("flatNo");	
			           } st1.close();
			           
			           
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				return flat; 
			}
			
			
			

			
			static public void  deletPaymentInfo(String flatNo) {
				
				
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
						int rs;
					   

				         
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("DELETE FROM paymentInfo WHERE flatNo = ? ");
			     		
			     
			     		st1.setString(1, flatNo);
			     		
			     		
			     		rs = st1.executeUpdate(); 
			     		
			     		
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				
			}
			

			
			static public void  deleteTenant(String flatNo) {
				
				
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
						int rs;
					   

				         
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("DELETE FROM Tenant2 WHERE flatNo = ? ");
			     		
			     
			     		st1.setString(1, flatNo);
			     		
			     		
			     		rs = st1.executeUpdate(); 
			     		
			     		
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				
			}
			

			static public void  deleteFlatsTable(String flatNo) {
				
				
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
						int rs;
					   

				         
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("DELETE FROM flatsTable WHERE flatNo = ? ");
			     		
			     
			     		st1.setString(1, flatNo);
			     		
			     		
			     		rs = st1.executeUpdate(); 
			     		
			     		
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				
			}
			
			
			
	static public void  deletpaymentHistory(String flatNo) {
				
				
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
						int rs;
					   

				         
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("DELETE FROM paymentHistory WHERE flatNo = ? ");
			     		
			     
			     		st1.setString(1, flatNo);
			     		
			     		
			     		rs = st1.executeUpdate(); 
			     		
			     		
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				
			}
			

	static public void  updateTenant2(String oldFlat , String newFlat) {
				
				
				
				try {
					
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
						int rs;
					   

				         
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("UPDATE Tenant2 SET flatNo = ? Where flatNo = ? ");
			     		
			     
			     		st1.setString(1, newFlat);
			     		st1.setString(2, oldFlat);
			     		
			     		
			     		rs = st1.executeUpdate(); 
			     		
			     		
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  

				
			}
			
			
		
}
