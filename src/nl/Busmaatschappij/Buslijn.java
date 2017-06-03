package nl.Busmaatschappij;

public abstract class Buslijn {
	abstract int getHaltes();
	abstract int getPassagiers();
}

class Lijn1 extends Buslijn{
	int haltes = 15;
	int passagiers = haltes*5;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
}

class Lijn2 extends Buslijn{
	int haltes = 5;
	int passagiers = haltes*10;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
}

class Lijn3 extends Buslijn{
	int haltes = 10;
	int passagiers = haltes*20;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
}