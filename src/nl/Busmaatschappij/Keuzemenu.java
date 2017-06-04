package nl.Busmaatschappij;

import java.util.Scanner;

public class Keuzemenu {

	static void opties(){
		System.out.println("Wat wilt u doen? Kies de volgende opties voor: ");
		System.out.println("1 voor het kopen van een bus");
		System.out.println("2 voor het huren van een chauffeur");
		System.out.println("3 om een rondje met alle bussen te rijden.");
		System.out.println("new voor het starten van een nieuwe busmaatschappij");
	}

	static Bus optie1(Scanner sc){
		System.out.println("Wat voor type bus wilt u? ");
		System.out.println("1 voor een bus die op benzine rijdt. Kosten: ");
		System.out.println("2 voor een bus die op waterstof rijdt. Kosten: ");
		System.out.println("3 voor een bus die op elektriciteit rijdt. Kosten: ");
		String input = sc.next();
		switch(input){
		case "1": return welkelijn("benzine",sc); 
		case "2": return welkelijn("waterstof",sc); 
		case "3": return welkelijn("elektrisch",sc); 
		default: System.out.println("Ongeldige input."); optie1(sc);
		}
		optie1(sc);
		return null;
	}

	static Bus welkelijn(String bus, Scanner sc){	
		System.out.println("Op welke lijn gaat uw bus rijden? ");
		System.out.println("1 voor lijn 1, er zijn 15 haltes en 5 passagiers per halte." );
		System.out.println("2 voor lijn 2, er zijn 5 haltes en 10 passagiers per halte.");
		System.out.println("3 voor lijn 3, er zijn 10 haltes en 20 passagiers per halte.");
		System.out.println("g voor garage. De bus wordt gestald voor onderhoud.");
		String input = sc.next();
		
		if(bus.equals("benzine")){
			switch(input){
			case "1": return new Benzinebus(new Lijn1());
			case "2": return new Benzinebus(new Lijn2());
			case "3": return new Benzinebus(new Lijn3());
			case "g": return new Benzinebus();
			}
		}

		if(bus.equals("waterstof")){
			switch(input){
			case "1": return new Waterstofbus(new Lijn1());
			case "2": return new Waterstofbus(new Lijn2());
			case "3": return new Waterstofbus(new Lijn3());
			case "g": return new Waterstofbus();
			}
		}
		
		if(bus.equals("elektrisch")){
			switch(input){
			case "1": return new Elektrischebus(new Lijn1());
			case "2": return new Elektrischebus(new Lijn2());
			case "3": return new Elektrischebus(new Lijn3());
			case "g": return new Elektrischebus();
			}
		}
		welkelijn(bus,sc);
		return null;
	}
	
	static Chauffeur optie2(Scanner sc){
		System.out.println("U wilt een chauffeur inhuren. Hoe moet de chauffeur heten?");
		String input = sc.next();
		return new Chauffeur(input);
		
	}
	
	static void optie3(Scanner sc){
		System.out.println("Weet u het zeker (Y / N)? U raakt uw busmaatschappij hierna kwijt.");
		String input = sc.next();
		switch(input){
		case "Y": OpdrachtEnRunner.main(null); System.exit(0);
		case "N": break;
		case "y": OpdrachtEnRunner.main(null); System.exit(0);
		case "n": break;
		default: System.out.println("Ongeldige invoer"); optie3(sc);
		}
	}
}



