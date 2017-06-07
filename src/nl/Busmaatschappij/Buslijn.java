package nl.Busmaatschappij;

public abstract class Buslijn {
	abstract int getHaltes();
	abstract int getPassagiers();
	abstract double getTicketprijs();
}

class Lijn1 extends Buslijn{
	static int haltes = 15;
	static int passagiers = haltes*5;
	static double ticketprijs = 3.50;
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
	@Override
	double getTicketprijs(){
		return ticketprijs;
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
	static double ticketprijs = 4.50;
	
	@Override
	int getHaltes() {
		return haltes;
	}
	
	@Override
	int getPassagiers() {
		return passagiers;
	}
	@Override
	double getTicketprijs(){
		return ticketprijs;
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
	static double ticketprijs = 2.0;
	
	@Override
	int getHaltes() {
		return haltes;
	}
	@Override
	int getPassagiers() {
		return passagiers;
	}
	@Override
	double getTicketprijs(){
		return ticketprijs;
	}
	
	@Override
	public String toString(){
		StringBuilder lijntemp = new StringBuilder(this.getClass().getSimpleName());
		String lijn = lijntemp.insert(4, " ").toString();
		return lijn;
	}
}