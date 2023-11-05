import java.util.*;
import java.sql.*;
public class seller {
	
    public static void show_details(String username) throws Exception{
		Scanner input = new Scanner(System.in);
 	    String url = "jdbc:mysql://localhost:3306/rems";
 	    String uname = "root";
 	    String pass = "Dhrushinadatha@1503";
 	    String query = "select * from personal_details where username = '"+username+"'";
 	    Class.forName("com.mysql.cj.jdbc.Driver");
 	    Connection con = DriverManager.getConnection(url, uname, pass);
 	    Statement st = con.createStatement();
 	    ResultSet rs = st.executeQuery(query);
		rs.next();
		String firstname = rs.getString(1);
		String lastname = rs.getString(2);
		String g = rs.getString(3);
		String dob = rs.getString(4);
		String phone_no = rs.getString(5);
		String mailid = rs.getString(6);
		System.out.println("firstname \t lastname \t gender \t date of birth \t phone_no \t   mailid ");
		System.out.printf("%s \t %8s \t %8s \t %8s \t %8s \t %s",firstname,lastname,g,dob,phone_no,mailid);	
	}
    
    
    public static void propertyRegistration(String username)throws Exception{
    	 Scanner input = new Scanner(System.in);
	     String url = "jdbc:mysql://localhost:3306/rems";
	     String uname = "root";
	     String pass = "Dhrushinadatha@1503";
	     Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection con = DriverManager.getConnection(url, uname, pass);
	     Statement st = con.createStatement();
	     System.out.println("Enter Owner name :");
	     String name =input.next();
	     System.out.println("Enter Area of Property in (sqft) :");
	     int area =input.nextInt();
	     System.out.println("Enter Price of Property :");
	     int price =input.nextInt();
	     System.out.println("Enter Location :");
	     String location = input.next();
	     System.out.println("Enter Other Details :");
	     String Other = input.next();
	     if(!name.equals("") && area != 0 && price != 0 && !location.equals("") && !Other.equals("")){
	            PreparedStatement pst = con.prepareStatement("insert into property(owner_name,location,area,price,OtherDetails,status,username) values('"+name+"','"+location+"','"+area+"','"+price+"','"+Other+"' ,'Not Available','"+username+"' );");
	            int result = pst.executeUpdate();
	            System.out.println("Property Registration  successfully");
	        }else{
	            System.out.println("Please check your credentials, some of them are invalid.");
	        }
	     }
    
    
    public static void sellProperty(String username) {
    	try {
    		Scanner input = new Scanner(System.in);
	   	     String url = "jdbc:mysql://localhost:3306/rems";
	   	     String uname = "root";
	   	     String pass = "Dhrushinadatha@1503";
	   	     Class.forName("com.mysql.cj.jdbc.Driver");
	   	     Connection con = DriverManager.getConnection(url, uname, pass);
	   	     Statement st = con.createStatement();
	   	     String q5678 = "select * from property where username = '"+username+"';"; 
//		   	 PreparedStatement pst = con.prepareStatement("select * from property where username = '"+username+"';");
//		   	 int result = pst.executeUpdate();
		   	 
//	         System.out.println(result);
//	         if(result == 1) {
	        	 ResultSet rs = st.executeQuery(q5678);
	        	 System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo ");
	 	  	     while( rs.next()) {
	 	  	    	int sno = rs.getInt(1);
	 	  		    String name = rs.getString(2);
	 	  		    String location = rs.getString(3);
	 	  		    int area = rs.getInt(4);
	 	  			int price = rs.getInt(5);
	 	  			String Others = rs.getString(6);
	 	  			String status = rs.getString(7);
	 				System.out.printf(" %d \t %8s \t %d sft \t %d \t %8s \t %8s \t %s\n",sno,name,area,price,location,Others,status);
	 	  	     }
	 	  	     System.out.println("Enter the sno of the property you want to sell :");
	 	  	     int sno = input.nextInt();
		 	  	     ResultSet rs1 = st.executeQuery("select * from property where sno = '"+sno+"'");
	      		 rs1.next();
	      		 String availability = rs1.getString(7);
	      		 String avai2 = null;
	      		 if(availability.equals("Available")) {
	      			System.out.println("The property you want to sell is already available for buyers.");
	      		 }else if(availability.equals("Booked")){
	      			System.out.println("The property you want to sell is already booked by a buyer.");
	      		 }else {
	      			 avai2 = "Available";
	      			 PreparedStatement pst3 = con.prepareStatement("update property set status = '"+avai2+"' where sno = "+sno);
		      		 int result2 = pst3.executeUpdate();
		      		 if(result2==1) {
		      			System.out.println("The property you want to sell is now available for buyers.");
		      		 }else{
		      			System.out.println("The property you want to sell is not available for buyers.");
		      		 }
	      		 }	 
//	         }else {
//		        	 System.out.println("No registered properties. ");
//		     }
    	}catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
}
