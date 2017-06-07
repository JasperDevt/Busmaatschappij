package nl.Busmaatschappij;

import java.util.ArrayList;

public abstract class Bus implements Berijdbaar, teKoop, onderhoudMaandelijks {
	int kostenAanschaf;
	double inkomsten;
	double rijKosten;
	double onderhoudsKosten;
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
		onderhoudsKosten = 3000.0;
		rijKosten = 100.0;
		kostenAanschaf = (int)500_000L;
		Busmaatschappij.budget -= kopen();
	}
	
	public static String kosten(){
		return "U kunt een waterstofbus kopen. Dit is de duurste bus. Dit kost u 500.000.";
	}
	
	public int kopen(){
		System.out.println("U heeft een waterstofbus gekocht voor: " + kostenAanschaf + " euro.");
		return kostenAanschaf;
	}
	
	
	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;
		System.out.println("We gaan rijden! Deze bus rijdt op waterstof. We gaan langs " + lijn.getHaltes() + " haltes en we nemen mee in totaal " + lijn.getPassagiers() + " passagiers mee." );
		Inkomsten.verzamelaar(inkomsten(lijn.getPassagiers()));
		System.out.println("De inkomsten van deze rit zijn: " + inkomsten(lijn.getPassagiers()) + ".We verdienden " + lijn.getTicketprijs() + " per " + lijn.getPassagiers() + " passagiers.");
	}
	
	public double inkomsten(int passagiers){
		return passagiers*lijn.getTicketprijs();
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}
	@Override
	public double rijKosten() {
		return rijKosten;
	}
	@Override
	public double onderhoudsKosten() {
		return onderhoudsKosten;
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
		onderhoudsKosten = 500.0;
		rijKosten = 2000.0;
		kostenAanschaf = (int)150_000L;
		Busmaatschappij.budget -= kopen();
	}
	
	public static String kosten(){
		return "U kunt een bus op benzine kopen. Dit is de goedkoopste bus. Dit kost u 150.000.";
	}
	
	public int kopen(){
		System.out.println("U heeft een bus op benzine gekocht voor: " + kostenAanschaf + " euro.");
		return kostenAanschaf;
	}
	
	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;
		System.out.println("We gaan rijden! Deze bus rijdt op benzine. We gaan langs " + lijn.getHaltes() + " haltes en we nemen in totaal " + lijn.getPassagiers() + " passagiers mee." );
		Inkomsten.verzamelaar(inkomsten(lijn.getPassagiers()));
		System.out.println("De inkomsten van deze rit zijn: " + inkomsten(lijn.getPassagiers()) + ".We verdienden " + lijn.getTicketprijs() + " per " + lijn.getPassagiers() + " passagiers.");
	}
	
	public double inkomsten(int passagiers){
		return passagiers*lijn.getTicketprijs();
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}

	@Override
	public double rijKosten() {
		return rijKosten;
	}

	@Override
	public double onderhoudsKosten() {
		return onderhoudsKosten;
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
		onderhoudsKosten = 1000.0;
		rijKosten = 50.0;
		kostenAanschaf = (int)300_000L;
		Busmaatschappij.budget -= kopen();
	}
	
	public static String kosten(){
		return "U kunt een elektrische bus kopen. Dit is een middeldure bus. Dit kost u 300.000.";
	}
	
	public int kopen(){
		System.out.println("U heeft een waterstofbus gekocht voor: " + kostenAanschaf + " euro.");
		return kostenAanschaf;
	}
	
	public void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn{
		if(lijn == null) {
			throw new GeenLijn();
		}
		buschauffeurvandienst.beschikbaar = false;		
		System.out.println("We gaan rijden! Deze bus rijdt op elektriciteit. We gaan langs " + lijn.getHaltes() + " haltes en we nemen in totaal mee: " + lijn.getPassagiers() + " passagiers mee." );
		Inkomsten.verzamelaar(inkomsten(lijn.getPassagiers()));
		System.out.println("De inkomsten van deze rit zijn: " + inkomsten(lijn.getPassagiers()) + ".We verdienden " + lijn.getTicketprijs() + " per " + lijn.getPassagiers() + " passagiers.");
	}
	
	public double inkomsten(int passagiers){
		return passagiers*lijn.getTicketprijs();
	}

	@Override
	public String toString(){
		return this.getClass().getSimpleName() + " met nummer " + busnummer + " op " + lijn;
	}

	@Override
	public double rijKosten() {
		return rijKosten;
	}

	@Override
	public double onderhoudsKosten() {
		return onderhoudsKosten;
	}	
}

interface Berijdbaar {
	void rijden(Chauffeur buschauffeurvandienst) throws GeenLijn;
	double inkomsten(int passagiers);
}

class GeenLijn extends Exception {
	void foutmelding(){
		System.out.println("Oeps! De bus kan niet rijden. De bus heeft geen lijn toegewezen gekregen. Hij staat in de garage.");
	}
}
