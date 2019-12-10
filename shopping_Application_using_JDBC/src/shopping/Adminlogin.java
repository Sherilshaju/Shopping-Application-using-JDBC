package shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Adminlogin {
	//Connection con=new Connection();
	public void Admin()throws ClassNotFoundException,SQLException {
		java.sql.Connection con=null;//con is an object
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
		
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int ch,f=0;
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		Statement s2=(Statement) con.createStatement();
		ResultSet rr=s2.executeQuery("select * from adminlogin");
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
				System.out.println("Enter the Choice:\n1.Add product\n2.Display product\n3.Remove product\n4.Update product\n5.Logout");
				 ch=s.nextInt();
				switch(ch)
				{
				case 1:
					Statement s12=(Statement) con.createStatement();
					ResultSet r12=s12.executeQuery("select * from addproduct");
					System.out.println("List of Products");
					while(r12.next())
						{
						
						System.out.println("######*****######");
						System.out.println("Product Id ->"+r12.getInt(1)+"\n"+"Product Name->"+r12.getString(2)+"\n"+"Quantity ->"+r12.getInt(3)+"\n"+"Price->"+r12.getFloat(4));
						System.out.println("######*****######");
					}
					System.out.println("Enter the product Id:");
					int pid=s.nextInt();
					System.out.println("Enter the product Name:");
					String pname=s.next();
					System.out.println("Enter the minsellquantity:");
					int quantity=s.nextInt();
					System.out.println("Enter the price:");
					float price=s.nextFloat();
					PreparedStatement st=con.prepareStatement("Insert into addproduct(productid,productname,minsellquantity,price) values(?,?,?,?);");
					st.setInt(1, pid);
					st.setString(2, pname);
					st.setInt(3, quantity);
					st.setFloat(4, price);
					st.executeUpdate();
					System.out.println("Product added Successfully");
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
					Statement s13=(Statement) con.createStatement();
					ResultSet r13=s13.executeQuery("select * from addproduct");
					System.out.println("List of Products");
					while(r13.next())
						{
						
						System.out.println("######*****######");
						System.out.println("Product Id ->"+r13.getInt(1)+"\n"+"Product Name->"+r13.getString(2)+"\n"+"Quantity ->"+r13.getInt(3)+"\n"+"Price->"+r13.getFloat(4));
						System.out.println("######*****######");
					}
					Statement smt=(Statement) con.createStatement();
					System.out.println("Enter the ID you want to delete:");
					int id=s.nextInt();
					PreparedStatement ps=con.prepareStatement("delete from addproduct where productid=?");
					ps.setInt(1, id);
					ps.executeUpdate();
					System.out.println("Successfully Deleted...");
					break;
				case 4:
					Statement s14=(Statement) con.createStatement();
					ResultSet r14=s14.executeQuery("select * from addproduct");
					System.out.println("List of Products");
					while(r14.next())
						{
						
						System.out.println("######*****######");
						System.out.println("Product Id ->"+r14.getInt(1)+"\n"+"Product Name->"+r14.getString(2)+"\n"+"Quantity ->"+r14.getInt(3)+"\n"+"Price->"+r14.getFloat(4));
						System.out.println("######*****######");
					}
					Statement s11=(Statement) con.createStatement();
					ResultSet r1=s11.executeQuery("select productid,productname from addproduct");
					
					while(r1.next())
					{
						System.out.println("######*****######");
						System.out.println("Product Id ->"+r1.getInt(1)+"\n"+"Product Name->"+r1.getString(2));
						System.out.println("######*****######");
					}
					
					int qua=0;
					System.out.println("Enter product Id:");
					int proid=s.nextInt();
					 System.out.println("Enter the updated quantity:");
					 int q=s.nextInt();
					 Statement smt1=(Statement) con.createStatement();
					 ResultSet rs4=smt1.executeQuery("Select * from addproduct");
					 while(rs4.next())
					 {
						 int idd=rs4.getInt(1);
						 if(idd==proid)
						 {
							 int q1=rs4.getInt(3);
							 qua=q1+q;
						 }
					 }
					 PreparedStatement pss=con.prepareStatement("update addproduct set minsellquantity=? where productid=?");
				    
					
					pss.setInt(1, qua);
					pss.setInt(2, proid);
					pss.executeUpdate();
					System.out.println("Successfully Updated...");
					break;
				case 5:
					System.out.println("admin account logout");
					return;
				}
			}while(ch!=0);
		}
		else
		{
			System.out.println("Incorrect Username and password ");
		}
	
	}

}
