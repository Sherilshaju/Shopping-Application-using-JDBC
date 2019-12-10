package shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n;
		do {
		System.out.println("Enter the Choice:\n1.Admin Login\n2.Agent Login\n3.Exit");
		 n=s.nextInt();
		 switch(n)
		 {
		 case 1:
			 Adminlogin obj1=new Adminlogin();
			 obj1.Admin();
			 break;
		 case 2:
			 Agentlogin obj2=new Agentlogin();
			 obj2.Agent();
		 }
		}while(n!=0);
	}

}
