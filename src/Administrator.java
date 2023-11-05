import java.util.*;
import java.sql.*;
public class Administrator extends Login{
	String Name;
	String Gender;
	String Username;
	String Password;
	String DateofBirth;
	int Age;
    static Scanner scn = new Scanner(System.in);
	static int i=0;
	
    public void setAge(int age) {
        Age = age;
    }
    
    public void setDateofBirth(String dateofBirth) {
        DateofBirth = dateofBirth;
    }
    
    public void setGender(String gender) {
        Gender = gender;
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public void setPassword(String password) {
        Password = password;
    }
    
    public void setUsername(String username) {
        Username = username;
    }
    
    public int getAge() {
        return Age;
    }
    
    public String getDateofBirth() {
        return DateofBirth;
    }
    
    public String getGender() {
        return Gender;
    }
    
    public String getName() {
        return Name;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public String getUsername() {
        return Username;
    }
    
    public Administrator(String name ,String gender ,int age,String dob,String username,String password){
        this.Name = name;
        this.Age = age;
        this.DateofBirth = dob;
        this.Gender = gender;
        this.Username = username;
        this.Password = password;
    }
    
    
    public static void login(){
    	try {
    		Scanner input = new Scanner(System.in);
			String url = "jdbc:mysql://localhost:3306/rems";
			String uname = "root";
			String pass = "Dhrushinadatha@1503";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			System.out.println("Enter username: ");
			String userName = input.next();
			System.out.println("Enter password: ");
			String password1 = input.next();
			ResultSet rs1 = st.executeQuery("select password from admininfo where username = '"+userName+"'");
			rs1.next();
			String password = rs1.getString("password");
			if(password1.equals(password)){
				System.out.println("Logged in Successfully.");
				i=1;
			}
			else{
				System.out.println("Enter Valid Password.");
			}
		}
		catch(Exception e) {
			System.out.println("Enter Valid Username and Password.");
		}
	}
    
    public static void list_users ()throws Exception {
    	String url = "jdbc:mysql://localhost:3306/rems";
        String uname = "root";
        String pass = "Dhrushinadatha@1503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
    	String q1 = "select * from userinfo";
		ResultSet rs = st.executeQuery(q1);
 	    System.out.println("First Name \t Last Name \t Username \t Password ");
		while(rs.next()) {
			String firstName = rs.getString(1);
    		String lastName = rs.getString(2);
    		String username = rs.getString(3);
    		String password = rs.getString(4);
    		 
    		System.out.printf( "%8s \t %8s \t %8s \t %s\n",firstName,lastName,username,password );
		}
    }
    
    public static void remove_user() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/rems";
        String uname = "root";
        String pass = "Dhrushinadatha@1503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        System.out.println("\nEnter usename that should be removed:");
		String username_in = scn.next();

		PreparedStatement pst = con.prepareStatement("delete from userinfo where username = '"+username_in+"'");
        PreparedStatement pst1 = con.prepareStatement("delete from personal_details where username = '"+username_in+"'");
        PreparedStatement pst2 = con.prepareStatement("delete from property where username = '"+username_in+"'");
        int result = pst.executeUpdate();
        int result1 = pst1.executeUpdate();
        int result2 = pst2.executeUpdate();
        if(result1 == 1 && result ==1 && result2 ==1) {
        System.out.println("\nUser removed successfully.");
        }
    	
    }
    
    public static void list_properties() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/rems";
        String uname = "root";
        String pass = "Dhrushinadatha@1503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from property");
 	    System.out.println("SNO \t  Owner name \t  Area   \t  Price   \t   Location   \t  OtherInfo \t Status");
		while(rs.next()) {
    		int sno = rs.getInt(1);
    		String name = rs.getString(2);
    		String location = rs.getString(3);
    		int area = rs.getInt(4);
			int price = rs.getInt(5);
    		String Others = rs.getString(6);
    		String status = rs.getString(7);
    		
    		System.out.printf( " %d \t %8s \t %d sft \t %d \t %8s \t %8s \t %s\n",sno,name,area,price,location,Others,status);
    	}
    	
    }
    
    public static void remove_property() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/rems";
        String uname = "root";
        String pass = "Dhrushinadatha@1503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        System.out.println("\nEnter Sno of the property from list to remove :");
		int i = scn.nextInt();
		PreparedStatement pst = con.prepareStatement("delete from property where sno = "+i);
		
		int result = pst.executeUpdate();
		if(result==1) {
			System.out.println("\nProperty removed successfully.");
		}else {
			System.out.println("\nInvalid details entered.");
		}
    	
    }
    
    public static void update_status() throws Exception{
    	String url = "jdbc:mysql://localhost:3306/rems";
        String uname = "root";
        String pass = "Dhrushinadatha@1503";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        Statement st = con.createStatement();
        System.out.println("\nEnter Sno of the property from list for status update:");
		int a = scn.nextInt();
		ResultSet rs1 = st.executeQuery("select * from property where sno = '"+a+"'");
		rs1.next();
		String availability = rs1.getString(7);
		String avai2;
		if(availability.equals("Available") || availability.equals("Booked")) {
			avai2 = "Not Available";
		}else {
			avai2="Available";
		}
		PreparedStatement pst3 = con.prepareStatement("update property set status = '"+avai2+"' where sno = "+a);
		int result2 = pst3.executeUpdate();
		if(result2==1) {
			System.out.println("\nStatus update successful.");
		}else {
			System.out.println("\nStatus update unsuccessful.");
		}
    	
    }
    
    public static void ManageUsers (){
    	
    	try {
    		String url = "jdbc:mysql://localhost:3306/rems";
            String uname = "root";
            String pass = "Dhrushinadatha@1503";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            int i=1;
        	while(i==1) {
    	    	System.out.println("\n1.List users\n");
    	    	System.out.println("2.Remove user\n");
    	    	System.out.println("3.Back\n");
    	    	System.out.println("Enter your choice:");
    	    	int choice = scn.nextInt();
    	    	switch(choice) {
	    	    	case 1:
	    	    		Administrator.list_users();
	    	    		break;
	    	    	case 2:
	    	    		Administrator.remove_user();
	    		        
	    		        break;
	    	    	case 3:
	    	    		i =0;
	    	    		break;
    	    	}
    	    	
        	}
            
    	}catch(Exception e) {
    		
    	}
    }

    public static void ManageProperties(){
    	try {
    		String url = "jdbc:mysql://localhost:3306/rems";
            String uname = "root";
            String pass = "Dhrushinadatha@1503";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            boolean k1234 = true;
            while(k1234) {
            	System.out.println("\n1.List Properties\n");
            	System.out.println("2.Remove property\n");
            	System.out.println("3.Change status of a property\n");
            	System.out.println("4.Back\n");
            	System.out.println("Enter your choice :");
            	int choice = scn.nextInt();
            	switch(choice) {
            	case 1:
            		Administrator.list_properties();
            		break;
            	case 2:
            		Administrator.remove_property();
            		break;
            	case 3:
            		Administrator.update_status();
            		break;
            	case 4:
            		k1234 = false;
            		break;
            	default:
            		System.out.println("\nEnter valid choice.");
            	}
            }
    	}catch(Exception e) {
    		
    	}
    }
}    