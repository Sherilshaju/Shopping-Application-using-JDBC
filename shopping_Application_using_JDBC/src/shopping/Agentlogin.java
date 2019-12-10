package shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agentlogin {

	public void Agent()throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		java.sql.Connection con=null;//con is an object
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
		
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int ch,f=0,flag=0;
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		Statement s2=(Statement) con.createStatement();
		ResultSet rr=s2.executeQuery("select * from agentlogin");
		while(rr.next())
		{
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
			{
				f=1;
			}
		}
		if(f==1)
		
		{
			System.out.println("Successfully verified");
			do {
				System.out.println("Enter the Choice:\n1.BuySell\n2.View product\n3.Logout");
				 ch=s.nextInt();
				 switch(ch)
				 {
				 case 1:
					 Statement s111=(Statement) con.createStatement();
						ResultSet r111=s111.executeQuery("select * from addproduct");
						System.out.println("List of Products");
						while(r111.next())
							{
							
							System.out.println("######*****######");
							System.out.println("Product Id ->"+r111.getInt(1)+"\n"+"Product Name->"+r111.getString(2)+"\n"+"Quantity ->"+r111.getInt(3)+"\n"+"Price->"+r111.getFloat(4));
							System.out.println("######*****######");
						}
					 System.out.println("Enter the product ID");
					 int pid=s.nextInt();
					 System.out.println("Enter the quantity");
					 int q1=s.nextInt();
					 


					 Statement s11=(Statement) con.createStatement();
						ResultSet r1=s11.executeQuery("select * from addproduct");
						float price=0;
						while(r1.next())
						{
							if(pid==r1.getInt(1))
							{
								price=r1.getFloat(4);
								int qq=r1.getInt(3);
								if(q1<=qq)
								{
									float amount=price*q1;
									System.out.println("The cost is ->"+amount);
									flag=1;
								}
								else
								{
									System.out.println("Stack overflow");
									flag=0;
								}
							}
						}
			           
						if(flag==1)
						{
						System.out.println("Enter 1 to confirm Booking");
						int choice=s.nextInt();
						if(choice==1)
						{
							System.out.println("Your Booking is Confirmed");
							System.out.println("Thank you!!!");
						}
						
						//*****************************************
						 Statement smt1=(Statement) con.createStatement();
						 ResultSet rs4=smt1.executeQuery("Select * from addproduct");
						 int diff=0;
						 while(rs4.next())
						 {
							 int idd=rs4.getInt(1);
							 if(idd==pid)
							 {
								 int q11=rs4.getInt(3);
								 diff=q11-q1;
							 }
						 }
						 PreparedStatement pss=con.prepareStatement("update addproduct set minsellquantity=? where productid=?");
					    
						
						pss.setInt(1, diff);
						pss.setInt(2, pid);
						pss.executeUpdate();
						//System.out.println("Successfully Updated...");
						}
					 break;
				 case 2:
					 Statement s1=(Statement) con.createStatement();
						ResultSet r=s1.executeQuery("select * from addproduct");
						System.out.println("List of Products");
						while(r.next())
							{
							
							System.out.println("######*****######");
							System.out.println("Product Id ->"+r.getInt(1)+"\n"+"Product Name->"+r.getString(2)+"\n"+"Quantity ->"+r.getInt(3)+"\n"+"Price->"+r.getFloat(4));
							System.out.println("######*****######");
						}
					 break;
				 case 3:
					 System.out.println("agent account logout");
				 }
			}while(ch!=0);
	}
		else
		{
			System.out.println("Incorrect Username and password ");
		}
	

	}
	}
