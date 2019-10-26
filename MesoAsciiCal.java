
public class MesoAsciiCal extends MesoAsciiAbstract 
{

	protected MesoStation stationID;
	public static int asciiCalAvg;
	public MesoAsciiCal(MesoStation mesoStation) {
		
		this.stationID = mesoStation;
		
	}

	@Override
	int calAverage() {
		int calAvg = 0;
		double[] asciiVal = new double[4];
		double asciiAvg = 0.0;
		String stationName = stationID.getStID();
		
		for (int i = 0; i < 4; i++) {
			asciiVal[i] = (double) stationName.charAt(i);
		}
		
		asciiAvg = (asciiVal[0] + asciiVal[1] + asciiVal[2] + asciiVal[3]) / 4.0;
		
		//calAvg = (int)Math.floor(asciiAvg + 0.25);
		calAvg = (int)Math.floor(asciiAvg);
		asciiCalAvg = calAvg;
		
		return calAvg;
	}
   
}