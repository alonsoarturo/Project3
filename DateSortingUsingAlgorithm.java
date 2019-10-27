import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {

	private HashMap<LocalDate, Integer> DatestoSortMap = new HashMap<LocalDate, Integer>();
	
	public void dateHashMapSortedDescending() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
		
	}
	
	public void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
	     
		 DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 
		 String strg = "";
	     int i = 0;
	     
		 strg = br.readLine();
		
		 while (strg != null) {
			LocalDate inputDate = LocalDate.parse(strg.trim(), inputFormat);
			
			DatestoSortMap.put(inputDate, ++i);
	    	
	    	strg = br.readLine();
	     }
	     br.close();
	}

}
