import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
		
	private static final int MILLI_CONVERSION = 1000;
	private LocalDateTime now = LocalDateTime.now();
	
	private LocalDateTime GMT;
	private LocalDateTime BST;
	private LocalDateTime CST;
	
	@Override
	int getValueOfSecond() {
		
		int timeSec = now.getSecond();
		System.out.println("The value of Second now: " + timeSec);
		
		return (int) timeSec;
	}

	@Override
	void dateTimeNow() {
		
		DateTimeFormatter dateTimeNowFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy h:mm a");
		
		System.out.println("Current Date/Time: " + dateTimeNowFormat.format(now));
		
	}

	@Override
	void sleepForFiveSec() {
		try {
			Thread.sleep(5 * MILLI_CONVERSION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	void dateTimeOfOtherCity() {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("H:mm");
			
		this.GMT = now.plusHours(5);
		this.BST = now.plusHours(6);
		this.CST = GMT.minusHours(5);
		
		String serverTime = dateTimeFormat.format(now);
		String timeGMT = dateTimeFormat.format(GMT);
		String timeBST = dateTimeFormat.format(BST);
		String timeCST = dateTimeFormat.format(CST);
		
		System.out.println("Time on Server: " + serverTime + "\n" + 
				"GMT: " + timeGMT + "\n" + 
				"BST (90E): " + timeBST + "\n" + 
				"CST (90W): " + timeCST);
		
	}

	@Override
	void dateTimeDifferentZone() {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
//		String nowNow = dateTimeFormat.format(now);
//		ZoneId GMTZoneId = ZoneId.of("GMT");
//        System.out.println("TimeZone : " + GMTZoneId);
//
//        //LocalDateTime + ZoneId = ZonedDateTime
//        ZonedDateTime GMTZonedDateTime = now.atZone(GMTZoneId);
//        System.out.println("Date (GMT) : " + GMTZonedDateTime);
		
		
		String DateTimeGMT = dateTimeFormat.format(GMT);
		String DateTimeBST = dateTimeFormat.format(BST);
		String DateTimeCST = dateTimeFormat.format(CST);
		
		HashMap<String, String> dateTimeDifferentZone = new HashMap<>();
		
		dateTimeDifferentZone.put("GMT", DateTimeGMT);
		dateTimeDifferentZone.put("BST", DateTimeBST);
		dateTimeDifferentZone.put("CST", DateTimeCST);
		
		for (Entry<String, String> DT: dateTimeDifferentZone.entrySet()) {
			System.out.println(DT.getKey() + ": " + DT.getValue());
		}
		
	}

	@Override
	void timeZoneHashMap() {
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		
		LocalDateTime AST = now.plusHours(1);
		LocalDateTime ZST = LocalDateTime.of(2018, 11, 05, 19, 59);
		
		String dateTimeAST = dateTimeFormat.format(AST);
		String dateTimeBST = dateTimeFormat.format(BST);
		String dateTimeCST = dateTimeFormat.format(CST);
		String dateTimeGMT = dateTimeFormat.format(GMT);
		String dateTimeZST = dateTimeFormat.format(ZST);
		
		HashMap<String, String> timeZones = new HashMap<>();
		
		timeZones.put("AST", dateTimeAST);
		timeZones.put("BST", dateTimeBST);
		timeZones.put("CST", dateTimeCST);
		timeZones.put("GMT", dateTimeGMT);
		timeZones.put("ZST", dateTimeZST);
		
        TreeMap<String, String> sortedKeys = new TreeMap<>(timeZones);
        Set<Entry<String, String>> sortedTZ = sortedKeys.entrySet();
        
        System.out.println("Print Style 1:");
        for(Entry<String, String> TZ : sortedTZ){
            System.out.println(TZ.getKey() + " " + TZ.getValue());
        }
        
        HashMap<String, String> ZoneDateTime = new HashMap<>();
		
        ZoneDateTime.put(dateTimeAST, "AST");
        ZoneDateTime.put(dateTimeBST, "BST");
        ZoneDateTime.put(dateTimeCST, "CST");
        ZoneDateTime.put(dateTimeGMT, "GMT");
        ZoneDateTime.put(dateTimeZST, "ZST");
        
	    TreeMap<String, String> sortedValues = new TreeMap<>(ZoneDateTime);
	    Set<Entry<String, String>> sortedZDT = sortedValues.entrySet();
		
        System.out.println("Print Style 2:");
        for(Entry<String, String> ZDT : sortedZDT){
            System.out.println(ZDT.getKey() + "");
        }
        
        DateTimeFormatter arrayFormat = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm");
        
        String[] finalSortedArray = new String[5];
        
        finalSortedArray[0] = arrayFormat.format(AST);
        finalSortedArray[1] = arrayFormat.format(BST);
        finalSortedArray[2] = arrayFormat.format(CST);
        finalSortedArray[3] = arrayFormat.format(GMT);
        finalSortedArray[4] = arrayFormat.format(ZST);
        
        System.out.println("Print Style 5: FInal Sorted Array:");
        for(int i = 0; i < finalSortedArray.length; i++){
            System.out.println(finalSortedArray[i].toString());
        }
	}
   
}