import java.sql.*;
import java.util.*;

public class Login{
	static int i=0;
	protected static void login(String userName,String password1) { 
		try {
			
			Scanner scn = new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/rems";
			String uname = "root";
			String pass = "Dhrushinadatha@1503";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			
			ResultSet rs1 = st.executeQuery("select password from userinfo where username = '"+userName+"'");
			rs1.next();
			String password = rs1.getString("password");
			if(password1.equals(password)){
				System.out.println("Logged in Successfully.");
				i=1;
			}
			else{
				System.out.println("Login unsuccessful.");
			}
		}
		catch(Exception e) {
    	System.out.println("Enter Valid Username and Password.");
		}
	}
}