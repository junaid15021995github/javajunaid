package Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.*;
import java.util.*;
public class ServiceProvider implements Service {
      //   =======================================User Implements=========================================
	public void User() {
		boolean b=false;
		try {
		System.out.println("Enter mobile No: ");
		String mobile=new Scanner(System.in).nextLine();
		System.out.println("Enter Password: ");
		String password=new Scanner(System.in).nextLine();
		 Connection con=DbConnection.getCon();
		 PreparedStatement ps=con.prepareStatement("select mobile,password from register where mobile=?");
		 ps.setString(1, mobile);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			 String mob=rs.getString(1);
			 String pass=rs.getString(2);
		 if(mob.equals(mobile)&&password.equals(pass)) {
			 b=true;
		   System.out.println("=========Welcome To shopping========"); 
		   System.out.println("Eneter 1.shop Product//2.Remove Product//3.show Product//4.TotalAmount Item//5/exit");
		   int choice=Integer.parseInt(new Scanner(System.in).nextLine());
		   if(choice==1) {
		   System.out.println("Enter Product Id: ");
		   String id=new Scanner(System.in).nextLine();
		   System.out.println("Enter Product Name: ");
		   String name=new Scanner(System.in).nextLine();
		   System.out.println("Enter Product Description: ");
		   String Discription=new Scanner(System.in).nextLine();
		   System.out.println("Enter Product Price: ");
		   String price=new Scanner(System.in).nextLine();
		   System.out.println("Enter Product Quantity: ");
		   String quantity=new Scanner(System.in).nextLine();
		   PreparedStatement ps2=con.prepareStatement("insert into productjugnu values(?,?,?,?,?,?)");
		   ps2.setString(1, id);
		   ps2.setString(2, name);
		   ps2.setString(3, Discription);
		   ps2.setString(4, price);
		   ps2.setString(5, quantity);
		   ps2.setString(6, mobile);
		   int k=ps2.executeUpdate();
		   if(k>0) {
			   System.out.println("Product Added ");
		   }
		   else {
			   System.out.println(" Product Not added");
		   }
		   }
		   else  if(choice==2) {
			   System.out.println("Eneter Product Name: ");
			   String productname=new Scanner(System.in).nextLine();
			   PreparedStatement ps3=con.prepareStatement("delete from Productjugnu where name=? AND mobile=?");
			   ps3.setString(1,productname);
			   ps3.setString(2,mobile);
			   int a=ps3.executeUpdate();
			   if(a>0) {
				   System.out.println("Product Removed");
			   }
			   else {
				   System.out.println("WrongProductname/mobile");
			   }
		   }
		   
		   else  if(choice==3) {
			   TreeMap<String,User> tm=new TreeMap();
			   PreparedStatement ps4=con.prepareStatement("select* from productjugnu where mobile=?");
			   ps4.setString(1, mobile);
			   ResultSet rs1=ps4.executeQuery();
			   while(rs1.next()) {
				   String productid=rs1.getString(1);
				   String productname=rs1.getString(2);
				   String productdescription=rs1.getString(3);
				   String productprice=rs1.getString(4);
				   String productquantity=rs1.getString(5);
				   tm.put(productid, new User(productname,productdescription,productprice,productquantity));
			   }
			   tm.forEach((k,v)->System.out.println("pId="+k+" "+v.toString()));
			 }
		   else if(choice==4) {
			   double sum=0;
			   PreparedStatement ps5=con.prepareStatement("select price from productjugnu where mobile=?");
			   ps5.setString(1, mobile);
			   ResultSet rs5=ps5.executeQuery();
			   while(rs5.next()) {
				  sum+=Double.parseDouble(rs5.getString(1)); 
			   }
			   System.out.println("Total ProductAmount: "+sum);
		   }
		   
		   else  if(choice==5) {
			   System.exit(choice);
		   }
		   
		   else {
			   System.out.println("Invalid choice");
		   }
		 }
		 }	 
		}catch(Exception e) {e.printStackTrace();}
		 if(b==false) {
			  System.out.println("Invalid Mobile/password");
		 }
	}

	//============================================================new User Implements==============================================
	public void NewUser() {
		try {
	  System.out.println("===========Welcome to Registration=====");
	  System.out.println("Enter Name: ");
	  String name=new Scanner(System.in).nextLine();
	  System.out.println("Enter mobile Number: ");
	  String mobile=new Scanner(System.in).nextLine();
	  System.out.println("Enter EmailId: ");
	  String email=new Scanner(System.in).nextLine();
	  System.out.println("Enter Address:vill+PO+PS+DIST+State+PINCode :");
	  String address=new Scanner(System.in).nextLine();
	  System.out.println("Enter Password: ");
	  String password=new Scanner(System.in).nextLine();
	  Connection con=DbConnection.getCon();
	  PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
	  ps.setString(1, name);
	  ps.setString(2, mobile);
	  ps.setString(3, email);
	  ps.setString(4, address);
	  ps.setString(5, password);
	  int a=ps.executeUpdate();
	  if(a>0) {
		  System.out.println("You Are Registered go to login");
	  }
	  else {
		  System.out.println("Sorry! Try again");
	  }
		}catch(Exception e) {e.printStackTrace();}
		
	}
	
