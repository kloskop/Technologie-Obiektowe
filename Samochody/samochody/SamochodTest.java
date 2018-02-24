package samochody;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SamochodTest {
	
	Samochod samochod;

	@Before
	public void setUp() throws Exception {
		samochod = new Samochod("KGR", 10000, 10);
	}

	@Test
	public void testGetRejestracja() {
		assertEquals(samochod.getRejestracja(),"KGR");
	}

	
	@Test
	public void testAmortyzuj() {
		samochod.amortyzuj();
		assertEquals(samochod.getWartosc(),9000,0.01);
	}

	@Test
	public void testGetWartosc() {
		assertEquals(samochod.getWartosc(),10000,0.01);
	}

}
