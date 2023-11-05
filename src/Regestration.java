import java.util.*;
import java.sql.*;

public class Regestration {
	
	public static void register() {
		 try {
	        Scanner scn = new Scanner(System.in);
	        String url = "jdbc:mysql://localhost:3306/rems";
	        String uname = "root";
	        String pass = "Dhrushinadatha@1503";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, uname, pass);
	        Statement st = con.createStatement();
	        System.out.println("Enter first name: ");
	        String firstName = (String) scn.next();
	        System.out.println("Enter last name: ");
	        String lastName = (String) scn.next();	
	        System.out.println("Enter Your Date of Birth :");
	        String dob = scn.next();
	        System.out.println("Enter Your Gender : ");
	        String G = scn.next();
	        System.out.println("Enter Your Phone Number : ");
	        String phone_no = scn.next();
	        System.out.println("Enter Your MailId: ");
	        String mailid = scn.next();
	        System.out.println("Enter username : ");
	        String userName = (String) scn.next();
	        System.out.println("Enter password: ");
	        String password = (String) scn.next();
	        if(!firstName.equals("") && !lastName.equals("") && !password.equals("") && !userName.equals("")){
	            PreparedStatement pst = con.prepareStatement("insert into userinfo values('"+firstName+"','"+lastName+"','"+userName+"','"+password+"')");
	            int result = pst.executeUpdate();
	            int result1 = 0;
	            if(result==1) {
		            PreparedStatement pst1 = con.prepareStatement("insert into personal_details values('"+firstName+"','"+lastName+"','"+G+"','"+dob+"','"+phone_no+"','"+mailid+"','"+userName+"');");
		            result1 = pst1.executeUpdate();
	            }
	            System.out.println("\nRegistered  successfully");
	        }
	        else{
	            System.out.println("Please check your credentials, some of them are invalid.");
	        }
		 }
		 catch(Exception e) {
			 System.out.println("Please check your credentials.");
		 }
	 }
}
