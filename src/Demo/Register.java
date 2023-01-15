package Demo;
import java.util.Scanner;
public class Register {
   String name;
   String mobile;
   String email;
   String address;
   String password;
   public Register(String name,String mobile,String email,String address,String password) {
	   this.name=name;
	   this.mobile=mobile;
	   this.email=email;
	   this.address=address;
	   this.password=password;
   }
@Override
public String toString() {
	return "Register [name=" + name + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", password="
			+ password + "]";
}
   
}
