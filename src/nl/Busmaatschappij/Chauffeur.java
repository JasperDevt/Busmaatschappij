package nl.Busmaatschappij;

import java.util.ArrayList;

public class Chauffeur {
	String naam;
	boolean beschikbaar = true;
	private double maandsalaris;

	Chauffeur(){
		this("John doe");
	}

	Chauffeur(String naam){
		this.naam = naam;
		maandsalaris = 2150.80F;
	}
	
	public double getMaandsalaris(){
		return maandsalaris;
	}
	
	@Override
	public String toString(){
		return ""+ naam + "";
	}
	public static void resetBeschikbaarheid(ArrayList<Chauffeur> chauffeurs){
		for (Chauffeur chauffeur: chauffeurs){
			chauffeur.beschikbaar = true;
		}
	}

	public static Chauffeur regelChauffeur (ArrayList<Chauffeur> chauffeurs, Beschikbaar beschikbaarheid) throws GeenChauffeur{
		for(Chauffeur chauffeur: chauffeurs){
			if(beschikbaarheid.check(chauffeur)){
				System.out.println(chauffeur + " rijdt!");
				return chauffeur;
			} else	{
				System.out.println("Oei, "+ chauffeur + " is al aan het rijden. Even verder kijken.");
				continue;
			}
		}
		throw new GeenChauffeur();
	}
}

interface Beschikbaar {
	boolean check(Chauffeur chauffeur);
}

class GeenChauffeur extends Exception{
	void foutmelding(){
		System.out.println("We hebben geen chauffeur kunnen vinden. Huur meer chauffeurs in of verkoop bussen!");
	}
}