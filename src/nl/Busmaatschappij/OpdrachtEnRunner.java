package nl.Busmaatschappij;

import java.util.ArrayList;

public class OpdrachtEnRunner {
	public static void main(String [] args){
		Busmaatschappij Groenvervoer = new Busmaatschappij("Groenvervoer");
		Groenvervoer.inBedrijf();
	}
}

class Busmaatschappij {
	String naam;
	
	Busmaatschappij(String naam){
		this.naam = naam;
	}
	
	public void inBedrijf(){		
		
		ArrayList<Buslijn> buslijnen = new ArrayList<Buslijn>();
		Buslijn lijn1 = new Lijn1();Buslijn lijn2 = new Lijn2();Buslijn lijn3 = new Lijn3();
		buslijnen.add(lijn1);buslijnen.add(lijn2);buslijnen.add(lijn3);
		
		ArrayList<Bus> bussen = new ArrayList<Bus>();
		bussen.add(new Waterstofbus());bussen.add(new Waterstofbus(lijn2));bussen.add(new Waterstofbus(lijn1));bussen.add(new Benzinebus(lijn1));
		bussen.add(new Elektrischebus(lijn1));
		
		ArrayList<Bus> garageBussen = new ArrayList<>();
		
		ArrayList<Chauffeur> chauffeurs = new ArrayList<Chauffeur>();
		chauffeurs.add(new Chauffeur("Kees"));chauffeurs.add(new Chauffeur("Jan"));chauffeurs.add(new Chauffeur("Harm"));chauffeurs.add(new Chauffeur("Koen"));chauffeurs.add(new Chauffeur("Jeffrey"));
		Beschikbaar beschikbaarheid = e -> e.beschikbaar == true;

				
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
				garageBussen.add(bus);
				f.foutmelding();	
			}
			catch(Exception g){
				System.out.println(g);
				System.out.println("Ojee, alles gaat mis! We weten niet wat er aan de hand is. Paniek!");
			}
		}
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
//1 StringBuilder-object (<- seriecode bus)
//1 van elke primitive-soort, dus 8
//2 static variabelen
//4 overloadings van methodes
//4 overridings van methodes
// 
//In te leveren op donderdag 8 juni uiterlijk 9:30. Code weer via Github, zorg weer voor meerdere commits!
