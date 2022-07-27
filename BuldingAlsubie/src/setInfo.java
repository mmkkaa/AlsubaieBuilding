
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class setInfo extends MainWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			// Connection to the mySQL database
			static DatabaseConnection connect = new DatabaseConnection(
					"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
					"Majan1957");
			
	
	   static  public void setTenantName( String name, String email, String contactNum, String nationalID , 
			                                String startDate, String endDate, String flatNo) { 

		  
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("INSERT INTO Tenant2(name,email,contactNum,nationalID,startDate,endDate,flatNo)" + 
	     		"VALUES (?,?,?,?,?,?,?) ");
	     		
	     		//st1.setLong(1, cif); 
	     		st1.setString(1, name);
	     		st1.setString(2, email);
	     		st1.setString(3, contactNum);
	     		st1.setString(4, nationalID);
	     		st1.setString(5, startDate);
	     		st1.setString(6, endDate);
	     		st1.setString(7, flatNo);
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		System.out.println("Inserted records into the table...");
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   
	   

	   static  public void setFlatDetails( String flatNo,String floor, String type, String bedroomsNo) { 

	    	
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("INSERT INTO flatsTable(flatNo,floor,type,bedroomsNo)" + 
	     		"VALUES (?,?,?,?) ");
	     		
	     		
	     		st1.setString(1, flatNo);
	     		st1.setString(2, floor);
	     		st1.setString(3, type);
	     		st1.setString(4, bedroomsNo);
	     	
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		System.out.println("Inserted records into the table...");
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   
	   static  public void setTaken( String flatNo) { 

	    	
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("UPDATE allFlats SET taken = ? WHERE  number = ?");
	     		
	     		
	     		st1.setInt(1,1);
	     		st1.setString(2, flatNo);
	     		
	     	
	     		rs = st1.executeUpdate(); 
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   
	   
	   

	   static  public void setNotTaken( String flatNo) { 

	    	
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("UPDATE allFlats SET taken = ? WHERE  number = ?");
	     		
	     		
	     		st1.setInt(1,0);
	     		st1.setString(2, flatNo);
	     		
	     	
	     		rs = st1.executeUpdate(); 
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   
	   
	   static  public void setPaymentDetails( String flatNo, String paymentPlan , String paymentMethod, String payAdv ) { 
		   
	    	
			  try {
					
				   PreparedStatement st1;
				   Connection connection;
				   @SuppressWarnings("unused")
				int rs;
				   
				  
		         
		     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
		     		st1 = connection.prepareStatement("INSERT INTO paymentInfo(flatNo,paymentPlan,paymentMethod,payAdv)" + 
		     		"VALUES (?,?,?,?) ");
		     		
		     		
		     		
		     
		     		st1.setString(1, flatNo);
		     		st1.setString(2, paymentPlan);
		     		st1.setString(3, paymentMethod);
		     		st1.setString(4, payAdv);
		     
		     	
		     		
		     	
		     		rs = st1.executeUpdate(); 
		     		
		     		System.out.println("Inserted records into the table...");
		     	
		           
				}catch (SQLException e1) { 
					
					System.out.println(e1.getMessage());
				}
			  

			  
		  }
	   

	   

	   static  public void sendToArchive(String paymentID, String flatNo, String name, String paymentMethod, String Amount, String Date, String officer) { 
		  
	    	
			  try {
					
				   PreparedStatement st1;
				   Connection connection;
				   @SuppressWarnings("unused")
				int rs;
				   
				  
		         
		     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
		     		st1 = connection.prepareStatement("INSERT INTO archive(paymentID,flatNo,name,paymentMethod,Amount,Date,officer) VALUES (?,?,?,?,?,?,?) ");
		     		
		   
		     		st1.setString(1, paymentID);
		     		st1.setString(2, flatNo);
		     		st1.setString(3, name);
		     		st1.setString(4, paymentMethod);
		     		st1.setString(5, Amount);
		     		st1.setString(6, Date);
		     		st1.setString(7, officer);
		     		
		     	
		     		rs = st1.executeUpdate(); 
		     		
		     		System.out.println("records where archived successfully...");
		     	
		           
				}catch (SQLException e1) { 
					
					System.out.println(e1.getMessage());
				}
			  

			  
		  }
	   
	   static  public void updateTenantName( String name, String email, String contactNum, String nationalID , 
			                                String startDate, String endDate, String flatNo) { 

		  
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("update Tenant2 set name = ?, email= ?, "
	     				+ "contactNum = ?, nationalID = ?,startDate = ?,endDate = ? where flatNo = ?" );
	     		
	     		//st1.setLong(1, cif); 
	     		st1.setString(1, name);
	     		st1.setString(2, email);
	     		st1.setString(3, contactNum);
	     		st1.setString(4, nationalID);
	     		st1.setString(5, startDate);
	     		st1.setString(6, endDate);
	     		st1.setString(7, flatNo);
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		System.out.println("Inserted records into the table...");
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   

	   static  public void updateTenantFlat( String flatNo , String ID) { 

	    	
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("UPDATE Tenant2 SET flatNo = ? WHERE  nationalID = ?");
	     		
	     		
	     		st1.setString(1,flatNo);
	     		st1.setString(2, ID);
	     		
	     	
	     		rs = st1.executeUpdate(); 
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   
	   
	   

	   static  public void updateFlatDetails(String bedroomsNo , String floor, String type, String flatNo ) { 

	    	
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("update flatsTable set bedroomsNo = ?  ,floor = ? ,type = ? WHERE flatNo = ?");
	     		
	     		st1.setString(1, bedroomsNo);
	     		st1.setString(2, floor);
	     		st1.setString(3, type);
	     		st1.setString(4, flatNo);
	     		
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		System.out.println("Inserted records into the table...");
	     		
	     	
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		  
	  }
	   

	   static  public void updatePaymentDetails( String payAdv, String paymentPlan , String paymentMethod,  String flatNo ) { 
		   
	    	
			  try {
					
				   PreparedStatement st1;
				   Connection connection;
				   @SuppressWarnings("unused")
				int rs;
				   
				  
		         
		     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
		     		st1 = connection.prepareStatement("update paymentInfo set payAdv = ?,paymentPlan = ? ,paymentMethod = ?"
		     				+ "where flatNo = ? " );
		     		
		     		
		     		st1.setString(1, payAdv);
		     		st1.setString(2, paymentPlan);
		     		st1.setString(3, paymentMethod);
		     		st1.setString(4, flatNo);
		     	
		     		
		     		
		     		rs = st1.executeUpdate(); 
		     		
		     		System.out.println("Inserted records into the table...");
		     	
		           
				}catch (SQLException e1) { 
					
					System.out.println(e1.getMessage());
				}
			 
		  }
	   
	   
}
	   