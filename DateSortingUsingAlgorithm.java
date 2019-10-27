import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;

public class DateSortingUsingAlgorithm {

	private HashMap<LocalDate, Integer> DatestoSortMap = new HashMap<LocalDate, Integer>();
	//private LocalDate[] arr;
	public void dateHashMapSortedDescending() {

		LocalDate[] descendArr = new LocalDate[DatestoSortMap.size()];
		int p = 0;
		for (LocalDate toSort : DatestoSortMap.keySet()) {
			descendArr[p] = toSort;
			++p;
		}
		
		int n = descendArr.length; 
        for (int i = 1; i < n; ++i) { 
            LocalDate key = descendArr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && descendArr[j].isBefore(key)) { 
            	descendArr[j + 1] = descendArr[j]; 
                j = j - 1; 
            } 
            descendArr[j + 1] = key; 
        } 
		
        for (int i= 0; i < descendArr.length; i++) {
        	System.out.println(descendArr[i]);
        }
		
	}

	public DateSortingUsingAlgorithm() throws IOException {
		
		try {
			read("SortingDates.txt");
		} catch (IOException e) {
			System.out.println("error printing from file");
			e.printStackTrace();
		}
		
	}
	
	public void dateHashMapSorted() {
		
		LocalDate[] arr = new LocalDate[DatestoSortMap.size()];
		int p = 0;
		for (LocalDate toSort : DatestoSortMap.keySet()) {
			arr[p] = toSort;
			++p;
		}
		
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            LocalDate key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j].isAfter(key)) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        }
		
        for (int i= 0; i < arr.length; i++) {
        	System.out.println(arr[i]);
        }
        
	}
	
	public void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 
		 String strg = "";
	     int i = 0;
	     
		 strg = br.readLine();
		
		 while (strg != null) {
			
			 String[] date = strg.trim().split("-");
			 int year = Integer.parseInt(date[0].trim());
			 int month = Integer.parseInt(date[1].trim());
			 int day = Integer.parseInt(date[2].trim());
			 
			 LocalDate inputDate = LocalDate.of(year, month, day);
			
			DatestoSortMap.put(inputDate, ++i);
	    	
	    	strg = br.readLine();
	     }
	     br.close();
	}

}
