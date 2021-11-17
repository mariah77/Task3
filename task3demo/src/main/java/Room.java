
public class Room {
  private String available;
  private int key;
  private static int generate = 100;
  
  public Room() {
	  available = "yes";
	  key = generate;
	  generate++;
  }
 /* public int bookroom() {
	  if(available=="yes") {
		  available = "no";
		  return key;
	  }
	  else {
		  System.out.println("Room already booked");
		  return 0;
	  }
  }*/
  public int getkey() {
	  return key;
  }
  public String getavailable() {
	  return available;
  }
  public void setkey(int key) {
	  if(key>=100) {
		  this.key = key;
	  }
  }
  public void setavailable(String s) {
	  if(s == "no") {
		  available = s;
	  }
	  else if(s =="yes") {
		  available = s;
	  }
	  else {
		  available = "yes";
	  }
  }
}
