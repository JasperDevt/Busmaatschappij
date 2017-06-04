package nl.Busmaatschappij;

import java.util.ArrayList;

public abstract class Bus implements Berijdbaar{
	int capaciteit;
	int aanschafWaarde;
	double rijKosten;
	static int busnummers;	

}

class Waterstofbus extends Bus {
	Buslijn lijn;
	int busnummer;

	Waterstofbus(){
		this(null);
	}
	Waterstofbus(Buslijn lijn){
		this.lijn = lijn;
		busnummers++;
		busnummer = busnummers;
	}

	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;
		System.out.println("We gaan rijden! Deze bus rijdt op waterstof. We gaan langs " + lijn.getHaltes() + " haltes en we nemen mee in totaal " + lijn.getPassagiers() + " passagiers mee." );
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}
}

class Benzinebus extends Bus{
	Buslijn lijn;
	int busnummer;

	Benzinebus(){
		this(null);
	}

	Benzinebus(Buslijn lijn){
		this.lijn = lijn;
		busnummers++;
		busnummer = busnummers;
	}

	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;
		System.out.println("We gaan rijden! Deze bus rijdt op benzine. We gaan langs " + lijn.getHaltes() + " haltes en we nemen in totaal " + lijn.getPassagiers() + " passagiers mee." );
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}
}

class Elektrischebus extends Bus{
	Buslijn lijn;
	int busnummer;

	Elektrischebus(){
		this(null);		
	}

	Elektrischebus(Buslijn lijn){
		this.lijn = lijn;
		busnummers++;
		busnummer = busnummers;
	}
	
	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;		
		System.out.println("We gaan rijden! Deze bus rijdt op elektriciteit. We gaan langs " + lijn.getHaltes() + " haltes en we nemen in totaal mee: " + lijn.getPassagiers() + " passagiers mee." );
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}

	
}

interface Berijdbaar {
	void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn;
}

class GeenLijn extends Exception {
	void foutmelding(){
		System.out.println("De bus heeft geen lijn toegewezen gekregen. Hij gaat naar de garage.");
	}
}
