import java.sql.*;
import java.util.*;

import javax.security.auth.login.LoginException;

public class dREam {
	public static void main(String [] args) throws Exception{
		Scanner scn = new Scanner(System.in);
		int k=1,l=1,m=1,n=1,o=1,p=1;
		Scanner input = new Scanner(System.in);
		System.out.println("\nWelcome to Dream Real Estate Managaement System\n");
		while(o==1) {
			System.out.println("1.Admin\n");
			System.out.println("2.User\n");
			System.out.println("3.Exit\n");
			System.out.println("Enter Your Choice:");
			int ch3 = input.nextInt();
			switch(ch3) {
				case 1:
					Administrator.login();
					if(Administrator.i==1) {
						while(p==1){
							System.out.println("\n1.Manage Users\n");
							System.out.println("2.Manage Properties\n");
							System.out.println("3.Back\n");
							System.out.println("Enter Your Choice : ");
							int ch4 = input.nextInt();
							switch(ch4) {
								case 1:
									Administrator.ManageUsers();
									break;
								case 2:
									Administrator.ManageProperties();
									break;
								case 3:
									p=0;
									break;
								default:
				            		System.out.println("Enter valid choice.");
							}
						}
					}
					break;
				case 2:
					while(k==1) {
						System.out.println("\n1.Login\n");
						System.out.println("2.Register\n");
						System.out.println("3.Log Out\n");
						System.out.println("Enter Your Choice :");
						int choice = input.nextInt();
						switch(choice) {
							case 1:
								System.out.println("Enter username: ");
								String userName = scn.next();
								System.out.println("Enter password: ");
								String password1 = scn.next();
								Login.login(userName,password1);
								if(Login.i == 0){
									break;
								}else if(Login.i==1){
									boolean l123 = true;
									while(l123){
										System.out.println("\n1.Buy / Sell\n");
										System.out.println("2.Your Personal Details\n");
										System.out.println("3.Register your property\n");
										System.out.println("4.Back\n");
										System.out.println("Enter Your Choice :");
										int ch = input.nextInt();
										switch(ch){
											case 2:
												seller.show_details(userName);
												//Shows his/her personal details to the user.
											case 1:
												boolean k1234 = true;
												while(k1234) {
													System.out.println("\n1.Buy\n");
													System.out.println("2.Sell\n");
													System.out.println("3.Back to main page\n");
													System.out.println("Enter Your Choice :");
													int lkj = input.nextInt();
													switch(lkj) {
														case 1:
															while(n==1) {
																System.out.println("\n1.Show available properties\n");
																System.out.println("2.Buy a property\n");
																System.out.println("3.Back to main page\n");
																System.out.println("Enter Your Choice :");
																int c = input.nextInt();
																switch(c) {
																	case 1:
																		buyer.available_properties();
																		//Shows all the available property to the user.
																		break;
																	case 2:
																		buyer.book_property();
																		//Allows user to book a property.
																	case 3:
																		n=0;
																		break;
																	default:
																		System.out.println("Enter valid choice.");
																}
															}
															break;
														case 2:
															boolean m123 = true;
															while(m123) {
																System.out.println("\n1.Property already registered\n");
																System.out.println("2.Register new property\n");
																System.out.println("3.Back\n");
																System.out.println("Enter Your choice");
																int ch2 = input.nextInt();
																switch(ch2) {
																	case 1:
																		seller.sellProperty(userName);
																		//change to available
																		break;
																	case 2:
																		System.out.println("Please register your property in the main page.");
																		//User have to go to main page to register his property.
																		break;
																	case 3:
																		m123 = false;
																		break;
																	default:
																		System.out.println("Enter valid choice.");
																}
															}
															break;
														case 3:
															k1234 = false;
															break;
														default:
															System.out.println("Enter valid choice.");
													}
												}
												break;
											case 3:
												seller.propertyRegistration(userName);
												break;
											case 4:
												l123 = false;
												break;
											default:
												System.out.println("Enter valid choice.");
										}
									}
								}
							break;
							case 2:
								Regestration.register();
								break;
							case 3:
								k = 0;
								break;
							default:
								System.out.println("Enter valid choice.");
							}
						}
						break;
						case 3:
					    	System.out.println("\nThank you for using Dream Real Estate Management system.\n");
					    	o = 0;
					    	break;
					    default:
		            		System.out.println("Enter valid choice.");
			}
		}
	}
}