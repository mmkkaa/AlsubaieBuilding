
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;


public class Statistics extends MainWindow {
	
	
	/**
	 * 
	 */
	
    
	
	private static final long serialVersionUID = 1L;
	static int l = 0;
	
	static ArrayList<String> buttonList = new ArrayList <String>();
	static Font font = new Font("Times New Roman", Font.BOLD, 18); 
	
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
		Tenantspanel .setBorder(BorderFactory.createTitledBorder("Tenants"));
	    Tenantspanel.setLayout(null);
		
		
		final JPanel Apartspanel = new JPanel(); 
		Apartspanel .setBorder(BorderFactory.createTitledBorder("Apartments"));
	     
		
		JButton back = new JButton("Back"); 
		back.setBounds(100, 690, 100, 40);
	    
		
	
		//Apartspanel.add(takenflatsNumLB); 
	   //Apartspanel.add(takenFlatsNum); 
		
		 JLabel label3 =new JLabel("- Select Apratment to Book :"); 
		 
		 label3.setBounds(20,240,800,30);
		 label3.setFont(font);
		
		 final JPanel containerPanel = new JPanel(); 
	        containerPanel.setBounds(0,0,1400,1000);
	        containerPanel.setLayout(null);
	    	containerPanel.setLayout(new OverlayLayout(containerPanel));
   
	    	
	    	Tenantspanel.setOpaque( false );
	    	Apartspanel .setOpaque(false); 
	    
	    	
	    	Tenantspanel.setBounds(20,20,810,200);
	    	Apartspanel .setBounds(20,270,1000,300);
	    	
	   
	    	
	    	Apartspanel.setBackground( new Color(0, 0, 0, 200) );
	    	Tenantspanel.setBackground( new Color(0, 0, 0, 200) );
	    	
	    	Apartspanel.setLayout(new GridLayout(5,10));
			
             final JLabel[] floors = { new JLabel("Floor 1") , new JLabel("Floor 2") , new JLabel("Floor 3"), 
            		                   new JLabel("Floor 4"),  new JLabel("Floor 5") , new JLabel("Floor 6"),
            		                   new JLabel("Floor 7"), new JLabel("Floor 8") , new JLabel("Floor 9") } ; 
             
             
            // final JLabel[] roomsN = { new JLabel("1") , new JLabel("2") , new JLabel("3") , new JLabel("4") }; 
             
             JButton book = new JButton("Book Apartment"); 
             
             book.setBounds(230, 690, 100, 40);
             
             
             
