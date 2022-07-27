import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class MainWindow extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

				// Connection to the mySQL database
				static DatabaseConnection connect = new DatabaseConnection(
						"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
						"Majan1957");
				
				static ViewTenantInfo info; 
				static TenantRegister tr; 
				static int attempts = 0; 
				static JTextField emailTxt = new JTextField(); 
				
				static ImageIcon[] buttonimages = new ImageIcon[3];
				
		// static ArrayList<Integer> ids = new ArrayList<Integer>();

		public static void main(String[] args) throws SQLException, InterruptedException {
			
			try {
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				
				
			}
			catch (Exception e) {
				e.printStackTrace ();
			}
		
		//opens main menu, determines whether user is regular user or admin
		     mainMenu();
		
		
		}
		
		public static void mainMenu() throws InterruptedException{
		
			
			final JPanel panel1 = new JPanel();
			
			final JPanel containPanel = new JPanel(); 
			containPanel.setBounds(0,0,1400,1000);
			
			JButton start = new JButton("Start"); 
			start .setFont(new Font("Times New Roman", Font.BOLD,16));
			start.setBounds(660,460,100,40);
			
			
			JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
			rights.setBounds(550,600,600,20);
			rights.setFont(new Font("Calibri", Font.PLAIN,13));
			rights.setForeground(Color.WHITE)	;
			
			JLabel Name = new JLabel("ALSUBAIE BUILDING"); 
			Name.setBounds(400, 200,1000,60);
			Name.setFont(new Font("Times New Roman", Font.BOLD,60));
			Name.setForeground(Color.WHITE);
			
			JLabel hello = new JLabel("Press start to launch the system"); 
			hello.setBounds(570,350,500,30);
			hello.setFont(new Font("Times New Roman", Font.BOLD,20));
			hello.setForeground(Color.LIGHT_GRAY);
			
			panel1.setBorder(BorderFactory.createTitledBorder(""));
			panel1.setBounds(600,400,700,700);
			
			containPanel.setLayout(new OverlayLayout(containPanel));

			 
		    panel1.setLayout(null);
			panel1.add(Name) ; 
			panel1.add(hello );
			panel1.add(start ); 
			panel1.add(rights );
			
		    panel1.setOpaque( false );
		    
		    containPanel.add(panel1);
		   
			SwingUtilities.invokeLater(new Runnable(){
		            public void run() {
		            	URL url = MainWindow.class.getResource("/images/mainBack.png");
		    	        ImageIcon icon = new ImageIcon(url);
		    			JLabel background = new JLabel(icon); 
	                    background.setBounds(0, 0, 1400, 1000);
	                    
	                    containPanel.add(background); 
		    			
		            }
		        });
			   
			  
		  //frame declaration, initialization
			final JFrame frame = new JFrame();
	        frame.setTitle("Alsubaie Building");
	        frame.setBounds(150,50,1400,1000);
	        frame.setLocationRelativeTo(null);
	       
	        start.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					adminMenu();
				//	Options();
					frame.dispose();
				
				}
	     		
	     	});
	     
	        frame.setLocationByPlatform(true);
	        frame.setLayout(null);
			//create container               
					Container con = frame.getContentPane();
					
					con.add(containPanel); 
					
					
					 //Ask for window decorations provided by the look and feel.
				     JFrame.setDefaultLookAndFeelDecorated(true);
				     
				     SwingUtilities.invokeLater(new Runnable(){
				            public void run() {
				            	
				            	URL url = MainWindow.class.getResource("/images/107636964.png");
				    	        ImageIcon icon = new ImageIcon(url);
				    	         
				    			  frame.setIconImage(icon.getImage());
				    			
				            }
				        });
					
					
					frame.setVisible(true);
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
					
					 
/**
				    Thread t = new Thread() {
				        public void run() {
				            synchronized(lock) {
				                while (frame.isVisible())
				                    try {
				                        lock.wait();
				                    } catch (InterruptedException e) {
				                        e.printStackTrace();
				                    }
				                System.out.println("Working now");
				            }
				        }
				    };
				    
				    
				    t.start();

				    frame.addWindowListener(new WindowAdapter() {

				        @Override
				        public void windowClosing(WindowEvent arg0) {
				            synchronized (lock) {
				                frame.setVisible(false);
				                lock.notify();
				            }
				        }

				    });

				    t.join();
				*/
		} 
		
		
		public static void adminMenu(){
			
			final JPanel containPanel = new JPanel(); 
			containPanel.setBounds(0,0,1400,1000);

			containPanel.setLayout(new OverlayLayout(containPanel));

			 
			
				final JPanel panel1 = new JPanel();
				panel1.setBorder(new EmptyBorder(5,5,5,5));
				panel1.setLayout(null); 
				
				JLabel signIn = new JLabel(" SIGN IN"); 
				signIn.setBounds(900,200,500,30);
				signIn.setFont(new Font("Times New Roman", Font.BOLD,30));
				signIn.setForeground(Color.LIGHT_GRAY);
				panel1.add(signIn); 
				
				JLabel label1 = new JLabel("Please verify your account to access to the system's data");
				label1.setFont(new Font("Times New Roman", Font.PLAIN,16));
				label1.setBounds(780,280,500,20);
				label1.setForeground(Color.white);
				panel1.add(label1);
				
				
				final JTextField usernameTxt = new JTextField(14);
				usernameTxt.setBounds(850,350,300,30);
				panel1.add(usernameTxt);
				usernameTxt.setColumns(10);
				
				
				final JPasswordField passwordTxt = new JPasswordField(14);
				
				
				passwordTxt.setBounds(850,430,300,30);
				panel1.add(passwordTxt);
				passwordTxt.setColumns(10);
				
				JLabel usernameLB = new JLabel("Username:");
				usernameLB .setFont(new Font("Times New Roman", Font.BOLD,16));
				usernameLB.setBounds(730,360,200,19);
				usernameLB.setForeground(Color.white);
				panel1.add(usernameLB); 
				
				
				JLabel passwordLB = new JLabel("Password:");
				passwordLB .setFont(new Font("Times New Roman", Font.BOLD,16));
				passwordLB.setBounds(730,440,200,14);
				passwordLB.setForeground(Color.white);
				panel1.add(passwordLB); 
				

				//Verify button declaration
				final JButton verify = new JButton("Verify");
				 verify .setFont(new Font("Times New Roman", Font.BOLD,14));
				verify.setBounds(870,520,89,30);
				  //add components to panel
				panel1.add(verify);
					
			    //Back button declaration
				 JButton back = new JButton("Back");
				 back.setFont(new Font("Times New Roman", Font.BOLD,14));
				 back.setBounds(970,520,89,30);
				//add components to panel
				 panel1.add(back);
				 
				 panel1.setOpaque( false );
				    
				 containPanel.add(panel1);
				   
				
				  SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/hidden.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    			
			    			  //Back button declaration
							 final JButton showpassButton = new JButton(icon);
							
							 showpassButton.setContentAreaFilled(false);
							 showpassButton.setBounds(870,480,15,15);
							 showpassButton.setBorderPainted(false);
							 showpassButton.setOpaque(false);
							 
							 JLabel showpss = new JLabel("show my passowrd.");
							 showpss.setForeground(Color.white);
							 showpss.setFont(new Font("Times New Roman", Font.BOLD,14));
							 showpss .setBounds(900,470,150,30);
							//add components to panel
							 panel1.add(showpassButton);
							 panel1.add(showpss);
							 
								showpassButton.getModel().addChangeListener(new ChangeListener() {
						              @Override
						                public void stateChanged(ChangeEvent e) {
						                    ButtonModel model = showpassButton.getModel();
						                    if (model.isArmed()) {
						                    	passwordTxt.setEchoChar((char)0);
						                    } else {
						                    	passwordTxt.setEchoChar('*');
						                    }
						                }

						            });

			            }
			            
			            
			        });
				  
				
				
				

					//frame declaration, initialization
					final JFrame frame1 = new JFrame();
			        frame1.setTitle("Admin Verification");
			        frame1.setBounds(150, 50, 1400, 1000);
			   
					  
					
					 //back clicked
					back.addActionListener(new ActionListener() {
						//close frame, open user menu
						public void actionPerformed(ActionEvent e) {
							frame1.dispose();
							//stop running to refresh the system...
							try {
								mainMenu();
							} catch (InterruptedException e1) {
								
								e1.printStackTrace();
							}
						}
					});
					
					
					
					
					
					
					
					class verify implements ActionListener {

						
						public void actionPerformed(ActionEvent e) {
							
				
						ResultSet rs;
						PreparedStatement st;
						Connection connection;
						
							
							
							//get value of text fields
							String username = usernameTxt.getText().trim(); 
							String password1 =String.valueOf(passwordTxt.getPassword());
						
							
							try { 
								

					     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");  
								st = connection.prepareStatement("SELECT `username` , `password` FROM `admin` WHERE `username` = ? AND `password` = ?");
							    st.setString(1, username);
							    st.setString(2, password1);
							    rs = st.executeQuery(); 
							    
							    if(rs.next()) { 
							    	
							    	JOptionPane.showMessageDialog(null,"Login Success, Welcome");
							    	frame1.dispose();
							    	Options(username);
							    	
							    } else { 
							    	
							    	JOptionPane.showMessageDialog(null, "Login Failed");
							    	attempts++;
							    }
									
								
							} catch (SQLException e1) {
							
							e1.printStackTrace();
						}
							

							 if (attempts ==3) {
								 
								 
								 frame1.setBounds(20, 50, 1400, 1000);
								   
							    	JLabel error = new JLabel("You have exceeded the maximum login attempts. "
							    			+ "Please verify your email address :"); 	
							    	
							    	final JButton verifyEmail = new JButton("Verify Email"); 
							    	verifyEmail.setBounds(1100,600,100,30);
							    	
							    	emailTxt.setBounds(710,600,300,30);
							    	error.setBounds(710,530,700,100);
							    	error.setFont( new Font("Serif", Font.PLAIN, 14));
							    	error.setForeground(Color.RED);
							    	panel1.add(error); 
							    	panel1.add(emailTxt);
							    	panel1.add(verifyEmail); 
							    	verify.setEnabled(false);
							    	
							    	
							    	verifyEmail.addActionListener(new ActionListener(){
										public void actionPerformed(ActionEvent e)
										{
											ResultSet rs;
											PreparedStatement st;
											Connection connection;
											
											String email = emailTxt.getText();

											try { 
												

									     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");  
												st = connection.prepareStatement("SELECT `email`  FROM `admin` WHERE `email` = ? ");
											    st.setString(1, email);
											    
											    rs = st.executeQuery(); 
											    
											    if(rs.next()) { 
											    	
											    	SendEmail.sendEmail();
													JLabel sent = new JLabel("The Username and Password has been sent to your email,"
															+ " please check your mailbox and try again."); 
													
													sent.setBounds(40,200,700,100);
													sent.setFont( new Font("Serif", Font.BOLD, 12));
													panel1.add(sent); 
												
													verify.setEnabled(true);
													verifyEmail.setEnabled(false);
													JOptionPane.showMessageDialog(null,"Username and Password sent to your email address");
											    	//move to next window 
											    	
											    } else { 
											    	
											    	JOptionPane.showMessageDialog(null,"Email address is not valid");
											    }
													
												
											} catch (SQLException e1) {
											
											e1.printStackTrace();
										}
											
											
										}
									});	
							    }	
				    	} 
					} 
					
				
				
				
					
				verify.addActionListener(new verify());
				
				  
				  SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	URL url = MainWindow.class.getResource("/images/New Project.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    			JLabel background = new JLabel(icon); 
		                    background.setBounds(20, 20, 1200, 600);
		                    
		                    containPanel.add(background); 
			    			
			            }
			        });
				  
				 
					
					
					
				  SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	URL url = MainWindow.class.getResource("/images/mainBack.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    			JLabel background = new JLabel(icon); 
		                    background.setBounds(0, 0, 1400, 1000);
		                    
		                    containPanel.add(background); 
			    			
			            }
			        });
				  
					
					JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
					
					
					rights.setFont(new Font("Calibri", Font.PLAIN,10));
					rights.setForeground(Color.BLACK);
					
					JPanel rightsPanel = new JPanel();
					rightsPanel.add(rights);
					
					
					
				//create container               
				Container con = frame1.getContentPane();
				
				
				con.add(containPanel);
				con.add(rightsPanel, BorderLayout.SOUTH);
				
				frame1.setVisible(true);
				
				
				 SwingUtilities.invokeLater(new Runnable(){
			            public void run() {
			            	
			            	URL url = MainWindow.class.getResource("/images/107636964.png");
			    	        ImageIcon icon = new ImageIcon(url);
			    	         
			    			  frame1.setIconImage(icon.getImage());
			    			
			            }
			        });
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
				
				
			}
		
		

			
		public static void Options(final String username){
			
			final JLabel dashboard = new JLabel("Dashboard"); 
			dashboard.setFont(new Font("Times New Roman", Font.BOLD,13));
			
	        final JLabel logout = new JLabel("Sign Out"); 
	        logout.setFont(new Font("Times New Roman", Font.BOLD,13));
	        
	        final JLabel terminate = new JLabel("Terminate Tenancy"); 
	        terminate.setFont(new Font("Times New Roman", Font.BOLD,13));
	        
	        
			JLabel label1 = new JLabel(" Commercial and Residential Apartments at Ghala Heights, Muscat, Sultante of Oman.\n"
					                             + " \n Location: 188, Phase - 2 , Bushar, Ghala Heights.");
			
			 label1 .setFont(new Font("Times New Roman", Font.BOLD,16));
			 label1.setForeground(Color.WHITE);
		
			label1.setBounds(590,500,2000,20);
			
			
			JLabel rights = new JLabel("| © Copyright Majan 2021. All Rights Reserved."); 
			
			
			rights.setFont(new Font("Calibri", Font.PLAIN,10));
			rights.setForeground(Color.BLACK);
			
			JPanel rightsPanel = new JPanel();
			rightsPanel.add(rights);
			
			JLabel Name = new JLabel("ALSUBAIE BUILDING"); 
			Name.setBounds(400, 200,1000,60);
			Name.setFont(new Font("Times New Roman", Font.BOLD,60));
			Name.setForeground(Color.BLACK);
		
			
		  //frame declaration, initialization
			final JFrame frame = new JFrame();
	        frame.setTitle("Alsubaie Building");
	       // frame.setLayout(null);

	        final JPanel homePage = new JPanel(); 
	        homePage .setBorder(BorderFactory.createTitledBorder(""));
	        
	        final JPanel statPanel = new JPanel();
	        statPanel .setBorder(BorderFactory.createTitledBorder(""));
	        
	        statPanel.setBounds(20,630, 630,130);
	        statPanel.setOpaque( false );
	        statPanel.setBackground( new Color(0, 0, 0, 200) );
	        statPanel.setLayout(null);
		      
	        
	        final JPanel containerPanel = new JPanel(); 
	        containerPanel.setBounds(0,0,1400,1000);
	        containerPanel.setLayout(null);
	    	containerPanel.setLayout(new OverlayLayout(containerPanel));

			
	    
	        final  JPanel buttonPanel = new JPanel();
	        buttonPanel .setBorder(BorderFactory.createTitledBorder("Building Facilities "));
	        
	        buttonPanel.setLayout(new GridLayout(4,1));
	        

	         homePage.setOpaque( false );
	         homePage.setBounds(20,20,1350,190);
			 buttonPanel.setOpaque(false); 
			 buttonPanel.setBounds(670,220,700,500);
			
	        homePage.add(Name); 
	        homePage.add(label1); 
	        
	      
	        
			final JButton[][] buttons = new JButton[2][2]; //Declared much earlier in the program, right after the class declaration.
	       
	       final  String[] label = {"View Apartments", "View Offices", "View Stores", "View Galleries"  };

	       final JPanel buttonPanel2 = new JPanel();
	       buttonPanel2.setBounds(20,220,630,400);
	       buttonPanel2.setOpaque(false);
	         
	        SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	           
	        JButton TR = new JButton(""); 
	        TR .setFont(new Font("Times New Roman", Font.BOLD,14));
	       
	        URL url = MainWindow.class.getResource("/images/register.png");
	        ImageIcon icon2 = new ImageIcon(url);
	        TR.setIcon(icon2);
	        
	        
	        JButton UP = new JButton(""); 
	        UP .setFont(new Font("Times New Roman", Font.BOLD,14));
	       
	        URL url2 = MainWindow.class.getResource("/images/update.png");
	        ImageIcon icon3 = new ImageIcon(url2);
	        UP.setIcon(icon3);
	        
	        
	        
	        //------------------Statistics Panel -----------------//
	        
	        final URL url3 = MainWindow.class.getResource("/images/Mall statistics (4).png");
	        final ImageIcon iconS = new ImageIcon(url3);			
	        final URL url4 = MainWindow.class.getResource("/images/Mall statistics.png");
	        final ImageIcon iconS2 = new ImageIcon(url4);


	        

	        final URL url5 = MainWindow.class.getResource("/images/teminateNotSelected (1).png");
	        final ImageIcon icon5 = new ImageIcon(url5);			
	        final URL url6 = MainWindow.class.getResource("/images/terminateSelected (1).png");
	        final ImageIcon icon6 = new ImageIcon(url6);
			
	        
	        
	        final URL url7 = MainWindow.class.getResource("/images/logoutNotSelected.png");
	        final ImageIcon icon7 = new ImageIcon(url7);			
	        final URL url8 = MainWindow.class.getResource("/images/logoutSelected.png");
	        final ImageIcon icon8 = new ImageIcon(url8);
			
	        
	        
	        
			final JButton statButton = new JButton(); 
			statButton .setContentAreaFilled(false);
			statButton .setBorderPainted(false);
			statButton .setOpaque(false);
			statButton.setBounds(250,5,100,100);
			statButton.setIcon(iconS);
			
			statButton.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	            	statButton.setIcon(iconS2); 
	            }

	            public void mouseExited(MouseEvent evt) {
	            	statButton.setIcon(iconS);
	            }
	        });
		
			
			dashboard.setBounds(270,75,80,80);
			dashboard.setForeground(Color.white);
			
			
			
			final JButton terminateButton = new JButton(); 
			terminateButton .setContentAreaFilled(false);
			terminateButton .setBorderPainted(false);
			terminateButton .setOpaque(false);
			terminateButton.setBounds(420,5,100,100);
			terminateButton.setIcon(icon5);

			terminate.setBounds(420,75,140,80);
			terminate.setForeground(Color.white);
			
			terminateButton.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	            	terminateButton.setIcon(icon6); 
	            }

	            public void mouseExited(MouseEvent evt) {
	            	terminateButton.setIcon(icon5);
	            }
	        });
			
			
			
			
			
			
			final JButton logoutButton = new JButton(); 
			logoutButton  .setContentAreaFilled(false);
			logoutButton  .setBorderPainted(false);
			logoutButton  .setOpaque(false);
			logoutButton .setBounds(70,5,100,100);
			logoutButton .setIcon(icon7);

			logout.setBounds(100,75,80,80);
			logout.setForeground(Color.white);
			

			logoutButton.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent evt) {
	            	logoutButton.setIcon(icon8); 
	            }

	            public void mouseExited(MouseEvent evt) {
	            	logoutButton.setIcon(icon7);
	            }
	            
	        });
			
		
			
			statPanel.add(terminateButton);
			statPanel.add(logoutButton);
			statPanel.add(statButton);
			statPanel.add(dashboard);
			statPanel.add(logout);
			statPanel.add(terminate);
			
			
			
			statButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							
						
								Statistics.start(username);
									
								frame.dispose();
						
						    }	
						}); 
			
			terminateButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
				
						termination.start(username);
							
						frame.dispose();
				
				    }	
				}); 
			
			
			
			logoutButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
				
					//	termination.start();
						
						frame.dispose();
						
					
				
				    }	
				}); 
		        
			
	        int j = 0;
			int r; 
			int c;
			
			
			    for( r = 0 ; r < 2; r++)
			    {
			    	
			        for(c = 0 ; c < 2; c++)
			        {
			        	
			        	buttons[r][c] = new JButton();
			        	
			        	buttons[r][c] .setFont(new Font("Times New Roman", Font.BOLD,20));
			        	buttons[r][c].setText(label[j]);
			        	buttons[r][c].setContentAreaFilled(true);
			        	buttons[r][c].setBorderPainted(true);
			        	buttons[r][c].setOpaque(true);
			        	buttonPanel.add(buttons[r][c]);
			          
			            j++;
	   
			        }
			    }
			    
		     
	        	
	       buttons[0][0].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
				
						ViewTenantInfo.enterNo(username);
						frame.dispose();
					
	     		
				}	}); 
	       
	       
	      buttons[0][1].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
				     Offices.view(username);
				}
	     		
	     	});
	       
	       
	    
	     
	       buttons[1][0].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Stores.view(username);
				
				}
	     		
	     	});
	     
	       
	       //Galleries 
	       buttons[1][1].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					Galleries.view(username);
				
				}
	     		
	     	});
	       
	    
	       TR.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					TenantRegister.Viewregister(username);
					frame.dispose();
				
				}
	     		
	     	});
	       
	       
	       UP.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					UpdateTenant.enterNo(username);
					frame.dispose();

				}
	     		
	     	});
	       

           JLabel info2 = new JLabel(" Click on button to choose a service ");
           JLabel info3 = new JLabel(" register a new tenant / update tenant information. ");
           JLabel TRText = new JLabel("Tenant Registeration"); 
           JLabel UPText = new JLabel("Update Tenant Info"); 
           
	       buttonPanel2 .setBorder(BorderFactory.createTitledBorder(" Customer Services "));
	       buttonPanel2.setLayout(null);
	       
	       info2.setBounds(150,50,500,20);
	       info3.setBounds(100,80,500,20);
	       
	       info2.setFont(new Font("Times New Roman", Font.PLAIN,20));
	       info3.setFont(new Font("Times New Roman", Font.PLAIN,20));
	       info2.setForeground(Color.white);
	       info3.setForeground(Color.white);
	       
	       TR.setBounds(150,150,130,120);
	       TRText.setBounds(135,300,200,20);
	       
	       UP.setBounds(340,150,130,120);
	       UPText.setBounds(327,300,200,20);
	       
	       UPText.setFont(new Font("Times New Roman", Font.BOLD,17));
	       TRText.setFont(new Font("Times New Roman", Font.BOLD,17));
	       TRText.setForeground(Color.WHITE);
	       UPText.setForeground(Color.WHITE);
	       
	       
	       buttonPanel2.add(info2); 
	       buttonPanel2.add(info3); 
	       buttonPanel2.add(TR); 
	       buttonPanel2.add(TRText); 
	       buttonPanel2.add(UP); 
	       buttonPanel2.add(UPText); 
	      
	       buttonPanel2.setBackground( new Color(0, 0, 0, 200) );
	       homePage.setBackground( new Color(0, 0, 0, 50) );
	       buttonPanel.setBackground( new Color(0, 0, 0, 200) );
	         
	      
			
	            }
	        });
			
	        
	        
			
	        
			 SwingUtilities.invokeLater(new Runnable(){
		            public void run() {
		            	
		            	URL url = MainWindow.class.getResource("/images/szYvJB.png");
		    	        ImageIcon icon = new ImageIcon(url);
		    			JLabel background = new JLabel(icon); 
		    			background.setBounds(0, -10, 1400, 900);
		                    
		    			containerPanel.add(background);
		    			
		    			
		            }
		        });
			
			 
			 
	       //create container        
	                frame.setBounds(150, 100,1400,1000);
	       
					final Container con = frame.getContentPane();
					con.add(homePage); 
					con.add(buttonPanel); 
					con.add(statPanel);
					con.add(buttonPanel2); 
					
					con.add(rightsPanel, BorderLayout.SOUTH);
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
		
		

		  public static String getEmail() {
			
				String email1 = null;
				ResultSet rs;
				PreparedStatement st;
				Connection connection;
				String email = emailTxt.getText().trim(); 
				
				try { 
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");    
					st = connection.prepareStatement("SELECT `email` FROM `admin` WHERE `email` = ? ");
				    st.setString(1, email);
				   
				    rs = st.executeQuery(); 
				   
				    if(rs.next()) { 
				    	email1 = rs.getString("email");
				    	
				    }st.close();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			
			return email1;
		}
		  
		  

		  public static String getPassword() {
				
				String email1 = null;
				ResultSet rs;
				PreparedStatement st;
				Connection connection;
				String email = emailTxt.getText().trim(); 
				
				try { 
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");    
					st = connection.prepareStatement("SELECT `password` FROM `admin` WHERE  `email` =? ");
				    st.setString(1, email);
				   
				    rs = st.executeQuery(); 
				   
				    if(rs.next()) { 
				    	email1 = rs.getString("password");
				    	
				    } st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			
			return email1;
		    }

		  public static String getUsername() {
				
				String email1 = null;
				ResultSet rs;
				PreparedStatement st;
				Connection connection;
				String email = emailTxt.getText().trim(); 
				
				try { 
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");    
					st = connection.prepareStatement("SELECT `username` FROM `admin` WHERE `email` = ? ");
				    st.setString(1, email);
				   
				    rs = st.executeQuery(); 
				   
				    if(rs.next()) { 
				    	email1 = rs.getString("username");
				    	
				    }st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			
			return email1;
		}
		  
		  
		  public static String getAdminName() {
				
				String email1 = null;
				ResultSet rs;
				PreparedStatement st;
				Connection connection;
				String email = emailTxt.getText().trim(); 
				
				try { 
					
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");    
					st = connection.prepareStatement("SELECT `name` FROM `admin` WHERE `email` = ? ");
				    st.setString(1, email);
				   
				    rs = st.executeQuery(); 
				   
				    if(rs.next()) { 
				    	email1 = rs.getString("name");
				    	
				    }st.close();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			
			return email1;
		}

		 }
		  



