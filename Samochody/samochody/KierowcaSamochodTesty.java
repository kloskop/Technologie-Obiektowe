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
	@Before
	public void zainicjujTesty() throws Exception {
		kierowca = new Kierowca(8374, "Wladek", "Zprzemysla");
		mockSamochod = createMock(Samochod.class);
		mockSamochod2 = createMock(Samochod.class);
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
	

}
