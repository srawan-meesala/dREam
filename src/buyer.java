import java.util.*;
import java.sql.*;
public class buyer implements property {
	
	static Scanner input = new Scanner(System.in);
	
	
    public static void listProperties(){
		try {
			
	 	    String url = "jdbc:mysql://localhost:3306/rems";
	 	    String uname = "root";
	 	    String pass = "Dhrushinadatha@1503";
	 	    String query = "select * from property where status = 'Available';";
	 	    Class.forName("com.mysql.cj.jdbc.Driver");
	 	    Connection con = DriverManager.getConnection(url, uname, pass);
	 	    Statement st = con.createStatement();
	 	    ResultSet rs = st.executeQuery(query);
	 	    System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo ");
			while(rs.next()) {
				int sno = rs.getInt(1);
				String name = rs.getString(2);
				int area = rs.getInt(4);
				int price = rs.getInt(5);
				String location = rs.getString(3);
				String Others = rs.getNString(6);
				System.out.println( ""+sno+"  \t   " +name + "  \t  " +area + "  \t  " +price + " \t "+location +"   \t   "+Others);
			}
		}
		catch(Exception e) {
			System.out.println("No properties available");
		}
	}
	
	
    public static void sort_by_price() {
		try {
			
	  	    String url = "jdbc:mysql://localhost:3306/rems";
	  	    String uname = "root";
	  	    String pass = "Dhrushinadatha@1503";
	  	    Class.forName("com.mysql.cj.jdbc.Driver");
	  	    Connection con = DriverManager.getConnection(url, uname, pass);
	  	    Statement st = con.createStatement();
	  	    System.out.println("Enter Your Budget :");
		    double budget = input.nextDouble();
		    String query = "select * from property where price <= "+budget+" and status = 'Available'";
	  	    ResultSet rs = st.executeQuery(query);
	  	    System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo ");
	  	    while( rs.next()) {
	  	    	int sno = rs.getInt(1);
	  		    String name = rs.getString(2);
	  		    String location = rs.getString(3);
	  		    int area = rs.getInt(4);
	  			int price = rs.getInt(5);
	  			String Others = rs.getString(6);
				System.out.println( ""+sno+"  \t   " +name + "  \t  " +area + "  \t  " +price + " \t "+location +"   \t   "+Others);
	  	    }
		
		}catch(Exception e) {
			System.out.println("No properties Available");
		}
	}
	
	
    public static void sort_by_location(){
		try {
		
  	    String url = "jdbc:mysql://localhost:3306/rems";
  	    String uname = "root";
  	    String pass = "Dhrushinadatha@1503";
  	    Class.forName("com.mysql.cj.jdbc.Driver");
  	    Connection con = DriverManager.getConnection(url, uname, pass);
  	    Statement st = con.createStatement();
  	    System.out.println("Enter Your Preffered Location :");
  	    String place = input.next();
  	    ResultSet rs = st.executeQuery("select *from property where location like '"+place+"%' and status = 'Available'");
  	    System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo ");
	    while(rs.next()) {
	    	int sno = rs.getInt(1);
		    String name = rs.getString(2);
		    String location = rs.getString(3);
		    int area = rs.getInt(4);
			int price = rs.getInt(5);
			String Others = rs.getNString(6);
		System.out.println( ""+sno+"  \t   " +name + "  \t  " +area + "  \t  " +price + " \t "+location +"   \t   "+Others);
		}
	}
	catch(Exception e) {
		System.out.println("No properties available");
	}
	}
	
	
    public static void sort_by_budget_location(){
		try {
			
	  	    String url = "jdbc:mysql://localhost:3306/rems";
	  	    String uname = "root";
	  	    String pass = "Dhrushinadatha@1503";
	  	    Class.forName("com.mysql.cj.jdbc.Driver");
	  	    Connection con = DriverManager.getConnection(url, uname, pass);
	  	    Statement st = con.createStatement();
	  	    System.out.println("Enter Your Budget :");
		    double budget = input.nextDouble();
	  	    System.out.println("Enter Your Preffered Location :");
	  	    String place = input.next();
	  	    ResultSet rs = st.executeQuery("select *from property where location ='"+place+"'and price <="+budget+" and status = 'Available'");
	  	    System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo ");
		    while(rs.next()) {
		    int sno = rs.getInt(1);
		    String name = rs.getString(2);
		    String location = rs.getString(3);
		    int area = rs.getInt(4);
			int price = rs.getInt(5);
			String Others = rs.getNString(6);
			System.out.println( ""+sno+"  \t   " +name + "  \t  " +area + "  \t  " +price + " \t "+location +"   \t   "+Others);
			}
		}
		catch(Exception e) {
			System.out.println("No properties available");
		}
	}
	
	
    public static void printOwnerDetails(int sno) throws Exception{
    	    String url = "jdbc:mysql://localhost:3306/rems";
	  	    String uname = "root";
	  	    String pass = "Dhrushinadatha@1503";
	  	    Class.forName("com.mysql.cj.jdbc.Driver");
	  	    Connection con = DriverManager.getConnection(url, uname, pass);
	  	    Statement st = con.createStatement();
	  	    String q1 = "select * from property where sno = "+sno;
			ResultSet rs = st.executeQuery(q1);
			rs.next();
			String username =rs.getString(8);
			String q2 = "select * from personal_details where username = '"+username+"'";
			ResultSet rs1 = st.executeQuery(q2);
			rs1.next();
			String firstname = rs1.getString(1);
			String lastname = rs1.getString(2);
			String g = rs1.getString(3);
			String dob = rs1.getString(4);
			String phone_no = rs1.getString(5);
			String mailid = rs1.getString(6);
			System.out.println("firstname \t lastname \t gender \t date of birth \t phone_no \t   mailid ");
			System.out.printf("%s \t %8s \t %8s \t %8s \t %8s \t %s",firstname,lastname,g,dob,phone_no,mailid);	
    	
    }
	
