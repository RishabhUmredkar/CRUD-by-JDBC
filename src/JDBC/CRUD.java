
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class CRUD { 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("hello");
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registerd");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Rishabh","root","abc123");
		System.out.println("connected");
		boolean j = true;
		int empno=0 ;
		String empname ="null";
		String sal = "null" ;
		while (j)
		{
		Statement stmt = con.createStatement();
		System.out.println("1. Insert");
		System.out.println("2. Show");
		System.out.println("3. Search");
		System.out.println("4. Delete");
		System.out.println("5. Update");
		System.out.println("0. Exit");
		System.out.println("enter your choice");
		int ch = Integer.parseInt(sc.nextLine());
		switch (ch)
		{
		case 1 :

    	    System.out.println("Enter the no. of Student...");
    	    int n = Integer.parseInt(sc.nextLine());
    	    for(int i=1; i<=n; i++)
    	    {    	   
		
		System.out.println("enter the empno.");
		 empno = Integer.parseInt(sc.nextLine());
		System.out.println("enter the empname.");
		 empname = sc.nextLine();
		System.out.println("enter the Emp sal.");
		 sal = sc.nextLine();
    	    }
		int a = stmt.executeUpdate("Insert into Rishabh.tb1(empno, empname, empsal) Values ("+empno+",'"+empname+"','"+sal+"')");
		if(a>0)
		{
			System.out.println("Insert Successful");
		}
		else
		{
			System.out.println("Error");
		}
		
		break;
		
		
		case 2 :
			String query = "select * from Rishabh.tb1";
			System.out.println("empno \t empname \t empsal");
			ResultSet r = stmt.executeQuery(query);
			while (r.next())
			{
				empno = r.getInt("empno");
				empname = r.getString("empname");
				sal = r.getString("empsal");
				
				System.out.println(empno+"\t"+empname+" \t\t"+sal);
			}
			break;
		case 3:
			System.out.println("enter empno to search");
			empno = Integer.parseInt(sc.nextLine());
			
			String sql ="select * from Rishabh.tb1 where empno = "+empno+"";
			ResultSet r1 = null;
			r1 = stmt.executeQuery(sql);
			while(r1.next())
			{
				System.out.println("empno : "+r1.getInt("empno")+"\nEmpname:"+r1.getString("empname")+"\nsal:"+r1.getString("empsal"));
			}
			
			break;
		case 4: 
		System.out.println("Enter empno to Delete data");
		empno = Integer.parseInt(sc.nextLine());
		int a1 = stmt.executeUpdate("Delete from Rishabh.tb1 where empno = "+empno+ " ");
		if(a1>0)
		{
			System.out.println("Delete Successful");
		}
		else
		{
			System.out.println("Error");
		}
		break;



		case 5 :
		System.out.println("Enter empno to Update data");
		empno = Integer.parseInt(sc.nextLine());
		System.out.println("Enter empname");
		 empname = sc.nextLine();
		 int a2 = stmt.executeUpdate("update Rishabh.tb1 set empname = '"+empname+ "' where empno = "+empno+"");
		if(a2>0)
		{
			System.out.println("Update Successful");
		}
		else
		{
			System.out.println("Error");
		}
		break;
		
		case 0 :
			con.close();
			System.out.println("close");
			j=false;
			break;
		}
		}
	}}
	