//=====================================================================Admin Implements=====================================================
	public void Admin() {
		boolean b=false;
		try {
	 System.out.println("Enter AdminId: ");
	 String id=new Scanner(System.in).nextLine();
	 System.out.println("Enter Mobile Number: ");
	 String mobile=new Scanner(System.in).nextLine();
	 System.out.println("Enter Password: ");
	 String password=new Scanner(System.in).nextLine();
	        Connection con=DbConnection.getCon();
	        PreparedStatement ps=con.prepareStatement("select* from admin where mobile=?");
	        ps.setString(1,mobile);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()) {
	       String id1=rs.getString(1);
	       String mobile2=rs.getString(2);
	       String pass=rs.getString(3);
	       if(id1.equals(id)&&mobile2.equals(mobile)&&pass.equals(password)) {
	    	   System.out.println("==========Welcome In Admin==========");
	    	   b=true;
	    	   try {
	    		   System.out.println("Enter 1.Search UserDetail by Mobile number"+"\n"+
	    	   "2.show Alluser"+"\n"+"3.Serch userProduct by Mobile Number"+"\n"+"4.show All userProduct"+"\n"+"5.exit");
	    		   switch(Integer.parseInt(new Scanner(System.in).nextLine())) {
	    		   case 1:System.out.println("Enter userMobile Number: ");
	    		   String userMobile=new Scanner(System.in).nextLine();
	    			   PreparedStatement ps1=con.prepareStatement("select* from register where mobile=?");
	    		   ps1.setString(1, userMobile);
	    		   ResultSet rs1=ps1.executeQuery();
	    		   while(rs1.next()) {
	    			   System.out.println("Name: "+rs1.getString(1));
	    			   System.out.println("Mobile:"+rs1.getString(2));
	    			   System.out.println("Email:"+rs1.getString(3));
	    			   System.out.println("Address: "+rs1.getString(4));
	    		   }
	    		   break;
	    		   case 2:PreparedStatement ps2=con.prepareStatement("select* from register");
	    		   ResultSet rs2=ps2.executeQuery();
	    		   while(rs2.next()) {
	    			   System.out.println("name:"+rs2.getString(1)+" "+"Mobile: "+rs2.getString(2)+" "+"Email: "+rs2.getString(3)+" "+"Address: "+rs2.getString(4));
	    		   }
	    		   break;
	    		   case 3:System.out.println("Enter UserMobile Number: ");
	    		   String userMobile2=new Scanner(System.in).nextLine();
	    		   PreparedStatement ps3=con.prepareStatement("select* from productjugnu where mobile=?");
	    		   ps3.setString(1, userMobile2);
	    		   ResultSet rs3=ps3.executeQuery();
	    		   while(rs3.next()) {
	    			   System.out.println("ProductId: "+rs3.getString(1));
	    			   System.out.println("Productname:"+rs3.getString(2));
	    			   System.out.println("ProductDiscription: "+rs3.getString(3));
	    			   System.out.println("ProductPrice: "+rs3.getString(4));
	    			   System.out.println("ProductQuantity: "+rs3.getString(5));
	    			   System.out.println("userMobile No: "+rs3.getString(6));
	    		   }
	    		   break;
	    		   case 4:PreparedStatement ps4=con.prepareStatement("select*from productjugnu");
	    		   ResultSet rs4=ps4.executeQuery();
	    		   while(rs4.next()) {
	    			   System.out.println("Productid: "+rs4.getString(1)+"\t"+"ProductName: "+rs4.getString(2)+"\t"+"ProductDiscription: "+rs4.getString(3)+"\t"+"ProductPrice: "+rs4.getString(4)+"\t"+"ProductQuantity: "+rs4.getString(5)+"\t"+"UserMobile No :"+rs4.getString(6));
	    		   }
	    		   break;
	    		   case 5:
	    			   System.exit(0);
	    		   default:
	    			   System.out.println("Invalid choice");
	    		   }
	    	   }catch(Exception e) {e.printStackTrace();}
	       }
	        }
		}catch(Exception e) {e.printStackTrace();}
		
		if(b==false) {
	    	   System.out.println("Invalid! AdminId/mobileNo/Password");
	       }
		}

}
