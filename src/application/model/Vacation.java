package application.model;

import java.util.*;
import java.io.*;
public class Vacation {
	private String name;
	private ArrayList<Destination> destinations = new ArrayList<Destination>();
	
	//Used to calculate ranking
	private double safetyImportance;
	
	
	public Vacation(String name) {
		this.name = name;
		destinations = defaultDestinations();
	}
	public Vacation(File file) {
		this.name = StringFunc.findAndReplace(".csv",file.getName(),"");
		destinations = loadVacation(file);
	}
	public void saveVacation() {
		try {
			File save = new File("./Data/SavedVaccations/"+this.name+".csv");
			save.createNewFile();
			FileWriter wr = new FileWriter(save);
			for(int i=0;i<destinations.size();i++) {
				wr.write(destinations.get(i).toString());
			}
			wr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Destination> loadVacation(File f) {
		ArrayList<Destination> dest = new ArrayList<Destination>();
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String data[] = new String[2];
				data = sc.nextLine().split(",");
				Destination dc = new Destination(data[0],Double.valueOf(data[1]),Double.valueOf(data[2]));
				dest.add(dc);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}
	private ArrayList<Destination> defaultDestinations(){
		File defFile = new File("./Data/NewCD.csv");
		ArrayList<Destination> dest = new ArrayList<Destination>();
		try {
			Scanner sc = new Scanner(defFile);
			while(sc.hasNextLine()) {
				String data[] = new String[2];
				data = sc.nextLine().split(",");
				Destination dc = new Destination(data[0],Double.valueOf(data[1]));
				dest.add(dc);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dest;
	}
	public String toString() {
		String toReturn = String.format("%s - %d elements\n",this.name,this.destinations.size());
		for(int i=0;i<this.destinations.size();i++) {
			toReturn = toReturn+"\t"+destinations.get(i).toString();
		}
		return toReturn;
	}
	
	public void sortDestinations() {
		//TODO: write entire function lol
		
	}
	
	public void calculateRankings() {
		for(int i=0;i<destinations.size();i++) {
			destinations.get(i).setRanking((safetyImportance*(100-destinations.get(i).getCrimeIndex())));
		}
	}
	public double getSafetyImportance() {
		return safetyImportance;
	}
	public void setSafetyImportance(double safetyImportance) {
		this.safetyImportance = safetyImportance;
	}
	
}