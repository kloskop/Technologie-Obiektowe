package samochody;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.classextension.EasyMock.*;

public class KierowcaSamochodTesty {

	Kierowca kierowca;
	Samochod mockSamochod;
	Samochod mockSamochod2;
	Samochod mockSamochod3;

	@Before
	public void zainicjujTesty() throws Exception {
		kierowca = new Kierowca(8374, "Wladek", "Zprzemysla");
		mockSamochod = createMock(Samochod.class);
		mockSamochod2 = createMock(Samochod.class);
		mockSamochod3 = createMock(Samochod.class);
	}

	@Test
	public void testAmortyzacjaSamochodu1() {
		// zakladamy, ze dodawany samochod ma wartosc 10000 i amortyzacje 10 %

		mockSamochod.amortyzuj();
		replay(mockSamochod);
		kierowca.dodajSamochod(mockSamochod);
		kierowca.amortyzujSamochody();
		verify(mockSamochod);
	}

	@Test
	public void testAmortyzacjaSamochodu0() {
		kierowca.amortyzujSamochody();
	}

	@Test
	public void testAmortyzacjaSamochodu2() {
		// zakladamy, ze dodawany samochod ma wartosc 10000 i amortyzacje 10 %

		mockSamochod.amortyzuj();
		mockSamochod2.amortyzuj();
		replay(mockSamochod);
		replay(mockSamochod2);
		kierowca.dodajSamochod(mockSamochod);
		kierowca.dodajSamochod(mockSamochod2);
		kierowca.amortyzujSamochody();
		verify(mockSamochod);
		verify(mockSamochod2);
	}

	@Test
	public void testZnajdzSamochod0() {

		kierowca.znajdzSamochod("kr12");

	}
	
	
	@Test
	public void testZnajdzSamochod1() {

		
		expect(mockSamochod.getRejestracja()).andReturn("kr12");
		replay(mockSamochod);
		kierowca.dodajSamochod(mockSamochod);
		
		Samochod s=kierowca.znajdzSamochod("kr12");
		assertSame(s,mockSamochod);
		verify(mockSamochod);
	}
	
	@Test
	public void testZnajdzSamochod3() {

		
		expect(mockSamochod.getRejestracja()).andReturn("kr12");
		expect(mockSamochod2.getRejestracja()).andReturn("krYYY");
		
		replay(mockSamochod);
		replay(mockSamochod2);
		replay(mockSamochod3);
		
		kierowca.dodajSamochod(mockSamochod2);
		kierowca.dodajSamochod(mockSamochod);
		kierowca.dodajSamochod(mockSamochod3);
		
		Samochod s=kierowca.znajdzSamochod("kr12");
		
		assertSame(s,mockSamochod);
		verify(mockSamochod);
		verify(mockSamochod2);
	}
	
	
	

}
