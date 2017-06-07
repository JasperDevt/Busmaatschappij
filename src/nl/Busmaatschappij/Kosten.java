package nl.Busmaatschappij;

import java.util.ArrayList;

public class Kosten {

	void maandelijkseAfrekening(){
		System.out.println("Het budget was: " + Busmaatschappij.budget + " en daar wordt " + variabeleLasten.getVariabeleLasten() + " van afgetrokken." );
		Busmaatschappij.budget -= variabeleLasten.getVariabeleLasten();
		System.out.println("We houden dan " + Busmaatschappij.budget + " over.");
		System.out.println("De inkomsten waren: " + Inkomsten.getMaandInkomsten());
		Busmaatschappij.budget += Inkomsten.getMaandInkomsten();
		System.out.println("Het budget is nu: " + Busmaatschappij.budget);
	}
}

class Inkomsten {
	static double totaleRitInkomsten;
	static double maandInkomsten;
	static void verzamelaar(double ritInkomsten){
		totaleRitInkomsten+=ritInkomsten;
		maandInkomsten = totaleRitInkomsten*31;
		Busmaatschappij.budget+=ritInkomsten;
	}
	static double getInkomsten(){
		return totaleRitInkomsten;
	}
	static void resetInkomsten(){
		totaleRitInkomsten = 0;
	}
	static double getMaandInkomsten(){
		return maandInkomsten;
	}
}

class variabeleLasten extends Kosten {
	static double variabeleLasten;

	public static double getVariabeleLasten(){
		return variabeleLasten;
	}

	public float salarissen(ArrayList<Chauffeur> chauffeurs){
		float maandsalarissen = 0;
		for(int i = 0; i<chauffeurs.size();i++){
			maandsalarissen += chauffeurs.get(i).getMaandsalaris();
			System.out.println("Het salaris van " + chauffeurs.get(i).naam + " is " + chauffeurs.get(i).getMaandsalaris());
		}
		variabeleLasten += maandsalarissen;
		return maandsalarissen;
	}

	public float maandelijksBussen(ArrayList<Bus> bussen){
		float maandonderhoud = 0;
		for (Bus bus: bussen){
			maandonderhoud += bus.onderhoudsKosten(); System.out.println("De kosten van " + bus + " zijn " + bus.onderhoudsKosten() + " aan onderhoud.");
			maandonderhoud += bus.rijKosten(); System.out.println("De kosten van " + bus + " zijn " + bus.rijKosten() + " aan het rijden.");
			variabeleLasten += maandonderhoud;
		}
		return maandonderhoud;
	}
}
interface onderhoudMaandelijks {
	double rijKosten();
	double onderhoudsKosten();
}

interface teKoop {
	static void kosten(){}
	int kopen();
}