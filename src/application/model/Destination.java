package application.model;

public class Destination {
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private double crimeIndex;
	private double ranking;
	public Destination(String name,double crimeIndex) {
		this.name = name;
		this.crimeIndex = crimeIndex;
		this.ranking = 0.0;
	}
	
	public Destination(String name,double crimeIndex,double ranking) {
		this.name = name;
		this.crimeIndex = crimeIndex;
		this.ranking = ranking;
	}
	public String getName() {
		return this.name;
	}
	public double getCrimeIndex() {
		return this.crimeIndex;
	}
	public double getRanking() {
		return ranking;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	public String toString() {
		return String.format("%s,%.2f,%.2f\n",this.name,this.crimeIndex,this.ranking);
	}
}
