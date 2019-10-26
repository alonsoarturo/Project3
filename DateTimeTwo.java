import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class DateTimeTwo {
	
	private LocalDate currentDate = LocalDate.now();
	private HashMap<LocalDate, Integer> LocalDatesMap = new HashMap<LocalDate, Integer>();
	private ArrayList<String> localDatesArray = new ArrayList<String>();
	
	public void daysOfCurrentMonth() {
		
		DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
		
		String tenthDay = dayOfWeekFormat.format(currentDate.withDayOfMonth(10)).toUpperCase();
		String eighteenthDay = dayOfWeekFormat.format(currentDate.withDayOfMonth(18)).toUpperCase();;
		
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
		
		for (LocalDate LD: LocalDatesMap.keySet()) {
			
			Period period = Period.between(currentDate, LD);
			int diffInDays = Math.abs(period.getDays());
			int diffInMonths = Math.abs(period.getMonths());
			int diffInYears = Math.abs(period.getYears());
			
			Year yearInput = Year.of(LD.getYear());
			boolean isLeapYear = yearInput.isLeap();
			
			if (isLeapYear == true) {
				System.out.println(LD.getYear() + " is a leap year, and Difference: " 
						+ diffInYears + " years, " + diffInMonths 
						+ " months, and " + diffInDays + " days.");
			}
		
			else {
				System.out.println(LD.getYear() + " is not a leap year, and Difference: " 
						+ diffInYears + " years, " + diffInMonths 
						+ " months, and " + diffInDays + " days.");
			}
		}
	}

	public void dateHashMap() {
		
		for (Entry<LocalDate, Integer> LD: LocalDatesMap.entrySet()) {
			System.out.println(LD.getKey() + ": " + LD.getValue());
		}
		
	}

	public void dateHashMapSorted() {
	     TreeMap<LocalDate, Integer> sortedKeys = new TreeMap<>(LocalDatesMap);
	        Set<Entry<LocalDate, Integer>> sortedMap = sortedKeys.entrySet();
	        
	        for(Entry<LocalDate, Integer> map : sortedMap){
	            System.out.println(map.getKey() + ": " + map.getValue());
	        }
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
