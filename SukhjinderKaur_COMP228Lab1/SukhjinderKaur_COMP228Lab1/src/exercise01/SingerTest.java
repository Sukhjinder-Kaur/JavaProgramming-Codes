package exercise01;

public class SingerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//deriver class or the test class which has the method main
		   Singers singer1 = new Singers();
		   
		   singer1.setSingerId(1);
	       System.out.println("Singer's Id: " + singer1.getSingerId());
	       
	       singer1.setName("Tim John");
	       System.out.println("Singer's Name: " + singer1.getName());
	       
	       singer1.setAddress("15 East Bolevard,Toronto,ON");
	       System.out.println("Singer's Address: " + singer1.getAddress());
	      
	       singer1.setDateOfBirth("07-07-1998");
	       System.out.println("Singer's D.O.B.: " + singer1.getDateOfBirth());
	       
	       singer1.setNumberOfAlbumsPublished(11);
	       System.out.println("Number of Albums by Singer: " + singer1.getNumberOfAlbumsPublished());
	       
				
		// other method
	
		//Singers singer1 = new Singers(1,"Tim","15 East Bolevard","07-07-1998",4);
		//System.out.println(singer1.toString());
		  
		//Singers singer2 = new Singers(2,"Brad Pitt","67 Avenue Scarborough","09-06-1990",10);
		//System.out.println(singer2.toString());
		  
		//Singers singer3 = new Singers(3,"Madonna", "40 West Toronto","15-03-1982", 12);
		//System.out.println(singer3.toString());
		  
		//Singers singer4 = new Singers(4,"John","13 E Street Brampton","04-11-1996", 9);
		//System.out.println(singer4.toString());
		  
	}
}