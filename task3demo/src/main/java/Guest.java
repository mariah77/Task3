
public class Guest {
  private int book_room_key;
  private String name;
  private int bill;
  private int[] st;
  private int stay;
  private static int stay_per_night;
  public Guest(String n, int d) {
	  bill = 0;
	  name = n;
	  book_room_key = 0;
	  st = new int[3];
	for(int i =0; i<3; i++) {
		st[i] = 0;
	}
	stay_per_night = 400;
	stay = d;
	  
	  
  }

  void setkey(int key) {
	  book_room_key=key;
  }
  void setname(String n) {
	  name = n;
  }
  void setbill(int n) {
	  if(n>0) {
		  bill = n;
	  }
	  else {
		  bill = 0;
	  }
  }
  public String getname() {
	  return name;
  }
  public int getbill() {
	  return bill;
  }
  public int getkey() {
	  return book_room_key;
  }
  public void display() {
	  System.out.println("Name : "+name );
	  System.out.println("Booked room : "+ book_room_key );
	  System.out.println("Bill : "+bill );
	  if(st[0] == 1) {
		  System.out.println("Swimming pool services availed");
		  
	  }
	  if(st[1] == 1) {
		  System.out.println("Food services availed");
		  
	  }
	  if(st[2] == 1) {
		  System.out.println("Gym services availed");
		  
	  }
	  
  }
  public int calculatebill(int a, int b, int c) {
	  if(a==1 ) {
	  st[0] = a;
	  }
	  if(b==1 ) {
		  st[1] = b;
		 }
	  
	  if(c==1) {
		  st[2] = c;
		  }
	  
	  int bill = st[0]*400+st[1]*500+st[2]*300+stay*stay_per_night;
	  return bill;
	  
  }
  public int make_payment(int a, int b, int c) {
	  return calculatebill(a,b,c);
  }
  public void setstay(int d) {
	  if(d>0) {
		  stay = d;
	  }
  }
  public int getstay() {
	  return stay;
  }
  public void sets(int d) {
	  if(d>0) {
		  stay_per_night = d;
	  }
  }
  public boolean setservices(int a, int b ,int c) {
	  if(a==0 || a==1) {
		  st[0] = a;
	  }
	  if(b==0||b==1) {
		  st[1] = b;
	  }
	  if(c==0||c==1) {
		  st[2] = c;
	  }
	  return true;
  }
}
