package nl.Busmaatschappij;

public abstract class Bus{
	int capaciteit;
	int aanschafWaarde;
	double rijKosten;
	abstract void rijden();
}

class Waterstofbus extends Bus {
	Buslijn lijn;
	Waterstofbus(){
		lijn = null;
	}

	Waterstofbus(Buslijn lijn){
		this.lijn = lijn;
	}

	void rijden(){
		System.out.println("We gaan rijden! Deze bus rijdt op waterstof. We gaan langs: " + lijn.getHaltes() + " haltes en we nemen mee: " + lijn.getPassagiers() + " passagiers." );
	}
}

class Benzinebus extends Bus {
	Buslijn lijn;
	Benzinebus(){
		lijn = null;
	}

	Benzinebus(Buslijn lijn){
		this.lijn = lijn;
	}
	void rijden(){
		System.out.println("We gaan rijden! Deze bus rijdt op benzine. We gaan langs: " + lijn.getHaltes() + " haltes en we nemen mee: " + lijn.getPassagiers() + " passagiers." );
	}
}

class Elektrischebus extends Bus{
	Buslijn lijn;
	Elektrischebus(){
		lijn = null;
	}

	Elektrischebus(Buslijn lijn){
		this.lijn = lijn;
	}
	void rijden(){
		System.out.println("We gaan rijden! Deze bus rijdt op elektriciteit. We gaan langs: " + lijn.getHaltes() + " haltes en we nemen mee: " + lijn.getPassagiers() + " passagiers." );
	}
}

