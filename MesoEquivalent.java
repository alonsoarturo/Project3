import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class MesoEquivalent {

	private HashMap<String, Integer> stationMap = new HashMap<String, Integer>();
	private ArrayList<String> stationArray;
	private String stationID;
	
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
		// TODO Auto-generated method stub
		return null;
	}
	
	public void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 
		 String strg = "";
	   
		 strg = br.readLine();
		
		 while (strg != null) {
			
			stationArray.add(strg.trim());
	    	
	    	strg = br.readLine();
	     }
	     br.close();
	}

}