             back.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						MainWindow.Options(username); 
						frame.dispose(); 
					    

					}
		     		
		     	});
             
             

			 SwingUtilities.invokeLater(new Runnable(){
		            public void run() {
		            	
		            	
		            	//add images of button check of flats 
 
		            	URL url = MainWindow.class.getResource("/images/cross.png");
		    	        final ImageIcon icon = new ImageIcon(url);
		    	        
		    	        URL url2 = MainWindow.class.getResource("/images/tick.png");
		    	        final ImageIcon icon2 = new ImageIcon(url2);
		    		
		    	        URL url3 = MainWindow.class.getResource("/images/cross (1).png");
		    	        final ImageIcon icon3 = new ImageIcon(url3);

		    	         final JButton[][] crossAndTick = new JButton[5][9]; 
		    	         
       		    	    
		    			
		    			   for ( int i=0 ; i < 5; i++) { 
		    	            
		    				 
		    				   if (i==0) { 
		    					   Apartspanel.add(new JLabel(" "));
		    					  
		    					   
		    				   } else { 
		    					   
		    	            		 Apartspanel.add( new JLabel(Integer.toString(i)));
		    	            		 
		    				   } 
		    				   
		    				   
		    	            	 for ( int j=0; j <9; j++)  { 
		    	            	    
		    	            	     if (i==0) { 
		    	            			
		    	            	    	 Apartspanel.add(floors[l]); 
		    	            	    	 l++; 
		    	            	     } 
		    	            	         
		    	            	     
		    	            	     else if (i==4 && j==8 || i==3 && j==8) {
		    	            	    	 
		    	            	    	 JLabel na = new JLabel("N/A"); 
		    	            	    	 na.setFont(font);
		    	            	    	 na.setForeground(Color.RED);
		    	            	    	
		    	            	    	 Apartspanel.add(na); 
		    	            	    	 
		    	            	     } else if (j==0 && i==1 || j==0 && i==2 || j==0 && i==3 || j==0 && i==4 || 
		    	            	    		    j==1 && i==1 || j==1 && i==2 || j==1 && i==3 || j==1 && i== 4 ) { 
		    	            	    	 
		    	            	    	 JLabel empty = new JLabel(" - "); 
		    	            	    	 empty .setFont(font);
		    	            	    	 empty .setForeground(Color.RED);
		    	            	    	 Apartspanel.add(empty); 
		    	            	    	 
		    	            	     }
		    	            	     
		    	            	     
		    	            	     else  {
		    	            	    	 
		    	            		    	 // we can have a string[][] 2D array to put all these icons inside first 
		    	            	    	 
		    	            	    	
		    	            	    	
		    	            		    	  if (check(j+1,i) == 1 ) {
		    	            		    		
		    	            		    	     crossAndTick[i][j] = new JButton(); 
		    	            		    	     crossAndTick[i][j].setIcon(icon2); 
		    	            		    	     crossAndTick[i][j].setContentAreaFilled(false);
		    	            		    	     crossAndTick[i][j] .setPreferredSize(new Dimension(10, 10));
		    	            		    	     crossAndTick[i][j] .setBorderPainted(false);
		    	            		    	     crossAndTick[i][j] .setOpaque(false);
		    	         	        			
				    	     	        		
		    	            		    	     Apartspanel.add(crossAndTick[i][j]);  
		    	            		    	     
		    	            		    	}  
		    	            		    	  
		    	            		    	  
		    	            		    	  else {
		    	            		    		 crossAndTick[i][j] = new JButton(); 
		    	            		    	     crossAndTick[i][j].setIcon(icon); 
		    	            		    	     crossAndTick[i][j] .setContentAreaFilled(false);
		    	         	        			 crossAndTick[i][j] .setPreferredSize(new Dimension(10, 10));
		    	         	        			 crossAndTick[i][j] .setBorderPainted(false);
		    	         	        			 crossAndTick[i][j] .setOpaque(false);
		    	         	        			 crossAndTick[i][j] .setEnabled(true);
		    	         	        			
		    	         	        			  Apartspanel.add(crossAndTick[i][j]);  
		    	         	        			  
		    	         	        			  
		    	         	        			 crossAndTick[i][j].setName(Integer.toString((j+1)+i));
		    	         	        			
		    	         	        		    
		    	         	  						
		    	         	        			 crossAndTick[i][j].addActionListener(new ActionListener(){
			 	         	               	    	 
				  	         	  						public void actionPerformed(ActionEvent e){
				  	         	  							
				  	         	  						int counter = 0; 
				  	         			    			
				  	         			    			   for ( int i=0 ; i < 5; i++) { 
				  	         			    	            
				  	         			    				   
				  	         			    	            	 for ( int j=0; j < 9; j++)  { 
				  	         			    	            	    
				  	         			    	            		 
				  	         			    	            	
				  	         			    	            		 if (e.getSource() == crossAndTick[i][j] && counter ==0 && crossAndTick[i][j].getIcon() != icon3) { 
				  	         			    	            			 
				  	         			    	            			if  (!buttonList.contains(crossAndTick[i][j].getName()) && buttonList.size() < 1) {
				  	         			    	            			System.out.println("button :" + (j+1) + i);
				  	         			    	            			crossAndTick[i][j].setIcon(icon3);
				  	         			    	            			counter ++;
				  	         			    	            			buttonList.add(crossAndTick[i][j].getName());
				  	         			    	            			
				  	         			    	            			// call registerCustomer(); 
				  	         			    	            			      System.out.println(Integer.toString((j+1))+Integer.toString(i)); 
				  	         			    	            			      System.out.println("floor:" + Integer.toString(j+1));
				  	         			    	            			  //     
				  	         			    	            			      
				  	         			    	            			  
				  	         			    	            			int dialogButton = JOptionPane.showConfirmDialog (null, 
				  	         								        			"Do you want to book this apartment?"
				  	         								        			,"WARNING",JOptionPane.YES_NO_OPTION);
				  	         								        	
				  	         								        	  if(dialogButton == JOptionPane.YES_OPTION) {
				  	         								        		
				  	         								        	     BookApart.Viewregister(Integer.toString((j+1))+Integer.toString(i),Integer.toString(j+1), username); 
					  	         			    						  
				  	         								        	   }
				  	         								        	
				  	         								        	
				  	         			    	            			
				  	         			    	            			}
				  	         			    	            			
				  	         			    	            		   	
				  	         			    	            			
				  	         			    	            		 } else if (e.getSource() == crossAndTick[i][j] && crossAndTick[i][j].getIcon() == icon3) {
				  	         			    	            			 
				  	         			    	            			crossAndTick[i][j].setIcon(icon);
				  	         			    	            			
				  	         			    	            			counter --;
				  	         			    	            			buttonList.remove(crossAndTick[i][j].getName());
				  	         			    	            		 }
				  	         			    	            		 
				  	         			    	            		  
				  	         			    	            	 
				  	         	  							
				  	         	  						     }
				  	         			    			   
				  	         			    			 } 
				  	         			    			   
				  	         	  						}
				  	         	  							
				  	         	        			 });  		 
				    	            	    	 
		    	            		    	    	 
		    	            		      } 

		 		    	            	     
		    	            		    	  
		    	            		    	
		    	            		    	 
		    	            	    	 }
		    	            	     
 	         	  						
		    	            	
		    	            	   
   	            		    	  
		    	            	       
		    	            	     	 /*
		    	            			    rooms[i][j] = new JButton (); 
		    	            			    rooms[i][j].setIcon(icon);
			 		    	    			rooms[i][j].setContentAreaFilled(true);
			 		    	    			rooms[i][j] .setPreferredSize(new Dimension(20, 20));
			 		    	    			rooms[i][j].setBorderPainted(true);
			 		    	    			rooms[i][j].setOpaque(false);
			 		    	    			Apartspanel.add(rooms[i][j]);
			 		    		            i++;
			 		    		            j++; */
		    	            			 
		    	            		
		    	            	    /** 	
		    	        
			    	            	    else { 
			    	            		 
			    	            			 
			    	            			    rooms[i][j] = new JButton (""); 
			    	            			    rooms[i][j].setIcon(icon);
				 		    	    			rooms[i][j].setContentAreaFilled(true);
				 		    	    			rooms[i][j] .setPreferredSize(new Dimension(90, 90));
				 		    	    			rooms[i][j].setBorderPainted(true);
				 		    	    			rooms[i][j].setOpaque(false);
				 		    	    			Apartspanel.add(rooms[i][j]);
				 		    		           i++;
				 		    		           j++;
			    	            		 } 
		    	            		 } 
		    	            		 
		    	           */ 
		    	            		 
		    	            	 }
		    	             
		    	             
		    			   }
			        
		    			
		            }
		        });
			
		
	    
          
               l =0;
	    	
	    	
               
               
              // ------------------------ Tenant's Panel ---------------------------
               
               
               
               JLabel tenantSum = new JLabel("Booked Flats");
               tenantSum.setFont(font);
               tenantSum.setBounds(50,70,150,30);
               
               
               JLabel OfficeSum = new JLabel("Booked Offices");
               OfficeSum.setFont(font);
               OfficeSum.setBounds(250,70,150,30);
               
               
               JLabel GallerySum = new JLabel("Booked Galleries");
               GallerySum.setFont(font);
               GallerySum.setBounds(450,70,150,30);
               
               
               JLabel StoreSum = new JLabel("Booked Stores");
               StoreSum.setFont(font);
               StoreSum.setBounds(650,70,150,30);
               
               
               JLabel TS = new JLabel(getInfo.getNumofTakenFalts()+ " / 26");
               TS.setFont(font);
               TS.setBounds(80,130,70,30);
               
               
               JLabel OS = new JLabel(getInfo.getNumofTakenOffices() + " / 4"); 
               OS.setFont(font);
               OS.setBounds(280,130, 70,30);
               
               JLabel GS = new JLabel(getInfo.getNumofTakenStores()+ " / 4"); 
               GS.setFont(font);
               GS.setBounds(480,130,70,30);
               
               
               JLabel SS = new JLabel(getInfo.getNumofTakenGalleries() + " / 3"); 
               SS.setFont(font);
               SS.setBounds(680,130,70,30);
               
               
               
               
        	   Tenantspanel.add(tenantSum);
        	   Tenantspanel.add(GallerySum);
        	   Tenantspanel.add(StoreSum);
        	   Tenantspanel.add(OfficeSum);
        	   Tenantspanel.add(TS);
        	   Tenantspanel.add(OS);
        	   Tenantspanel.add(GS);
        	   Tenantspanel.add(SS);
        	   
        	   
				 SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/buildingBack.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    			JLabel background = new JLabel(icon); 
			    			background.setBounds(0, 0, 1400, 900);
			                    
			    			containerPanel.add(background);
			    			
			    			
			            }
			        });
				
			
		 	 
		       //create container        
		                frame.setBounds(150, 100,1200,850);
		       
						final Container con = frame.getContentPane();
					    
						
						con.add(Tenantspanel);
						con.add(rightsPanel, BorderLayout.SOUTH);
						con.add(Apartspanel);
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
	
	
	
	
	public static boolean selected(int i) {
		
		Boolean selected = false; 
		
		   if (i==0) {
			   selected = false; 
		   } else { 
			   selected = true;
		   }
		return selected; 
		
	}

	
    public static int isTaken(String flatNo ) { 
    	int t = 0; 
    	try {
    		
    		   PreparedStatement st1;
    		   Connection connection;
    		   ResultSet rs;
    		   
          		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
          		st1 = connection.prepareStatement("SELECT  `taken` FROM `allFlats` WHERE `number` = ? ");
          		st1.setString(1, flatNo);
          		rs = st1.executeQuery(); 
          		
          		while (rs.next())
                {
          			t= rs.getInt("taken");
                } st1.close();
                
    		}catch (SQLException e1) {
    			
    			System.out.println(e1.getMessage());
    		} 
    	
    	return t; 
	 
    }
    
    
    public static int check(int i, int j) { 
    	
    	int taken = 0; 
    	try {
    		
 		   PreparedStatement st1;
 		   Connection connection;
 		   ResultSet rs;
 		   
       		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
       		st1 = connection.prepareStatement("SELECT  `taken` FROM `allFlats` WHERE `i` = ? and `j` = ?");
       		st1.setInt(1, j);
       		st1.setInt(2, i);
       		
       		
       		rs = st1.executeQuery(); 
       		
       		while (rs.next())
             {
       			taken= rs.getInt("taken");
             } st1.close();
             
 		}catch (SQLException e1) {
 			
 			System.out.println(e1.getMessage());
 		} 
    	
    	return taken; 
 	
    }
    
    
    
  
	
	
	
	
	
} 
