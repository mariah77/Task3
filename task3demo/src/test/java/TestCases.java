import static org.junit.Assert.*;

import java.io.IOException;

//import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestCases {
	
	public static Hotel h;
	
    @BeforeClass
    public static void init() {
    	
    	 try {
    		    		
    		 h = new Hotel(5);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 
    	
    }
	@Test
	public void test1() {
		boolean f1 = false, f2 = false,f3 =false;
		f1=h.bookroom("maria");
		f2=h.bookroom("hanna");
		f3=h.bookroom("tony");
		assertTrue(f1);
		assertTrue(f2);
		assertTrue(f3);
		
	}
	@Test
	public void test2() {
		boolean flag = h.reserve("boyle");
		boolean flag1 = h.reserve("clay");
		//boolean f1 = h.searchguest(100);
		assertTrue(flag);
		assertTrue(flag1);
	}
	
           
	@Test
	public void test3() {
		boolean f1 =false;
		try {
			f1 = h.writetofile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(f1);
	}
	@Test(expected = CustomException.class)
    public void test4() throws CustomException {
        //your logic goes here.
        h.bookroom("tony");
	}
	
	@Test
	public void test5() {
		boolean found = h.searchguest(100);
		assertTrue(found);
	}
	
   @Test
   public void test6() {
	   for(int i =0; i<5; i++) {
		   h.getguest()[i].setstay(1);
		   h.update_revenue(1, 1, 1, h.getguest()[i].getkey());
		  
	   }
	   
	   int p = h.getmoneyearned();
	   assertEquals(8000,p);
   }
}
