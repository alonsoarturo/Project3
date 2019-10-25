import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
		
	private static final int MILLI_CONVERSION = 1000;
	private LocalDateTime now = LocalDateTime.now();
	
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
			
		LocalDateTime GMT = now.plusHours(5);
		LocalDateTime BST = now.plusHours(6);
		LocalDateTime CST = GMT.minusHours(5);
		
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
		
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm");
		
		String DateTimeGMT;
		String DateTimeBST;
		String DateTimeCST;
		
		HashMap<String, String> dateTimeDifferentZone = new HashMap<>();
		
		dateTimeDifferentZone.put("GMT", DateTimeGMT);
		dateTimeDifferentZone.put("BST", DateTimeBST);
		dateTimeDifferentZone.put("CST", DateTimeCST);
		
		for (Entry<String, String> DT: dateTimeDifferentZone.entrySet()) {
			System.out.println(DT.getKey() + ":" + DT.getValue());
		}
		
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}