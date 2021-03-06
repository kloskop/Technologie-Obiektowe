package samochody;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class KierowcaTesty {

	Kierowca kierowca;
	List<Samochod> samochody;

	@Before
	public void inicjujTesty() {
		samochody = new ArrayList<Samochod>();
		kierowca = new Kierowca(3843, "John", "Doe");
	}

	@Test
	public void testDaneKierowcy() {
		assertEquals(kierowca.getImieINazwisko(), "John Doe");
	}


	@Test
	public void testowanieGetPesel() {
		assertEquals(kierowca.getPesel(), 3843);
	}

}