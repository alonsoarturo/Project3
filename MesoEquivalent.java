import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {

	private HashMap<String, Integer> stationMap = new HashMap<String, Integer>();
	private ArrayList<String> stationArray = new ArrayList<String>();
	private String stationID;
	private ArrayList<String> sameStationArray = new ArrayList<String>();
	private int asciiCalAvg = MesoAsciiCal.asciiCalAvg;
	public static ArrayList<String> sameAvgArray;
	
	public MesoEquivalent(String stId) {
		this.stationID = stId;
		
		try {
			read("Mesonet.txt");
		} catch (IOException e) {
			System.out.println("error printing from file");
			e.printStackTrace();
		}
		
	}

	public HashMap<String, Integer> calAsciiEqual() {
		Integer inputAsciiAvg = asciiCalAvg;
		//sameStationArray = CalSameAsciiAvg();
		
		for (int i = 0; i < CalSameAsciiAvg().size(); i++) {
			stationMap.put(CalSameAsciiAvg().get(i), inputAsciiAvg);
		}
		return stationMap;
	}
	
	public ArrayList<String> CalSameAsciiAvg() {
		
		sameAvgArray = new ArrayList<String>();
		
		int Avg;
		double[] asciiVal = new double[4];
		double asciiAvg = 0.0;
		String stationName;
		
		for(int i = 0; i < stationArray.size(); i++) {
			
			Avg = 0;
			//double[] asciiVal = new double[4];
			//double asciiAvg = 0.0;
			stationName = stationArray.get(i);
			
			for (int j = 0; j < 4; j++) {
				asciiVal[j] = (double) stationName.charAt(j);
			}
			
			asciiAvg = (asciiVal[0] + asciiVal[1] + asciiVal[2] + asciiVal[3]) / 4.0;
			
			Avg = (int) Math.round(asciiAvg);
			
			if (Avg == asciiCalAvg) {
				sameAvgArray.add(stationName);
			}
		}
		
		return sameAvgArray;
		
	}
	
	public void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 
		 String strg = "";
		 String stid = "";
		 
		 strg = br.readLine();
		 strg = br.readLine();
		 strg = br.readLine();
		 strg = br.readLine();
		 
		 while (strg != null) {
			stid = strg.trim().substring(0, 4);
			stationArray.add(stid);
			
	    	strg = br.readLine();
	     }
	     br.close();
	}

}