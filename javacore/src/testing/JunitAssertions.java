package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class JunitAssertions {
String str="medplus";
String str1="medplusx";
int var1=1;
int var2=2;
String str2=null;
int a[]= {1,2,3};
int a1[]= {1,2,3};


	@Test
	public void testEquals() {
		assertEquals("they are not equals",str,str1);
	
	}
	@Test
	public void testNull() {
	assertNull(str2);	
	}
	@Test
	public void testTrue() {
	assertTrue(var1<var2);	
	}
	@Test
	public void testnull() {
	assertArrayEquals(a,a1);	
	}
}
