package nl.Busmaatschappij;

import java.util.ArrayList;
import java.util.Scanner;

public class OpdrachtEnRunner {
	public static void main(String [] args){
		Busmaatschappij Groenvervoer = new Busmaatschappij("Groenvervoer");
		Groenvervoer.startmenu();
	}
}

class Busmaatschappij {
	static String naam;
	static ArrayList<Buslijn> buslijnen = new ArrayList<Buslijn>();
	static ArrayList<Bus> bussen = new ArrayList<Bus>();
	static ArrayList<Chauffeur> chauffeurs = new ArrayList<Chauffeur>();
	static Beschikbaar beschikbaarheid = e -> e.beschikbaar == true;
	static Scanner sc = new Scanner(System.in);


	Busmaatschappij(String naam){
		this.naam = naam;
	}

	public static void startmenu(){	
		boolean stoppen = false;
		while(stoppen == false){
			Keuzemenu.opties();
			String input = sc.next();
			switch(input){
			case "1": bussen.add(Keuzemenu.optie1(sc)); System.out.println("U heeft een " + bussen.get(bussen.size()-1) + " toegevoegd voor kosten: "); break;
			case "2": chauffeurs.add(Keuzemenu.optie2(sc)); System.out.println("U heeft een chauffeur toegevoegd met de naam: " + chauffeurs.get(chauffeurs.size()-1).naam); break;
			case "3": rondjeRijden(); break;
			case "o": Busmaatschappij.overzicht(); break;
			case "new": Keuzemenu.optie3(sc); break;
			case "stoppen": stoppen = true; break;
			}
		}
	}
	static void rondjeRijden(){
		for (Bus bus: bussen){
			try{
				System.out.println();System.out.println("We zoeken een chauffeur voor de " + bus + "....");
				bus.rijden(Chauffeur.regelChauffeur(chauffeurs, beschikbaarheid));
			}
			catch(GeenChauffeur e){
				System.out.println("Deze " + bus + " heeft geen chauffeur en kan niet rijden.");
				e.foutmelding();
			}
			catch(GeenLijn f){
				f.foutmelding();	
			}
			catch(Exception g){
				System.out.println(g);
				System.out.println("Ojee, alles gaat mis! We weten niet wat er aan de hand is. Paniek!");
			}
		}
		Chauffeur.resetBeschikbaarheid(chauffeurs);
		Busmaatschappij.overzicht();
		startmenu();
	}

	public static void overzicht(){
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("Bij deze het overzicht van busmaatschappij " + Busmaatschappij.naam);
		System.out.println("------------------------------");
		System.out.println("We hebben " + bussen.size() + " bussen. Hieronder een overzicht van de bussen: ");
		for (Bus bus: bussen){
			System.out.println(bus);
		}
		System.out.println("------------------------------");
		System.out.println("We hebben " + chauffeurs.size() + " chauffeurs. Bij deze het overzicht van alle chauffeurs ");
		for (Chauffeur chauffeur: chauffeurs){
			System.out.println(chauffeur.naam);
		}
		System.out.println("------------------------------");
	}

	@Override
	public String toString(){
		return ""+ naam + "";
	}
}

interface Betaalbaar {

}

//De criteria voor de opdracht is dat je alle onderstaande onderdelen toepast in je applicatie.
//10 klassen
//2 interfaces
//2 Exceptions (Zelfgemaakt & getry-ed en gecatched)
//4 Has-a relaties (Geen primitive relatie)
//4 Is-a relaties
//1 switch, while, do-while, for-loop EN enhanced for-loop
//1 Array
//1 ArrayList
//1 String-object
//1 StringBuilder-object 
//1 van elke primitive-soort, dus 8
//2 static variabelen
//4 overloadings van methodes
//4 overridings van methodes
// 
//In te leveren op donderdag 8 juni uiterlijk 9:30. Code weer via Github, zorg weer voor meerdere commits!
