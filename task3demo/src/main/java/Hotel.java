import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.nio.file.Paths;

public class Hotel {
  private Room[] r;
  private static int num;
  private int money_earned;
  private Guest[] g;
  private static int index1;
  
  
  public Hotel(int n) {
	
	 if(n>0 && n<=20) { 
	   num = n;
	   r =  new Room[n];
	   g = new Guest[n];
	   for(int i = 0; i<num; i++) {
		   r[i] = new Room();
	   }
	   for(int i =0; i<num; i++) {
		   g[i] = new Guest(" ",0);
	   }
	   index1 = 0;
	   money_earned = 0;
	 }
	 else {
		 num = 0;
		 r = null;
		 g = null;
	 }
	 
 }
	
  
  /*public boolean AddRoom(Room r1) throws CustomException {
	  if(index<=num-1) {
		  r[index] = r1;
		  index++;
		  return true;
	  }
	  else {
		  throw new CustomException("Rooms full");
	  }
  }*/
  public boolean searchguest(int key) {
	  for(int i =0; i<=index1; i++) {
		  if(g[i].getkey() == key) {
			  return true;
		  }
		 
	  }
	  return false;
  }
  public void displayallrooms() {
	  for(int i =0; i<num; i++) {
		  if(r[i].getavailable()=="yes") {
			  System.out.println("Room is avaialble");
			  System.out.println("Key is "+r[i].getkey());
		  }
	  }
	  
  }
  public boolean reserve(String n) throws CustomException {
	  boolean flag = false;
	  if(index1<=num-1) {
		     g[index1].setname(n);//adding guest to guest array
		     
		     for(int i =0; i<num; i++) {
		    	 if(r[i].getavailable()=="yes") {
		    		 g[index1].setkey(r[i].getkey());
		    		 r[i].setavailable("no");
		    		 break;
		    	 }
		     }
		     index1++;
		     flag =  true;
		  }
		  else {
			  flag = false;
			  throw new CustomException("Rooms full");
			 
		  }
	  return flag;
	  
  }
  
  public  boolean bookroom(String h) throws CustomException {
	  boolean f = false;
	  if(index1<=num-1) {
	     g[index1].setname(h);//adding guest to guest array
	     
	     for(int i =0; i<num; i++) {
	    	 if(r[i].getavailable()=="yes") {
	    		 g[index1].setkey(r[i].getkey());
	    		 r[i].setavailable("no");
	    		 break;
	    	 }
	     }
	     index1++;
	     f =  true;
	  }
	  else {
		  f=  false;
		  throw new CustomException("Rooms full");
	  }
	  return f;
  }
  public boolean writetofile() throws IOException {
	  
	  
	  File obj = new File("file.txt");
		 
		 try {
			 boolean f=obj.createNewFile();
	         if (f) {
	            System.out.println("File created with name " + obj.getName());
	          } else {
	             System.out.println("Fileexists.");
	           }
	         } catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	          }
	   boolean flag = false;
	   int len = 0;
	   if(index1 >= num-1) {
		   len = num-1;
	   }
	   else {
		   len = index1;
	   }
	   try {
		      
		      FileWriter f = new FileWriter("file.txt");
		      for(int i =0; i<num; i++) {
				   if(r[i].getavailable() == "no") {
					   f.write("This Room is booked and has key ");
					   //f.write(r[i].getkey());
					   f.append(r[i].getkey() + "\n");
				   }
				   else {
					   f.write("This Room is not booked and has key");
					   f.append(r[i].getkey()+"\n");
				   }
			   }
		      
			   for(int i =0; i<=len; i++) {
				   int j=i+1;
				   f.write("Guest "+j+" details : \n");
				   f.write("Name : "+g[i].getname()+"\n");
				   f.append("Room alloted with key : "+g[i].getkey()+"\n");
				   f.append("Services bill : "+g[i].getbill()+"\n");
				   
			   }
					   
				   
			   flag= true;
			   f.close();
			   System.out.println("Written to file ");
		    } catch (IOException e) {
		    	
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	   
	   return flag;
	   
  
  }
  public int update_revenue(int a, int b, int c, int k) {
	  int len = 0;
	   if(index1 >= num-1) {
		   len = num-1;
	   }
	   else {
		   len = index1;
	   }
	  for(int i =0; i<=len;i++) {
		  if(g[i].getkey()==k) {
			  money_earned += g[i].make_payment(a, b, c);
		     break;
		  }
		  
	  }
	  return money_earned;
  }
  public int getmoneyearned() {
	  return money_earned;
  }
  public Guest[] getguest() {
	  return g;
  }
  
}