    public static void book_property() {
		try {
			
	  	    String url = "jdbc:mysql://localhost:3306/rems";
	  	    String uname = "root";
	  	    String pass = "Dhrushinadatha@1503";
	  	    Class.forName("com.mysql.cj.jdbc.Driver");
	  	    Connection con = DriverManager.getConnection(url, uname, pass);
	  	    Statement st = con.createStatement();
	  	    System.out.println("\nEnter Property sno to book :");
	  	    int sno = input.nextInt();
	  	    PreparedStatement pst3 = con.prepareStatement("update property set status = 'Booked' where sno = "+sno);
	  	    int result2 = pst3.executeUpdate();
	  	    
	  		if(result2==1) {
	  			buyer.printOwnerDetails(sno);	
	  			System.out.println("\nProperty Booking successful.");
	  		}else {
	  			System.out.println("\nProperty Booking unsuccessful.");
	  		}
	  		System.out.println("\nAdministrator will conform your Booking soon..");
			
		}catch(Exception e) {
			System.out.println("\nThis property is not available for booking ");
		}
	}
	
	public static void available_properties() {
		boolean u123 = true;
        while(u123) {
            System.out.println("\n1.List all properties \n");
            System.out.println("2.Show properties for your budget\n");
            System.out.println("3.Show properties in your city\n");
            System.out.println("4.Show properties for your Budget in your city\n");
            System.out.println("5.Exit\n");
            System.out.println("Enter Your Choice :");
            int ch5 = input.nextInt();
            switch(ch5) {
                case 1:
                    buyer.listProperties();
                    break;
                case 2:
                    buyer.sort_by_price();
                    break;
                case 3:
                    buyer.sort_by_location();
                    break;
                case 4:
                    buyer.sort_by_budget_location();
                    break;
                case 5:
                    u123 = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice.\n");
            }
        }
	}
}
