package nl.Busmaatschappij;

public abstract class Buslijn {
	abstract int getHaltes();
	abstract int getPassagiers();
}

class Lijn1 extends Buslijn{
	static int haltes = 15;
	static int passagiers = haltes*5;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
	
	@Override
	public String toString(){
		StringBuilder lijntemp = new StringBuilder(this.getClass().getSimpleName());
		String lijn = lijntemp.insert(4, " ").toString();
		return lijn;
	}
}

class Lijn2 extends Buslijn{
	static int haltes = 5;
	static int passagiers = haltes*10;
	
	@Override
	int getHaltes() {
		return haltes;
	}
	
	@Override
	int getPassagiers() {
		return passagiers;
	}
	
	@Override
	public String toString(){
		StringBuilder lijntemp = new StringBuilder(this.getClass().getSimpleName());
		String lijn = lijntemp.insert(4, " ").toString();
		return lijn;
	}
}

class Lijn3 extends Buslijn{
	static int haltes = 10;
	static int passagiers = haltes*20;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
	
	@Override
	public String toString(){
		StringBuilder lijntemp = new StringBuilder(this.getClass().getSimpleName());
		String lijn = lijntemp.insert(4, " ").toString();
		return lijn;
	}
}