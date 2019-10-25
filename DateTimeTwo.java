import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class DateTimeTwo {
	
	private LocalDateTime currentDateTime = LocalDateTime.now();
	private HashMap<LocalDate, Integer> LocalDatesMap = new HashMap<LocalDate, Integer>();
	private ArrayList<String> localDatesArray = new ArrayList<String>();
	
	public void daysOfCurrentMonth() {
		
		DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
		
		String tenthDay = dayOfWeekFormat.format(currentDateTime.withDayOfMonth(10)).toUpperCase();
		String eighteenthDay = dayOfWeekFormat.format(currentDateTime.withDayOfMonth(18)).toUpperCase();;
		
		
		
		System.out.println("The tenth day of this month is " 
				+ tenthDay + " and eighteenth is " + eighteenthDay);
		
	}

	public void daysOfAnyMonth(int month, int year) {
		
		DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
		
		LocalDateTime anyDate = LocalDateTime.of(year, month, 1, 1, 1);
		
		LocalDateTime finalDay = anyDate.withDayOfMonth(anyDate.getMonth().maxLength());
		
		String fifteenthDay = dayOfWeekFormat.format(anyDate.withDayOfMonth(15)).toUpperCase();
		String lastDay = dayOfWeekFormat.format(finalDay).toUpperCase();
		
		System.out.println("For the year (" + year + ") and month (" + month + 
				"), the fifteenth day is " + fifteenthDay + " and the last day is " + lastDay);
		
	}

	public void compareYear() {
		try {
			read("Dates.txt");
		} catch (IOException e) {
			System.out.println("error printing from file");
			e.printStackTrace();
		}
		
		for (Entry<LocalDate, Integer> LD: LocalDatesMap.entrySet()) {
			System.out.println(LD.getKey() + ": " + LD.getValue());
		}
		
		
		
	}

	public void dateHashMap() {
		
		for (Entry<LocalDate, Integer> LD: LocalDatesMap.entrySet()) {
			System.out.println(LD.getKey() + ": " + LD.getValue());
		}
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}
	
	public void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
	     
		 DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		 
		 String strg = "";
	     int i = 0;
	     
		 strg = br.readLine();
		
		 while (strg != null) {
			LocalDate inputDate = LocalDate.parse(strg, inputFormat);
			
			LocalDatesMap.put(inputDate, ++i);
	    	
	    	strg = br.readLine();
	     }
	     br.close();
	}

}
