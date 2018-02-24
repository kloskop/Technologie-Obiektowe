package samochody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Kierowca implements Serializable {

	//Help -> install new software->add codecover i link do httt z codecoverem  pozniej properties enable -> loop cover branch i statementcover
	// ppm na dana klase i use for covarage measurement (dla klas kierowcy i samochod)
	//ppm run as code cover cos tam
	
	private int pesel;
	private String imie;
	private String nazwisko;
	private ArrayList<Samochod> samochody;
	
	public Kierowca(int pesel, String imie, String nazwisko)
	{
		this.pesel=pesel;
		this.imie=imie;
		this.nazwisko=nazwisko;
		samochody=new ArrayList<Samochod>();
	}
	public int getPesel(){return pesel;}
	public Samochod znajdzSamochod(String rejestracja)
	{		 		   
		  for (Iterator<Samochod> it = samochody.iterator(); it.hasNext (); ) {
		    Samochod k = it.next();
		    if(k.getRejestracja()==rejestracja)
		    	return k;
		  }
		return null;
	}
	public String getImieINazwisko()
	{
		return imie+" "+ nazwisko;
	}
	public void amortyzujSamochody()
	{
		 for (Iterator<Samochod> it = samochody.iterator(); it.hasNext (); ) {
			    Samochod k = it.next();
			    k.amortyzuj();
		 }
	}	
	public void dodajSamochod(Samochod samochod)
	{
		samochody.add(samochod);
	}
}
