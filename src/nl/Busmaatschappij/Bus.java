package nl.Busmaatschappij;

public abstract class Bus{
	int capaciteit;
	int aanschafWaarde;
	double rijKosten;
	abstract void rijden(Buslijn lijn);
}

class Waterstofbus extends Bus {
	void rijden(Buslijn lijn){
		System.out.println("We gaan rijden! Deze bus rijdt op waterstof.");
	}
}

class Benzinebus extends Bus {
	void rijden(Buslijn lijn){
		System.out.println("We gaan rijden! Deze bus rijdt op benzine.");
	}
	
}

class Elektrischebus extends Bus{
	void rijden(Buslijn lijn){
		System.out.println("We gaan rijden! Deze bus heeft een elektromotor.");
	}
}

