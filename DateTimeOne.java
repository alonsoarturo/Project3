import java.time.LocalDateTime;

public class DateTimeOne extends MesoDateTimeOneAbstract
{
	private LocalDateTime dateTimeNow;
	
	
	@Override
	int getValueOfSecond() {
		
		dateTimeNow();
		int second = dateTimeNow.getSecond();
		
		return second;
	}

	@Override
	void dateTimeNow() {
		
		dateTimeNow = LocalDateTime.now();
		
	}

	@Override
	void sleepForFiveSec() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void dateTimeOfOtherCity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void dateTimeDifferentZone() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void timeZoneHashMap() {
		// TODO Auto-generated method stub
		
	}
   
}