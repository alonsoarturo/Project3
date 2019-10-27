
public class MesoAsciiCal extends MesoAsciiAbstract 
{

	protected MesoStation stationID;
	public static int asciiCalAvg;
	public MesoAsciiCal(MesoStation mesoStation) {
		
		this.stationID = mesoStation;
		
	}

	@Override
	int calAverage() {
		
		int NRMNcalAvg = 0;
		double[] NRMNasciiVal = new double[4];
		double NRMNasciiAvg = 0.0;
		String Norman = "NRMN";
		
		for (int i = 0; i < 4; i++) {
			NRMNasciiVal[i] = (double) Norman.charAt(i);
		}
		
		NRMNasciiAvg = (NRMNasciiVal[0] + NRMNasciiVal[1] + NRMNasciiVal[2] + NRMNasciiVal[3]) / 4.0;
		
		//calAvg = (int)Math.floor(asciiAvg + 0.25);
		NRMNcalAvg = (int)Math.round(NRMNasciiAvg);
		
		//************************************
		int calAvg = 0;
		double[] asciiVal = new double[4];
		double asciiAvg = 0.0;
		String stationName = stationID.getStID();
		
		for (int i = 0; i < 4; i++) {
			asciiVal[i] = (double) stationName.charAt(i);
		}
		
		asciiAvg = (asciiVal[0] + asciiVal[1] + asciiVal[2] + asciiVal[3]) / 4.0;
		
		//calAvg = (int)Math.floor(asciiAvg + 0.25);
		calAvg = (int)Math.round(asciiAvg);
		
		
		int Average = (int)Math.round((calAvg + NRMNasciiAvg) / 2);
		
		asciiCalAvg = Average;
		return Average;
	}
   
}