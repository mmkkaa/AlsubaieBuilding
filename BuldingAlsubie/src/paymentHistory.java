import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;




import javax.servlet.http.HttpServletResponse;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Header;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;






//import com.lowagie.text.pdf.PdfPTable;


public class paymentHistory {

	
	
	
	
	static  String[] columnNames = {  "Payment ID" , "Flat Number", "Tenant Name" , "Payment Method"
			                        , "Amount Paid" , "Date", "Officer"};
	
	static  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	static  LocalDateTime now = LocalDateTime.now();  
	 
	static String currentdate = dtf.format(now); 
	
	static HttpServletResponse response;
	static JTable table;
	static JFileChooser fc; 
	static JFrame frame; 
	
	//static HttpServletResponse response; 
	
	static public void view(final String s, final String username) { 
		
		
	    frame = new JFrame("Payment History"); 
	    frame.setSize(new Dimension(1100, 740));
	    frame.setBounds(200,50,1200,740);
	    frame.setLayout(null);
	    
	    JPanel panel1 = new JPanel();
	    panel1.setLayout(null);
	    panel1.setBorder(BorderFactory.createTitledBorder("Tenant Payment Details"));
	    panel1.setBounds(10, 10, 1100, 620);
	    
	    frame.setBackground(Color.gray);
	  //TableModel tm = new TableModel();
	  final DefaultTableModel model = new DefaultTableModel();
	  model.setColumnIdentifiers(columnNames);
	  //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames()); 
	  //table = new JTable(model);
	  table = new JTable();
	  table.setEnabled(true);
	  table.setModel(model); 
	  table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	  table.setFillsViewportHeight(true);
	  table.setBounds(10,10,1200,400); 
	  JScrollPane scroll = new JScrollPane(table);
	  scroll.setHorizontalScrollBarPolicy(
	  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	  scroll.setVerticalScrollBarPolicy(
	  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
	  
	  scroll.setBounds(20,20,1080,590);
	  
	  JButton back = new JButton("Back");
	  back.setBounds(200,650 , 150, 30);
	  
	  JButton addNew = new JButton("Add New");
	  addNew.setBounds(370,650 , 150, 30);
	  
	  JButton print = new JButton("Print"); 
	  print.setBounds(540 , 650 , 150 , 30);
	  
	  JButton delete = new JButton("Delete Payment"); 
	  delete.setBounds(710 , 650 , 150 , 30);
	  
	  JButton update = new JButton("Update"); 
	  update.setBounds(880, 650 , 150 ,30);
	  
	  
	  
	  String paymentID = ""; 
	  String flatNO= "";
	  String name="";
	  String pMethod = ""; 
	  String amount = ""; 
	  String date = ""; 
	  String officer = "";
	  
	  System.out.println("Connection starts.."); 
	  try {
	   
		  
		    ResultSet rs;
			
			Connection connection;
			
		
	  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");  
	  String sql = " select * from `paymentHistory` where `flatNo` = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, s); 
     
      rs = ps.executeQuery();
     
	  
	  while(rs.next())  {
		  
	  paymentID = rs.getString("paymentID"); 
	  flatNO = rs.getString("flatNo");
	  name = rs.getString("name");
	  pMethod = rs.getString("paymentMethod"); 
	  amount = rs.getString("Amount"); 
	  date = rs.getString("Date"); 
	  officer = rs.getString("officer");
	 
	  model.addRow(new Object[]{paymentID, flatNO, name, pMethod, amount, date,officer});
	  
	   
	  }
	  
	  
	  }
	  
	  
	catch(Exception ex)
	{

		  System.out.println("Connection falied.."); 
	JOptionPane.showMessageDialog(null,ex.getMessage(),"No Payments founded",
	JOptionPane.ERROR_MESSAGE);
	}
	  
	  
	  
	  //back clicked
		back.addActionListener(new ActionListener() {
			//close frame, open user menu
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		update.addActionListener(new ActionListener() {
			//close frame, open user menu
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.showConfirmDialog (null, 
	        			"Updating this row will update the data in your server"
	        			+ " do you want to proceed ?","WARNING",JOptionPane.YES_NO_OPTION);
				
				int viewRow = table.getSelectedRow();
				int viewCol = table.getSelectedColumn();
				int selectedRows = table.getSelectedRowCount(); 
				
		if (selectedRows != 0) {
			
			
	        	if(dialogButton == JOptionPane.YES_OPTION) {
	        		
	        	//update the table
	        		model.fireTableCellUpdated(viewRow, viewCol);
	        		
	        	// update in sql server
	        		String value0 = table.getModel().getValueAt(viewRow, 0).toString();
	        		String value1 = table.getModel().getValueAt(viewRow, 1).toString();
	        		String value2 = table.getModel().getValueAt(viewRow, 2).toString();
	        		String value3 = table.getModel().getValueAt(viewRow, 3).toString();
	        		String value4 = table.getModel().getValueAt(viewRow, 4).toString();
	        		String value5 = table.getModel().getValueAt(viewRow, 5).toString();
	        		String value6 = table.getModel().getValueAt(viewRow, 6).toString();
	        		
	        		updateRow(value0,value1, value2, value3, value4, value5,value6);
	        		
					
		            JOptionPane.showMessageDialog(null, "Row Updated");
		            
		            
	        	}
	        	
	        	else {
	        		
	        		JOptionPane.showMessageDialog(null, "Row is not updated");
	        		}
	        	
	          
	          	} else { 

	          		
	        		JOptionPane.showMessageDialog(null, "Please select a raw to update");
	          		
	          	}
				
			}
		});
	  
	  
		//back clicked
				addNew.addActionListener(new ActionListener() {
					//close frame, open user menu
					public void actionPerformed(ActionEvent e) {
						addElement(s, username); // add parameter to it
					    
					}
				});
				
				
				 
				
				delete.addActionListener(new ActionListener() {
					//close frame, open user menu
					public void actionPerformed(ActionEvent e) {
						
						
						
							int viewRow = table.getSelectedRow();
							int selectedRows = table.getSelectedRowCount(); 
							
							String value = table.getModel().getValueAt(viewRow, 0).toString();
						
							
							 //Check if their is a row selected
					        if (selectedRows != 0) {
					        	int dialogButton = JOptionPane.showConfirmDialog (null, 
					        			"Deleting this row will delete the data from your server"
					        			+ " and will not be recovered , do you want to proceed ?","WARNING",JOptionPane.YES_NO_OPTION);
					        	
					        	if(dialogButton == JOptionPane.YES_OPTION) {
					        		
					        	//delete from table
					        		model.removeRow(viewRow);
					        	// delete from sql server
						            deleteRow(value); 
						            
						            JOptionPane.showMessageDialog(null, "Row Deleted");
						            
						            
					        	}
					        	
					        	else {
					        		
					        		JOptionPane.showMessageDialog(null, "Row is not deleted");
					        		}
					        	
					          
					            
					        } else {
					            JOptionPane.showMessageDialog(null, "Please Select a Row");
					        }
						    

						   
						  
						}
						
					
				});
				
				
			
				 
				
				
				print.addActionListener(new ActionListener() {
					//close frame, open user menu
					public void actionPerformed(ActionEvent e) {

					   try {
						    	
						    	
						    	 int count = table.getRowCount(); 
						    	//special font sizes
						    	//   Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0)); 
							    
							  
						      //open a file for the table 
						      
						    	  
								   
							    	   
							   Document document = new Document();
							  
							 
						
							 
							   
							   
							   JPanel save = new JPanel(); 
						       save.setName("Save");
						       
						       JButton saveButton = new JButton("save"); 
						       
						       save.add(saveButton, BorderLayout.CENTER); 
				
						       
						       int returnVal = fc.showSaveDialog(frame); 
						       
						       fc = new JFileChooser(); 
							   fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF Document", "pdf")); 
							   fc.setAcceptAllFileFilterUsed(true); 
							   fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
							   fc.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
							   
							   
						       
						       if(returnVal == JFileChooser.APPROVE_OPTION) { 
						    	   
						    	   File file = fc.getSelectedFile(); 
						    	 //  FieldInformation
						    	  
						    //	   information.setText(fc.getSelectedFile().getAbsolutePath()); 
							    	
						    	   FileWriter fw = new FileWriter(file+"/paymentHistory.pdf");
						    	   
						    	 
						    	   System.out.println("Save as file: " + file.getAbsolutePath()); 
						    	   PdfWriter.getInstance(document,new FileOutputStream(file.getAbsolutePath()+"/paymentHistory.pdf"));
							       document.open();  
						    	  
						    	   
						    	   
								   com.itextpdf.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11);
								 
								   com.itextpdf.text.Font font1 = FontFactory.getFont(FontFactory.TIMES_ROMAN,9);
									 
									
								   com.itextpdf.text.Font font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN,12);
									 
								   com.itextpdf.text.Font fontHeader = FontFactory.getFont(FontFactory.COURIER,9, BaseColor.LIGHT_GRAY);
									
								   
							    //	PdfWriter.getInstance(document,new FileOutputStream("PaymentHistory.pdf"));
		                         
								// document.open();
								   
								   
								  
								  //adding features to the pdf file
								  
								  document.addAuthor("ALSUBAIE BULDING");
								  document.addCreationDate();
								  document.addProducer();
								  document.addCreator("MAJAN ALSUBAIE");
								  document.addTitle("Tenant Payment History");
								  document.setPageSize(PageSize.LETTER);
								   
							     
							      PdfPTable PDFtable = new PdfPTable(7);
							    

							      String s1 = "PaymentID"; 
							      PdfPCell header1 = new PdfPCell();
							      header1.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header1.setPhrase(new Phrase(s1, font)); 
							      PDFtable.addCell(header1);
						    	  
							      
							      String s2 = "Apartment"; 
							      PdfPCell header2 = new PdfPCell();
							      header2.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header2.setPhrase(new Phrase(s2,font)); 
							      PDFtable.addCell(header2);
						   

							      String s3 = "Name"; 
							      PdfPCell header3 = new PdfPCell();
							      header3.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header3.setPhrase(new Phrase(s3,font)); 
							      PDFtable.addCell(header3);
						   
					   
							      String s4 = "Payment Method"; 
							      PdfPCell header4 = new PdfPCell();
							      header4.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header4.setPhrase(new Phrase(s4,font)); 
							      PDFtable.addCell(header4);
						   
					   
							      String s5 = "Amount Paied"; 
							      PdfPCell header5= new PdfPCell();
							      header5.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header5.setPhrase(new Phrase(s5,font)); 
							      PDFtable.addCell(header5);
							      

							      String s6 = "Date"; 
							      PdfPCell header6 = new PdfPCell();
							      header6.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header6.setPhrase(new Phrase(s6,font)); 
							      PDFtable.addCell(header6);
							      
							      
							      String s7 = "Officer"; 
							      PdfPCell header7 = new PdfPCell();
							      header7.setBackgroundColor(BaseColor.LIGHT_GRAY); 
							      header7.setPhrase(new Phrase(s7,font)); 
							      PDFtable.addCell(header7);
						   
					   
							         PDFtable.setWidthPercentage(200); 
							         PDFtable.setTotalWidth(200);
							      
							       
							      
							   //   PDFtable.addCell("Payment ID"); 
							   //   PDFtable.addCell("Apartment"); 
							   //   PDFtable.addCell("Name");
							   //   PDFtable.addCell("Payment Method");
							   //   PDFtable.addCell("Amount Paied"); 
							   //   PDFtable.addCell("Date"); 
							      
							  
							      
							      for (int i =0; i< count; i++ ) { 
							    	  
							    	  
							    	  Object obj1 = GetData(table, i,0); 
							    	  Object obj2 = GetData(table, i,1);
							    	  Object obj3 = GetData(table, i,2);
							    	  Object obj4 = GetData(table, i,3);
							    	  Object obj5 = GetData(table, i,4);
							    	  Object obj6 = GetData(table, i,5);
							    	  Object obj7 = GetData(table, i,6);
							    	  
							    	  
							    	  String value1 = obj1.toString();  
							    	  String value2 = obj2.toString(); 
							    	  String value3 = obj3.toString(); 
							    	  String value4 = obj4.toString(); 
							    	  String value5 = obj5.toString(); 
							    	  String value6 = obj6.toString(); 
							    	  String value7 = obj7.toString();
							    	  
							    	
							    	  
							    	//  PdfCell cell1 = new PdfCell(new Phrase("name")); 
							    	//  cell1.setBorderColor(BaseColor.GRAY);

								      PdfPCell IDCell = new PdfPCell();
								    //  IDCell.setBackgroundColor(BaseColor.WHITe); 
								      IDCell.setPhrase(new Phrase(value1,font1)); 
								      
								      PdfPCell ApartmentCell = new PdfPCell();
								     // IDCell.setBackgroundColor(BaseColor.LIGHT_GRAY); 
								      ApartmentCell.setPhrase(new Phrase(value2,font1)); 
								      
								      PdfPCell NameCell = new PdfPCell();
								     // IDCell.setBackgroundColor(BaseColor.LIGHT_GRAY); 
								      NameCell.setPhrase(new Phrase(value3,font1)); 
								      
								      
								      PdfPCell MethodCell = new PdfPCell();
								    //  IDCell.setBackgroundColor(BaseColor.LIGHT_GRAY); 
								      MethodCell.setPhrase(new Phrase(value4,font1)); 
								      

								      PdfPCell amountPaid = new PdfPCell();
								      amountPaid.setBackgroundColor(BaseColor.GREEN); 
								      amountPaid.setPhrase(new Phrase(value5,font1)); 
								      amountPaid.setPaddingLeft(20);
								      amountPaid.setPaddingRight(20);
								      
								      
								      PdfPCell dateCell = new PdfPCell();
								      dateCell.setBackgroundColor(BaseColor.YELLOW); 
								      dateCell.setPhrase(new Phrase(value6,font1)); 
								      
								      
								      PdfPCell usernameCell = new PdfPCell();
								      usernameCell.setBackgroundColor(BaseColor.WHITE); 
								      usernameCell.setPhrase(new Phrase(value7,font1)); 
								      
						   
								      
								      
							    	  PDFtable.addCell(IDCell);
							    	  PDFtable.addCell(ApartmentCell);
							    	  PDFtable.addCell(NameCell);
							    	  PDFtable.addCell(MethodCell);
							    	  PDFtable.addCell(amountPaid);
							    	  PDFtable.addCell(dateCell);
							    	  PDFtable.addCell(usernameCell);
									
							    	 
							    	  
							      }
							      
							      
							      //add image first to the header 
							      
							     
							      String historyDate =  "Date: " + currentdate +"\r\n"+ "P.O Box : 444" + "\r\n" + "P.C : 114" + "\r\n"+ "Email: AlsubaieBuilding@gmail.com"; 
							      Paragraph historyDateP = new Paragraph(historyDate, FontFactory.getFont(FontFactory.COURIER , 9, Font.PLAIN , BaseColor.LIGHT_GRAY));
							      historyDateP.setPaddingTop(0);
							      historyDateP.setSpacingAfter(0);
							      historyDateP.setSpacingBefore(0);
							      historyDateP.setAlignment(Paragraph.HEADER);
							      Header hd = new Header("1" , "2");
							      
							      String companyName = "ALSUBAIE BUILDING" + "\r\n" + "Commercial and Residential Apartments "; 
							      Paragraph companyNameP = new Paragraph(companyName, FontFactory.getFont(FontFactory.TIMES , 13, Font.PLAIN , BaseColor.GRAY));
							      companyNameP.setPaddingTop(0);
							      companyNameP.setSpacingAfter(10);
							      companyNameP.setSpacingBefore(10);
							      companyNameP.setAlignment(Paragraph.ALIGN_CENTER);
							      companyNameP.setFirstLineIndent(10);	
							      
							      
							      String address = "188, Phase - 2 Ghala Heights," +"\r\n" + "Muscat, Sultante of Oman" + "\r\n" + "GSM : +96893331133 , +96896726372 ";
							      Paragraph addressP = new Paragraph(address, FontFactory.getFont(FontFactory.TIMES , 8, Font.PLAIN , BaseColor.LIGHT_GRAY));
							      addressP.setPaddingTop(0);
							      addressP.setSpacingAfter(3);
							      addressP.setSpacingBefore(3);
							      addressP.setAlignment(Paragraph.HEADER);
							      addressP.setAlignment(Paragraph.ALIGN_RIGHT);
							     
							      
							      Chunk glue1 = new Chunk(new VerticalPositionMark()); 
							      
								  
							      
							      Paragraph pHeader = new Paragraph(); 
							      pHeader.setFont(fontHeader);
							      
							      
							      pHeader.add("Date: " + currentdate); 
							      pHeader.add(glue1); 
							      pHeader.add("188, Phase - 2 Ghala Heights,"); 
							      
							      pHeader.add("\r\n"); 
							     
							      
							      pHeader.add("P.O Box : 444"); 
							      pHeader.add(glue1);
							      pHeader.add("Muscat, Sultante of Oman"); 
							      
							      pHeader.add("\r\n"); 
							  
							      
							      pHeader.add("P.C : 114"); 
							      pHeader.add(glue1);
							      pHeader.add("GSM : +96893331133 , +96896726372"); 
							      
							      pHeader.add("\r\n"); 
							     
							      
							      pHeader.add(""); 
							      pHeader.add(glue1);
							      pHeader.add("Email: AlsubaieBuilding@gmail.com"); 
							      
							      
							     
							      
							      
							      String Header = "Payment History Statement"; 
							      Paragraph HeaderP = new Paragraph(Header , FontFactory.getFont(FontFactory.TIMES_ROMAN , 15 , Font.BOLD , BaseColor.BLUE)); 
							      HeaderP.setPaddingTop(10);
							      HeaderP.setSpacingAfter(20);
							      HeaderP.setSpacingBefore(20);
							      HeaderP.setAlignment(Paragraph.ALIGN_CENTER);
							     
							      String breaker = "___________________________Tenant Details ______________________________"; 
							      Paragraph breakerP = new Paragraph(breaker, FontFactory.getFont(FontFactory.TIMES_ROMAN , 12 , Font.PLAIN , BaseColor.LIGHT_GRAY)); 
							      breakerP.setAlignment(Paragraph.ALIGN_CENTER);
							      breakerP.setSpacingAfter(10);
							      breakerP.setSpacingBefore(30);
							      
							      String Linebreaker = "_________________________________________________________"; 
							      Paragraph LinebreakerP = new Paragraph(Linebreaker, FontFactory.getFont(FontFactory.TIMES_ROMAN , 12 , Font.PLAIN , BaseColor.LIGHT_GRAY)); 
							      LinebreakerP .setAlignment(Paragraph.ALIGN_CENTER);
							      LinebreakerP .setSpacingAfter(10);
							      LinebreakerP .setSpacingBefore(50);
							      
							      String flatInfo1 = " Name: " + getInfo.getTenantName(s) + "\r\n" +
							    		             
							    		             " Flat Number: " + getInfo.getFlatNo(s) + "\r\n" +
							    
							    		             " Tenancy Starting Date: " + getInfo.getTenantStartDay(s)  +  "\r\n" 
							    		             ; 
							      
							      
							      String flatInfo2 = "Contact Number : " + getInfo.getTenantPhoneNo(s) +  "\r\n" + 
							    	                 " Flat Type: " + getInfo.getFlatType(s) +  "\r\n" + 
							    	                 " Tenancy Ending Date: " + getInfo.getTenantEndDay(s) +  "\r\n" ; 
							      
							      String footerInfo =  "Offcier Name: " + username + " |  ALSUBAIE BUILDING  |  GSM : +96893331133 , +96896726372 | " ;    
							      Paragraph footerInfoP = new Paragraph(footerInfo, FontFactory.getFont(FontFactory.COURIER  , 8, Font.PLAIN , BaseColor.LIGHT_GRAY));
							      footerInfoP.setSpacingBefore(10);
							      footerInfoP.setAlignment(Paragraph.ALIGN_BASELINE);
							      
							     //----------TRY THIS----------------
							      
							      
							     
							      
							      
							      Paragraph p = new Paragraph(); 
							      
							      p.setFont(font);
							      
							      p.add("\r\n"); 
							      p.add("Name: " + getInfo.getTenantName(s) ); 
							      p.add(glue1); 
							      p.add("Contact Number : " + getInfo.getTenantPhoneNo(s) );
							     
							      p.add("\r\n"); 
							      p.add("\r\n"); 
							    
							      p.add("Flat Number: " + getInfo.getFlatNo(s)); 
							      p.add(glue1); 
							      p.add("Flat Type: " + getInfo.getFlatType(s));
							      
							      
							      p.add("\r\n");  
							      p.add("\r\n"); 
							      
							      p.add("Tenancy Starting Date: " + getInfo.getTenantStartDay(s) ); 
							      p.add(glue1);
							      p.add("Tenancy Ending Date: " + getInfo.getTenantEndDay(s) ); 
							      
							      
							      /** + "\r\n" +
					    		             
					    		             " + "\r\n" +
					    
					    		             "  +  "\r\n" 
					    		             
					    		             
					    		             +  "\r\n" + 
					    	                 "  +  "\r\n" + 
					    	                 +  "\r\n"
					    	                 
					    	                 
					    		        
					    		         */ 
							      //---------------------------
							      
							      
							      
							      Paragraph flatInfoP1 = new Paragraph(flatInfo1, FontFactory.getFont(FontFactory.TIMES_ROMAN , 12 , Font.PLAIN , BaseColor.BLACK)); 
							      Paragraph flatInfoP2 = new Paragraph(flatInfo2 , FontFactory.getFont(FontFactory.TIMES_ROMAN , 12 , Font.PLAIN , BaseColor.BLACK)); 
								   
							   
							      
							     
							      flatInfoP1.setAlignment(Paragraph.ALIGN_LEFT);
							      flatInfoP2.setAlignment(Paragraph.ALIGN_RIGHT); 
							 
							      
							      Paragraph allinfo = new Paragraph(); 
							      
							      allinfo.add(flatInfoP1);
							      allinfo.add(flatInfoP2);
							      allinfo.setFont(font2);
							      allinfo.setAlignment(Paragraph.DIV);
							      
							      PDFtable.setSpacingBefore(10);
							      PDFtable.setTotalWidth(100);
							      PDFtable.setWidthPercentage(100);
							     
							    
							      document.add(hd); 
							     // document.add(historyDateP); 
							      document.add(companyNameP);
							      document.add(pHeader); 
							     // document.add(addressP);
							      document.add(HeaderP); 
							      document.add(breakerP); 
							      document.add(p);
							     // document.add(flatInfoP1);
							     // document.add(flatInfoP2);
							      document.add(LinebreakerP); 
							      document.add(PDFtable); 
							      document.add(LinebreakerP);
							      document.add(footerInfoP); 
							      
							      
							      
							      
						    	   fw.close();
							    	  
								   
						    	
						    	   
						       }
						       
						      
						 	  

					    	  
					    	  
						      
							  JOptionPane.showMessageDialog(null,"File was generated successfully !! Please Check Your File");
							  
							 
						     
							    
						     
					  	   //   response.setContentType("application/pdf");
								 
							  //write table in the file
					     	//	  PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
						    
						   //   PrintToTemplate(); 
								
							  document.close();
						  
						      } catch (Exception e1) {
						      System.err.println(e1.getMessage());
						    } 
						    
					  
					   
						  } 
					
				});
				
	
				
	panel1.add(scroll);
	frame.add(back);
	frame.add(addNew);
	frame.add(print); 
	frame.add(delete);
	frame.add(update);
	  
	    Container con  = frame.getContentPane();
	    con.add(panel1);
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
	
	

	/**
	static public void stamper() throws IOException { 

		 PdfReader pdfReader = new PdfReader("PaymentHistory.pdf"); 
	     PdfStamper pdfStamper;
	      
	      
		try {
			pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("/Users/majanalsubaie/Desktop/PaymentTamplate.pdf"));
			  
		      
		      for(int i=1; i<=pdfReader.getNumberOfPages(); i++) {
		   	   
		   	   PdfContentByte content = pdfStamper.getUnderContent(i);
		   	   //content.addImage(Image); 
		   	   
		      }
		      pdfStamper.close();
		      

			  
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
	
			e.printStackTrace();
		}
	    
	}

	  
	*/
	
	
	
	
	static public void addElement(String n, final String username) {
		

		Font font = new Font("Times New Roman", Font.PLAIN, 14); 
		
		 
		  //------------------------------------------------
	    final JFrame viewFrame = new JFrame("New Payment"); 
	    viewFrame.setBounds(200, 100,700, 350);
	    viewFrame.setIconImage(new ImageIcon("/images/107636964.png").getImage());
        
	    
	    
	    final JPanel tenantInfo = new JPanel();
	    tenantInfo.setLayout(null);
	    tenantInfo.setBorder(BorderFactory.createTitledBorder("Enter New Payment Details:"));
	   
	    String[] flatnum = { "--SELECT--", "Gallery A" , "Gallery B" , "Gallery C" , "Gallery D" ,
	             "Store 1" , "Store 2", "Store 3" ,
	             "Office 11" , "Office 12" , "Office 21", "Office 22",
	             "31" , "32"  , "33" , "34" ,
	             "41" , "42" , "43" , "44" ,
	             "51" , "52" , "53" , "54"
	           , "61" , "62" , "63" , "64" , 
	             "71" , "72" , "73" , "74",
	             "81" , "82" , "83" , "84",
	             "91" , "92"}; 


        @SuppressWarnings({ "unchecked", "rawtypes" })
		final JComboBox  flatno = new JComboBox(flatnum); 
        flatno.setEnabled(false);
        flatno.setSelectedItem(n); 
        

	    JLabel nameLB2 = new JLabel("Flat Number:"); 
	    nameLB2.setBounds(30 ,60 ,200,30);
	    tenantInfo.add(nameLB2);
	    nameLB2.setFont(font);
	    
	    
	    flatno .setBounds( 300, 60, 200, 30);
        tenantInfo.add(flatno );
        
		
	    JLabel idLB = new JLabel("Tenant Name:"); 
	    idLB.setBounds(30 , 90, 200, 30);
	    tenantInfo.add(idLB);
	    idLB.setFont(font);
	    
	    final JTextField  id = new JTextField (); 
        id.setBounds(300 , 90, 200, 30);
        tenantInfo.add(id);
        id.setFont(font);
        


        String[] methods = { "Checks" , "Bank Transfare" }; 
        JLabel pMethodLB = new JLabel("Payment Method:"); 
        pMethodLB.setBounds(30,120,200,30);
        @SuppressWarnings({ "rawtypes", "unchecked" })
		final   JComboBox pMethod = new JComboBox(methods); 
       // pMethod.setSelectedItem("--SELECT--"); 
        pMethod.setBounds(300,120,200,30);
        tenantInfo.add(pMethod);
        tenantInfo.add(pMethodLB); 
        pMethodLB.setFont(font);
        

        JLabel pAdvLB = new JLabel("Advanced Paid Amount:");
        pAdvLB.setBounds(30,150,200,30);
        final    JTextField pAdv = new JTextField ();
        
       
        pAdv.setBounds(300,150,200,30);
        tenantInfo.add(pAdvLB);
        tenantInfo.add(pAdv);
        pAdvLB.setFont(font);
        
        
        JButton back = new JButton("Back");
  	    back.setBounds(370,200 , 150, 30);
  	    
  	    tenantInfo.add(back);
  	    
  	   
  	    JButton confirm = new JButton("Confirm");
  	    confirm .setBounds(520,200 , 150, 30);
  	  
  	    tenantInfo.add(confirm); 
  	
      
  	       final JLabel lable = new JLabel(""); 
  	       lable.setForeground(Color.RED);
  	       
  	       
  	        pAdv.addKeyListener(new KeyAdapter() {
  	        	
  	        	    public void keyPressed(KeyEvent k) {
  	        	    	
  	        	    	
  	        	    	// Error for any delete and . 
  	        	    	
  	        	    	if (k.getKeyChar() >= '0' &&
  	        	    			k.getKeyChar() <= '9' || k.getKeyChar() == '.' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
  	        	    		
  	        	    		
  	        	    		pAdv.setEditable(true); 
  	        	    		lable.setText("");
  	        	    	} else { 
  	        	    		
  	        	    		pAdv.setEditable(false);
  	        	    		lable.setText(" * Enter only digits (1.000 - 250.000)");
  	        	    	}
  	        	    	
  	        	    }
  	        	
  	        });
  	        
  	        
  	        lable.setBounds(300,170,400,30);
  	        tenantInfo.add(lable); 
  	        
  	        
  	//back clicked
  			back.addActionListener(new ActionListener() {
  				//close frame, open user menu
  				public void actionPerformed(ActionEvent e) {
  					viewFrame.dispose();
  					
  					
  				}
  			});
  			

  			

  			
  	     confirm.addActionListener(new ActionListener() {
			//close frame, open user menu
			public void actionPerformed(ActionEvent e) {
				
				
				  try {
						
					  
					   if ( flatno.getSelectedItem().toString() == "--SELECT--" || id.getText().isEmpty() ||  
							   pMethod.getSelectedItem().toString().isEmpty() || pAdv.getText().isEmpty()  ) { 
						   
						   JOptionPane.showMessageDialog(null,"Please fill in all detailes");
						   
						   
					   } else { 
						  
					   
					   PreparedStatement st1;
					   Connection connection;
					   @SuppressWarnings("unused")
					int rs;
					   
					   
					   //should be generated by a method randomly 
					   
					  
			     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
			     		st1 = connection.prepareStatement("INSERT INTO paymentHistory(paymentID,flatNo,name,paymentMethod,Amount,date,officer)" + 
			     		"VALUES (?,?,?,?,?,?,?) ");
			     		
			     		st1.setString(1, getRandomID());
			     		st1.setString(2, flatno.getSelectedItem().toString());
			     		st1.setString(3, id.getText());
			     		st1.setString(4, pMethod.getSelectedItem().toString());
			     		st1.setString(5, pAdv.getText());
			     		st1.setString(6, currentdate);
			     	    st1.setString(7, username);
			     		
			     	 //1. send old records of old flat to archive 
				    	setInfo.sendToArchive(getRandomID(), flatno.getSelectedItem().toString(), id.getText(), pMethod.getSelectedItem().toString(), pAdv.getText(), currentdate, username);
			     		
				    	rs = st1.executeUpdate(); 
			     		JOptionPane.showMessageDialog(null,"New Payment Added");
			     		viewFrame.dispose();
					   } 
			           
					}catch (SQLException e1) { 
						
						System.out.println(e1.getMessage());
					}
				  
				  
			    
			}
		});
  	     
        
		 // set flow layout for the frame  
		Container con  = viewFrame.getContentPane();
		    
     		 
        con.add(tenantInfo, BorderLayout.CENTER);
		        
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
        
        
		
		
	}
	
	public static Object GetData(JTable table, int row_index, int col_index){
		return table.getModel().getValueAt(row_index, col_index);
		}
		   
	
	public static void deleteRow(String x) { 

		  try {
				
			  
			  
			   
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("DELETE FROM paymentHistory WHERE paymentID = ? ");
	     		
	     		
	     		
	     		st1.setString(1, x);
	     		
	     	
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  
		  
	}
	
	

	
	public static void updateRow(String x0 , String x1 , String x2 , String x3 , String x4, String x5 , String x6) { 

		  try {
				
			  
			  
			   
			   PreparedStatement st1;
			   Connection connection;
			   @SuppressWarnings("unused")
			int rs;
			   
			  
	         
	     		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alsubaieBuilding","root","Majan1957");
	     		st1 = connection.prepareStatement("UPDATE paymentHistory SET paymentID = ? , flatNo= ? , name = ? , "
	     				+ "paymentMethod = ? , Amount = ?, Date = ? , officer = ? WHERE  paymentID = ?");
	     		
	     		
	     		
	     		st1.setString(1, x0);
	     		st1.setString(2, x1);
	     		st1.setString(3, x2);
	     		st1.setString(4, x3);
	     		st1.setString(5, x4);
	     		st1.setString(6, x5);
	     		st1.setString(7, x6);
	     		st1.setString(8, x0);
	     	
	     		
	     		
	     		rs = st1.executeUpdate(); 
	     		 System.out.println("paymentHistory table has been updated succefully");
	 			
	           
			}catch (SQLException e1) { 
				
				System.out.println(e1.getMessage());
			}
		  
		  
	}
	
	
	
	
	 public static String getRandomID() {
			
		   
		   StringBuilder sb = new StringBuilder(); 
		   String candiChars = "QRCA1234567890";
		   
		   Random rm = new Random(); 
		   
		   
		   for (int i=0; i< 8 ; i++) {
			   
			   sb.append(candiChars.charAt(rm.nextInt(candiChars.length()))); 
			   
		   }
			   
			   		     
		   
		   return sb.toString(); 
		   
		   
	   }
	 
	 
	
}
