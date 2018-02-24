package samochody;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.classextension.EasyMock.*;

public class KierowcaSamochodTesty {

	Kierowca kierowca;
	Samochod mockSamochod;
	
	@Before
	public void zainicjujTesty() throws Exception {
		kierowca = new Kierowca(8374,"Wladek", "Zprzemysla");
		mockSamochod = createMock(Samochod.class);
	}
	
	@Test
	public void testAmortyzacjaSamochodu()
	{
		//zakladamy, ze dodawany samochod ma wartosc 10000 i amortyzacje 10 %
		
		mockSamochod.amortyzuj();
		expect(mockSamochod.getWartosc()).andReturn(9000.0f);
		replay(mockSamochod);
				
		kierowca.dodajSamochod(mockSamochod);
		kierowca.amortyzujSamochody();
		
		assertEquals(mockSamochod.getWartosc(),9000.0f);
		verify(mockSamochod);
	}
	

}
	