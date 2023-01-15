package Demo;

public class User {
   String pname;
   String pdiscription;
   String pprice;
   String pqty;
   
    public User(String pname,String pdiscription,String pprice,String pqty) {
    	this.pname=pname;
    	this.pdiscription=pdiscription;
    	this.pprice=pprice;
    	this.pqty=pqty;
    
    }
	@Override
	public String toString() {
		return "pname=" + pname + ", pdiscription=" + pdiscription + ", pprice=" + pprice
				+ ", pqty=" + pqty +"";
	}
	
    
}
