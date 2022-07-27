import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getInfo extends MainWindow {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			// Connection to the mySQL database
			static DatabaseConnection connect = new DatabaseConnection(
					"jdbc:mysql://localhost/alsubaieBuilding", "com.mysql.jdbc.Driver", "root",
					"Majan1957");
	  
	
	   
	   
	   static  public String getTenantName(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `name` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("name");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getTenantEmail(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			  
	         

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `email` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("email");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   
	   static  public String getTenantIDno(String flatNo) { 

	    	
	    	String name = null ;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			  

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `nationalID` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("nationalID");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	  
	   
	   static  public String getTenantPhoneNo(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `contactNum` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("contactNum");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getTenantStartDay(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			  
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `startDate` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("startDate");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   

	   static  public String getTenantEndDay(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			  
	         

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `endDate` FROM `Tenant2`  WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("endDate");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   

	     // only for database queries 
	   static  public String getTenantCIF() { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `CIF` FROM `Tenant2` WHERE `flatNo` = ? ");
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("CIF");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	  //------------------------------------ Payment Methods ----------------------------------------------
	 
	   
	   static  public String getPaymentPlan(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `paymentPlan` FROM `paymentInfo` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("paymentPlan");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   static  public String getPaymentMethod(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `paymentMethod` FROM `paymentInfo` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("paymentMethod");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   static  public String getPaymnetAdv(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `payAdv` FROM `paymentInfo` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("payAdv");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getPaymnetHistory(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `paymentType` FROM `flatsTable` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("paymentType");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   
	   
	   
	   // ------------------------- Floor Methods --------------------------------------------------------------
	   
	   static  public String getFloor(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `floor` FROM `flatsTable` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("floor");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getFlatType(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `type` FROM `flatsTable` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("type");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getFlatNo(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `flatNo` FROM `flatsTable` WHERE `flatNo` = ? ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("flatNo");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public String getBedroomsNo(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `bedroomsNo` FROM `flatsTable` WHERE `flatNo` = ?  ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("bedroomsNo");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   static  public String getspace(String flatNo) { 

	    	
	    	String name = null;
			
		  try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `space` FROM `Stores` WHERE `flatNo` = ?  ");
	     		st1.setString(1, flatNo); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			name= rs.getString("space");	
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return name;
		  
	  }
	   
	   
	   static  public int getNumofRaws() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from allFlats where taken = 0";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	      count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	     			
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   
	   

	   static  public int getNumofTakenFalts() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from allFlats where taken = 1";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	       count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   
	   


	   static  public int getNumofTakenOffices() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from Offices where name != null";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	       count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   


	   static  public int getNumofTakenStores() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from Stores where name != null";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	       count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   
	   

	   static  public int getNumofTakenGalleries() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from Galleries where name != null";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	       count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   
	   
	   static  public int getTakenNumber() { 

	    	int count = 0;
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			   
			 
	     		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select count(*) as count from allFlats where taken = 1";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	      count = rs.getInt(1);
	     		
	     		while (rs.next());
	           {
	     			count= rs.getInt("count");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  

		return count;
		  
	  }
	   
	   
	   static  public String getflatNumberString() { 

	    	String count = "";
	    	
		  try {
				
			   Statement stmt;
			   Connection connection;
			   ResultSet rs;
			 
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		 stmt = connection.createStatement();
	     		 //Query to get the number of rows in a table
	     	      String query = "select number from allFlats where taken = 1 ";
	     	      //Executing the query
	     	      rs = stmt.executeQuery(query);
	     	      //Retrieving the result
	     	      rs.next();
	     	     
	     		while (rs.next());
	           {
	     			count= rs.getString("number");	
	           } stmt.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}

		return count;
		  
	  }
	   
	   
	   
	   static public boolean checkID(String id) { 
		   
		  boolean unique = false; 
         
          String paymentid = "";
          
          try {
				
			   PreparedStatement st1;
			   Connection connection;
			   ResultSet rs;
			   
			 

	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("SELECT `paymentID` FROM `paymentHistory` WHERE `paymentID` = ? ");
	     		st1.setString(1, id); 
	     		rs = st1.executeQuery(); 
	     		
	     		while (rs.next())
	           {
	     			paymentid= rs.getString("paymentID");	
	     			
	     			if (paymentid=="") {
	     				unique = true; 
	     			} else {
	     				unique = false; 
	     			}
	     				
	     				
	           } st1.close();
	           
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  
          
          return unique; 
          
          
		   
	   }
	   
	   
	   
	  
	   
	   
   

}
