package nl.Busmaatschappij;

public class OpdrachtEnRunner {
	public static void main(String [] args){
		Busmaatschappij Groenvervoer = new Busmaatschappij("Groenvervoer");
		System.out.println(Groenvervoer.toString());
	}
}

class Busmaatschappij {
	String naam;	
	Busmaatschappij(String naam){
		this.naam = naam;
	}
	@Override
	public String toString(){
		return naam;
	}
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
