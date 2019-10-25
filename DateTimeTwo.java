import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTwo {
	
	private LocalDateTime currentDateTime = LocalDateTime.now();
	
	public void daysOfCurrentMonth() {
		
		DateTimeFormatter dayOfWeekFormat = DateTimeFormatter.ofPattern("EEEE");
		
		String tenthDay = dayOfWeekFormat.format(currentDateTime.withDayOfMonth(10)).toUpperCase();
		String eighteenthDay = dayOfWeekFormat.format(currentDateTime.withDayOfMonth(18)).toUpperCase();;
		
		
		
		System.out.println("The tenth day of this month is " 
		+ tenthDay + " and eighteenth is " + eighteenthDay);
		
	}

	public void daysOfAnyMonth(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public void compareYear() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMapSorted() {
		// TODO Auto-generated method stub
		
	}

}
