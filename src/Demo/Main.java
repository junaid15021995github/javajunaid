package Demo;
import java.util.*;
import java.sql.*;

public class Main {
public static void main(String[] args) {
	       while(true) {
		System.out.println("Enter 1.New User//2.Login//3.Admin//4.exit");
		Service s=new ServiceProvider();
		switch(Integer.parseInt(new Scanner(System.in).nextLine())) {
		case 1:s.NewUser();
		  break;
		case 2:s.User();
		break;
		case 3:s.Admin();
		break;
		case 4:System.exit(0);
		default:System.out.println("Invalid Input");
		}
		System.out.println("Enter 1.Again Visit//2.exit");
		if(Integer.parseInt(new Scanner(System.in).nextLine())==2) {
			System.exit(0);
		}
		else {
			System.out.println("Invalid choice--ReEnter");
		}
	       }
}
}
