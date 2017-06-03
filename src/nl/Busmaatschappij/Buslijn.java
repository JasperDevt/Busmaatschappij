package nl.Busmaatschappij;

public abstract class Buslijn {
	int haltes;
	int passagiers;
}

class Lijn1 extends Buslijn{
	int haltes = 15;
	int passagiers = haltes*5;
}

class Lijn2 extends Buslijn{
	int haltes = 5;
	int passagiers = haltes*10;
}

class Lijn3 extends Buslijn{
	int haltes = 10;
	int passagiers = haltes*20;
}